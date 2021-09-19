package com.tradyl.shipment.services;

import com.tradyl.shipment.dto.Shipment;
import com.tradyl.shipment.dto.ShipmentOption;
import java.util.List;

public interface ShipmentOptionsService {

	List<ShipmentOption> getShipmentOptions(Shipment product);

	ShipmentOption getShipmentOption(Shipment product, String deliveryType);

}
