package com.tradyl.shipment.common.controller;

import com.tradyl.shipment.common.dto.Shipment;
import com.tradyl.shipment.common.dto.ShipmentOption;
import com.tradyl.shipment.v1.services.ShipmentOptionsService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShipmentController {

	@Autowired
	private ShipmentOptionsService shipmentOptionsService;

	@GetMapping(value = "api/v1/shipment/options")
	public List<ShipmentOption> getShipmentOptions(@RequestBody Shipment shipment) {
		return shipmentOptionsService.getShipmentOptions(shipment);
	}

	@GetMapping(value = "api/v1/shipment/{deliveryType}")
	public ShipmentOption getShipmentOption(@RequestBody Shipment shipment, @PathVariable String deliveryType) {
		return shipmentOptionsService.getShipmentOption(shipment, deliveryType);
	}

}
