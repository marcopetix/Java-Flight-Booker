package p2.gui;

import p2.logic.App;

/**
 *
 * @author markp
 */
public class LoginForm extends javax.swing.JFrame {

    public LoginForm() {
        initComponents();
        this.setTitle("Client B - Login");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        login_panel = new javax.swing.JPanel();
        username_field = new javax.swing.JTextField();
        password_field = new javax.swing.JPasswordField();
        login_submit_button = new javax.swing.JButton();
        password_label = new javax.swing.JLabel();
        username_label = new javax.swing.JLabel();
        login_alert_label = new javax.swing.JLabel();
        register_label = new javax.swing.JLabel();
        sign_in_button = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        login_panel.setBackground(new java.awt.Color(26, 60, 160));
        login_panel.setPreferredSize(new java.awt.Dimension(270, 312));

        username_field.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        username_field.setPreferredSize(new java.awt.Dimension(60, 28));

        password_field.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        login_submit_button.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        login_submit_button.setText("Conferma");
        login_submit_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                login_submit_buttonMouseClicked(evt);
            }
        });

        password_label.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        password_label.setForeground(new java.awt.Color(255, 255, 255));
        password_label.setText("Password:");

        username_label.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        username_label.setForeground(new java.awt.Color(255, 255, 255));
        username_label.setText("Username:");

        login_alert_label.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        login_alert_label.setForeground(new java.awt.Color(255, 255, 0));

        register_label.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        register_label.setForeground(new java.awt.Color(255, 255, 255));
        register_label.setText("Non hai un account?");

        sign_in_button.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        sign_in_button.setText("Registrati");
        sign_in_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sign_in_buttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout login_panelLayout = new javax.swing.GroupLayout(login_panel);
        login_panel.setLayout(login_panelLayout);
        login_panelLayout.setHorizontalGroup(
            login_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(login_panelLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(login_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(login_alert_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(login_panelLayout.createSequentialGroup()
                        .addGroup(login_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(login_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(username_field, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(password_field)
                                .addComponent(login_submit_button, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                                .addComponent(password_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(username_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(login_panelLayout.createSequentialGroup()
                                .addComponent(register_label)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(sign_in_button)))
                        .addGap(0, 41, Short.MAX_VALUE)))
                .addContainerGap())
        );
        login_panelLayout.setVerticalGroup(
            login_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(login_panelLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(username_label)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(username_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(password_label)
                .addGap(5, 5, 5)
                .addComponent(password_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(login_submit_button)
                .addGap(32, 32, 32)
                .addComponent(login_alert_label, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(login_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(register_label)
                    .addComponent(sign_in_button))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(login_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(login_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void login_submit_buttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_login_submit_buttonMouseClicked
        String username = username_field.getText();
        String password = password_field.getText();
        String token = App.login_utente(username, password);
        if(token == null){
            login_alert_label.setText("Username e/o Password errati");
        }else{
            this.setVisible(false);
            new Interfaccia(token).setVisible(true);
        }
    }//GEN-LAST:event_login_submit_buttonMouseClicked

    private void sign_in_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sign_in_buttonActionPerformed
        java.awt.EventQueue.invokeLater(() -> {
            this.setVisible(false);
            new Sign_inForm().setVisible(true);
        });
    }//GEN-LAST:event_sign_in_buttonActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(() -> {
            new LoginForm().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel login_alert_label;
    private javax.swing.JPanel login_panel;
    private javax.swing.JButton login_submit_button;
    private javax.swing.JPasswordField password_field;
    private javax.swing.JLabel password_label;
    private javax.swing.JLabel register_label;
    private javax.swing.JButton sign_in_button;
    private javax.swing.JTextField username_field;
    private javax.swing.JLabel username_label;
    // End of variables declaration//GEN-END:variables
}
