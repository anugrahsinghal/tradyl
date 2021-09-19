package com.tradyl.shipment.v2.services;

import com.tradyl.shipment.v2.entities.ProductCodeSurcharge;
import com.tradyl.shipment.v2.repositories.ProductCodeSurchargeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ProductCodeBasedSurchargeImpl implements ProductCodeBasedSurcharge {

	private final ProductCodeSurcharge NO_CHARGE = new ProductCodeSurcharge(0L, "", 0.0);
	private final ProductCodeSurchargeRepository productCodeSurchargeRepository;

	@Override
	public ProductCodeSurcharge getSurchargePercentForProduct(String productCode) {

		final char startChar = productCode.charAt(0);

		final String code = startChar + "";
		return productCodeSurchargeRepository.findProductCodeSurchargeByCode(code).orElse(NO_CHARGE);
	}
}
