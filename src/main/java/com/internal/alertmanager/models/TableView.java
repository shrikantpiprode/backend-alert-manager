package com.internal.alertmanager.models;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TableView {
    List<Alerts> alert;
    List<AlertsResolution> alertsResolution;
}
