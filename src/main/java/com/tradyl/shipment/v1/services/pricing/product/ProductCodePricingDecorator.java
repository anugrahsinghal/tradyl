package com.tradyl.shipment.v1.services.pricing.product;

import com.tradyl.shipment.v1.services.pricing.PricingDecorator;
import com.tradyl.shipment.v1.services.pricing.country.CountryBasedPricingStrategy;

public abstract class ProductCodePricingDecorator implements PricingDecorator {

	private final CountryBasedPricingStrategy shippingPrice;

	public ProductCodePricingDecorator(CountryBasedPricingStrategy countryShippingPrice) {
		this.shippingPrice = countryShippingPrice;
	}

	@Override
	public double getPrice() {
		final double price = shippingPrice.getPrice();

		final String productCode = shippingPrice.getShipment().getProductCode();

		return (price * getSurchargeForProduct(productCode)) + price;
	}

	public abstract double getSurchargeForProduct(String productCode);

}
