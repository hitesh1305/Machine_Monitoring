package com.hitesh.monitoring.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.hitesh.monitoring.dto.AlertDTO;
import com.hitesh.monitoring.entity.Alert;
import com.hitesh.monitoring.repository.AlertRepository;


@Service
public class AlertService {
    private final AlertRepository alertRepository;
    
    public AlertService(AlertRepository alertRepository){
        this.alertRepository = alertRepository;
    }    
     public AlertDTO convertToDTO(Alert alert) {
        AlertDTO dto = new AlertDTO();
        dto.setAlertId(alert.getAlertId());
        dto.setMachineId(alert.getMachineId());
        dto.setMessage(alert.getMessage());
        dto.setTimestamp(alert.getTimestamp());
        dto.setCounter(alert.getCounter());
        return dto;
    }
    
    public Alert createAlert(Alert alert){
        alert.setTimestamp(LocalDateTime.now());
        return alertRepository.save(alert);
    }

    public List<AlertDTO> getAllAlerts() {
    List<Alert> alerts=  alertRepository.findAll();
    List<AlertDTO> dtoList = new ArrayList<>();
    for (Alert alert : alerts) {
        dtoList.add(convertToDTO(alert));
    }
    return dtoList;
    }

    public AlertDTO getAlertById(Long id) {
    Alert alert = alertRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Alert not found"));
        return convertToDTO(alert);
    }

    public List<AlertDTO> getAlertsByMachineId(Long machineId) {
        List <Alert> alerts = alertRepository.findByMachineId(machineId);
        List <AlertDTO> dtoList = new ArrayList<>();
        for (Alert alert : alerts) {
            dtoList.add(convertToDTO(alert));
        }
        return dtoList;
    }

    public void deleteAlert(Long id) {
        alertRepository.deleteById(id);
    }

   
}
