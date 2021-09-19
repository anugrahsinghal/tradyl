package com.tradyl.shipment.v2.services;

import com.tradyl.shipment.v2.entities.DeliveryPricing;
import java.util.List;
import java.util.Optional;

public interface DeliveryPricingService {

	Optional<DeliveryPricing> getDeliveryServiceDetails(String deliveryType);

	List<DeliveryPricing> getDeliveryServiceDetails();

}
