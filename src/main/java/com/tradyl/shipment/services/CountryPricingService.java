package com.tradyl.shipment.services;

import com.tradyl.shipment.entities.CountryWeightPricing;

public interface CountryPricingService {

	CountryWeightPricing getPriceBandForWeight(double weight, String country);

}
