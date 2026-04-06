package org.example;

import lombok.Getter;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

@Getter
public class JakartaMailSenderUI extends JFrame {
    private JTextField toField;
    private JTextField subjectField;
    private JTextField timeField;
    private JTextArea bodyArea;
    private JButton connectBtn;
    private JButton sendBtn;
    private JLabel statusLabel;

    public JakartaMailSenderUI() {
        setTitle("Jakarta Mail - Advanced Email Sender v1.1");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(750, 550);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout(0, 5));
        mainPanel.setBorder(new EmptyBorder(15, 20, 10, 20));
        mainPanel.setBackground(new Color(245, 245, 245));

        JPanel inputPanel = createInputPanel();
        mainPanel.add(inputPanel, BorderLayout.CENTER);

        JPanel southPanel = createSouthPanel();
        mainPanel.add(southPanel, BorderLayout.SOUTH);

        add(mainPanel);
        setVisible(true);
    }

    private JPanel createInputPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(Color.WHITE);
        panel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(200, 200, 200)),
                new EmptyBorder(15, 15, 15, 15)));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 5, 8, 15);

        gbc.gridx = 0;
        gbc.weightx = 0;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.fill = GridBagConstraints.NONE;

        Font labelFont = new Font("SansSerif", Font.BOLD, 15);
        Font inputFont = new Font("Monospaced", Font.PLAIN, 13); // Font Monospaced như ảnh

        gbc.gridy = 0;
        panel.add(createLabel("✉ To:", labelFont), gbc);

        gbc.gridx = 1; gbc.weightx = 1.0; gbc.fill = GridBagConstraints.HORIZONTAL;
        toField = new JTextField("example@recipient.com");
        toField.setFont(inputFont);
        panel.add(toField, gbc);

        gbc.gridx = 0; gbc.gridy = 1; gbc.weightx = 0; gbc.fill = GridBagConstraints.NONE;
        panel.add(createLabel("🏷 Subject:", labelFont), gbc);

        gbc.gridx = 1; gbc.weightx = 1.0; gbc.fill = GridBagConstraints.HORIZONTAL;
        subjectField = new JTextField("Hello World Meeting Request");
        subjectField.setFont(inputFont);
        panel.add(subjectField, gbc);

        gbc.gridx = 0; gbc.gridy = 2; gbc.weightx = 0; gbc.fill = GridBagConstraints.NONE;
        panel.add(createLabel("🕒 Send Time:", labelFont), gbc);

        gbc.gridx = 1; gbc.weightx = 1.0; gbc.fill = GridBagConstraints.HORIZONTAL;
        timeField = new JTextField("2026-04-07T09:00:00 (Hanoi Time)");
        timeField.setFont(inputFont);
        panel.add(timeField, gbc);

        gbc.gridx = 0; gbc.gridy = 3; gbc.weightx = 0; gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.NORTHEAST; // Label nằm góc trên bên phải ô nhập
        panel.add(createLabel("Email Body:", labelFont), gbc);

        gbc.gridx = 1; gbc.gridy = 3; gbc.weightx = 1.0; gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        bodyArea = new JTextArea("Dear team,\n\nLet's connect at 9AM on Tuesday, April 7th...");
        bodyArea.setFont(new Font("SansSerif", Font.PLAIN, 13));
        bodyArea.setLineWrap(true);
        bodyArea.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(bodyArea);
        scrollPane.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200)));
        panel.add(scrollPane, gbc);

        return panel;
    }

    private JPanel createSouthPanel() {
        JPanel southPanel = new JPanel(new BorderLayout());
        southPanel.setBackground(new Color(245, 245, 245));

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 5));
        buttonPanel.setOpaque(false);

        connectBtn = new JButton("Connect Session");
        styleButton(connectBtn, new Color(139, 195, 74), Color.WHITE);
        buttonPanel.add(connectBtn);

        sendBtn = new JButton("Send Email");
        styleButton(sendBtn, new Color(33, 150, 243), Color.WHITE);
        buttonPanel.add(sendBtn);

        southPanel.add(buttonPanel, BorderLayout.NORTH);

        JPanel statusBar = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 2));
        statusBar.setBackground(Color.WHITE);
        statusBar.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, new Color(220, 220, 220)));

        statusLabel = new JLabel("Connected to SMTP (Persistent: 1.2s latent) | Ready");
        statusLabel.setFont(new Font("SansSerif", Font.PLAIN, 12));
        statusLabel.setForeground(new Color(80, 80, 80));
        statusBar.add(statusLabel);

        southPanel.add(statusBar, BorderLayout.SOUTH);

        return southPanel;
    }

    private JLabel createLabel(String text, Font font) {
        JLabel label = new JLabel(text);
        label.setFont(font);
        label.setForeground(new Color(50, 50, 50));
        return label;
    }

    private void styleButton(JButton btn, Color bgColor, Color fgColor) {
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

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        SwingUtilities.invokeLater(JakartaMailSenderUI::new);
    }
}