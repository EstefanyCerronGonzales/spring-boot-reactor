package com.pe.springboot.reactor.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.pe.springboot.reactor.app.model.CurrencyRate;
import com.pe.springboot.reactor.app.model.CurrencyRateResponse;
import com.pe.springboot.reactor.app.service.CurrencyRateService;

import io.reactivex.Flowable;
import io.reactivex.Maybe;

@RestController
@RequestMapping("/currency-rate")
public class CurrencyRateController {
	 @Autowired
	  private CurrencyRateService currencyRateService;

	  @GetMapping()
	  public Flowable<CurrencyRate> getAllCurrency() {
	    return currencyRateService.listAllCurrencyRate();
	  }

	  @GetMapping("/convert")
	  public Maybe<CurrencyRateResponse> convertCurrency(@RequestParam() String originCurrencyId,
	                                                     @RequestParam() double amount,
	                                                     @RequestParam String destinationCurrencyId) {
	    return currencyRateService.convertCurrency(originCurrencyId, amount, destinationCurrencyId);
	  }

	  @GetMapping("/id")
	  public Maybe<CurrencyRate> convertCurrency(@RequestParam() Long originCurrencyId) {
	    return currencyRateService.finOneById(originCurrencyId);
	  }

	@PostMapping("/create")
	public Maybe<CurrencyRate> createConvertCurrency(@RequestBody CurrencyRate currencyrate ) {
		return currencyRateService.createCurrencyRate(currencyrate);
	}
}
