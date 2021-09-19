package com.tradyl.shipment.common.controller;

import com.tradyl.shipment.common.dto.Shipment;
import com.tradyl.shipment.common.dto.ShipmentOption;
import com.tradyl.shipment.common.services.ShipmentOptionsService;
import java.util.List;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShipmentControllerV2 {

	private final ShipmentOptionsService shipmentOptionsService;

	public ShipmentControllerV2(@Qualifier("DB_BASED") ShipmentOptionsService shipmentOptionsService) {
		this.shipmentOptionsService = shipmentOptionsService;
	}

	@GetMapping(value = "api/v2/shipment/options")
	public List<ShipmentOption> getShipmentOptions(@RequestBody Shipment shipment) {
		return shipmentOptionsService.getShipmentOptions(shipment);
	}

	@GetMapping(value = "api/v2/shipment/{deliveryType}")
	public ShipmentOption getShipmentOption(@RequestBody Shipment shipment, @PathVariable String deliveryType) {
		return shipmentOptionsService.getShipmentOption(shipment, deliveryType);
	}

}
