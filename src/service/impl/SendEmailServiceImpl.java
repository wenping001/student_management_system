package service.impl;

import service.SendEmailService;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class SendEmailServiceImpl implements SendEmailService {
    @Override
    public void sendEmail(String email) {

        // Recipient's email ID needs to be mentioned.
        String to = email;

        // Sender's email ID needs to be mentioned
        String from = "wping_net@163.com";
        final String username = "wping_net@163.com";//change accordingly
        final String password = "FBBUWAVMRDHYSNZC";//change accordingly

        // Assuming you are sending email through relay.jangosmtp.net
        String host = "smtp.163.com";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "25");

        // Get the Session object.
        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {
            // Create a default MimeMessage object.
            Message message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(to));

            // Set Subject: header field
            message.setSubject("Testing Subject");

            // Now set the actual message
            message.setText("We heard that you lost your password. Sorry about that!\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "But don’t worry! You can use the following link to reset your password:\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "http://localhost:8080/reset_password?method=get&Email="+email+
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "Thanks,\n");

            // Send message
            Transport.send(message);


        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
