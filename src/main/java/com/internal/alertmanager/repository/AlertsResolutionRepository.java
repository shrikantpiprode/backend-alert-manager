package com.internal.alertmanager.repository;

import com.internal.alertmanager.models.AlertsResolution;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlertsResolutionRepository extends JpaRepository<AlertsResolution, Long> {
    // You can define custom query methods here if needed
}
