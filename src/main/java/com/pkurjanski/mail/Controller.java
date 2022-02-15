package com.pkurjanski.mail;

import jakarta.activation.DataHandler;
import jakarta.activation.FileDataSource;
import jakarta.mail.BodyPart;
import jakarta.mail.Flags;
import jakarta.mail.Folder;
import jakarta.mail.Header;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.Part;
import jakarta.mail.Session;
import jakarta.mail.Store;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import jakarta.mail.SendFailedException;
import jakarta.mail.internet.MimeBodyPart;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Base64;
import java.util.Date;
import java.util.Enumeration;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

public class Controller {
    
    public static ArrayList<User> users = new ArrayList<>();
    public final static ArrayList<User> serializedusers = new ArrayList<>();
    public static int selectedtab;
    public static boolean serializing;
    public static SecretKey key;
    
    public static int AddUser(String username, String password, String name, String smtphost, String smtpport, String imaphost, String imapport, boolean savepassword) {
        for(int i = 0; i < users.size(); i++){
            if(users.get(i).getUsername().equals(username)) return 2;
        }
        Store store = ConnectIMAP(username, password, imaphost, imapport);
        if(store == null) { 
            return 1;
        }
        else { 
            Session session = ConnectSMTP(username, password, smtphost, smtpport);
            User user;
            if(savepassword) {
                user = new User(username, session, store, name, encrypt(password), smtphost, smtpport, imaphost, smtpport);
                serializedusers.add(user);
            }
            else {
                user = new User(username, session, store, name, "", smtphost, smtpport, imaphost, smtpport);
            }
            users.add(user);
            user.FetchFolders();
            return 0;
        }
    }
    
    public static void DeleteUser(int i) {
        User user = users.get(i);
        if(!user.getPassword().equals("")) {
            serializedusers.remove(user);
        }
        users.remove(user);
    }
    
    public static String SendEmail(Session session, String recipients, String ccrecipients, String bccrecipients, String subject, String text, Boolean ReadReciept, String username, String name, ArrayList<File> attachments, Email email) {
        
        try {
            Message message = new MimeMessage(session);
            MimeMultipart messagemultipart = new MimeMultipart();
            BodyPart messagebodypart = new MimeBodyPart();
            
            String[] recipientlist = recipients.split(",");
            InternetAddress[] recipientaddresses = new InternetAddress[recipientlist.length];
            for(int i = 0; i < recipientlist.length; i++) {
                if(!recipientlist[i].trim().equals("")) recipientaddresses[i] = new InternetAddress(recipientlist[i].trim());
            }
            if(!ccrecipients.trim().equals("")) {
                String[] ccrecipientlist = ccrecipients.split(",");
                ArrayList<InternetAddress> ccrecipientaddresses = new ArrayList<>();
                for(String ccrecipient : ccrecipientlist) {
                    if(!ccrecipient.trim().equals("")) {
                        ccrecipientaddresses.add(new InternetAddress(ccrecipient.trim()));
                    }
                }
                for(InternetAddress ccrecipient : ccrecipientaddresses) {
                    message.addRecipient(Message.RecipientType.CC, ccrecipient);
                }
            }
            if(!bccrecipients.trim().equals("")) {
                String[] bccrecipientlist = bccrecipients.split(",");
                ArrayList<InternetAddress> bccrecipientaddresses = new ArrayList<>();
                for(String bccrecipient : bccrecipientlist) {
                    if(!bccrecipient.trim().equals("")) {
                        bccrecipientaddresses.add(new InternetAddress(bccrecipient.trim()));
                    }
                }
                for(InternetAddress bccrecipient : bccrecipientaddresses) {
                    message.addRecipient(Message.RecipientType.CC, bccrecipient);
                }
            }
            
            messagebodypart.setContent(text, "text/html");
            messagemultipart.addBodyPart(messagebodypart);
            if(attachments != null) {
                for(File attachment : attachments) {
                    messagebodypart = new MimeBodyPart();
                    messagebodypart.setDataHandler(new DataHandler(new FileDataSource(attachment)));
                    messagebodypart.setFileName(attachment.getName());
                    messagemultipart.addBodyPart(messagebodypart);
                }
            }
            
            
            message.setFrom(new InternetAddress('"' + name + '"' + "<" + username + ">"));
            message.addRecipients(Message.RecipientType.TO, recipientaddresses);
            message.setSubject(subject);
            message.setContent(messagemultipart);
            if(ReadReciept == true) {
                message.setHeader("Disposition-Notification-To", username);
            }
            
            Transport.send(message);
            if(email != null) {
                email.setReplied(true);
            }
            
            return "Message sent";
        }
        catch(SendFailedException e) {
            return "Invalid address";
        }
        catch(MessagingException e) {
            return e.toString();
        }
    }
    
