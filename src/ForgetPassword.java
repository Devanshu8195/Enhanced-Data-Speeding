
import conn.plasmaCon;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Prital
 */
public class ForgetPassword extends javax.swing.JFrame {

    plasmaCon c;
    String dbrid = "", em;
    int randomNum;
    SendEmail sm = new SendEmail();
    
    /**
     * Creates new form ForgetPassword
     */
    public ForgetPassword() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panMain = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        panPersonal = new javax.swing.JPanel();
        lblEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        btnContinue = new javax.swing.JButton();
        lblError1 = new javax.swing.JLabel();
        lblError2 = new javax.swing.JLabel();
        lblErrorMain = new javax.swing.JLabel();
        panChange = new javax.swing.JPanel();
        lblNpass = new javax.swing.JLabel();
        lblCpass = new javax.swing.JLabel();
        txtCpass = new javax.swing.JPasswordField();
        txtNpass = new javax.swing.JPasswordField();
        btnUpdate = new javax.swing.JButton();
        lblError3 = new javax.swing.JLabel();
        lblError4 = new javax.swing.JLabel();
        lblOtp = new javax.swing.JLabel();
        txtOtp = new javax.swing.JTextField();
        btnResend = new javax.swing.JButton();
        btnSubmit = new javax.swing.JButton();
        lblError5 = new javax.swing.JLabel();
        btnLogin = new javax.swing.JButton();
        lblImage = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        panMain.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 255, 0));
        jLabel1.setText("Forget Password");
        panMain.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(572, 11, -1, -1));

        panPersonal.setBorder(javax.swing.BorderFactory.createTitledBorder("Personal Details"));

        lblEmail.setFont(new java.awt.Font("Yu Gothic", 1, 12)); // NOI18N
        lblEmail.setText("E-Mail Id");

        txtEmail.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtEmailFocusLost(evt);
            }
        });

        btnContinue.setFont(new java.awt.Font("Yu Gothic", 1, 12)); // NOI18N
        btnContinue.setText("Continue");
        btnContinue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnContinueActionPerformed(evt);
            }
        });

        lblErrorMain.setForeground(new java.awt.Color(255, 0, 0));
        lblErrorMain.setText("Please Enter Correct Details...");

        javax.swing.GroupLayout panPersonalLayout = new javax.swing.GroupLayout(panPersonal);
        panPersonal.setLayout(panPersonalLayout);
        panPersonalLayout.setHorizontalGroup(
            panPersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panPersonalLayout.createSequentialGroup()
                .addGap(258, 258, 258)
                .addComponent(btnContinue, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panPersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblError2, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblError1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(50, Short.MAX_VALUE))
            .addGroup(panPersonalLayout.createSequentialGroup()
                .addGroup(panPersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panPersonalLayout.createSequentialGroup()
                        .addGap(133, 133, 133)
                        .addComponent(lblEmail)
                        .addGap(27, 27, 27)
                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panPersonalLayout.createSequentialGroup()
                        .addGap(221, 221, 221)
                        .addComponent(lblErrorMain, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panPersonalLayout.setVerticalGroup(
            panPersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panPersonalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblErrorMain, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panPersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEmail))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblError1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panPersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblError2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnContinue))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        panMain.add(panPersonal, new org.netbeans.lib.awtextra.AbsoluteConstraints(391, 127, 620, 150));

        panChange.setBorder(javax.swing.BorderFactory.createTitledBorder("Change Password"));

        lblNpass.setFont(new java.awt.Font("Yu Gothic", 1, 12)); // NOI18N
        lblNpass.setText("New Password");

        lblCpass.setFont(new java.awt.Font("Yu Gothic", 1, 12)); // NOI18N
        lblCpass.setText("Confirm Password");

        txtCpass.setEnabled(false);
        txtCpass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCpassActionPerformed(evt);
            }
        });
        txtCpass.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCpassFocusLost(evt);
            }
        });

        txtNpass.setEnabled(false);
        txtNpass.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNpassFocusLost(evt);
            }
        });
        txtNpass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNpassKeyReleased(evt);
            }
        });

        btnUpdate.setFont(new java.awt.Font("Yu Gothic", 1, 12)); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.setEnabled(false);
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        lblError4.setForeground(new java.awt.Color(255, 0, 0));
        lblError4.setText("Password Does not match...");

        lblOtp.setFont(new java.awt.Font("Yu Gothic", 1, 12)); // NOI18N
        lblOtp.setText("Enter OTP");

        btnResend.setFont(new java.awt.Font("Yu Gothic", 1, 12)); // NOI18N
        btnResend.setText("Re-send OTP");
        btnResend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResendActionPerformed(evt);
            }
        });

        btnSubmit.setFont(new java.awt.Font("Yu Gothic", 1, 12)); // NOI18N
        btnSubmit.setText("Submit");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });

        lblError5.setForeground(new java.awt.Color(255, 0, 0));
        lblError5.setText("Please enter correct OTP...");

        javax.swing.GroupLayout panChangeLayout = new javax.swing.GroupLayout(panChange);
        panChange.setLayout(panChangeLayout);
        panChangeLayout.setHorizontalGroup(
            panChangeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panChangeLayout.createSequentialGroup()
                .addContainerGap(141, Short.MAX_VALUE)
                .addGroup(panChangeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblError4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panChangeLayout.createSequentialGroup()
                        .addComponent(lblCpass)
                        .addGap(18, 18, 18)
                        .addComponent(txtCpass, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panChangeLayout.createSequentialGroup()
                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(97, 97, 97))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panChangeLayout.createSequentialGroup()
                        .addGroup(panChangeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panChangeLayout.createSequentialGroup()
                                .addComponent(lblOtp)
                                .addGap(72, 72, 72))
                            .addGroup(panChangeLayout.createSequentialGroup()
                                .addComponent(lblNpass)
                                .addGap(18, 18, 18)))
                        .addGroup(panChangeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblError3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panChangeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtNpass, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                .addComponent(txtOtp))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panChangeLayout.createSequentialGroup()
                        .addComponent(btnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnResend)))
                .addGap(195, 195, 195))
            .addGroup(panChangeLayout.createSequentialGroup()
                .addGap(233, 233, 233)
                .addComponent(lblError5, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panChangeLayout.setVerticalGroup(
            panChangeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panChangeLayout.createSequentialGroup()
                .addComponent(lblError5)
                .addGap(8, 8, 8)
                .addGroup(panChangeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblOtp)
                    .addComponent(txtOtp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(panChangeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSubmit)
                    .addComponent(btnResend))
                .addGap(18, 18, 18)
                .addGroup(panChangeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNpass)
                    .addComponent(txtNpass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblError3, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panChangeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCpass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCpass))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblError4)
                .addGap(28, 28, 28)
                .addComponent(btnUpdate)
                .addGap(21, 21, 21))
        );

        panMain.add(panChange, new org.netbeans.lib.awtextra.AbsoluteConstraints(391, 302, 630, 290));

        btnLogin.setText("Login");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        panMain.add(btnLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(1240, 30, 90, -1));

        lblImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/plasma1.jpg"))); // NOI18N
        panMain.add(lblImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 700));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

        lblError5.setVisible(false);
        lblErrorMain.setVisible(false);
        panChange.setVisible(false);
        lblError4.setVisible(false);
    }//GEN-LAST:event_formWindowOpened

    private void btnContinueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnContinueActionPerformed

        em = "";
        lblErrorMain.setVisible(false);
        String select = "", dbem = "", dbco = "";
        em = txtEmail.getText();
