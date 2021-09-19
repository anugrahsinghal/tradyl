package com.tradyl.shipment.v2.excpetions;

public class ItemTooHeavyException extends RuntimeException {
	public ItemTooHeavyException(String message) {
		super(message);
	}
}
