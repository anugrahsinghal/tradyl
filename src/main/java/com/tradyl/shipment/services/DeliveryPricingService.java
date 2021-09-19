package com.tradyl.shipment.services;

import com.tradyl.shipment.entities.DeliveryPricing;
import java.util.List;
import java.util.Optional;

public interface DeliveryPricingService {

	Optional<DeliveryPricing> getDeliveryServiceDetails(String deliveryType);

	List<DeliveryPricing> getDeliveryServiceDetails();

}
