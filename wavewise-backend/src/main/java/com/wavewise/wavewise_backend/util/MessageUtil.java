package com.wavewise.wavewise_backend.util;

public class MessageUtil {

    public static String formatSafetyMessage(String status, String message) {

        StringBuilder result = new StringBuilder();

        result.append("Status: ");
        result.append(status);
        result.append(" | Message: ");
        result.append(message);

        return result.toString();
    }
}