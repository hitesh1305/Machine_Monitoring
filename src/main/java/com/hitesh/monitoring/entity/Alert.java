package com.hitesh.monitoring.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Alert {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long alertId;

    private Long machineId;

    private Long sensorId;

    private String message;

    private LocalDateTime timestamp;

    private int counter;

    // Constructors
    public Alert() {}

    public Alert(Long machineId, Long sensorId, String message, LocalDateTime timestamp, int counter) {
        this.machineId = machineId;
        this.sensorId = sensorId;
        this.message = message;
        this.timestamp = timestamp;
        this.counter = counter;
    }

    // Getters and Setters

    public Long getAlertId() {
        return alertId;
    }

    public Long getMachineId() {
        return machineId;
    }

    public void setMachineId(Long machineId) {
        this.machineId = machineId;
    }

    public Long getSensorId() {
        return sensorId;
    }

    public void setSensorId(Long sensorId) {
        this.sensorId = sensorId;
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