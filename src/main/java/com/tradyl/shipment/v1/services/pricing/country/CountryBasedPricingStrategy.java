package com.tradyl.shipment.v1.services.pricing.country;

import com.tradyl.shipment.common.dto.Shipment;
import com.tradyl.shipment.v1.services.pricing.PricingDecorator;

public abstract class CountryBasedPricingStrategy implements PricingDecorator {

	private final Shipment shipment;

	public CountryBasedPricingStrategy(Shipment shipment) {
		this.shipment = shipment;
	}

	protected abstract double getRate(double itemWeight);

	@Override
	public double getPrice() {
		return getRate(shipment.getTotalWeight()) * shipment.getTotalWeight();
	}

	public Shipment getShipment() {
		return shipment;
	}

}
