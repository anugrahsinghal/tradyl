package com.tradyl.shipment.services;

import com.tradyl.shipment.entities.DeliveryPricing;
import com.tradyl.shipment.repositories.DeliveryPricingRepository;
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
