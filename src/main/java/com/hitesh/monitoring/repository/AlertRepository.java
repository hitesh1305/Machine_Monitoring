package com.hitesh.monitoring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.hitesh.monitoring.entity.Alert;

public interface AlertRepository extends JpaRepository<Alert, Long> {

    List<Alert> findByMachineId(Long machineId);

}
