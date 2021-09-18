package com.tradyl.shipment.v1.services.pricing.product;

import com.tradyl.shipment.v1.services.pricing.country.CountryBasedPricingStrategy;

public class ProductCodePricingDecoratorImpl extends ProductCodePricingDecorator {
	public ProductCodePricingDecoratorImpl(CountryBasedPricingStrategy shippingPrice) {
		super(shippingPrice);
	}

	@Override
	public double getSurchargeForProduct(String productCode) {
		int startCode = Character.getNumericValue(productCode.charAt(0));
		if (startCode >= 1 && startCode <= 3) {
			return 0.05;
		} else {
			return 0.06;
		}
	}
}
