package com.tradyl.shipment.repositories;

import com.tradyl.shipment.entities.CountryWeightPricing;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryWeightPricingRepository extends JpaRepository<CountryWeightPricing, Long> {

	@Query(value = "SELECT c FROM CountryWeightPricing c WHERE c.country = ?1 AND (c.minWeightInclusive <= ?2 AND c.maxWeightExclusive > ?2)")
	Optional<CountryWeightPricing> findCountryPricingForWeight(String country, double weight);

}