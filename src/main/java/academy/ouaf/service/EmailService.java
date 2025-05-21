//package academy.ouaf.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.mail.SimpleMailMessage;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.mail.javamail.MimeMessageHelper;
//import org.springframework.stereotype.Service;
//
//import jakarta.mail.MessagingException;
//import jakarta.mail.internet.MimeMessage;
//
//@Service
//public class EmailService {
//
//    @Autowired
//    private JavaMailSender mailSender;
//
//    public void sendEmailValidationToken(String to, String token) {
//        try {
//            MimeMessage mimeMessage = mailSender.createMimeMessage();
//            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
//
//            helper.setTo(to);
//            helper.setSubject("Validation de votre compte OUAF");
//
//            String htmlContent = """
//                    <!DOCTYPE html>
//                    <html>
//                    <head>
//                        <meta charset="UTF-8">
//                        <style>
//                            body {
//                                font-family: Arial, sans-serif;
//                                color: #333;
//                                line-height: 1.6;
//                            }
//                            .container {
//                                max-width: 600px;
//                                margin: 0 auto;
//                                padding: 20px;
//                                border: 1px solid #ddd;
//                                border-radius: 5px;
//                            }
//                            .header {
//                                background-color: #007bff;
//                                color: white;
//                                padding: 15px;
//                                text-align: center;
//                                border-radius: 5px 5px 0 0;
//                            }
//                            .content {
//                                padding: 20px;
//                            }
//                            .button {
//                                display: inline-block;
//                                background-color: #007bff;
//                                color: white;
//                                padding: 10px 20px;
//                                text-decoration: none;
//                                border-radius: 5px;
//                                margin-top: 15px;
//                            }
//                            .footer {
//                                text-align: center;
//                                margin-top: 20px;
//                                font-size: 12px;
//                                color: #777;
//                            }
//                        </style>
//                    </head>
//                    <body>
//                        <div class="container">
//                            <div class="header">
//                                <h1>OUAF</h1>
//                            </div>
//                            <div class="content">
//                                <h2>Bonjour,</h2>
//                                <p>Merci pour votre inscription à OUAF !</p>
//                                <p>Pour finaliser votre inscription et accéder à tous nos services, veuillez cliquer sur le bouton ci-dessous :</p>
//                                <div style="text-align: center;">
//                                    <a href="http://localhost:4200/validate-email/%s" class="button">Valider mon compte</a>
//                                </div>
//                                <p>Si le bouton ne fonctionne pas, vous pouvez copier et coller le lien suivant dans votre navigateur :</p>
//                                <p>http://localhost:4200/validate-email/%s</p>
//                                <p>Ce lien est valable pendant 24 heures.</p>
//                            </div>
//                            <div class="footer">
//                                <p>© 2023 OUAF - Tous droits réservés</p>
//                                <p>Cet email a été envoyé automatiquement, merci de ne pas y répondre.</p>
//                            </div>
//                        </div>
//                    </body>
//                    </html>
//                    """.formatted(token, token);
//
//            helper.setText(htmlContent, true);
//            mailSender.send(mimeMessage);
//        } catch (MessagingException e) {
//            throw new RuntimeException("Erreur lors de l'envoi de l'email de validation", e);
//        }
//    }
//}
