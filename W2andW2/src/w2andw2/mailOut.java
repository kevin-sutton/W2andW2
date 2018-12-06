/////////////////////////////////////////////////////////////////////////////
//
//  Name: mailOut
//  Author: Kevin Sutton
//  Description: This class handles sending mail out from the application.
//
//  Fields:
//  Functions: static void sendOut(String subject, String content)
//  Parent:
//  Children:
//
/////////////////////////////////////////////////////////////////////////////

package w2andw2;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

/**
 *
 * @author Kevin
 */
public class mailOut {
    
    ///////////////////////////////////////////////////////////////////////////////
    //  Description: This function sends out mail.
    //
    //  Inputs: A string containing the subject line of the email
    //          A string containing the content of the email
    //
    //  Outputs: nothing
    ///////////////////////////////////////////////////////////////////////////////
    public static void sendOut(String subject, String content)
    {
        String to = "W2andW2.Submission@gmail.com";
        String from = "W2andW2.Output@gmail.com";
        
        String host = "smtp.gmail.com";
        
        Properties properties = System.getProperties();
        
        properties.setProperty("mail.smtp.host", host);
        properties.setProperty("mail.user", "W2andW2.Output@gmail.com");
        properties.setProperty("mail.password", "This is secure");
        properties.put("mail.smtp.starttls.enable", "true");
        
        Session session = Session.getDefaultInstance(properties);
        
        try
        {
            MimeMessage message = new MimeMessage(session);
            
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            
            message.setSubject(subject);
            message.setContent(content, "text/html");
            
            Transport.send(message);
            System.out.println("Message sent successfully");
        }
        catch (MessagingException e)
        {
            System.out.println("Failed to send message");
            System.out.println(e);
        }
        
        
    }
    
}