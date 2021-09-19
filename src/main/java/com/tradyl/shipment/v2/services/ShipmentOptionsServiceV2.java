package com.tradyl.shipment.v2.services;

import com.tradyl.shipment.common.dto.Shipment;
import com.tradyl.shipment.common.dto.ShipmentOption;
import com.tradyl.shipment.common.services.ShipmentOptionsService;
import com.tradyl.shipment.v2.entities.CountryWeightPricing;
import com.tradyl.shipment.v2.entities.DeliveryPricing;
import com.tradyl.shipment.v2.entities.ProductCodeSurcharge;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service("DB_BASED")
public class ShipmentOptionsServiceV2 implements ShipmentOptionsService {

	private final CountryPricingService countryPricingService;
	private final ProductCodeBasedSurcharge productCodeSurcharge;
	private final TaxationService taxationService;
	private final DeliveryPricingService deliveryPricingService;

	@Override
	public List<ShipmentOption> getShipmentOptions(Shipment product) {

		final double shipmentPriceWithTax = getShipmentPriceWithTax(product);
		final List<DeliveryPricing> deliveryServices = deliveryPricingService.getDeliveryServiceDetails();

		//noinspection UnnecessaryLocalVariable
		final List<ShipmentOption> shipmentOptions = deliveryServices.stream()
				.map(deliveryService -> new ShipmentOption(
						deliveryService.getName(),
						deliveryService.getPrice() + shipmentPriceWithTax,
						deliveryService.getPeriod()))
				.collect(Collectors.toList());

		return shipmentOptions;
	}

	private double getShipmentPriceWithTax(Shipment product) {
		final CountryWeightPricing priceBandForWeightAndCountry = countryPricingService.getPriceBandForWeight(product.getTotalWeight(), product.getCountry());
		final double priceBandForWeight = priceBandForWeightAndCountry.getPrice();

		final ProductCodeSurcharge productCodeBasedSurcharge = productCodeSurcharge.getSurchargePercentForProduct(product.getProductCode());
		final double surchargePercentForProduct = productCodeBasedSurcharge.getSurcharge();

		final double taxPercentage = taxationService.getTaxPercentage(product);

		final double priceForWeight = priceBandForWeight * product.getTotalWeight();
		final double priceWithSurcharge = priceForWeight + (priceForWeight * (surchargePercentForProduct / 100));

		//noinspection UnnecessaryLocalVariable
		final double priceWithTaxes = priceWithSurcharge + (priceWithSurcharge * taxPercentage);

		return priceWithTaxes;
	}


	@Override
	public ShipmentOption getShipmentOption(Shipment product, String deliveryType) {

		final double shipmentPriceWithTax = getShipmentPriceWithTax(product);
		final Optional<DeliveryPricing> deliveryServiceOpt = deliveryPricingService.getDeliveryServiceDetails(deliveryType);

		if (deliveryServiceOpt.isPresent()) {

			DeliveryPricing deliveryServiceDetails = deliveryServiceOpt.get();

			final double totalPrice = deliveryServiceDetails.getPrice() + shipmentPriceWithTax;

			//noinspection UnnecessaryLocalVariable
			ShipmentOption shipmentOption = new ShipmentOption(deliveryServiceDetails.getName(), totalPrice, deliveryServiceDetails.getPeriod());

			return shipmentOption;
		} else {
			throw new UnsupportedOperationException("Delivery Type not supported");
		}
	}

}
