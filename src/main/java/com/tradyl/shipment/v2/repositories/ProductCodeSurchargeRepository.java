package com.tradyl.shipment.v2.repositories;

import com.tradyl.shipment.v2.entities.ProductCodeSurcharge;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductCodeSurchargeRepository extends JpaRepository<ProductCodeSurcharge, Long> {

	Optional<ProductCodeSurcharge> findProductCodeSurchargeByCode(String code);

}