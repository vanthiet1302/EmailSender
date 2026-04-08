package org.example.presentation.view;

import lombok.Data;
import lombok.Getter;
import org.example.Util;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

@Getter
public class SouthPanel extends JPanel {
    private JButton connectBtn;
    private JButton sendBtn;
    private JLabel statusLabel;
    
    public SouthPanel() {
        setLayout(new BorderLayout());
        setBackground(new Color(245, 245, 245));

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 5));
        buttonPanel.setOpaque(false);

        connectBtn = new JButton("Connect Session");
        Util.styleButton(connectBtn, new Color(139, 195, 74), Color.WHITE);
        buttonPanel.add(connectBtn);

        sendBtn = new JButton("Send Email");
        Util.styleButton(sendBtn, new Color(33, 150, 243), Color.WHITE);
        buttonPanel.add(sendBtn);

        add(buttonPanel, BorderLayout.NORTH);

        JPanel statusBar = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 2));
        statusBar.setBackground(Color.WHITE);
        statusBar.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, new Color(220, 220, 220)));

        statusLabel = new JLabel("Connected to SMTP (Persistent: 1.2s latent) | Ready");
        statusLabel.setFont(new Font("SansSerif", Font.PLAIN, 12));
        statusLabel.setForeground(new Color(80, 80, 80));
        statusBar.add(statusLabel);

        add(statusBar, BorderLayout.SOUTH);
    }

    public void addSendListener(ActionListener listener) {
        sendBtn.addActionListener(listener);
    }

    public void showError(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    public void showSuccess(String message) {
        JOptionPane.showMessageDialog(this, message);
    }
}
