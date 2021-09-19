package com.tradyl.shipment.entities;

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
public class ProductCodeSurcharge {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long id;

	private String code;

	private double surcharge;

}
