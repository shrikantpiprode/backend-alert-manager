package com.internal.alertmanager.controller;

import com.internal.alertmanager.models.AlertsResolution;
import com.internal.alertmanager.service.AlertsResolutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/alerts-resolution")
public class AlertsResolutionController {

    @Autowired
    private  AlertsResolutionService alertsResolutionService;


 

    @PostMapping
    public AlertsResolution createAlertsResolution(@RequestBody AlertsResolution newAlertsResolution) {
        return alertsResolutionService.createAlertsResolution(newAlertsResolution);
    }

    @GetMapping
    public List<AlertsResolution> getAllAlertsResolutions() {
        return alertsResolutionService.getAllAlertsResolutions();
    }

    @GetMapping("/{id}")
    public Optional<AlertsResolution> getAlertsResolutionById(@PathVariable Long id) {
        return alertsResolutionService.getAlertsResolutionById(id);
    }

    @PutMapping("/{id}")
    public AlertsResolution updateAlertsResolution(@PathVariable Long id, @RequestBody AlertsResolution updatedAlertsResolution) {
        return alertsResolutionService.updateAlertsResolution(id, updatedAlertsResolution);
    }

    @DeleteMapping("/{id}")
    public void deleteAlertsResolution(@PathVariable Long id) {
        alertsResolutionService.deleteAlertsResolution(id);
    }
}
