package com.internal.alertmanager.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Alerts {
    @Id
    private Long id;
    private String alertID;
    private String createdtime;
    private String env;
    private int count;
    private boolean active;
    private String severity;
    
    // Constructors, getters, setters, and other methods
}
