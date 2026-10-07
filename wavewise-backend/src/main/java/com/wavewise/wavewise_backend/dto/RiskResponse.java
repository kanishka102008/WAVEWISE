package com.wavewise.wavewise_backend.dto;

public class RiskResponse {

    private int riskScore;
    private String riskLevel;
    private String recommendation;

    public RiskResponse() {
    }

    public RiskResponse(int riskScore, String riskLevel, String recommendation) {
        this.riskScore = riskScore;
        this.riskLevel = riskLevel;
        this.recommendation = recommendation;
    }

    public int getRiskScore() {
        return riskScore;
    }

    public void setRiskScore(int riskScore) {
        this.riskScore = riskScore;
    }

    public String getRiskLevel() {
        return riskLevel;
    }

    public void setRiskLevel(String riskLevel) {
        this.riskLevel = riskLevel;
    }

    public String getRecommendation() {
        return recommendation;
    }

    public void setRecommendation(String recommendation) {
        this.recommendation = recommendation;
    }
}