    public static Email FetchEmail(Message message, Folders folder) throws MessagingException, IOException {
        ArrayList<File> attachments = null;
        String text = "";
        String id = "";
        String readreciept = "";
        Date sentdate = message.getSentDate();
        Enumeration<Header> headers = message.getAllHeaders();
        while(headers.hasMoreElements()) {
            Header header = headers.nextElement();
            if(header.getName().equals("Message-ID")) {
                id = header.getValue();
            }
            if(header.getName().equals("Disposition-Notification-To")) {
                readreciept = header.getValue();
            }
        }
        if(message.isMimeType("multipart/*")) {
            MimeMultipart mime = (MimeMultipart)message.getContent();
            AbstractMap.SimpleEntry<String, ArrayList<File>> content = ReadMime(mime, id.split("@")[0].substring(1));
            text = content.getKey();
            attachments = content.getValue();
        }
        else if(message.isMimeType("text/html") || message.isMimeType("text/plain")) {
            text = message.getContent().toString();
        }
        text = text.replaceAll("<meta[^>]*>[^\\\n]*\\\n  ", "");
        return new Email(InternetAddress.toString(message.getFrom()), message.getSubject(), text, message.getFlags().contains(Flags.Flag.SEEN), sentdate, readreciept, id, folder, attachments, message.getFlags().contains(Flags.Flag.ANSWERED));
    }
    
    public static ArrayList<Message> FetchMessages(Folder folder) {
        try {
            ArrayList<Message> messages = new ArrayList<>(Arrays.asList(folder.getMessages()));
            return messages;
        }
        catch(MessagingException e) {
            return null;
        }
    }
    
    private static AbstractMap.SimpleEntry<String, ArrayList<File>> ReadMime(MimeMultipart mime, String foldername) throws MessagingException, IOException {
        String text = "";
        ArrayList<File> attachments = new ArrayList<>();
        int count = mime.getCount();
        if(count != 0) {
            if(mime.getContentType().contains("ALTERNATIVE")) {
                MimeBodyPart bodypart = (MimeBodyPart) mime.getBodyPart(count - 1);
                if(Part.ATTACHMENT.equalsIgnoreCase(bodypart.getDisposition()) && !bodypart.getFileName().isBlank()) {
                    new File("Attachments/" + foldername).mkdirs();
                    File file = new File("Attachments/" + foldername, bodypart.getFileName());
                    bodypart.saveFile(file);
                    attachments.add(file);
                }
                else if (bodypart.isMimeType("text/html")) {
                    text = text + "\n" + bodypart.getContent().toString();
                } 
                else if (bodypart.isMimeType("text/plain")) {
                    text = bodypart.getContent().toString();
                }
                else if (bodypart.getContent().getClass().equals(MimeMultipart.class)){
                    AbstractMap.SimpleEntry<String, ArrayList<File>> content = ReadMime((MimeMultipart)bodypart.getContent(), foldername);
                    text = text + content.getKey();
                    attachments.addAll(content.getValue());
                }
            }
            else {
                for(int n = 0; n < count; n++) {
                    MimeBodyPart bodypart = (MimeBodyPart) mime.getBodyPart(n);
                    if(Part.ATTACHMENT.equalsIgnoreCase(bodypart.getDisposition()) && !bodypart.getFileName().isBlank()) {
                        new File("Attachments/" + foldername).mkdirs();
                        File file = new File("Attachments/" + foldername, bodypart.getFileName());
                        bodypart.saveFile(file);
                        attachments.add(file);
                    }
                    else if (bodypart.isMimeType("text/html")) {
                        text = text + "\n" + bodypart.getContent().toString();
                    } 
                    else if (bodypart.isMimeType("text/plain")) {
                        text = bodypart.getContent().toString();
                    }
                    else if (bodypart.getContent().getClass().equals(MimeMultipart.class)){
                        AbstractMap.SimpleEntry<String, ArrayList<File>> content = ReadMime((MimeMultipart)bodypart.getContent(), foldername);
                        text = text + content.getKey();
                        attachments.addAll(content.getValue());
                    }
                }
            }
        } 
        return new AbstractMap.SimpleEntry<>(text, attachments);
    }
    
