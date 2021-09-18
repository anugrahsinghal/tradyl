package com.tradyl.shipment.v1.services.delivery;

import org.springframework.stereotype.Component;

@Component
public class DeliveryServiceFactory {

	public DeliveryService getDeliveryService(String type) {
		DeliveryService deliveryService;

		switch (type) {
			case "NORMAL":
				deliveryService = new NormalDelivery();
				break;
			case "EXPRESS":
				deliveryService = new ExpressDelivery();
				break;
			default:
				throw new UnsupportedOperationException("Delivery Type not supported");
		}

		return deliveryService;
	}

}
