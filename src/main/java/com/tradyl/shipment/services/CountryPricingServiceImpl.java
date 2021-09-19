package com.tradyl.shipment.services;

import com.tradyl.shipment.entities.CountryWeightPricing;
import com.tradyl.shipment.excpetions.ItemTooHeavyException;
import com.tradyl.shipment.repositories.CountryWeightPricingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CountryPricingServiceImpl implements CountryPricingService {

	private final CountryWeightPricingRepository weightPricingRepository;

	@Override
	public CountryWeightPricing getPriceBandForWeight(double weight, String country) {
		return weightPricingRepository.findCountryPricingForWeight(country, weight)
				.orElseThrow(() -> new ItemTooHeavyException(weight + " is too heavy"));
	}

}
