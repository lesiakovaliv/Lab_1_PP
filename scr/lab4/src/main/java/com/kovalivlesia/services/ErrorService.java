package com.kovalivlesia.services;

import lombok.SneakyThrows;
import lombok.extern.java.Log;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Log
public class ErrorService {

    private static String from = "lesia.kovaliv.knm.2019@lpnu.ua";
    private static String to = "lesia2512349@gmail.com";
    private static String password = "29.10.2002";


    @SneakyThrows
    public static void error(String err) {
        Properties props = new Properties();
        props.put("mail.smtp.port", "465");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(from, password);
                    }
                });

        MimeMessage message = new MimeMessage(session);
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
        message.setSubject("Error in coffee");
        message.setText(err);

        Transport.send(message);
        log.info("message sent successfully");
    }
}
