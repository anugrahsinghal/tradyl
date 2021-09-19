package com.tradyl.shipment.v2.services;

import com.tradyl.shipment.v2.entities.DeliveryPricing;
import com.tradyl.shipment.v2.repositories.DeliveryPricingRepository;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class DeliveryPricingServiceImpl implements DeliveryPricingService {

	private final DeliveryPricingRepository deliveryPricingRepository;

	@Override
	public Optional<DeliveryPricing> getDeliveryServiceDetails(String deliveryType) {
		return deliveryPricingRepository.findById(deliveryType);
	}

	@Override
	public List<DeliveryPricing> getDeliveryServiceDetails() {
		return deliveryPricingRepository.findAll();
	}

}
