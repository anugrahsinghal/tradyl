package com.tradyl.shipment.v1.services.pricing.country;

import com.tradyl.shipment.common.dto.Shipment;

public class UKPricingStrategy extends CountryBasedPricingStrategy {

	public UKPricingStrategy(Shipment shipment) {
		super(shipment);
	}

	@Override
	public double getRate(double itemWeight) {
		if (itemWeight < 6) {
			return 15;
		} else {
			return 20;
		}
	}

}
