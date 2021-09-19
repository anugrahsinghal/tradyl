package com.tradyl.shipment.repositories;

import com.tradyl.shipment.entities.DeliveryPricing;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryPricingRepository extends JpaRepository<DeliveryPricing, String> {
}