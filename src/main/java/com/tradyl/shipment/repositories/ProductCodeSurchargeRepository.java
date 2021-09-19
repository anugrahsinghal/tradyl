package com.tradyl.shipment.repositories;

import com.tradyl.shipment.entities.ProductCodeSurcharge;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductCodeSurchargeRepository extends JpaRepository<ProductCodeSurcharge, Long> {

	Optional<ProductCodeSurcharge> findProductCodeSurchargeByCode(String code);

}