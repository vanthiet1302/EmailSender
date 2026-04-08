package org.example.domain.service;

import jakarta.mail.*;
import jakarta.mail.internet.*;
import org.example.Util;

import java.util.Properties;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class EmailSenderModel {

    public void sendEmail(String toEmail, String subject, String content, LocalDateTime targetTime) {
        Properties config = Util.getSMTPConfig();
        String fromEmail = Util.getProperty("app.email");
        String appPassword = Util.getProperty("app.password");
        long targetMillis = targetTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();

        Session session = Session.getInstance(config, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, appPassword);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(fromEmail));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));

            message.setSubject(subject);

            message.setContent(content, "text/plain; charset=UTF-8");

            System.out.println("Đang thực hiện bắt tay (handshake) với máy chủ Google...");

            Transport transport = session.getTransport("smtp");
            transport.connect(fromEmail, appPassword);

            System.out.println("Đường truyền đã mở! Đang chờ đến đúng " + targetTime + "...");

            while (System.currentTimeMillis() < targetMillis) {
                Thread.sleep(10);
            }

            transport.sendMessage(message, message.getAllRecipients());
            System.out.println("Đã phóng email thành công vào lúc: " + LocalDateTime.now());
            transport.close();
        } catch (Exception e) {
            System.err.println("Có lỗi xảy ra: " + e.getMessage());
            e.printStackTrace();
        }
    }
}