package com.tradyl.shipment.v1.services;

import com.tradyl.shipment.common.dto.Shipment;
import com.tradyl.shipment.common.dto.ShipmentOption;
import com.tradyl.shipment.common.services.ShipmentOptionsService;
import com.tradyl.shipment.v1.services.delivery.DeliveryService;
import com.tradyl.shipment.v1.services.delivery.DeliveryServiceFactory;
import com.tradyl.shipment.v1.services.pricing.PricingDecorator;
import com.tradyl.shipment.v1.services.pricing.country.CountryBasedPricingStrategy;
import com.tradyl.shipment.v1.services.pricing.country.CountryPricingFactory;
import com.tradyl.shipment.v1.services.pricing.product.ProductCodePricingDecoratorImpl;
import com.tradyl.shipment.v1.services.pricing.taxation.GSTDecorator;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service("OOPS_BASED")
public class ShipmentOptionsServiceV1 implements ShipmentOptionsService {

	private final CountryPricingFactory countryPricingFactory;
	private final List<DeliveryService> deliveryServices;
	private final DeliveryServiceFactory deliveryServiceFactory;

	public ShipmentOptionsServiceV1(CountryPricingFactory countryPricingFactory, List<DeliveryService> deliveryServices, DeliveryServiceFactory deliveryServiceFactory) {
		this.countryPricingFactory = countryPricingFactory;
		this.deliveryServices = deliveryServices;
		this.deliveryServiceFactory = deliveryServiceFactory;
	}

	@Override
	public List<ShipmentOption> getShipmentOptions(Shipment product) {

		final GSTDecorator withGSTPrice = getShipmentPriceWithGST(product);

		//noinspection UnnecessaryLocalVariable
		final List<ShipmentOption> shipmentOptions = deliveryServices.stream()
				.map(deliveryService -> deliveryService.getShipmentDetails(withGSTPrice))
				.collect(Collectors.toList());

		return shipmentOptions;
	}

	private GSTDecorator getShipmentPriceWithGST(Shipment product) {
		final CountryBasedPricingStrategy countryPricing = countryPricingFactory.getCountryPricing(product);
		final PricingDecorator withProductCodePricing = new ProductCodePricingDecoratorImpl(countryPricing);
		//noinspection UnnecessaryLocalVariable
		final GSTDecorator withGSTPrice = new GSTDecorator(withProductCodePricing);

		return withGSTPrice;
	}

	@Override
	public ShipmentOption getShipmentOption(Shipment product, String deliveryType) {
		final GSTDecorator shipmentPriceWithGST = getShipmentPriceWithGST(product);

		final DeliveryService deliveryService = deliveryServiceFactory.getDeliveryService(deliveryType);

		return deliveryService.getShipmentDetails(shipmentPriceWithGST);
	}

}
