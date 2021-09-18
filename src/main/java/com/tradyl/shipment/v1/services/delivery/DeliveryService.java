package com.tradyl.shipment.v1.services.delivery;

import com.tradyl.shipment.common.dto.ShipmentOption;
import com.tradyl.shipment.v1.services.pricing.PricingDecorator;

public abstract class DeliveryService {

	public abstract double getDeliveryPeriodSurcharge();

	public abstract String getName();

	public abstract String getPeriod();

	private double getTotalPrice(PricingDecorator pricingDecorator) {
		final double price = pricingDecorator.getPrice();
		//noinspection UnnecessaryLocalVariable
		final double priceWithSurcharge = price + getDeliveryPeriodSurcharge();

		return priceWithSurcharge;
	}

	public ShipmentOption getShipmentDetails(PricingDecorator pricingDecorator) {
		return new ShipmentOption(getName(), getTotalPrice(pricingDecorator), getPeriod());
	}

}
