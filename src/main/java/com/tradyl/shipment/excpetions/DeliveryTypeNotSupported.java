package com.tradyl.shipment.excpetions;

public class DeliveryTypeNotSupported extends RuntimeException {
	public DeliveryTypeNotSupported(String msg) {
		super(msg);
	}
}
