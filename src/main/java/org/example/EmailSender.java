package org.example;

import jakarta.mail.*;
import jakarta.mail.internet.*;

import java.time.LocalDate;
import java.util.Properties;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class EmailSender {

    public static void main(String[] args) {
        String myEmail = "thietvo02@gmail.com";
        String appPassword = "fknw bvhw hstn qivz";
        String teacherEmail = "phandinhlong@hcmuaf.edu.vn";

        LocalDateTime targetTime = LocalDateTime.of(2026, 4, 6, 23, 59, 58);
        long targetMillis = targetTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(myEmail, appPassword);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myEmail));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(teacherEmail));

            message.setSubject("Nhóm 19 - Ca 1 Thứ 2 - Đăng ký Seminar Topic 1");
            String content = """
                    Dạ em chào thầy,
                    
                    Chúng em là nhóm 19, học ca 1 ngày thứ 2. Chúng em viết email này xin phép được đăng ký seminar chủ đề Topic 1 (Session Tracking and User permission).
                    
                    Danh sách thành viên nhóm em bao gồm:
                    1. 23130314 - Võ Văn Thiệt
                    2. 23130300 - Phan Nguyễn Minh Thắng (Ca 1 thứ 3)
                    3. 21130572 - Trần Văn Toàn
                    
                    Chúng em rất mong nhận được cơ hội thử sức với Topic này. Thay mặt nhóm, em xin chân thành cảm ơn thầy.
                    
                    Chúc thầy có một ngày làm việc vui vẻ và hiệu quả ạ.
                    Trân trọng.
            """;
            message.setContent(content, "text/plain; charset=UTF-8");

            System.out.println("Đang thực hiện bắt tay (handshake) với máy chủ Google...");

            Transport transport = session.getTransport("smtp");
            transport.connect(myEmail, appPassword);

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