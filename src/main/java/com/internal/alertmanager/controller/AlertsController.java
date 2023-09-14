package com.internal.alertmanager.controller;

import com.internal.alertmanager.models.AlertRequest;
import com.internal.alertmanager.models.Alerts;
import com.internal.alertmanager.models.TableView;
import com.internal.alertmanager.service.AlertsService;
import com.internal.alertmanager.service.TableViewService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/alerts")
public class AlertsController {

    @Autowired
    private AlertsService alertsService;
    @Autowired
    private  TableViewService tableViewService;
   

    @PostMapping
    public Alerts createAlerts(@RequestBody Alerts newAlerts) {
        return alertsService.createAlerts(newAlerts);
    }

    @GetMapping
    public List<Alerts> getAllAlerts() {
        return alertsService.getAllAlerts();
    }

    @GetMapping("/{id}")
    public Optional<Alerts> getAlertsById(@PathVariable Long id) {
        return alertsService.getAlertsById(id);
    }

    @PutMapping("/updateAlert")
    public Alerts updateAlerts(@RequestBody AlertRequest alertRequest) {
        return alertsService.updateAlertsRequestFromGrap(alertRequest);
    }

    
    @GetMapping("/get-data")
    public TableView getTableViewData() {
        return tableViewService.getData();
    }

    @DeleteMapping("/{id}")
    public void deleteAlerts(@PathVariable Long id) {
        alertsService.deleteAlerts(id);
    }
}
