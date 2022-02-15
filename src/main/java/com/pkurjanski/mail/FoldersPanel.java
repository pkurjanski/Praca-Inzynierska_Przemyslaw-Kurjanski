package com.pkurjanski.mail;

import java.awt.CardLayout;
import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import org.apache.commons.io.IOUtils;

public class FoldersPanel extends javax.swing.JPanel{

    
    private final CardLayout inboxlayout;
    private final Folders folder;
    private final DefaultListModel<File> listmodel = new DefaultListModel<>();
    private Email openedemail = null;
    
    public FoldersPanel(Folders folder) {
        this.folder = folder;
        initComponents();
        inboxlayout = (CardLayout)(InboxPanel.getLayout());
        AttachmentList.setCellRenderer((JList<? extends File> list, File value, int index, boolean isSelected, boolean cellHasFocus) -> {
            javax.swing.JLabel text = new javax.swing.JLabel();
            text.setText(value.getName());
            text.setOpaque(true);
            Color background1;
            Color foreground1;
            if(isSelected) {
                background1 = list.getSelectionBackground();
                foreground1 = list.getSelectionForeground();
            } else {
                background1 = list.getBackground();
                foreground1 = list.getForeground();
            }
            text.setBackground(background1);
            text.setForeground(foreground1);
            return text;
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();
        Inbox = new javax.swing.JScrollPane();
        InboxPanel = new javax.swing.JPanel();
        InboxScrollPanel = new javax.swing.JLayeredPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        List = new javax.swing.JPanel();
        ProgressBarPanel = new javax.swing.JPanel();
        ProgressBar = new javax.swing.JProgressBar();
        Message = new javax.swing.JPanel();
        BackButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        SenderM = new javax.swing.JTextField();
        DateM = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        SubjectM = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TextM = new javax.swing.JEditorPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        AttachmentList = new javax.swing.JList<>();
        DeleteB = new javax.swing.JButton();
        ReplyB = new javax.swing.JButton();

        jFileChooser1.setDialogType(javax.swing.JFileChooser.SAVE_DIALOG);
        jFileChooser1.setFileSelectionMode(javax.swing.JFileChooser.DIRECTORIES_ONLY);

        setPreferredSize(new java.awt.Dimension(0, 0));

        Inbox.setBorder(null);
        Inbox.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        Inbox.setMinimumSize(new java.awt.Dimension(0, 0));

        InboxPanel.setPreferredSize(new java.awt.Dimension(0, 0));
        InboxPanel.setLayout(new java.awt.CardLayout());

        InboxScrollPanel.setPreferredSize(new java.awt.Dimension(583, 325));

        jScrollPane1.setBorder(null);
        jScrollPane1.getVerticalScrollBar().setUnitIncrement(20);

        List.setLayout(new javax.swing.BoxLayout(List, javax.swing.BoxLayout.PAGE_AXIS));
        jScrollPane1.setViewportView(List);

        ProgressBarPanel.setVisible(false);

        ProgressBar.setStringPainted(true);

        javax.swing.GroupLayout ProgressBarPanelLayout = new javax.swing.GroupLayout(ProgressBarPanel);
        ProgressBarPanel.setLayout(ProgressBarPanelLayout);
        ProgressBarPanelLayout.setHorizontalGroup(
            ProgressBarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ProgressBar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        ProgressBarPanelLayout.setVerticalGroup(
            ProgressBarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        InboxScrollPanel.setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        InboxScrollPanel.setLayer(ProgressBarPanel, javax.swing.JLayeredPane.PALETTE_LAYER);

        javax.swing.GroupLayout InboxScrollPanelLayout = new javax.swing.GroupLayout(InboxScrollPanel);
        InboxScrollPanel.setLayout(InboxScrollPanelLayout);
        InboxScrollPanelLayout.setHorizontalGroup(
            InboxScrollPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(InboxScrollPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(InboxScrollPanelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(ProgressBarPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        InboxScrollPanelLayout.setVerticalGroup(
            InboxScrollPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(InboxScrollPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, InboxScrollPanelLayout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ProgressBarPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(9, 9, 9)))
        );

        InboxPanel.add(InboxScrollPanel, "Inbox");

        BackButton.setText("Back");
        BackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackButtonActionPerformed(evt);
            }
        });

        jLabel2.setText("Sender");

        SenderM.setEditable(false);

        DateM.setEditable(false);

        jLabel1.setText("Date");

        jLabel3.setText("Subject");

        SubjectM.setEditable(false);
        SubjectM.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        jPanel2.setLayout(new java.awt.BorderLayout(6, 0));

        TextM.setEditable(false);
        TextM.setBorder(null);
        TextM.setContentType("text/html"); // NOI18N
        TextM.setText("");
        jScrollPane2.setViewportView(TextM);

        jPanel2.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        jScrollPane3.setMinimumSize(new java.awt.Dimension(150, 16));
        jScrollPane3.setPreferredSize(new java.awt.Dimension(150, 146));

        AttachmentList.setModel(listmodel);
        AttachmentList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        AttachmentList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AttachmentListMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(AttachmentList);

        jPanel2.add(jScrollPane3, java.awt.BorderLayout.LINE_END);

        DeleteB.setText("Delete");
        DeleteB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DeleteBMouseClicked(evt);
            }
        });

        ReplyB.setText("Reply");
        ReplyB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ReplyBMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout MessageLayout = new javax.swing.GroupLayout(Message);
        Message.setLayout(MessageLayout);
        MessageLayout.setHorizontalGroup(
            MessageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MessageLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(MessageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(MessageLayout.createSequentialGroup()
                        .addGroup(MessageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(SenderM)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(MessageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(MessageLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(DateM)))
                    .addComponent(SubjectM)
                    .addGroup(MessageLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MessageLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(ReplyB)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(DeleteB)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BackButton)))
                .addContainerGap())
        );
        MessageLayout.setVerticalGroup(
            MessageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MessageLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(MessageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(MessageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SenderM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DateM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SubjectM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 368, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(MessageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BackButton)
                    .addComponent(DeleteB)
                    .addComponent(ReplyB))
                .addContainerGap())
        );

        InboxPanel.add(Message, "Message");

        Inbox.setViewportView(InboxPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 788, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, 0)
                    .addComponent(Inbox, javax.swing.GroupLayout.DEFAULT_SIZE, 788, Short.MAX_VALUE)
                    .addGap(0, 0, 0)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 526, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, 0)
                    .addComponent(Inbox, javax.swing.GroupLayout.DEFAULT_SIZE, 526, Short.MAX_VALUE)
                    .addGap(0, 0, 0)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void BackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackButtonActionPerformed
        listmodel.removeAllElements();
        openedemail = null;
        inboxlayout.show(InboxPanel, "Inbox");
    }//GEN-LAST:event_BackButtonActionPerformed

