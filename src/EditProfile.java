import conn.plasmaCon;
import java.awt.Color;
import java.awt.event.KeyEvent;
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
public class EditProfile extends javax.swing.JFrame {

    /**
     * Creates new form EditProfile
     */
    String Loginid;
    plasmaCon c;
    
    public EditProfile() {
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
        lblHeading = new javax.swing.JLabel();
        panEdit = new javax.swing.JPanel();
        lblFname = new javax.swing.JLabel();
        lblLname = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        lblContact = new javax.swing.JLabel();
        txtFname = new javax.swing.JTextField();
        txtLname = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtContact = new javax.swing.JTextField();
        btnEnable = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnTp = new javax.swing.JButton();
        lblError1 = new javax.swing.JLabel();
        lblError2 = new javax.swing.JLabel();
        lblMain = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1364, 699));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        panMain.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblHeading.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        lblHeading.setForeground(new java.awt.Color(51, 255, 0));
        lblHeading.setText("Edit Profile");
        panMain.add(lblHeading, new org.netbeans.lib.awtextra.AbsoluteConstraints(637, 11, -1, -1));

        panEdit.setBorder(javax.swing.BorderFactory.createTitledBorder("Edit"));

        lblFname.setFont(new java.awt.Font("Yu Gothic", 1, 12)); // NOI18N
        lblFname.setText("First Name");

        lblLname.setFont(new java.awt.Font("Yu Gothic", 1, 12)); // NOI18N
        lblLname.setText("Last Name");

        lblEmail.setFont(new java.awt.Font("Yu Gothic", 1, 12)); // NOI18N
        lblEmail.setText("E-Mail Id");

        lblContact.setFont(new java.awt.Font("Yu Gothic", 1, 12)); // NOI18N
        lblContact.setText("Contact No.");

        txtFname.setEditable(false);

        txtLname.setEditable(false);

        txtEmail.setEditable(false);
        txtEmail.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtEmailFocusLost(evt);
            }
        });

        txtContact.setEditable(false);
        txtContact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContactActionPerformed(evt);
            }
        });
        txtContact.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtContactFocusLost(evt);
            }
        });
        txtContact.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtContactKeyTyped(evt);
            }
        });

        btnEnable.setFont(new java.awt.Font("Yu Gothic", 1, 12)); // NOI18N
        btnEnable.setText("Enable");
        btnEnable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnableActionPerformed(evt);
            }
        });

        btnUpdate.setFont(new java.awt.Font("Yu Gothic", 1, 12)); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        lblError2.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout panEditLayout = new javax.swing.GroupLayout(panEdit);
        panEdit.setLayout(panEditLayout);
        panEditLayout.setHorizontalGroup(
            panEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panEditLayout.createSequentialGroup()
                .addContainerGap(136, Short.MAX_VALUE)
                .addGroup(panEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panEditLayout.createSequentialGroup()
                        .addComponent(btnEnable, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panEditLayout.createSequentialGroup()
                        .addGroup(panEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panEditLayout.createSequentialGroup()
                                .addComponent(lblContact)
                                .addGap(23, 23, 23)
                                .addGroup(panEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblError2, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtContact, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(panEditLayout.createSequentialGroup()
                                .addGroup(panEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblFname)
                                    .addComponent(lblLname)
                                    .addComponent(lblEmail))
                                .addGap(28, 28, 28)
                                .addGroup(panEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblError1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(panEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(txtFname, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                                        .addComponent(txtLname, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtEmail, javax.swing.GroupLayout.Alignment.LEADING)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnTp, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(80, 80, 80))))
        );
        panEditLayout.setVerticalGroup(
            panEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panEditLayout.createSequentialGroup()
                .addComponent(btnEnable)
                .addGap(18, 18, 18)
                .addGroup(panEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFname)
                    .addComponent(txtFname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLname)
                    .addComponent(txtLname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEmail)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTp))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblError1)
                .addGap(26, 26, 26)
                .addGroup(panEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblContact)
                    .addComponent(txtContact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblError2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(btnUpdate)
                .addContainerGap())
        );

        panMain.add(panEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(449, 224, -1, 330));

        lblMain.setIcon(new javax.swing.ImageIcon(getClass().getResource("/plasma1.jpg"))); // NOI18N
        panMain.add(lblMain, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1360, 700));

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

    private void btnEnableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnableActionPerformed

        txtFname.setEditable(true);
        txtLname.setEditable(true);
        txtEmail.setEditable(true);
        txtContact.setEditable(true);
    }//GEN-LAST:event_btnEnableActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

        lblError2.setVisible(false);
