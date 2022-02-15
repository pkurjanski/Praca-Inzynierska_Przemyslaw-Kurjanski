package com.pkurjanski.mail;

import jakarta.mail.Folder;
import jakarta.mail.MessagingException;
import jakarta.mail.Session;
import jakarta.mail.Store;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class User implements Serializable{
    
    private final String username;
    private final ArrayList<Folders> folders = new ArrayList<>();
    private transient Session session;
    private transient Store store;
    private final String name;
    private transient boolean fetching = false;
    private transient UserPanel panel;
    private final String password;
    private final String smtphost;
    private final String imaphost;
    private final String smtpport;
    private final String imapport;
    
    public User(String username, Session session, Store store, String name, String password, String smtphost, String smtpport, String imaphost, String imapport) {
        this.username = username;
        this.session = session;
        this.store = store;
        this.name = name;
        this.password = password;
        this.smtphost = smtphost;
        this.smtpport = smtpport;
        this.imaphost = imaphost;
        this.imapport = imapport;
        panel = new UserPanel(this);
    }
    
    public void FetchFolders(){
        if(!fetching) {
            new Thread(() -> {
                fetching = true;
                try {
                    if(!store.isConnected()) {
                        store.connect();
                    }
                    Folder[] fetchedfolders = store.getDefaultFolder().list("*");
                    ArrayList<String> names = new ArrayList<>();
                    for (Folder fetchedfolder : fetchedfolders) {
                        while(Controller.serializing) {}
                        boolean present = false;
                        if((fetchedfolder.getType() & Folder.HOLDS_MESSAGES) != 0) {
                            for(Folders folder : folders) {
                                if(fetchedfolder.getFullName().equals(folder.getFullname())) {
                                    present = true;
                                    folder.FetchEmails();
                                    break;
                                }
                            }
                            if(!present) {
                                folders.add(new Folders(fetchedfolder.getFullName(), fetchedfolder.getName(), this));
                                panel.AddFolder(folders.get(folders.size() - 1));
                                folders.get(folders.size() - 1).FetchEmails();
                            }
                            names.add(fetchedfolder.getFullName());
                        }
                    }
                    Iterator<Folders> iterator = folders.iterator();
                    while(iterator.hasNext()) {
                        Folders folder = iterator.next();
                        if(!names.contains(folder.getFullname())) {
                            panel.RemoveFolder(folder);
                            folders.remove(folder);
                        }
                    }
                    fetching = false;
                }
                catch(MessagingException e) {
                    fetching = false;
                }
            }).start();
        }
    }
        
    public void Populate() {
        panel = new UserPanel(this);
        session = Controller.ConnectSMTP(username, Controller.decrypt(password), smtphost, smtpport);
        store = Controller.ConnectIMAP(username, Controller.decrypt(password), imaphost, imapport);
        for(Folders folder: folders) {
            folder.Populate();
            panel.AddFolder(folder);
        }
    }
    
    public String getUsername() {
        return username;
    }

    public Session getSession() {
        return session;
    }

    public Store getStore() {
        return store;
    }

    public String getname() {
        return name;
    }

    public UserPanel getPanel() {
        return panel;
    }

    public String getPassword() {
        return password;
    }

    public ArrayList<Folders> getFolders() {
        return folders;
    }
    
    
}
