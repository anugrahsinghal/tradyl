package com.tradyl.shipment.services;

import com.tradyl.shipment.dto.Shipment;

public interface TaxationService {

	// GST TAXATION
	default double getTaxPercentage(Shipment shipment) {
		return 0.18;
	}

}
