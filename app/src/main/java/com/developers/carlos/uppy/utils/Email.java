package com.developers.carlos.uppy.utils;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * Created by carlos on 15/10/16.
 */

public class Email {

    private static Session session = null;
    private static final String CORREO = "carloscolmenarez200@gmail.com";
    private static final String CLAVE = "aqui va tu clave";


    private static void autenticar(){

        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        session = Session.getDefaultInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(CORREO, CLAVE);
            }
        });
    }

    public static boolean enviarCorreo(String destinatario, String tema, String mensaje){
        try{
            autenticar();
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("carloscolmenarez200@gmail.com"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinatario));
            message.setSubject(tema);
            message.setContent(mensaje, "text/html; charset=utf-8");
            Transport.send(message);
        } catch(MessagingException e) {
            e.printStackTrace();
            return false;
        } catch(Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
