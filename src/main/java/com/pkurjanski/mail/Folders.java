package com.pkurjanski.mail;

import jakarta.mail.Flags;
import jakarta.mail.Folder;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.Store;
import jakarta.mail.search.MessageIDTerm;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;

public class Folders implements Serializable{
    
    private final ArrayList<Email> emails = new ArrayList<>();
    private final ArrayList<Email> tobedeleted = new ArrayList<>();
    private final ArrayList<Email> seen = new ArrayList<>();
    private final ArrayList<Email> replied = new ArrayList<>();
    private final String fullname;
    private final String name;
    private final User user;
    private transient boolean fetching = false;
    private transient FoldersPanel panel;
    
    public Folders(String fullname, String name, User user) {
        this.fullname = fullname;
        this.name = name;
        this.user = user;
        this.panel = new FoldersPanel(this);
    }
    
    public void FetchEmails() {
        if(!fetching) {
            new Thread(() -> {
                fetching = true;
                try {
                    Store store = user.getStore();
                    if(!store.isConnected()) {
                        store.connect();
                    }
                    Folder folder = store.getFolder(fullname);
                    folder.open(Folder.READ_ONLY);

                    int status = 1;
                    ArrayList<Message> messages = new ArrayList<>(Controller.FetchMessages(folder));
                    ArrayList<String> ids = new ArrayList<>();

                    panel.ShowProgressBar(messages.size());

                    for(Message message : messages) {
                        while(Controller.serializing) {}
                        boolean present = false;
                        String id = message.getHeader("Message-ID")[0];
                        Iterator<Email> iterator = emails.iterator();
                        while (iterator.hasNext()) {
                            Email email = iterator.next();
                            if(email.getId().equals(id)) {
                                present = true;
                                email.setIsread(message.getFlags().contains(Flags.Flag.SEEN));
                                break;
                            }
                        }
                        ids.add(id);
                        if(present == false) {
                            Email email = Controller.FetchEmail(message, this);
                            if(email != null) {
                                emails.add(email);
                                panel.AddEmail(email);
                            }
                        }
                        panel.UpdateProgressBar(status);
                        status++;
                    }

                    Iterator<Email> iterator = emails.iterator();
                    while(iterator.hasNext()) {
                        Email email = iterator.next();
                        if(!ids.contains(email.getId())) {
                            emails.remove(email);
                        }
                    }
                    if(folder.isOpen()) {
                        folder.close();
                    }
                    panel.HideProgressBar();
                    Controller.Serialize();
                    fetching = false;
                    SetFlags();
                }
                catch (MessagingException | IOException | IllegalStateException e) {
                    Controller.Serialize();
                    fetching = false;
                    SetFlags();
                    FetchEmails();
                }
            }).start();
        }
    }
    
    public void OpenEmail(Email email) {
        user.getPanel().SetFocus(this);
        new Thread(() -> {
                if(!email.getReadreceipt().equals("")) {
                    if(JOptionPane.showConfirmDialog(panel, "The sender of this message asks for a read receipt. Would you like to send it?", "Read receipt", JOptionPane.YES_NO_OPTION) == 0) {
                        Controller.SendEmail(user.getSession(), email.getReadreceipt(), null, null, "Your massage has arrived", "Your message to " + user.getUsername() + " has been opened", false, user.getUsername(), user.getname(), null, null);
                    }
                    email.setReadreceipt("");
                }
            }).start();
        panel.OpenEmail(email);
        if(!email.getIsread()) {
            seen.add(email);
            email.setIsread(true);
        }
        new Thread(() -> {
            SetFlags();
        }).start();
    }
    
    public void DeleteEmail(Email email) {
        tobedeleted.add(email);
        emails.remove(email);
        seen.remove(email);
        replied.remove(email);
        panel.RemoveEmail(email);
        new Thread(() -> {
            SetFlags();
        }).start();
    }
    
    public void ReplyEmail(Email email) {
        replied.add(email);
        new Thread(() -> {
            SetFlags();
        }).start();
    }
    
    public void SetFlags() {
        if(!fetching) {
            fetching = true;
            try {
                Store store = user.getStore();
                if(!store.isConnected()) {
                    store.connect();
                }
                Folder folder = store.getFolder(fullname);
                folder.open(Folder.READ_WRITE);
                if(!tobedeleted.isEmpty()) {
                    Iterator<Email> iterator = tobedeleted.iterator();
                    while(iterator.hasNext()) {
                        Email email = iterator.next();
                        MessageIDTerm messagetodelete = new MessageIDTerm(email.getId());
                        Message[] message = folder.search(messagetodelete);
                        message[0].setFlag(Flags.Flag.DELETED, true);
                        tobedeleted.remove(email);
                    }
                }
                if(!seen.isEmpty()) {
                    Iterator<Email> iterator = seen.iterator();
                    while(iterator.hasNext()) {
                        Email email = iterator.next();
                        MessageIDTerm messagetodelete = new MessageIDTerm(email.getId());
                        Message[] message = folder.search(messagetodelete);
                        message[0].setFlag(Flags.Flag.SEEN, true);
                        seen.remove(email);
                    }
                }
                if(!replied.isEmpty()) {
                    Iterator<Email> iterator = replied.iterator();
                    while(iterator.hasNext()) {
                        Email email = iterator.next();
                        MessageIDTerm messagetodelete = new MessageIDTerm(email.getId());
                        Message[] message = folder.search(messagetodelete);
                        message[0].setFlag(Flags.Flag.SEEN, true);
                        replied.remove(email);
                    }
                }
                if(folder.isOpen()) {
                    folder.close();
                }
                fetching = false;
            }
            catch(MessagingException e) {
                fetching = false;
            }
        }
    }
        
    public void Populate() {
        panel = new FoldersPanel(this);
        for(Email email: emails) {
            email.setPanel();
            panel.AddEmail(email);
        }
    }
    
    public String getname() {
        return name;
    }

    public String getFullname() {
        return fullname;
    }

    public FoldersPanel getPanel() {
        return panel;
    }

    public User getUser() {
        return user;
    }

    public ArrayList<Email> getEmails() {
        return emails;
    }
    
    
}
