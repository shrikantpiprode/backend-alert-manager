package com.internal.alertmanager.service;

import com.internal.alertmanager.models.AlertsResolution;
import com.internal.alertmanager.repository.AlertsResolutionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlertsResolutionService {

     @Autowired
    private  AlertsResolutionRepository alertsResolutionRepository;

  
    // Create a new AlertsResolution entry
    public AlertsResolution createAlertsResolution(AlertsResolution newAlertsResolution) {
        return alertsResolutionRepository.save(newAlertsResolution);
    }

    // Retrieve all AlertsResolution entries
    public List<AlertsResolution> getAllAlertsResolutions() {
        return alertsResolutionRepository.findAll();
    }

    // Retrieve an AlertsResolution entry by ID
    public Optional<AlertsResolution> getAlertsResolutionById(Long id) {
        return alertsResolutionRepository.findById(id);
    }

    // Update an existing AlertsResolution entry
    public AlertsResolution updateAlertsResolution(Long id, AlertsResolution updatedAlertsResolution) {
        Optional<AlertsResolution> existingAlertsResolutionOptional = alertsResolutionRepository.findById(id);

        if (existingAlertsResolutionOptional.isPresent()) {
            AlertsResolution existingAlertsResolution = existingAlertsResolutionOptional.get();
            // Update the fields of the existingAlertsResolution with the values from updatedAlertsResolution
            // Assuming you have appropriate setters in the AlertsResolution class
            existingAlertsResolution.setAlertID(updatedAlertsResolution.getAlertID());
            existingAlertsResolution.setResolution(updatedAlertsResolution.getResolution());
            existingAlertsResolution.setTeam(updatedAlertsResolution.getTeam());
            existingAlertsResolution.setContact(updatedAlertsResolution.getContact());
            // Save the updated AlertsResolution
            return alertsResolutionRepository.save(existingAlertsResolution);
        } else {
            // Handle the case where the AlertsResolution with the given ID doesn't exist
            throw new RuntimeException("AlertsResolution with ID " + id + " not found.");
        }
    }

    // Delete an AlertsResolution entry by ID
    public void deleteAlertsResolution(Long id) {
        alertsResolutionRepository.deleteById(id);
    }
}
