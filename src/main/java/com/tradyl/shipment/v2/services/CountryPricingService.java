package com.tradyl.shipment.v2.services;

import com.tradyl.shipment.v2.entities.CountryWeightPricing;

public interface CountryPricingService {

	CountryWeightPricing getPriceBandForWeight(double weight, String country);

}
