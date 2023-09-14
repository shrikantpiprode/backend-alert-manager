package com.internal.alertmanager.service;

import com.internal.alertmanager.models.AlertRequest;
import com.internal.alertmanager.models.Alerts;
import com.internal.alertmanager.repository.AlertsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlertsService {

    @Autowired
    private  AlertsRepository alertsRepository;

   

    // Create a new Alerts entry
    public Alerts createAlerts(Alerts newAlerts) {
        return alertsRepository.save(newAlerts);
    }

    // Retrieve all Alerts entries
    public List<Alerts> getAllAlerts() {
        return alertsRepository.findAll();
    }

    // Retrieve an Alerts entry by ID
    public Optional<Alerts> getAlertsById(Long id) {
        return alertsRepository.findById(id);
    }

      // Update an existing Alerts entry
    public Alerts updateAlertsRequestFromGrap(AlertRequest alertRequest) {

        // Find the Alerts entity by alertId
        Alerts existingAlert = alertsRepository.findByAlertID(alertRequest.getAlertId());

        if (existingAlert != null) {
            // Update the timeStamp
            existingAlert.setCreatedtime(alertRequest.getTimeStamp());
            existingAlert.setCount(existingAlert.getCount() +1);

            // Save the updated entity
            return alertsRepository.save(existingAlert);
        } else {
            // Handle the case where the alertId is not found
            throw new RuntimeException("Alert with alertId " + alertRequest.getAlertId() + " not found.");
        }

    }

    // Update an existing Alerts entry
    public Alerts updateAlerts(Long id, Alerts updatedAlerts) {
        Optional<Alerts> existingAlertsOptional = alertsRepository.findById(id);

        if (existingAlertsOptional.isPresent()) {
            Alerts existingAlerts = existingAlertsOptional.get();
            // Update the fields of the existingAlerts with the values from updatedAlerts
            // Assuming you have appropriate setters in the Alerts class
            existingAlerts.setAlertID(updatedAlerts.getAlertID());
            existingAlerts.setCreatedtime(updatedAlerts.getCreatedtime());
            existingAlerts.setEnv(updatedAlerts.getEnv());
            existingAlerts.setCount(updatedAlerts.getCount());
            existingAlerts.setActive(updatedAlerts.isActive());
            existingAlerts.setSeverity(updatedAlerts.getSeverity());
            // Save the updated Alerts
            return alertsRepository.save(existingAlerts);
        } else {
            // Handle the case where the Alerts with the given ID doesn't exist
            throw new RuntimeException("Alerts with ID " + id + " not found.");
        }
    }

    // Delete an Alerts entry by ID
    public void deleteAlerts(Long id) {
        alertsRepository.deleteById(id);
    }
}
