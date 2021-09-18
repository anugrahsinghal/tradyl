package com.tradyl.shipment.v1.services.delivery;

import org.springframework.stereotype.Component;

@Component
public class NormalDelivery extends DeliveryService {

	@Override
	public double getDeliveryPeriodSurcharge() {
		return 0;
	}

	@Override
	public String getName() {
		return "Normal Delivery";
	}

	@Override
	public String getPeriod() {
		return "10-14 Days";
	}

}
