package com.internal.alertmanager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.internal.alertmanager.models.Alerts;
import com.internal.alertmanager.models.AlertsResolution;
import com.internal.alertmanager.models.TableView;
import com.internal.alertmanager.repository.AlertsRepository;
import com.internal.alertmanager.repository.AlertsResolutionRepository;

@Service
public class TableViewService {

    @Autowired
    private  AlertsRepository alertsRepository;
    @Autowired
    private  AlertsResolutionRepository alertsResolutionRepository;

   
    public TableView getData() {
        TableView tableView = new TableView();

        // Fetch data from the Alerts table based on alertId
        List<Alerts> alert = alertsRepository.findAll();
        
        // Fetch data from the AlertsResolution table based on alertId
        List<AlertsResolution> alertsResolution = alertsResolutionRepository.findAll();

        tableView.setAlert(alert);
        tableView.setAlertsResolution(alertsResolution);

        return tableView;
    }
}
