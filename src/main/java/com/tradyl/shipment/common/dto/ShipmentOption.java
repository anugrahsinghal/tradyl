package com.tradyl.shipment.common.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
@AllArgsConstructor
public class ShipmentOption {

	private String name;
	private double shipmentCost;
	private String deliveryPeriod;

}
