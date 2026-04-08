package org.example;

import org.example.presentation.view.MainFrame;

import javax.swing.*;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        SwingUtilities.invokeLater(MainFrame::new);
    }
}
