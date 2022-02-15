package com.pkurjanski.mail;

import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;
import java.awt.event.ActionEvent;
import java.security.NoSuchAlgorithmException;
import javax.swing.AbstractAction;
import javax.swing.UIManager;
import javax.swing.SwingUtilities;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.KeyStroke;
import javax.swing.UnsupportedLookAndFeelException;

public class GUI extends javax.swing.JFrame {
    
    private final Action enterpressed = new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent e) {
            Login();
        }
    };
    private final Action popupenterpressed = new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent e) {
            PopupLogin();
        }
    };
    private final Action f1pressed = new AbstractAction(){
        @Override
        public void actionPerformed(ActionEvent evt){
            try {   
                if(UIManager.getLookAndFeel().toString().contains("FlatLightLaf")) {
                    UIManager.setLookAndFeel(new FlatDarkLaf());
                }
                else {
                    UIManager.setLookAndFeel(new FlatLightLaf());
                }
                SwingUtilities.updateComponentTreeUI(rootPane);
            }
            catch(UnsupportedLookAndFeelException e) {
                
            }
        }
    };
    
    public GUI() {
        initComponents();
        Name.requestFocus();
        rootPane.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(KeyStroke.getKeyStroke("F1"), "F1 pressed");
        rootPane.getActionMap().put("F1 pressed", f1pressed);
        try {
            Controller.Key();
        }
        catch(NoSuchAlgorithmException e) {}
        Populate();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LoginPopup = new javax.swing.JFrame();
        LPPanel = new javax.swing.JPanel();
        LPNameL = new javax.swing.JLabel();
        LPName = new javax.swing.JTextField();
        LPUsernameL = new javax.swing.JLabel();
        LPUsername = new javax.swing.JTextField();
        LPPasswordL = new javax.swing.JLabel();
        LPPassword = new javax.swing.JPasswordField();
        SMTPHostL = new javax.swing.JLabel();
        SMTPHost = new javax.swing.JTextField();
        IMAPHostL = new javax.swing.JLabel();
        IMAPHost = new javax.swing.JTextField();
        SMTPPortL = new javax.swing.JLabel();
        SMTPPort = new javax.swing.JTextField();
        IMAPPortL = new javax.swing.JLabel();
        IMAPPort = new javax.swing.JTextField();
        LPLoginB = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        LPSavePassword = new javax.swing.JCheckBox();
        Panel = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        Login = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        Name = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        Username = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        Password = new javax.swing.JPasswordField();
        LoginB = new javax.swing.JButton();
        SavePassword = new javax.swing.JCheckBox();
        ProgressBar = new javax.swing.JProgressBar();
        ProgressBar.setVisible(false);
        ProgressBar.setIndeterminate(true);
        ErrorMsg = new javax.swing.JTextField();
        ErrorMsg.setBorder(BorderFactory.createEmptyBorder());
        ErrorMsg.setVisible(false);

        LoginPopup.setTitle("Login");
        LoginPopup.setAlwaysOnTop(true);
        LoginPopup.setMinimumSize(new java.awt.Dimension(640, 360));
        LoginPopup.setResizable(false);
        LoginPopup.setType(java.awt.Window.Type.POPUP);
        LoginPopup.setLocationRelativeTo(null);

        LPPanel.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(KeyStroke.getKeyStroke("pressed ENTER"), "popup enter pressed");
        LPPanel.getActionMap().put("popup enter pressed", popupenterpressed);

        LPNameL.setLabelFor(LPName);
        LPNameL.setText("Your name:");

        LPUsernameL.setText("Email:");

        LPPasswordL.setText("Password:");

        SMTPHostL.setText("SMTP Host:");

        IMAPHostL.setText("IMAP HOST:");

        SMTPPortL.setText("SMTP Port:");

        IMAPPortL.setText("IMAP Port:");

        LPLoginB.setText("Login");
        LPLoginB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LPLoginBMouseClicked(evt);
            }
        });

        jTextField1.setEditable(false);
        jTextField1.setText("We can't automatically configure your mailbox, please provide additional information.");
        jTextField1.setBorder(null);
        jTextField1.setFocusable(false);

        LPSavePassword.setText("Save password");

        javax.swing.GroupLayout LPPanelLayout = new javax.swing.GroupLayout(LPPanel);
        LPPanel.setLayout(LPPanelLayout);
        LPPanelLayout.setHorizontalGroup(
            LPPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LPPanelLayout.createSequentialGroup()
                .addGap(93, 93, 93)
                .addGroup(LPPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(LPPanelLayout.createSequentialGroup()
                        .addComponent(LPSavePassword)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(LPLoginB)
                        .addGap(284, 284, 284))
                    .addGroup(LPPanelLayout.createSequentialGroup()
                        .addGroup(LPPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 456, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(LPPanelLayout.createSequentialGroup()
                                .addGroup(LPPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(LPPasswordL)
                                    .addComponent(LPUsernameL)
                                    .addComponent(LPNameL)
                                    .addComponent(LPName)
                                    .addComponent(LPUsername)
                                    .addComponent(LPPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(LPPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(LPPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(IMAPHost, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(SMTPHost, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, LPPanelLayout.createSequentialGroup()
                                            .addGroup(LPPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(SMTPPortL)
                                                .addComponent(SMTPPort, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(LPPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(LPPanelLayout.createSequentialGroup()
                                                    .addGap(10, 10, 10)
                                                    .addComponent(IMAPPortL))
                                                .addGroup(LPPanelLayout.createSequentialGroup()
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(IMAPPort)))))
                                    .addComponent(SMTPHostL)
                                    .addComponent(IMAPHostL))))
                        .addGap(93, 93, 93))))
        );
        LPPanelLayout.setVerticalGroup(
            LPPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LPPanelLayout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(LPPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LPNameL)
                    .addComponent(SMTPHostL))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(LPPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LPName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SMTPHost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(LPPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LPUsernameL)
                    .addComponent(IMAPHostL))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(LPPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LPUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(IMAPHost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(LPPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LPPasswordL)
                    .addComponent(SMTPPortL)
                    .addComponent(IMAPPortL))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(LPPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SMTPPort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(IMAPPort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LPPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(LPPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LPLoginB)
                    .addComponent(LPSavePassword))
                .addContainerGap(84, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout LoginPopupLayout = new javax.swing.GroupLayout(LoginPopup.getContentPane());
        LoginPopup.getContentPane().setLayout(LoginPopupLayout);
        LoginPopupLayout.setHorizontalGroup(
            LoginPopupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(LPPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        LoginPopupLayout.setVerticalGroup(
            LoginPopupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(LPPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(660, 400));

        Panel.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        Panel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Panel.setFocusable(false);
        Panel.setPreferredSize(new java.awt.Dimension(640, 360));
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

        jScrollPane1.setBorder(null);
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        jScrollPane1.setPreferredSize(new java.awt.Dimension(640, 327));

        Login.setPreferredSize(new java.awt.Dimension(640, 360));
        Login.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(KeyStroke.getKeyStroke("pressed ENTER"), "enter pressed");
        Login.getActionMap().put("enter pressed", enterpressed);

        jLabel3.setLabelFor(Name);
        jLabel3.setText("Your name:");

        jLabel1.setLabelFor(Password);
        jLabel1.setText("Email:");

        jLabel2.setLabelFor(Password);
        jLabel2.setText("Password:");

        LoginB.setText("Login");
        LoginB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LoginBMouseClicked(evt);
            }
        });

        SavePassword.setText("Save password");

        javax.swing.GroupLayout LoginLayout = new javax.swing.GroupLayout(Login);
        Login.setLayout(LoginLayout);
        LoginLayout.setHorizontalGroup(
            LoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LoginLayout.createSequentialGroup()
                .addContainerGap(211, Short.MAX_VALUE)
                .addGroup(LoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(LoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(Password, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addComponent(Username, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGroup(LoginLayout.createSequentialGroup()
                            .addComponent(SavePassword)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(LoginB))
                        .addComponent(Name)))
                .addContainerGap(211, Short.MAX_VALUE))
        );
        LoginLayout.setVerticalGroup(
            LoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LoginLayout.createSequentialGroup()
                .addContainerGap(63, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(LoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LoginB)
                    .addComponent(SavePassword))
                .addContainerGap(80, Short.MAX_VALUE))
        );

        ProgressBar.setMaximum(4);

        ErrorMsg.setEditable(false);
        ErrorMsg.setText("Couldn't connect to account");
        ErrorMsg.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        ErrorMsg.setFocusable(false);

        jLayeredPane1.setLayer(Login, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(ProgressBar, javax.swing.JLayeredPane.PALETTE_LAYER);
        jLayeredPane1.setLayer(ErrorMsg, javax.swing.JLayeredPane.PALETTE_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Login, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(ProgressBar, javax.swing.GroupLayout.DEFAULT_SIZE, 628, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(ErrorMsg, javax.swing.GroupLayout.DEFAULT_SIZE, 628, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Login, javax.swing.GroupLayout.DEFAULT_SIZE, 327, Short.MAX_VALUE)
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createSequentialGroup()
                    .addContainerGap(317, Short.MAX_VALUE)
                    .addComponent(ProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createSequentialGroup()
                    .addContainerGap(299, Short.MAX_VALUE)
                    .addComponent(ErrorMsg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );

        jScrollPane1.setViewportView(jLayeredPane1);

        Panel.addTab("Login", jScrollPane1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        Panel.getAccessibleContext().setAccessibleDescription("");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void LoginBMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LoginBMouseClicked
        Login();
    }//GEN-LAST:event_LoginBMouseClicked

    private void TabChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_TabChanged
        Controller.setSelectedtab(Panel.getSelectedIndex());
    }//GEN-LAST:event_TabChanged

    private void PanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelMouseClicked
        final int i = Panel.getUI().tabForCoordinate(Panel, evt.getX(), evt.getY());
        if(i != -1 && i != 0) {
            if(SwingUtilities.isMiddleMouseButton(evt)) {
                Controller.DeleteUser(i - 1);
                Panel.removeTabAt(i);
            }
        }
    }//GEN-LAST:event_PanelMouseClicked

    private void LPLoginBMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LPLoginBMouseClicked
        PopupLogin();
    }//GEN-LAST:event_LPLoginBMouseClicked
    
    private void Login() {
        if(!Username.getText().trim().equals("") && !Password.getText().equals("") && !Name.getText().equals("")) {
            if(Username.getText().contains("@gmail.com")) {
                Login(Username.getText().trim(), Password.getText(), Name.getText().trim(), "smtp.gmail.com", "587", "imap.gmail.com", "993", SavePassword.isSelected());
            }
            else if(Username.getText().contains("@yahoo.com")) {
                Login(Username.getText().trim(), Password.getText(), Name.getText().trim(), "smtp.mail.yahoo.com", "587", "imap.mail.yahoo.com", "993", SavePassword.isSelected());
            }
            else {
                LPName.setText(Name.getText());
                LPUsername.setText(Username.getText());
                LPPassword.setText(Password.getText());
                LPSavePassword.setSelected(SavePassword.isSelected());
                LoginPopup.setVisible(true);
            }
        }
    }
    
    private void PopupLogin() {
        LoginPopup.setVisible(false);
        if(!LPUsername.getText().trim().equals("") && !LPPassword.getText().equals("") && !LPName.getText().equals("") && !SMTPHost.getText().equals("") && !SMTPPort.getText().equals("") && !IMAPHost.getText().equals("") && !IMAPPort.getText().equals("")) {
            Login(LPUsername.getText().trim(), LPPassword.getText(), LPName.getText().trim(), SMTPHost.getText().trim(), SMTPPort.getText().trim(), IMAPHost.getText().trim(), IMAPPort.getText().trim(), LPSavePassword.isSelected());
        }
    }
    
    private void Login(String username, String password, String name, String smtphost, String smtpport, String imaphost, String imapport, boolean savepassword) {
        new Thread(() -> {
            ErrorMsg.setVisible(false);
            ProgressBar.setVisible(true);
            LoginB.setEnabled(false);
            switch (Controller.AddUser(username, password, name, smtphost, smtpport, imaphost, imapport, savepassword)) {
                case 0:
                    Panel.addTab(Username.getText(), Controller.users.get(Controller.getUsercount() - 1).getPanel());
                    Panel.setSelectedIndex(Panel.getTabCount()-1);
                    Controller.setSelectedtab(Panel.getSelectedIndex());
                    Username.setText("");
                    Password.setText("");
                    ProgressBar.setVisible(false);
                    LoginB.setEnabled(true);
                    break;
                case 1:
                    ProgressBar.setVisible(false);
                    ErrorMsg.setText("Couldn't connect to account");
                    ErrorMsg.setVisible(true);
                    LoginB.setEnabled(true);
                    break;
                case 2 :
                    ProgressBar.setVisible(false);
                    ErrorMsg.setText("User already exists");
                    ErrorMsg.setVisible(true);
                    LoginB.setEnabled(true);
                    break;
                default:
            }
        }).start();
    }
    
    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
            
        }
        catch(UnsupportedLookAndFeelException e) {
            System.err.println( "Failed to initialize LaF" );
        }

        java.awt.EventQueue.invokeLater(() -> {
            new GUI().setVisible(true);
        });
    }
    
    private void Populate() {
        for(User user : Controller.ReadSerialized()) {
            user.Populate();
            Panel.addTab(user.getUsername(), user.getPanel());
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ErrorMsg;
    private javax.swing.JTextField IMAPHost;
    private javax.swing.JLabel IMAPHostL;
    private javax.swing.JTextField IMAPPort;
    private javax.swing.JLabel IMAPPortL;
    private javax.swing.JButton LPLoginB;
    private javax.swing.JTextField LPName;
    private javax.swing.JLabel LPNameL;
    private javax.swing.JPanel LPPanel;
    private javax.swing.JPasswordField LPPassword;
    private javax.swing.JLabel LPPasswordL;
    private javax.swing.JCheckBox LPSavePassword;
    private javax.swing.JTextField LPUsername;
    private javax.swing.JLabel LPUsernameL;
    private javax.swing.JPanel Login;
    private javax.swing.JButton LoginB;
    private javax.swing.JFrame LoginPopup;
    private javax.swing.JTextField Name;
    private javax.swing.JTabbedPane Panel;
    private javax.swing.JPasswordField Password;
    private javax.swing.JProgressBar ProgressBar;
    private javax.swing.JTextField SMTPHost;
    private javax.swing.JLabel SMTPHostL;
    private javax.swing.JTextField SMTPPort;
    private javax.swing.JLabel SMTPPortL;
    private javax.swing.JCheckBox SavePassword;
    private javax.swing.JTextField Username;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
