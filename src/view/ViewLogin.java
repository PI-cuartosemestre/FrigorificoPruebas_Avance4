/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import model.DAOUser;
import controller.NUser;
import javax.swing.JOptionPane;

public class ViewLogin extends javax.swing.JFrame {
   
    public ViewLogin() {
        initComponents();
        btnLogin.setEnabled(false);
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlBackGround = new javax.swing.JPanel();
        lblUser = new javax.swing.JLabel();
        lblPass = new javax.swing.JLabel();
        btnLogin = new javax.swing.JButton();
        txtPass = new javax.swing.JPasswordField();
        txtUser = new javax.swing.JTextField();
        lblBackGround = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Registrate");

        pnlBackGround.setBackground(new java.awt.Color(38, 35, 34));
        pnlBackGround.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblUser.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblUser.setForeground(new java.awt.Color(38, 35, 34));
        lblUser.setText("Usuario");
        pnlBackGround.add(lblUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 340, -1, -1));

        lblPass.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblPass.setForeground(new java.awt.Color(38, 35, 34));
        lblPass.setText("Contraseña");
        pnlBackGround.add(lblPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 400, -1, -1));

        btnLogin.setBackground(new java.awt.Color(255, 255, 255));
        btnLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/imgIngresar.png"))); // NOI18N
        btnLogin.setBorderPainted(false);
        btnLogin.setContentAreaFilled(false);
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        pnlBackGround.add(btnLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 460, 90, 30));

        txtPass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtPassMouseClicked(evt);
            }
        });
        txtPass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPassKeyPressed(evt);
            }
        });
        pnlBackGround.add(txtPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 420, 220, -1));

        txtUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtUserMouseClicked(evt);
            }
        });
        txtUser.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtUserKeyPressed(evt);
            }
        });
        pnlBackGround.add(txtUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 360, 220, -1));

        lblBackGround.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/imgLoginBg.PNG"))); // NOI18N
        pnlBackGround.add(lblBackGround, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 580, 590));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlBackGround, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlBackGround, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed

        /* VALIDADO EL USUARIO */
        NUser us = new NUser();
        DAOUser login = new DAOUser();      
        String pass = new String(txtPass.getPassword());
        
        /* VALIDAR CAJA TEXTOS */
        if (!txtUser.getText().equals("") && !pass.equals("")) {
            login.setUser(txtUser.getText());
            login.setPass(txtPass.getText());

            if (us.login(login)) {
                ViewPrincipalMenu x = new ViewPrincipalMenu(login);

                x.setVisible(true);

                dispose();

            } else {

                JOptionPane.showMessageDialog(this, "El usuario  o contraseña  es incorrecto", "Aviso..", JOptionPane.INFORMATION_MESSAGE);

            }

        } else {
            
            JOptionPane.showMessageDialog(this, "Debe ingresar los datos", "Aviso..", JOptionPane.INFORMATION_MESSAGE);
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_btnLoginActionPerformed

    private void txtUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtUserMouseClicked
           if (txtUser.getText().equals("") || txtPass.getText().equals("")) {           
            btnLogin.setEnabled(false);
        }
    }//GEN-LAST:event_txtUserMouseClicked

    private void txtPassMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtPassMouseClicked
        if (txtUser.getText().equals("") || txtPass.getText().equals("")) {           
            btnLogin.setEnabled(false);
        }
    }//GEN-LAST:event_txtPassMouseClicked

    private void txtPassKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPassKeyPressed
        if (!txtUser.getText().equals("") && !txtPass.getText().equals("")) {           
            btnLogin.setEnabled(true);
        }
    }//GEN-LAST:event_txtPassKeyPressed

    private void txtUserKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUserKeyPressed
        if (!txtUser.getText().equals("") && !txtPass.getText().equals("")) {
            
            btnLogin.setEnabled(true);
        }
    }//GEN-LAST:event_txtUserKeyPressed

    /**
     * @param args the command line arguments
     */
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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ViewLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewLogin().setVisible(true);
            }
        });
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JLabel lblBackGround;
    private javax.swing.JLabel lblPass;
    private javax.swing.JLabel lblUser;
    private javax.swing.JPanel pnlBackGround;
    private javax.swing.JPasswordField txtPass;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}
