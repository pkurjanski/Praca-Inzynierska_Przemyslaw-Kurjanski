package com.pkurjanski.mail;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.io.File;
import java.util.ArrayList;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JList;
import javax.swing.KeyStroke;
import javax.swing.ListCellRenderer;
import javax.swing.text.html.HTMLDocument;

public class SendPanel extends javax.swing.JPanel {
    
    private Email replyemail;
    private final User user;
    private final ArrayList<File> attachments = new ArrayList<>();
    private final DefaultListModel<File> listmodel = new DefaultListModel<>();
    
    private final Action delpressed = new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent e) {
            attachments.removeAll(AttachmentList.getSelectedValuesList());
            listmodel.removeAllElements();
            listmodel.addAll(attachments);
        }
    };

    public SendPanel(Email replyemail, User user) {
        this.replyemail = replyemail;
        this.user = user;
        initComponents();
        if(replyemail == null) {
            SetComponents(true);
        }
        else {
            RecTB.setText(replyemail.getSender());
            SubTB.setText("Re: " + replyemail.getSubject());
            SetComponents(false);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        FileChooser = new javax.swing.JFileChooser();
        SendEmail = new javax.swing.JPanel();
        RecL = new javax.swing.JLabel();
        RecTB = new javax.swing.JTextField();
        CCL = new javax.swing.JLabel();
        CCTB = new javax.swing.JTextField();
        BCCL = new javax.swing.JLabel();
        BCCTB = new javax.swing.JTextField();
        SubL = new javax.swing.JLabel();
        SubTB = new javax.swing.JTextField();
        MsgL = new javax.swing.JLabel();
        SendB = new javax.swing.JButton();
        jLayeredPane2 = new javax.swing.JLayeredPane();
        ErrorMsg = new javax.swing.JTextField();
        ErrorMsg.setBorder(BorderFactory.createEmptyBorder());
        ErrorMsg.setVisible(false);
        SendProgressBar = new javax.swing.JProgressBar();
        SendProgressBar.setIndeterminate(true);
        SendProgressBar.setVisible(false);
        ReadReciept = new javax.swing.JCheckBox();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        AttachmentList = new javax.swing.JList<>();
        MsgS = new javax.swing.JScrollPane();
        MsgTB = new javax.swing.JEditorPane();
        AttachB = new javax.swing.JButton();
        CancelReplyB = new javax.swing.JButton();
        InputChoice = new javax.swing.JComboBox<>();

        setLayout(new java.awt.BorderLayout());

        RecL.setText("Recipients:");

        CCL.setText("CC:");

        BCCL.setText("BCC:");

        SubL.setText("Subject:");

        MsgL.setText("Message:");

        SendB.setText("Send");
        SendB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SendBMouseClicked(evt);
            }
        });

        ErrorMsg.setEditable(false);
        ErrorMsg.setBorder(null);
        ErrorMsg.setFocusable(false);

        jLayeredPane2.setLayer(ErrorMsg, javax.swing.JLayeredPane.PALETTE_LAYER);
        jLayeredPane2.setLayer(SendProgressBar, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane2Layout = new javax.swing.GroupLayout(jLayeredPane2);
        jLayeredPane2.setLayout(jLayeredPane2Layout);
        jLayeredPane2Layout.setHorizontalGroup(
            jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(ErrorMsg, javax.swing.GroupLayout.DEFAULT_SIZE, 331, Short.MAX_VALUE))
            .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(SendProgressBar, javax.swing.GroupLayout.DEFAULT_SIZE, 331, Short.MAX_VALUE))
        );
        jLayeredPane2Layout.setVerticalGroup(
            jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(ErrorMsg, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE))
            .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane2Layout.createSequentialGroup()
                    .addContainerGap(9, Short.MAX_VALUE)
                    .addComponent(SendProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(9, Short.MAX_VALUE)))
        );

        ReadReciept.setText("Read Reciept");

        AttachmentList.setModel(listmodel);
        AttachmentList.getInputMap().put(KeyStroke.getKeyStroke("DELETE"), "Delete pressed");
        AttachmentList.getActionMap().put("Delete pressed", delpressed);
        AttachmentList.setCellRenderer(new ListCellRenderer<File>() {
            @Override
            public Component getListCellRendererComponent(JList<? extends File> list, File value, int index, boolean isSelected, boolean cellHasFocus) {
                javax.swing.JLabel text = new javax.swing.JLabel();
                text.setText(value.getName());
                text.setOpaque(true);
                Color background;
                Color foreground;
                if (isSelected) {
                    background = list.getSelectionBackground();
                    foreground = list.getSelectionForeground();
                }
                else {
                    background = list.getBackground();
                    foreground = list.getForeground();
                }

                text.setBackground(background);
                text.setForeground(foreground);
                return text;
            }
        });
        jScrollPane1.setViewportView(AttachmentList);

        MsgS.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        MsgTB.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        MsgS.setViewportView(MsgTB);

        jLayeredPane1.setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(MsgS, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addComponent(MsgS)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MsgS, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        AttachB.setText("Attach");
        AttachB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AttachBMouseClicked(evt);
            }
        });

        CancelReplyB.setText("Cancel Reply");
        CancelReplyB.setMargin(new java.awt.Insets(2, 6, 2, 6));
        CancelReplyB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CancelReplyBMouseClicked(evt);
            }
        });

        InputChoice.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "HTML Editor", "Text Editor" }));
        InputChoice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InputChoiceActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout SendEmailLayout = new javax.swing.GroupLayout(SendEmail);
        SendEmail.setLayout(SendEmailLayout);
        SendEmailLayout.setHorizontalGroup(
            SendEmailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SendEmailLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLayeredPane2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CancelReplyB)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(AttachB)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SendB)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SendEmailLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(SendEmailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLayeredPane1)
                    .addComponent(SubTB, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(SendEmailLayout.createSequentialGroup()
                        .addComponent(MsgL)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(InputChoice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 273, Short.MAX_VALUE)
                        .addComponent(ReadReciept))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, SendEmailLayout.createSequentialGroup()
                        .addComponent(SubL)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, SendEmailLayout.createSequentialGroup()
                        .addGroup(SendEmailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(RecL)
                            .addComponent(CCL)
                            .addComponent(BCCL))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(SendEmailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(BCCTB, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(CCTB, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(RecTB))))
                .addGap(28, 28, 28))
        );
        SendEmailLayout.setVerticalGroup(
            SendEmailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SendEmailLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(SendEmailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RecTB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(RecL))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(SendEmailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CCTB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CCL))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(SendEmailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BCCTB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BCCL))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SubL)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SubTB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addGroup(SendEmailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(MsgL)
                    .addComponent(ReadReciept)
                    .addComponent(InputChoice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLayeredPane1)
                .addGap(6, 6, 6)
                .addGroup(SendEmailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(SendEmailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(SendB)
                        .addComponent(AttachB)
                        .addComponent(CancelReplyB))
                    .addComponent(jLayeredPane2))
                .addContainerGap())
        );

        add(SendEmail, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void SendBMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SendBMouseClicked
        new Thread(() -> {
            if(RecTB.getText().trim().equals("")) {
                RecTB.setText("");
                ErrorMsg.setText("No recipient specified");
                SendProgressBar.setVisible(true);
                SendProgressBar.setVisible(false);
                ErrorMsg.setVisible(true);
            }
            else {
                ErrorMsg.setVisible(false);
                SendProgressBar.setVisible(true);
                SendB.setEnabled(false);
                ErrorMsg.setText(Controller.SendEmail(user.getSession(), RecTB.getText(), CCTB.getText(), BCCTB.getText(), SubTB.getText(), MsgTB.getText(), ReadReciept.isSelected(), user.getUsername(), user.getname(), attachments, replyemail));
                SendProgressBar.setVisible(false);
                ErrorMsg.setVisible(true);
                if(ErrorMsg.getText().equals("Message sent")) {
                    RecTB.setText("");
                    CCTB.setText("");
                    BCCTB.setText("");
                    SubTB.setText("");
                    MsgTB.setDocument(new HTMLDocument());
                    listmodel.removeAllElements();
                    attachments.clear();
                }
                if(replyemail != null) {
                    SetComponents(true);
                    replyemail = null;
                }
                SendB.setEnabled(true);
            }
        }).start();
    }//GEN-LAST:event_SendBMouseClicked

    private void AttachBMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AttachBMouseClicked
        int result = FileChooser.showOpenDialog(this);
        if(result == JFileChooser.APPROVE_OPTION) {
            attachments.add(FileChooser.getSelectedFile());
            listmodel.addElement(attachments.get(attachments.size() - 1));
        }
    }//GEN-LAST:event_AttachBMouseClicked

    private void CancelReplyBMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CancelReplyBMouseClicked
        replyemail = null;
        SetComponents(true);
    }//GEN-LAST:event_CancelReplyBMouseClicked

    private void InputChoiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InputChoiceActionPerformed
        String contents = MsgTB.getText();
        if(InputChoice.getSelectedItem().toString().equals("Text Editor")) {
            MsgTB.setContentType("text/html");
        }
        else {
            MsgTB.setContentType("text/plain");
        }
        MsgTB.setText(contents);
    }//GEN-LAST:event_InputChoiceActionPerformed

    private void SetComponents(boolean visible) {
        CancelReplyB.setVisible(!visible);
        RecTB.setEnabled(visible);
        CCL.setVisible(visible);
        CCTB.setVisible(visible);
        BCCL.setVisible(visible);
        BCCTB.setVisible(visible);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AttachB;
    private javax.swing.JList<File> AttachmentList;
    private javax.swing.JLabel BCCL;
    private javax.swing.JTextField BCCTB;
    private javax.swing.JLabel CCL;
    private javax.swing.JTextField CCTB;
    private javax.swing.JButton CancelReplyB;
    private javax.swing.JTextField ErrorMsg;
    private javax.swing.JFileChooser FileChooser;
    private javax.swing.JComboBox<String> InputChoice;
    private javax.swing.JLabel MsgL;
    private javax.swing.JScrollPane MsgS;
    private javax.swing.JEditorPane MsgTB;
    private javax.swing.JCheckBox ReadReciept;
    private javax.swing.JLabel RecL;
    private javax.swing.JTextField RecTB;
    private javax.swing.JButton SendB;
    private javax.swing.JPanel SendEmail;
    private javax.swing.JProgressBar SendProgressBar;
    private javax.swing.JLabel SubL;
    private javax.swing.JTextField SubTB;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JLayeredPane jLayeredPane2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
