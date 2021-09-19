package com.tradyl.shipment.v2.services;

import com.tradyl.shipment.v2.entities.ProductCodeSurcharge;

public interface ProductCodeBasedSurcharge {

	ProductCodeSurcharge getSurchargePercentForProduct(String productCode);

}
