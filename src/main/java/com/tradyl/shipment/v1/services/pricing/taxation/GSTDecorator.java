package com.tradyl.shipment.v1.services.pricing.taxation;

import com.tradyl.shipment.v1.services.pricing.PricingDecorator;

public class GSTDecorator implements PricingDecorator {

	private final PricingDecorator productPrice;

	public GSTDecorator(PricingDecorator productPrice) {
		this.productPrice = productPrice;
	}

	@Override
	public double getPrice() {
		final double price = productPrice.getPrice();

		//noinspection UnnecessaryLocalVariable
		final double totalPrice = (price * 0.18) + price;

		return totalPrice;
	}
}
