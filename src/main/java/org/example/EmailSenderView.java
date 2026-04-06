package org.example;

import javax.swing.*;
import java.awt.*;

public class EmailSenderView extends JFrame {

    public EmailSenderView() {
        setTitle("Email Sender");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(550, 450);
        init();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void init() {
        JPanel mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridx = 0; gbc.gridy = 0;
        mainPanel.add(new JLabel("To:"), gbc);

        gbc.gridx = 1; gbc.weightx = 1.0;
        JTextField toText = new JTextField();
        mainPanel.add(toText, gbc);

        gbc.gridx = 0; gbc.gridy = 1; gbc.weightx = 0;
        mainPanel.add(new JLabel("Subject:"), gbc);

        gbc.gridx = 1; gbc.weightx = 1.0;
        JTextField subjectText = new JTextField();
        mainPanel.add(subjectText, gbc);

        gbc.gridx = 0; gbc.gridy = 2;
        mainPanel.add(new JLabel("Message:"), gbc);

        gbc.gridx = 1; gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        JTextArea messageBody = new JTextArea();
        mainPanel.add(new JScrollPane(messageBody), gbc);

        gbc.gridx = 0; gbc.gridy = 3; gbc.weighty = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        mainPanel.add(new JLabel("Time:"), gbc);

        gbc.gridx = 1;
        JTextField timeText = new JTextField("2026-04-26T23:01:01");
        mainPanel.add(timeText, gbc);

        JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton btnConnect = new JButton("Connect");
        JButton btnSend = new JButton("Send Email");
        btnSend.setBackground(new Color(0, 123, 255));
        btnSend.setForeground(Color.WHITE);

        btnPanel.add(btnConnect);
        btnPanel.add(btnSend);

        gbc.gridx = 0; gbc.gridy = 4; gbc.gridwidth = 2;
        mainPanel.add(btnPanel, gbc);

        add(mainPanel);
    }
}