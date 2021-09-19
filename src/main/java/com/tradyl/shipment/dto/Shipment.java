package com.tradyl.shipment.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@ToString
@Getter
@RequiredArgsConstructor
@NoArgsConstructor
public class Shipment {

	private String productCode;
	private int totalWeight;
	private String country;

}