//        panEdit.setVisible(false);

        c = new plasmaCon();
        int i = Integer.parseInt(Loginid);
//        JOptionPane.showMessageDialog(null, "LoginId = "+Loginid);
        String select = "", dbfname="", dblname="", dbemail="", dbcontact="", dbuname="", dbpass="";
        try
        {
            c.st = c.con.createStatement();
//            JOptionPane.showMessageDialog(null, "st create...");
            select = "select fname,lname,email_id,contactno from tbl_register where rid = "+i+"";
//            JOptionPane.showMessageDialog(null, "query write...");
            c.rs = c.st.executeQuery(select);
//            JOptionPane.showMessageDialog(null, "select query excecute...");
            
            while(c.rs.next())
            {
                dbfname = c.rs.getString("fname");
                dblname = c.rs.getString("lname");
                dbemail = c.rs.getString("email_id");
                dbcontact = c.rs.getString("contactno");
                
                txtFname.setText(dbfname);
                txtLname.setText(dblname);
                txtEmail.setText(dbemail);
                txtContact.setText(dbcontact);
            }
            c.con.close();
        }catch(Exception e){}
    }//GEN-LAST:event_formWindowOpened

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed

        String update="";
        int i = Integer.parseInt(Loginid);
        c = new plasmaCon();
        String fn="", ln="", email="", contact="";
        
        fn = txtFname.getText();
        ln = txtLname.getText();
        email = txtEmail.getText();
        contact = txtContact.getText();
        
        try
        {
            if((!fn.equals("")) && (!ln.equals("")) && (!email.equals("")) && (!contact.equals("")))
            {
                c.st = c.con.createStatement();
                update = "update tbl_register set fname = '"+fn+"', lname = '"+ln+"', email_id = '"+email+"', contactno = '"+contact+"' where rid = "+i+"";
                c.st.executeUpdate(update);
                JOptionPane.showMessageDialog(null, "Your profile has been updated...");

                c.con.close();

                dispose();
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Please insert all details...");
            }
        }catch(Exception e){}
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void txtEmailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEmailFocusLost

        String z = txtEmail.getText();
        lblError1.setText("");

        if(!z.equals(""))
        {
            if(!((z.contains(".com")) || (z.contains(".co.in")) && z.contains("@")))
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

    private void txtContactFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtContactFocusLost

        String contact = txtContact.getText();

        if(!contact.equals(""))
        {
            if(contact.length()<10 || contact.length()>10)
            {
                lblError2.setVisible(true);
                lblError2.setForeground(Color.red);
                lblError2.setText("Enter 10 Digit Number");
                txtContact.setBackground(Color.LIGHT_GRAY);
                txtContact.requestFocus();
            }
            else
            {
                lblError2.setVisible(false);
                lblError2.setText("");
                txtContact.setBackground(Color.WHITE);
            }                    
        }

    }//GEN-LAST:event_txtContactFocusLost

    private void txtContactKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtContactKeyTyped

        char c = evt.getKeyChar();
        if(!(Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE))
        {
            getToolkit().beep();
            evt.consume();
        }        
    }//GEN-LAST:event_txtContactKeyTyped

    private void txtContactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContactActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtContactActionPerformed

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
            java.util.logging.Logger.getLogger(EditProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditProfile().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEnable;
    private javax.swing.JButton btnTp;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel lblContact;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblError1;
    private javax.swing.JLabel lblError2;
    private javax.swing.JLabel lblFname;
    private javax.swing.JLabel lblHeading;
    private javax.swing.JLabel lblLname;
    private javax.swing.JLabel lblMain;
    private javax.swing.JPanel panEdit;
    private javax.swing.JPanel panMain;
    private javax.swing.JTextField txtContact;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtFname;
    private javax.swing.JTextField txtLname;
    // End of variables declaration//GEN-END:variables
}