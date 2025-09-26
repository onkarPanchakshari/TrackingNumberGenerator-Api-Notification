package io.github.onkarp.generator_api_notification.service;

import io.github.onkarp.generator_api_notification.dto.NotificationRequest;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {


    @Autowired
    private JavaMailSender mailSender;

    public void sendNotification(NotificationRequest request) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(request.customerEmail());
            message.setSubject("Your Tracking Number: " + request.trackingNumber());
            message.setText("Hello " + request.customerName() + ",\n\n" +
                    "Your order tracking number is: " + request.trackingNumber() + "\n\n" +
                    "Thank you for choosing us!");
            mailSender.send(message);

            System.out.println("Email sent successfully for tracking: " + request.trackingNumber());
        } catch (Exception e) {
            System.out.println("Failed to send email: " + e.getMessage());
        }
    }
}
