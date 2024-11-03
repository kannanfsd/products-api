package com.teammenz.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {
    @Async
    public void sendNotification(String message) {
        // Simulate sending a notification (e.g., email or SMS)
        System.out.println("Sending notification: " + message);
        // Add your notification logic here, such as calling an external service
    }
}
