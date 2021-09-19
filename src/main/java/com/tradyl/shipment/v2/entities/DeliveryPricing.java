package com.tradyl.shipment.v2.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@ToString
@Getter
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
public class DeliveryPricing {

	@Id
	private String deliveryType;

	private double price;

	private String period;

	private String name;

}
