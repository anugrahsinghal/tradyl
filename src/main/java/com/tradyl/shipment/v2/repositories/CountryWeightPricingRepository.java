package com.tradyl.shipment.v2.repositories;

import com.tradyl.shipment.v2.entities.CountryWeightPricing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryWeightPricingRepository extends JpaRepository<CountryWeightPricing, Long> {

	@Query(value = "SELECT c FROM CountryWeightPricing c WHERE c.country = ?1 AND (c.minWeightInclusive <= ?2 AND c.maxWeightExclusive > ?2)")
	CountryWeightPricing findCountryPricingForWeight(String country, double weight);

}