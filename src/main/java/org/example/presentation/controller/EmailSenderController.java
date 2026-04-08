package org.example.presentation.controller;

import org.example.domain.service.EmailSenderModel;
import org.example.Util;
import org.example.presentation.view.MainFrame;

public class EmailSenderController {
    private MainFrame view;
    private EmailSenderModel model;

    public EmailSenderController(MainFrame view, EmailSenderModel model) {
        this.view = view;
        this.model = model;
    }

    private void validateEmail(String email) {
        if (email == null || email.isEmpty()) {
            throw new IllegalArgumentException("Email người nhận không được để trống");
        }

        if (!Util.isValidEmail(email)) {
            throw new IllegalArgumentException("Email không hợp lệ");
        }
    }
}