    public static Session ConnectSMTP(String username, String password, String host, String port) {
        Session session;
        
        Properties prop = new Properties();
        
        prop.put("mail.smtp.ssl.trust", host);
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true");
        prop.put("mail.smtp.host", host);
        prop.put("mail.smtp.port", port);
        
        session = Session.getInstance(prop, new jakarta.mail.Authenticator() {
            @Override
            protected jakarta.mail.PasswordAuthentication getPasswordAuthentication() {
                return new jakarta.mail.PasswordAuthentication(username, password);
            }
        });
        
        return session;
    }
    
    public static Store ConnectIMAP(String username, String password, String host, String port) {
        Session session;
        Store store;
        
        Properties prop = new Properties();
        
        try {
            prop.put("mail.imaps.ssl.trust", host);
            prop.put("mail.imaps.host", host);
            prop.put("mail.imaps.port", port);
            prop.put("mail.store.protocol", "imaps");
            session = Session.getInstance(prop);

            store = session.getStore("imaps");

            store.connect(username, password);
            store.close();
            return store;
        }
        catch(MessagingException e) {
            return null;
        }
    }
    
    public static void Serialize() {
        serializing = true;
        boolean waiting = true;
        File serializationfile = new File("ser.ser");
        while(waiting) {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(serializationfile);
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
                objectOutputStream.writeObject(serializedusers);
                objectOutputStream.flush();
                serializing = false;
                waiting = false;
            }
            catch(IOException e) {
                serializing = false;
            }
        }
    }
    
    public static ArrayList<User> ReadSerialized() {
        File serializedfile = new File("ser.ser");
        if(serializedfile.exists()) {
            try {
                FileInputStream fileInputStream = new FileInputStream("ser.ser");
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                users = (ArrayList<User>) objectInputStream.readObject();
                serializedusers.addAll(users);
            } 
            catch(IOException | ClassNotFoundException e) {
            }
        }
        return users;
    }
    
    public static String encrypt(String input) {
        try {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encryptedtext = cipher.doFinal(input.getBytes());
        return Base64.getEncoder().encodeToString(encryptedtext);
        }
        catch(NoSuchPaddingException | NoSuchAlgorithmException | InvalidKeyException | BadPaddingException | IllegalBlockSizeException e) {
            return "";
        }
    }
    
    public static String decrypt(String input) {
        try {
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, key);
            byte[] decryptedtext = cipher.doFinal(Base64.getDecoder().decode(input));
            return new String(decryptedtext);
        }
        catch(NoSuchPaddingException | NoSuchAlgorithmException | InvalidKeyException | BadPaddingException | IllegalBlockSizeException e) {
            return "";
        }
    }
    
    public static void Key() throws NoSuchAlgorithmException {
        File serializationfile = new File("crypto.key");
        try {
            if(!serializationfile.isFile()) {
                serializationfile.createNewFile();
                KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
                keyGenerator.init(256);
                key = keyGenerator.generateKey();
                FileOutputStream fileOutputStream = new FileOutputStream(serializationfile);
                try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
                    objectOutputStream.writeObject(key);
                    objectOutputStream.flush();
                }
            }
            else {
                FileInputStream fileInputStream = new FileInputStream("crypto.key");
                try (ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
                    key = (SecretKey) objectInputStream.readObject();
                }
            }
        }
        catch(IOException | ClassNotFoundException e) {
        }
    }
    
    

    public static int getUsercount() {
        return users.size();
    }
    
    
    public static void setSelectedtab(int x) {
        selectedtab = x;
        if(selectedtab > 0) {
            users.get(selectedtab - 1).getPanel().requestFocus();
        }
    }
    
}
