package com.tradyl.shipment.v2.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
public class CountryWeightPricing {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long id;

	public String country;

	public double price;

	public double minWeightInclusive;

	public double maxWeightExclusive;

}
