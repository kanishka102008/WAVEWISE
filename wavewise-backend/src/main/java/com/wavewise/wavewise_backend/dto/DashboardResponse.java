package com.wavewise.wavewise_backend.dto;

public class DashboardResponse {

    private long totalUsers;
    private long totalBoats;
    private long activeEmergencies;
    private int safeWeatherZones;
    private int highRiskZones;
    private String systemStatus;

    public DashboardResponse() {
    }

    public DashboardResponse(long totalUsers,
                             long totalBoats,
                             long activeEmergencies,
                             int safeWeatherZones,
                             int highRiskZones,
                             String systemStatus) {
        this.totalUsers = totalUsers;
        this.totalBoats = totalBoats;
        this.activeEmergencies = activeEmergencies;
        this.safeWeatherZones = safeWeatherZones;
        this.highRiskZones = highRiskZones;
        this.systemStatus = systemStatus;
    }

    public long getTotalUsers() {
        return totalUsers;
    }

    public void setTotalUsers(long totalUsers) {
        this.totalUsers = totalUsers;
    }

    public long getTotalBoats() {
        return totalBoats;
    }

    public void setTotalBoats(long totalBoats) {
        this.totalBoats = totalBoats;
    }

    public long getActiveEmergencies() {
        return activeEmergencies;
    }

    public void setActiveEmergencies(long activeEmergencies) {
        this.activeEmergencies = activeEmergencies;
    }

    public int getSafeWeatherZones() {
        return safeWeatherZones;
    }

    public void setSafeWeatherZones(int safeWeatherZones) {
        this.safeWeatherZones = safeWeatherZones;
    }

    public int getHighRiskZones() {
        return highRiskZones;
    }

    public void setHighRiskZones(int highRiskZones) {
        this.highRiskZones = highRiskZones;
    }

    public String getSystemStatus() {
        return systemStatus;
    }

    public void setSystemStatus(String systemStatus) {
        this.systemStatus = systemStatus;
    }
}