package academy.ouaf.service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    //    public void sendEmailValidationToken(String to, String token) {
//        SimpleMailMessage message = new SimpleMailMessage();
//        message.setTo(to);
//        message.setSubject("Validation de votre compte PineApple Store");
//        message.setText("Merci de cliquer sur le lien suivant " +
//                "pour valider votre compte : http://localhost:8080/validate?token=" + token);
//        mailSender.send(message);
//    }
    public void sendEmailValidationToken(String to, String token) {
        try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");

            helper.setTo(to);
            helper.setSubject("Validation de votre compte PineApple Store");

            String htmlContent = """
                    <!DOCTYPE html>
                    <html>
                    <head>
                        <meta charset="UTF-8">
                        <style>
                            body {
                                font-family: Arial, sans-serif;
                                color: #333;
                                line-height: 1.6;
                            }
                            .container {
                                max-width: 600px;
                                margin: 0 auto;
                                padding: 20px;
                                border: 1px solid #ddd;
                                border-radius: 5px;
                            }
                            .header {
                                background-color: #007bff;
                                color: white;
                                padding: 15px;
                                text-align: center;
                                border-radius: 5px 5px 0 0;
                            }
                            .content {
                                padding: 20px;
                            }
                            .button {
                                display: inline-block;
                                background-color: #007bff;
                                color: white;
                                padding: 10px 20px;
                                text-decoration: none;
                                border-radius: 5px;
                                margin-top: 15px;
                            }
                            .footer {
                                text-align: center;
                                margin-top: 20px;
                                font-size: 12px;
                                color: #777;
                            }
                        </style>
                    </head>
                    <body>
                        <div class="container">
                            <div class="header">
                                <h1>PineApple Store</h1>
                            </div>
                            <div class="content">
                                <h2>Bonjour,</h2>
                                <p>Merci pour votre inscription au PineApple Store !</p>
                                <p>Pour finaliser votre inscription et accéder à tous nos services, veuillez cliquer sur le bouton ci-dessous :</p>
                                <div style="text-align: center;">
                                    <a href="http://localhost:8080/validate?token=%s" class="button">Valider mon compte</a>
                                </div>
                                <p>Si le bouton ne fonctionne pas, vous pouvez copier et coller le lien suivant dans votre navigateur :</p>
                                <p>http://localhost:8080/validate?token=%s</p>
                                <p>Ce lien est valable pendant 24 heures.</p>
                            </div>
                            <div class="footer">
                                <p>© 2023 PineApple Store - Tous droits réservés</p>
                                <p>Cet email a été envoyé automatiquement, merci de ne pas y répondre.</p>
                            </div>
                        </div>
                    </body>
                    </html>
                    """.formatted(token, token);

            helper.setText(htmlContent, true);
            mailSender.send(mimeMessage);
        } catch (MessagingException e) {
            throw new RuntimeException("Erreur lors de l'envoi de l'email de validation", e);
        }
    }


}
