package com.tradyl.shipment.v1.services.pricing.country;

import com.tradyl.shipment.common.dto.Shipment;

public class USAPricingStrategy extends CountryBasedPricingStrategy {

	public USAPricingStrategy(Shipment shipment) {
		super(shipment);
	}

	@Override
	public double getRate(double itemWeight) {
		if (itemWeight < 5) {
			return 10;
		} else {
			return 15;
		}
	}
}
