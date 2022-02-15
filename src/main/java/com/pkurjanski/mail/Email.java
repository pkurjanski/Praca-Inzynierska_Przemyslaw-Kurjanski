package com.pkurjanski.mail;

import java.io.File;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Email implements Serializable{
    private final String sender;
    private final String subject;
    private final String text;
    private boolean isread;
    private final Date sentdate;
    private String readreceipt;
    private final String id;
    private final Folders folder;
    private transient EmailPanel panel;
    private final ArrayList<File> files;
    private boolean replied;
    
    public Email(String sender, String subject, String text, boolean read, Date sentdate, String readreceipt, String id, Folders folder, ArrayList<File> files, boolean replied) {
        this.sender = sender;
        this.subject = subject;
        this.text = text;
        this.isread = read;
        this.sentdate = sentdate;
        this.readreceipt = readreceipt;
        this.id = id;
        this.folder = folder;
        this.files = files;
        this.replied = replied;
        panel = new EmailPanel(this);
        panel.HighlightChange();
        panel.SetRepliedVisible(this.replied);
    }
    
    public String getText() {
        return text;
    }

    public String getSubject() {
        return subject;
    }

    public String getSender() {
        return sender;
    }

    public Date getSentdate() {
        return sentdate;
    }

    public boolean getIsread() {
        return isread;
    }

    public void setIsread(boolean read) {
        isread = read;
        panel.HighlightChange();
    }

    public String getDate() {
        return new SimpleDateFormat("HH:mm dd/MM/yyyy").format(this.sentdate);
    }

    public String getReadreceipt() {
        return readreceipt;
    }

    public void setReadreceipt(String readreceipt) {
        this.readreceipt = readreceipt;
    }

    public String getId() {
        return id;
    }

    public Folders getFolder() {
        return folder;
    }

    public EmailPanel getPanel() {
        return panel;
    }
    
    public void setPanel() {
        panel = new EmailPanel(this);
        panel.HighlightChange();
    }

    public ArrayList<File> getFiles() {
        return files;
    }

    public void setReplied(boolean replied) {
        this.replied = replied;
        panel.SetRepliedVisible(this.replied);
        folder.ReplyEmail(this);
    }
    
    
    
}
