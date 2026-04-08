package org.example.presentation.view;

import lombok.Getter;
import org.example.Util;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

@Getter
public class InputPanel extends JPanel {
    private JTextField toField;
    private JTextField subjectField;
    private JTextField timeField;
    private JTextArea bodyArea;
    
    public InputPanel() {
        setLayout( new GridBagLayout() );
        setBackground(Color.WHITE);
        setBorder(BorderFactory.createCompoundBorder(
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
        add(Util.createLabel("To:", labelFont), gbc);

        gbc.gridx = 1; gbc.weightx = 1.0; gbc.fill = GridBagConstraints.HORIZONTAL;
        toField = new JTextField("example@recipient.com");
        toField.setFont(inputFont);
        add(toField, gbc);

        gbc.gridx = 0; gbc.gridy = 1; gbc.weightx = 0; gbc.fill = GridBagConstraints.NONE;
        add(Util.createLabel("Subject:", labelFont), gbc);

        gbc.gridx = 1; gbc.weightx = 1.0; gbc.fill = GridBagConstraints.HORIZONTAL;
        subjectField = new JTextField("Hello World Meeting Request");
        subjectField.setFont(inputFont);
        add(subjectField, gbc);

        gbc.gridx = 0; gbc.gridy = 2; gbc.weightx = 0; gbc.fill = GridBagConstraints.NONE;
        add(Util.createLabel("Send Time:", labelFont), gbc);

        gbc.gridx = 1; gbc.weightx = 1.0; gbc.fill = GridBagConstraints.HORIZONTAL;
        timeField = new JTextField("2026-04-07T09:00:00 (Hanoi Time)");
        timeField.setFont(inputFont);
        add(timeField, gbc);

        gbc.gridx = 0; gbc.gridy = 3; gbc.weightx = 0; gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.NORTHEAST; // Label nằm góc trên bên phải ô nhập
        add(Util.createLabel("Email Body:", labelFont), gbc);

        gbc.gridx = 1; gbc.gridy = 3; gbc.weightx = 1.0; gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        bodyArea = new JTextArea("Dear team,\n\nLet's connect at 9AM on Tuesday, April 7th...");
        bodyArea.setFont(new Font("SansSerif", Font.PLAIN, 13));
        bodyArea.setLineWrap(true);
        bodyArea.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(bodyArea);
        scrollPane.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200)));
        add(scrollPane, gbc);
    }

    public String getToEmail() {
        return toField.getText();
    }

    public String getSubject() {
        return subjectField.getText();
    }


}
