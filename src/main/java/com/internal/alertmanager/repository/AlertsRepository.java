package com.internal.alertmanager.repository;

import com.internal.alertmanager.models.Alerts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlertsRepository extends JpaRepository<Alerts, Long> {
    // You can define custom query methods here if needed
    Alerts findByAlertID(String alertID);
}
