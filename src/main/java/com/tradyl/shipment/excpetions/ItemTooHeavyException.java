package com.tradyl.shipment.excpetions;

public class ItemTooHeavyException extends RuntimeException {
	public ItemTooHeavyException(String message) {
		super(message);
	}
}
