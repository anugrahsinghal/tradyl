package com.tradyl.shipment.common.controller;

import com.tradyl.shipment.common.dto.Shipment;
import com.tradyl.shipment.common.dto.ShipmentOption;
import com.tradyl.shipment.common.services.ShipmentOptionsService;
import java.util.List;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShipmentController {

	private final ShipmentOptionsService shipmentOptionsService;

	public ShipmentController(@Qualifier("OOPS_BASED") ShipmentOptionsService shipmentOptionsService) {
		this.shipmentOptionsService = shipmentOptionsService;
	}

	@PostMapping(value = "api/v1/shipment/options")
	public List<ShipmentOption> getShipmentOptions(@RequestBody Shipment shipment) {
		return shipmentOptionsService.getShipmentOptions(shipment);
	}

	@PostMapping(value = "api/v1/shipment/{deliveryType}")
	public ShipmentOption getShipmentOption(@RequestBody Shipment shipment, @PathVariable String deliveryType) {
		return shipmentOptionsService.getShipmentOption(shipment, deliveryType);
	}

}
