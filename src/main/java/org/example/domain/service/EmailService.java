package org.example.domain.service;

import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import org.example.Util;
import org.example.domain.model.EmailSender;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Properties;

public class EmailService {

    public void sendEmail(EmailSender emailSender) {
        validate(emailSender);

        Properties config = Util.getSMTPConfig();
        String fromEmail = Util.getProperty("app.email");
        String appPassword = Util.getProperty("app.password");
        long targetMillis = emailSender.getTargetTime().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();

        Session session = Session.getInstance(config, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, appPassword);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(fromEmail));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailSender.getToEmail()));

            message.setSubject(emailSender.getSubject());

            message.setContent(emailSender.getBody(), "text/plain; charset=UTF-8");

            System.out.println("Đang thực hiện bắt tay (handshake) với máy chủ Google...");

            Transport transport = session.getTransport("smtp");
            transport.connect(fromEmail, appPassword);

            System.out.println("Đường truyền đã mở! Đang chờ đến đúng " + emailSender.getTargetTime() + "...");

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


    private void validate(EmailSender email) {
        if (email.getToEmail() == null || email.getToEmail().isBlank()) {
            throw new IllegalArgumentException("Email không được để trống");
        }



        if (!email.getToEmail().matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
            throw new IllegalArgumentException("Email không hợp lệ");
        }
    }

}
