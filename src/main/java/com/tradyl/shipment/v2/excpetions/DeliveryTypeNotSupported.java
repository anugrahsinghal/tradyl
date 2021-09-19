package com.tradyl.shipment.v2.excpetions;

public class DeliveryTypeNotSupported extends RuntimeException {
	public DeliveryTypeNotSupported(String msg) {
		super(msg);
	}
}
