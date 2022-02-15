package com.pkurjanski.mail;

import java.awt.Font;
import java.text.SimpleDateFormat;
import javax.swing.UIManager;

public class EmailPanel extends javax.swing.JPanel{
    
    private final Email email;
    
    public EmailPanel(Email email) {
        this.email = email;
        initComponents();
        Sender.setText(email.getSender());
        Date.setText(new SimpleDateFormat("HH:mm dd/MM/yyyy").format(email.getSentdate()));
        Subject.setText(email.getSubject());
        jScrollPane2.setOpaque(false);
        jScrollPane2.getViewport().setOpaque(false);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        Panel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Subject = new javax.swing.JLabel();
        Date = new javax.swing.JLabel();
        Sender = new javax.swing.JLabel();
        Replied = new javax.swing.JButton();

        setFocusable(false);
        setMaximumSize(new java.awt.Dimension(32767, 72));
        setMinimumSize(new java.awt.Dimension(0, 72));
        setPreferredSize(new java.awt.Dimension(0, 72));

        jScrollPane1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        jScrollPane1.setFocusable(false);
        jScrollPane1.setMaximumSize(new java.awt.Dimension(32767, 72));
        jScrollPane1.setMinimumSize(new java.awt.Dimension(0, 72));
        jScrollPane1.setOpaque(false);
        jScrollPane1.setPreferredSize(new java.awt.Dimension(0, 72));
        jScrollPane1.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                jScrollPane1MouseWheelMoved(evt);
            }
        });

        Panel.setFocusable(false);
        Panel.setPreferredSize(new java.awt.Dimension(0, 68));
        Panel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PanelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PanelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                PanelMouseExited(evt);
            }
        });

        jScrollPane2.setBorder(null);
        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        jScrollPane2.setFocusable(false);
        jScrollPane2.setOpaque(false);
        jScrollPane2.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                jScrollPane2MouseWheelMoved(evt);
            }
        });
        jScrollPane2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPane2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jScrollPane2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jScrollPane2MouseExited(evt);
            }
        });

        Subject.setFocusable(false);
        Subject.setInheritsPopupMenu(false);
        jScrollPane2.setViewportView(Subject);

        Date.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        Date.setFocusable(false);

        Sender.setFocusable(false);

        Replied.setText("Replied");
        Replied.setEnabled(false);
        Replied.setMargin(new java.awt.Insets(2, 0, 2, 0));

        javax.swing.GroupLayout PanelLayout = new javax.swing.GroupLayout(Panel);
        Panel.setLayout(PanelLayout);
        PanelLayout.setHorizontalGroup(
            PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelLayout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 459, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Replied, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelLayout.createSequentialGroup()
                        .addComponent(Sender, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Date, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        PanelLayout.setVerticalGroup(
            PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Sender, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Date, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Replied)
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );

        jScrollPane1.setViewportView(Panel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void PanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelMouseClicked
        email.getFolder().OpenEmail(email);
        HighlightChange();
    }//GEN-LAST:event_PanelMouseClicked

    private void PanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelMouseEntered
        if(UIManager.getLookAndFeel().toString().contains("FlatLightLaf")) {
            Panel.setBackground(Panel.getBackground().darker());
        }
        else {
            Panel.setBackground(Panel.getBackground().brighter());
        }
    }//GEN-LAST:event_PanelMouseEntered

    private void PanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelMouseExited
        if(UIManager.getLookAndFeel().toString().contains("FlatLightLaf")) {
            Panel.setBackground(Panel.getBackground().brighter());
        }
        else {
            Panel.setBackground(Panel.getBackground().darker());
        }
    }//GEN-LAST:event_PanelMouseExited

    private void jScrollPane1MouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_jScrollPane1MouseWheelMoved
        getParent().dispatchEvent(evt);
    }//GEN-LAST:event_jScrollPane1MouseWheelMoved

    private void jScrollPane2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane2MouseExited
        Panel.dispatchEvent(evt);
    }//GEN-LAST:event_jScrollPane2MouseExited

    private void jScrollPane2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane2MouseEntered
        Panel.dispatchEvent(evt);
    }//GEN-LAST:event_jScrollPane2MouseEntered

    private void jScrollPane2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane2MouseClicked
        Panel.dispatchEvent(evt);
    }//GEN-LAST:event_jScrollPane2MouseClicked

    private void jScrollPane2MouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_jScrollPane2MouseWheelMoved
        getParent().dispatchEvent(evt);
    }//GEN-LAST:event_jScrollPane2MouseWheelMoved

    public void HighlightChange() {
        Font font;
        if(!email.getIsread()) {
            font = new Font("Segoe UI", Font.BOLD, 12);
            Sender.setFont(font);
            Date.setFont(font);
            Subject.setFont(font);
        }
        else {
            font = new Font("Segoe UI", Font.PLAIN, 12);
            Sender.setFont(font);
            Date.setFont(font);
            Subject.setFont(font);
        }
    }
    
    public void SetRepliedVisible(boolean visible) {
        Replied.setVisible(visible);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Date;
    private javax.swing.JPanel Panel;
    private javax.swing.JButton Replied;
    private javax.swing.JLabel Sender;
    private javax.swing.JLabel Subject;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
