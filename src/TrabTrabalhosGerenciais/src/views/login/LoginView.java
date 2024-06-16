package views.login;

import java.net.URL;
import javax.swing.ImageIcon;
import java.awt.*;
import javax.swing.JLabel;
import views.main.MainView;

public class LoginView extends javax.swing.JFrame {

    public LoginView() {
        initComponents();  
        
        setLocationRelativeTo(getParent());
        URL urlIcon = getClass().getResource("/images/systemIcon.png");
        ImageIcon imageIcon = new ImageIcon(urlIcon);
        this.setIconImage(imageIcon.getImage());
        
        URL url = getClass().getResource("/images/Logo.png");
        ImageIcon originalIcon = new ImageIcon(url);
        Image scaledImage = originalIcon.getImage().getScaledInstance(400, 400, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        JLabel jLabel1 = new JLabel(scaledIcon);
        jLabel1.setHorizontalAlignment(JLabel.CENTER);
        jLabel1.setVerticalAlignment(JLabel.CENTER);
        this.jPanel1.setLayout(new BorderLayout());
        this.jPanel1.add(jLabel1, BorderLayout.CENTER);
        
        this.addIconsImages();

        this.jLabelDisabledPassword.setVisible(false);
        this.jLabelDisabledPassword.setEnabled(false);
    }
    
    private void addIconsImages(){
        addImage(this.jLabelUserIcon, "/images/Username.png");
        addImage(this.jLabelPasswordIcon, "/images/Password.png");
        addImage(this.jLabelShowPassword, "/images/showPassword.png");
        addImage(this.jLabelDisabledPassword, "/images/disabledPassword.png");
    }
    
    private void addImage(JLabel label, String filaPath){
        
        URL url = getClass().getResource(filaPath);
        ImageIcon originalIcon = new ImageIcon(url);
        Image scaledImage = originalIcon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        label.setIcon(scaledIcon);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jTextFieldUsername = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabelUserIcon = new javax.swing.JLabel();
        jLabelShowPassword = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jPasswordField = new javax.swing.JPasswordField();
        jPanel3 = new javax.swing.JPanel();
        jLabelAccess = new javax.swing.JLabel();
        jLabelPasswordIcon = new javax.swing.JLabel();
        jLabelDisabledPassword = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(217, 217, 217));
        jPanel1.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.setPreferredSize(new java.awt.Dimension(350, 739));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 350, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 826, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.WEST);

        jPanel2.setBackground(new java.awt.Color(173, 148, 100));
        jPanel2.setForeground(new java.awt.Color(0, 0, 0));
        jPanel2.setPreferredSize(new java.awt.Dimension(900, 826));

        jTextFieldUsername.setBackground(new java.awt.Color(173, 148, 100));
        jTextFieldUsername.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTextFieldUsername.setForeground(new java.awt.Color(217, 217, 217));
        jTextFieldUsername.setBorder(null);

        jLabelShowPassword.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabelShowPassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelShowPasswordMouseClicked(evt);
            }
        });

        jPasswordField.setBackground(new java.awt.Color(173, 148, 100));
        jPasswordField.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPasswordField.setForeground(new java.awt.Color(217, 217, 217));
        jPasswordField.setBorder(null);
        jPasswordField.setMinimumSize(new java.awt.Dimension(64, 16));

        jPanel3.setBackground(new java.awt.Color(173, 148, 100));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(217, 217, 217)));

        jLabelAccess.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabelAccess.setForeground(new java.awt.Color(217, 217, 217));
        jLabelAccess.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelAccess.setText("ACESSAR");
        jLabelAccess.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelAccess.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelAccessMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelAccess, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelAccess, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
        );

        jLabelDisabledPassword.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabelDisabledPassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelDisabledPasswordMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(268, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelPasswordIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelUserIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextFieldUsername)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelShowPassword, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelDisabledPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(269, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(250, 250, 250)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextFieldUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelUserIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelShowPassword, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                            .addComponent(jLabelDisabledPassword, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                            .addComponent(jLabelPasswordIcon, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(381, 381, 381))
        );

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabelDisabledPasswordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelDisabledPasswordMouseClicked
        this.jPasswordField.setEchoChar((char)8226);
        this.jLabelDisabledPassword.setVisible(false);
        this.jLabelDisabledPassword.setEnabled(false);
        this.jLabelShowPassword.setVisible(true);
        this.jLabelShowPassword.setVisible(true);
    }//GEN-LAST:event_jLabelDisabledPasswordMouseClicked

    private void jLabelShowPasswordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelShowPasswordMouseClicked
        this.jPasswordField.setEchoChar((char)0);
        this.jLabelDisabledPassword.setVisible(true);
        this.jLabelDisabledPassword.setEnabled(true);
        this.jLabelShowPassword.setVisible(false);
        this.jLabelShowPassword.setVisible(false);
    }//GEN-LAST:event_jLabelShowPasswordMouseClicked

    private void jLabelAccessMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelAccessMouseClicked
        this.dispose();
        
        MainView mainView = new MainView();
        mainView.setVisible(true);
    }//GEN-LAST:event_jLabelAccessMouseClicked

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabelAccess;
    private javax.swing.JLabel jLabelDisabledPassword;
    private javax.swing.JLabel jLabelPasswordIcon;
    private javax.swing.JLabel jLabelShowPassword;
    private javax.swing.JLabel jLabelUserIcon;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPasswordField jPasswordField;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField jTextFieldUsername;
    // End of variables declaration//GEN-END:variables
}
