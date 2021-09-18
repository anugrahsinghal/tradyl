package com.tradyl.shipment.v1.services.pricing.country;

import com.tradyl.shipment.common.dto.Shipment;
import org.springframework.stereotype.Service;

@Service
public class CountryPricingFactory {

	public CountryBasedPricingStrategy getCountryPricing(Shipment shipment) {
		CountryBasedPricingStrategy pricingStrategy;
		switch (shipment.getCountry()) {
			case "USA":
				pricingStrategy = new USAPricingStrategy(shipment);
				break;
			case "UK":
				pricingStrategy = new UKPricingStrategy(shipment);
				break;
			default:
				throw new UnsupportedOperationException("Country Not Supported");
		}

		return pricingStrategy;
	}

}
