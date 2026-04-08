package org.example.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmailSender {
    private String toEmail;
    private String subject;
    private String body;
    private LocalDateTime targetTime;
}
