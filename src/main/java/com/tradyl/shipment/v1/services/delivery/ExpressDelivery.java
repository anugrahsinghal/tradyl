package com.tradyl.shipment.v1.services.delivery;

import org.springframework.stereotype.Component;

@Component
public class ExpressDelivery extends DeliveryService {

	@Override
	public double getDeliveryPeriodSurcharge() {
		return 200;
	}

	@Override
	public String getName() {
		return "Express Delivery";
	}

	@Override
	public String getPeriod() {
		return "5-7 Days";
	}

}
