package com.wavewise.wavewise_backend.util;

public class ValidationUtil {

    public static boolean isValidCoordinate(double latitude, double longitude) {

        return latitude >= -90 && latitude <= 90
                && longitude >= -180 && longitude <= 180;
    }

    public static boolean isValidDistance(double distance) {

        return distance > 0;
    }

    public static boolean isValidFuel(double fuel) {

        return fuel >= 0;
    }
}