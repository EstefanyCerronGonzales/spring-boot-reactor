package com.pe.springboot.reactor.app.service;

import com.pe.springboot.reactor.app.model.CurrencyRate;
import com.pe.springboot.reactor.app.model.CurrencyRateResponse;

import io.reactivex.Flowable;
import io.reactivex.Maybe;

public interface CurrencyRateService {

	 Flowable<CurrencyRate> listAllCurrencyRate();

	 Maybe<CurrencyRate> finOneById(Long id);

	 Maybe<CurrencyRateResponse> convertCurrency(String originCurrencyId,
	                                              double amount,
	                                              String destinationCurrencyId);

	Maybe<CurrencyRate> createCurrencyRate(CurrencyRate currencyrate);
}
