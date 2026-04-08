package org.example.presentation.view;


import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class MainFrame extends JFrame {

    public MainFrame() {

        setTitle("Email Sender - v1.1");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(750, 550);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout(0, 5));
        mainPanel.setBorder(new EmptyBorder(15, 20, 10, 20));
        mainPanel.setBackground(new Color(245, 245, 245));

        mainPanel.add(new InputPanel(), BorderLayout.CENTER);
        mainPanel.add(new SouthPanel(), BorderLayout.SOUTH);

        add(mainPanel);
        setVisible(true);
    }


}
