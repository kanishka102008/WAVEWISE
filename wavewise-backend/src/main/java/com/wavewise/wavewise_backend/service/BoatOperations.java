package com.wavewise.wavewise_backend.service;

public abstract class BoatOperations {

    public abstract String getOperationType();

    public String getSystemMessage() {
        return "WaveWise boat operation system is active.";
    }
}