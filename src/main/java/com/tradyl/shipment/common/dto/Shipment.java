package com.tradyl.shipment.common.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@ToString
@Getter
@RequiredArgsConstructor
public class Shipment {

	private String productCode;
	private int totalWeight;
	private String country;

}
