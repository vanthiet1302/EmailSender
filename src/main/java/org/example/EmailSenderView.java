package org.example;

import javax.swing.*;
import java.awt.*;

public class EmailSenderView extends JFrame {

    public EmailSenderView() {
        init();
    }

    public void init() {
        JPanel main =  new JPanel();
        BorderLayout mainLayout = new BorderLayout();
        main.setLayout(mainLayout);
        main.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        add(BorderLayout.CENTER, main);

        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        main.add(topPanel, BorderLayout.NORTH);
        JLabel toLable = new JLabel("To: ");
        topPanel.add(toLable);

        JTextField toText = new JTextField();
        topPanel.add(toText);
        JButton sendButton = new JButton("Send");
        topPanel.add(sendButton);

        JPanel contentPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        main.add(contentPanel, BorderLayout.CENTER);
        JLabel subjectLabel = new JLabel("Subject:");
        contentPanel.add(subjectLabel);

        JTextArea subjectText = new JTextArea();
        contentPanel.add(subjectText);

        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        main.add(bottomPanel, BorderLayout.SOUTH);
        JLabel timeLabel = new JLabel("Time:");
        contentPanel.add(timeLabel);

        JTextField timeText = new JTextField(); // 2026-04-26T23:01:01
        bottomPanel.add(timeText);
    }

}
