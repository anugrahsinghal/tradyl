package com.tradyl.shipment.v2.repositories;

import com.tradyl.shipment.v2.entities.DeliveryPricing;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryPricingRepository extends JpaRepository<DeliveryPricing, String> {
}