package io.github.onkarp.generator_api_notification.dto;

public record NotificationRequest(
            String trackingNumber,
            String customerName,
            String customerSlug,
            String customerEmail
    ) {}

