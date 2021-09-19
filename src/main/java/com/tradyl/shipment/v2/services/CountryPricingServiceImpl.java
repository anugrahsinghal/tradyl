package com.tradyl.shipment.v2.services;

import com.tradyl.shipment.v2.entities.CountryWeightPricing;
import com.tradyl.shipment.v2.repositories.CountryWeightPricingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CountryPricingServiceImpl implements CountryPricingService {

	private final CountryWeightPricingRepository weightPricingRepository;

	@Override
	public CountryWeightPricing getPriceBandForWeight(double weight, String country) {
		return weightPricingRepository.findCountryPricingForWeight(country, weight);
	}

}
