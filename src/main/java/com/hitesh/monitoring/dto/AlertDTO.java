package com.hitesh.monitoring.dto;

import java.time.LocalDateTime;

public class AlertDTO {

    private Long alertId;
    private Long machineId;
    private String message;
    private LocalDateTime timestamp;
    private int counter;
    public Long getAlertId() {
        return alertId;
    }
    public void setAlertId(Long alertId) {
        this.alertId = alertId;
    }
    public Long getMachineId() {
        return machineId;
    }
    public void setMachineId(Long machineId) {
        this.machineId = machineId;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public LocalDateTime getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
    public int getCounter() {
        return counter;
    }
    public void setCounter(int counter) {
        this.counter = counter;
    }
}