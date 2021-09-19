package com.tradyl.shipment.v2.services;

import com.tradyl.shipment.common.dto.Shipment;

public interface TaxationService {

	// GST TAXATION
	default double getTaxPercentage(Shipment shipment) {
		return 0.18;
	}

}