    private void AttachmentListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AttachmentListMouseClicked
        File file = listmodel.elementAt(AttachmentList.locationToIndex(evt.getPoint()));
        if(file != null) {
            try {
                if(jFileChooser1.showSaveDialog(getRootPane()) == 0) {
                    FileInputStream inputStream = new FileInputStream(file);
                    File newfile = new File(jFileChooser1.getSelectedFile(), file.getName());
                    newfile = Checkfile(newfile);
                    if(newfile != null) {
                        FileOutputStream outputStream = new FileOutputStream(newfile);
                        IOUtils.copy(inputStream, outputStream);
                    }
                }
            } catch(IOException e) {
            } 
        }
    }//GEN-LAST:event_AttachmentListMouseClicked

    private void DeleteBMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DeleteBMouseClicked
        folder.DeleteEmail(openedemail);
        listmodel.removeAllElements();
        openedemail = null;
        inboxlayout.show(InboxPanel, "Inbox");
    }//GEN-LAST:event_DeleteBMouseClicked

    private void ReplyBMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ReplyBMouseClicked
        folder.getUser().getPanel().Reply(openedemail);
    }//GEN-LAST:event_ReplyBMouseClicked
   
    private File Checkfile(File file) {
        File newfile = null;
        if(file.isFile()) {
            for(int i = 1; i < 99; i++) {
                newfile = new File(file.getParentFile(), file.getName().substring(0, file.getName().lastIndexOf(".")) + "(" + i + ")" + file.getName().substring(file.getName().lastIndexOf("."), file.getName().length()));
                if(!newfile.isFile()) break;
                else newfile = null;
            }
        }
        else newfile = file;
        return newfile;
    }
    
    public void ShowProgressBar(int size) {
        ProgressBar.setIndeterminate(false);
        ProgressBar.setString(null);
        ProgressBar.setMaximum(size);
        ProgressBarPanel.setVisible(true);
    }
    
    public void HideProgressBar() {
        ProgressBarPanel.setVisible(false);
        InboxScrollPanel.validate();
        InboxScrollPanel.repaint();
    }
    
    public void UpdateProgressBar(int value) {
        ProgressBar.setValue(value);
    }
    
    public void AddEmail(Email email) {
        List.add(email.getPanel(), 0); 
        List.validate();
        List.repaint();
    }
    
    public void RemoveEmail(Email email) {
        List.remove(email.getPanel());
        List.validate();
        List.repaint();
    }
    
    public void OpenEmail(Email email) {
        SenderM.setText(email.getSender());
        DateM.setText(email.getDate());
        SubjectM.setText(email.getSubject());
        SubjectM.setCaretPosition(0);
        TextM.setText(email.getText());
        TextM.setCaretPosition(0);
        if(email.getFiles() != null) {
            for(File file : email.getFiles()) {
                listmodel.addElement(file);
            }
        }
        openedemail = email;
        if(email.getSender().equals(folder.getUser().getUsername())) ReplyB.setVisible(false);
        else ReplyB.setVisible(true);
        inboxlayout.show(InboxPanel, "Message");
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<File> AttachmentList;
    private javax.swing.JButton BackButton;
    private javax.swing.JTextField DateM;
    private javax.swing.JButton DeleteB;
    private javax.swing.JScrollPane Inbox;
    private javax.swing.JPanel InboxPanel;
    private javax.swing.JLayeredPane InboxScrollPanel;
    private javax.swing.JPanel List;
    private javax.swing.JPanel Message;
    private javax.swing.JProgressBar ProgressBar;
    private javax.swing.JPanel ProgressBarPanel;
    private javax.swing.JButton ReplyB;
    private javax.swing.JTextField SenderM;
    private javax.swing.JTextField SubjectM;
    private javax.swing.JEditorPane TextM;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables
}
