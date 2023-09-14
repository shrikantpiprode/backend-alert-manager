package com.internal.alertmanager.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlertRequest {

     String alertId;
     String timeStamp;
    
}