//        String co = txtContact.getText();
        int count = 0;
        
        try
        {
            if(!em.equals(""))
            {
                c = new plasmaCon();
                c.st = c.con.createStatement();
                select = "select rid,email_id from tbl_register";
                c.rs = c.st.executeQuery(select);

                while(c.rs.next())
                {

                    dbem = c.rs.getString("email_id");
//                    dbco = c.rs.getString("contactno");

                    if(em.equals(dbem))
                    {
                        dbrid = c.rs.getString("Rid");
                        panPersonal.setVisible(true);
                        panChange.setVisible(false);
                        randomNum = sm.sendEmail(em);
                        count++;
                    }

                }
                if(count == 0)
                {
    //                JOptionPane.showMessageDialog(null, "count is Zero...:P");
                    panChange.setVisible(false);
                    lblErrorMain.setVisible(true);
                    panPersonal.setVisible(true);
                }
                else
                {
                    panPersonal.setVisible(false);
                    panChange.setVisible(true);
                }
                c.con.close();
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Please Enter All Details...");
            }
        }catch(Exception e){}
        
        
//        JOptionPane.showMessageDialog(null, "Id = "+dbrid+"");

    }//GEN-LAST:event_btnContinueActionPerformed

    
    
    
    private void txtEmailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEmailFocusLost

        String z = txtEmail.getText();
        lblError1.setVisible(false);
        
        if(!z.equals(""))
        {
            if(!(((z.contains("gmail.com")) || (z.contains("yahoo.com")) || (z.contains("gmail.co.in")) || (z.contains("yahoo.co.in")) ) && z.contains("@")))
            {
                lblError1.setVisible(true);
                lblError1.setText("Please Insert Correct Email Id...");
                lblError1.setForeground(Color.red);
                txtEmail.requestFocus();
                txtEmail.setBackground(Color.LIGHT_GRAY);
            }
            else
            {
                lblError1.setText("");
                txtEmail.setBackground(Color.white);
            }
            
        }

    }//GEN-LAST:event_txtEmailFocusLost

    private void txtNpassFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNpassFocusLost

        int i = txtNpass.getText().length();
        
        if(i<=6)
        {
            txtNpass.requestFocus();
        }
        else
        {
            lblError3.setVisible(false);
        }
        
    }//GEN-LAST:event_txtNpassFocusLost

    private void txtCpassFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCpassFocusLost

        String pass = null, cpass = null;
        pass = txtNpass.getText();
        cpass = txtCpass.getText();
        
        if(cpass.equals(""))
        {
            lblError4.setVisible(false);
        }
        else if(!pass.equals(cpass))
        {
            lblError4.setVisible(true);
            txtNpass.requestFocus();
        }
        else
        {
            lblError4.setVisible(false);
        }        
    }//GEN-LAST:event_txtCpassFocusLost

    private void txtCpassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCpassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCpassActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed

        String update = "";
        String npass = txtNpass.getText();
        String cpass = txtCpass.getText();
        int i = Integer.parseInt(dbrid);
        
        try
        {
            if((!npass.equals("")) && (!cpass.equals("")))
            {
                if(cpass.equals(npass))
                {
                    c = new plasmaCon();
                    c.st = c.con.createStatement();
                    update = "update tbl_register set password = '"+npass+"' where rid = "+i+"";
//                    JOptionPane.showMessageDialog(null, "query write...");
                    c.st.executeUpdate(update);
                    JOptionPane.showMessageDialog(null, "Your Password has been Updated...");

                    c.con.close();

                    dispose();
                    Login l = new Login();
                    l.setVisible(true);
                }
            }
            else
            {
                JOptionPane.showMessageDialog(null, "please insert all details...");
            }
        }catch(Exception e){}
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void txtNpassKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNpassKeyReleased

        lblError3.setVisible(true);
        String s = txtNpass.getText();
        if(s.length() <= 6)
        {
            lblError3.setText("Weak Password...");
            lblError3.setForeground(Color.red);
        }
        else
        {
            lblError3.setText("Strong Password...");
            lblError3.setForeground(Color.GREEN);
        }        
    }//GEN-LAST:event_txtNpassKeyReleased

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed

        dispose();
        Login l = new Login();
        l.setVisible(true);
    }//GEN-LAST:event_btnLoginActionPerformed

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed

        lblError5.setVisible(false);
        int otp = Integer.parseInt(txtOtp.getText());
        if(otp==randomNum)
        {
            txtNpass.setEnabled(true);
            txtCpass.setEnabled(true);
            btnUpdate.setEnabled(true);
            btnSubmit.setEnabled(false);
            btnResend.setEnabled(false);
            txtOtp.setEnabled(false);
        }
        else
        {
            lblError5.setVisible(true);
        }
    }//GEN-LAST:event_btnSubmitActionPerformed

    private void btnResendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResendActionPerformed

            try {
                sm.sendEmail(em);
            } catch (SQLException ex) {
                Logger.getLogger(ForgetPassword.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }//GEN-LAST:event_btnResendActionPerformed

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
            java.util.logging.Logger.getLogger(ForgetPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ForgetPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ForgetPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ForgetPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ForgetPassword().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnContinue;
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnResend;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblCpass;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblError1;
    private javax.swing.JLabel lblError2;
    private javax.swing.JLabel lblError3;
    private javax.swing.JLabel lblError4;
    private javax.swing.JLabel lblError5;
    private javax.swing.JLabel lblErrorMain;
    private javax.swing.JLabel lblImage;
    private javax.swing.JLabel lblNpass;
    private javax.swing.JLabel lblOtp;
    private javax.swing.JPanel panChange;
    private javax.swing.JPanel panMain;
    private javax.swing.JPanel panPersonal;
    private javax.swing.JPasswordField txtCpass;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JPasswordField txtNpass;
    private javax.swing.JTextField txtOtp;
    // End of variables declaration//GEN-END:variables
}
