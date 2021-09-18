package com.tradyl.shipment.v1.services;

import com.tradyl.shipment.common.dto.Shipment;
import com.tradyl.shipment.common.dto.ShipmentOption;
import java.util.List;

public interface ShipmentOptionsService {

	List<ShipmentOption> getShipmentOptions(Shipment product);

	ShipmentOption getShipmentOption(Shipment product, String deliveryType);

}
