package com.hitesh.monitoring.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hitesh.monitoring.dto.AlertDTO;
import com.hitesh.monitoring.entity.Alert;
import com.hitesh.monitoring.service.AlertService;

@RestController
@RequestMapping("/alerts")
public class AlertController {

    private final AlertService alertService;

    public AlertController(AlertService alertService) {
        this.alertService = alertService;
    }

    @PostMapping
    public ResponseEntity<Alert> createAlert(@RequestBody Alert alert) {
        Alert savedAlert = alertService.createAlert(alert);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedAlert);
    }

    @GetMapping
    public List<AlertDTO> getAllAlerts() {
        return alertService.getAllAlerts();
    }

    @GetMapping("/{id}")
    public AlertDTO getAlertById(@PathVariable Long id) {
        return alertService.getAlertById(id);
    }

    @GetMapping("/machines/{machineId}/alerts")
    public List<AlertDTO> getAlertsByMachine(@PathVariable Long machineId) {
        return alertService.getAlertsByMachineId(machineId);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAlert(@PathVariable Long id) {
        alertService.deleteAlert(id);
        return ResponseEntity.noContent().build();
    }
}