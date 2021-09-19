package com.tradyl.shipment.services;

import com.tradyl.shipment.entities.ProductCodeSurcharge;

public interface ProductCodeBasedSurcharge {

	ProductCodeSurcharge getSurchargePercentForProduct(String productCode);

}
