import conn.plasmaCon;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Random;
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
 * @author Miti
 */
public class SendEmail {

    int randomNum;
    plasmaCon p = new plasmaCon();
    String ss1 = "", ss2 = "";
    public void connect() throws SQLException
    {
        String select = "";
        try
        {
            p.st = p.con.createStatement();
            select = "select email,emailpass from tbl_admin";
            p.rs = p.st.executeQuery(select);

            while(p.rs.next())
            {
                ss1 = p.rs.getString("email");
                ss2 = p.rs.getString("emailpass");
            }
            
        }catch(Exception e){}
        finally{
            p.rs.close();
            p.con.close();
        }

    }
    
    public Integer sendEmail(String em) throws SQLException
    {
        connect();
        
        if(!ss1.equals("") && !ss2.equals(""))
        {
            randomNum = 0;

            Properties props = new Properties();
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.port", "587");

            Random rn = new Random();
            int range = 9999 - 1 + 1000;
            randomNum =  rn.nextInt(range) + 1000;

            Session session = Session.getDefaultInstance(props,
                    new javax.mail.Authenticator() 
                    {
                        protected PasswordAuthentication getPasswordAuthentication()
                        {
                            return new PasswordAuthentication(ss1, ss2);
                        }
                    }
                );


            try
            {
                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress("mitisshah@gmail.com"));
                message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(em));
                message.setSubject("Forget Password");
                message.setText("Set new password by the given otp. Your otp is "+randomNum+".");
                JOptionPane.showMessageDialog(null, "message set");

                Transport.send(message);

                JOptionPane.showMessageDialog(null, "OTP sent successfully...!!!");
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null, e);
            }
                        
        }
        return randomNum;
    }
    
}
