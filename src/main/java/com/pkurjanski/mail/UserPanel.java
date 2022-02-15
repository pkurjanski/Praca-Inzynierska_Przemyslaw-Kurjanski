package com.pkurjanski.mail;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.Iterator;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JComponent;
import javax.swing.KeyStroke;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class UserPanel extends javax.swing.JPanel{
    
    private final User user;
    private final CardLayout cardlayout;
    
    private final Action ctrlfpressed = new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent e) {
            ChangePane();
        }
    };
    
    public UserPanel(User user) {
        this.user = user;
        initComponents();
        Panel.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(KeyStroke.getKeyStroke(KeyEvent.VK_F, InputEvent.CTRL_DOWN_MASK), "ctrlf");
        Panel.getActionMap().put("ctrlf", ctrlfpressed);
        Write.add(new SendPanel(null, user));
        Write.validate();
        Write.repaint();
        cardlayout = (CardLayout) getLayout();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Panel = new javax.swing.JTabbedPane();
        Write = new javax.swing.JPanel();
        FindPanel = new javax.swing.JPanel();
        FindTB = new javax.swing.JTextField();
        CloseB = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        List = new javax.swing.JPanel();

        setPreferredSize(new java.awt.Dimension(640, 327));
        setLayout(new java.awt.CardLayout());

        Panel.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        Panel.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        Panel.setPreferredSize(new java.awt.Dimension(640, 327));
        Panel.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                TabChanged(evt);
            }
        });
        Panel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PanelMouseClicked(evt);
            }
        });

        Write.setLayout(new java.awt.BorderLayout());
        Panel.addTab("Write", Write);

        add(Panel, "Panel");

        FindTB.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                Find();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                Find();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                Find();
            }
        });

        CloseB.setText("X");
        CloseB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CloseBMouseClicked(evt);
            }
        });

        List.setLayout(new javax.swing.BoxLayout(List, javax.swing.BoxLayout.PAGE_AXIS));
        jScrollPane1.setViewportView(List);

        javax.swing.GroupLayout FindPanelLayout = new javax.swing.GroupLayout(FindPanel);
        FindPanel.setLayout(FindPanelLayout);
        FindPanelLayout.setHorizontalGroup(
            FindPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FindPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(FindPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(FindPanelLayout.createSequentialGroup()
                        .addComponent(FindTB, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CloseB))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        FindPanelLayout.setVerticalGroup(
            FindPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FindPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(FindPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(FindTB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CloseB))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1)
                .addContainerGap())
        );

        add(FindPanel, "FindPanel");
    }// </editor-fold>//GEN-END:initComponents

    private void PanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelMouseClicked
        Panel.requestFocus();
        user.FetchFolders();
    }//GEN-LAST:event_PanelMouseClicked

    private void TabChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_TabChanged
        if(Panel.getSelectedIndex() == 0) {
            Write.removeAll();
            Write.add(new SendPanel(null, user));
            Write.validate();
            Write.repaint();
        }
    }//GEN-LAST:event_TabChanged

    private void CloseBMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CloseBMouseClicked
        FindTB.setText("");
        List.removeAll();
        ChangePane();
        Panel.requestFocus();
    }//GEN-LAST:event_CloseBMouseClicked

    public void AddFolder(Folders folder) {
        Panel.addTab(folder.getname(), folder.getPanel());
    }
    
    public void RemoveFolder(Folders folder) {
        Panel.remove(folder.getPanel());
    }
    
    public void Reply(Email email) {
        Panel.setSelectedIndex(0);
        Write.removeAll();
        Write.add(new SendPanel(email, user));
        Write.validate();
        Write.repaint();
    }
    
    public void SetFocus(Folders folder) {
        cardlayout.show(this, "Panel");
        Panel.setSelectedComponent(folder.getPanel());
    }
    
    public void Find() {
        List.removeAll();
        if(!FindTB.getText().equals("")) {
            Iterator<Folders> folderiterator = user.getFolders().iterator();
            while(folderiterator.hasNext()) {
                Folders folder = folderiterator.next();
                Iterator<Email> emailiterator = folder.getEmails().iterator();
                while(emailiterator.hasNext()) {
                    Email email = emailiterator.next();
                    if(email.getSender().contains(FindTB.getText()) || email.getSubject().contains(FindTB.getText()) || email.getText().contains(FindTB.getText())) {
                        List.add(email.getPanel());
                    }
                }
            }
        }
        List.validate();
        List.repaint();
    }
    
    public void ChangePane() {
        cardlayout.next(this);
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CloseB;
    private javax.swing.JPanel FindPanel;
    private javax.swing.JTextField FindTB;
    private javax.swing.JPanel List;
    private javax.swing.JTabbedPane Panel;
    private javax.swing.JPanel Write;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
