package com.pe.springboot.reactor.app.repository;

import com.pe.springboot.reactor.app.model.CurrencyRate;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface CurrencyRateRepository extends CrudRepository <CurrencyRate,Long>{

	 CurrencyRate findByName(String name);
}