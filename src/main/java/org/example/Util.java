package org.example;

import lombok.Getter;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.regex.Pattern;

public class Util {
    @Getter
    private static final Properties properties = new Properties();

    static {
        try (InputStream is = Util.class.getClassLoader()
                .getResourceAsStream("application.properties")){

            if (is == null) {
                System.out.println("Cannot find application.properties");
            } else {
                properties.load(is);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }

    public static Properties getSMTPConfig(){
        Properties config = new Properties();
        config.put("mail.smtp.auth", "true");
        config.put("mail.smtp.starttls.enable", "true");
        config.put("mail.smtp.host", "smtp.gmail.com");
        config.put("mail.smtp.port", "587");

        return config;
    }

    public static boolean isValidEmail(String email) {
        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        return Pattern.matches(regex, email);
    }

    public static JLabel createLabel(String text, Font font) {
        JLabel label = new JLabel(text);
        label.setFont(font);
        label.setForeground(new Color(50, 50, 50));
        return label;
    }

    public static void styleButton(JButton btn, Color bgColor, Color fgColor) {
        btn.setFont(new Font("SansSerif", Font.BOLD, 13));
        btn.setBackground(bgColor);
        btn.setForeground(fgColor);
        btn.setFocusPainted(false);
        btn.setBorderPainted(false);
        btn.setOpaque(true);
        btn.setPreferredSize(new Dimension(160, 35));
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));

        btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn.setBackground(bgColor.darker());
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn.setBackground(bgColor);
            }
        });
    }
}
