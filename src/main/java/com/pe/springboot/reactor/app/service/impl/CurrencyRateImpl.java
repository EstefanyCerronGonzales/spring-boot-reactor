package com.pe.springboot.reactor.app.service.impl;

import com.pe.springboot.reactor.app.builder.CurrencyRateBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pe.springboot.reactor.app.model.CurrencyRate;
import com.pe.springboot.reactor.app.model.CurrencyRateResponse;
import com.pe.springboot.reactor.app.repository.CurrencyRateRepository;
import com.pe.springboot.reactor.app.service.CurrencyRateService;

import io.reactivex.Flowable;
import io.reactivex.Maybe;

@Service
public class CurrencyRateImpl implements CurrencyRateService {
  @Autowired
  private CurrencyRateRepository currencyRateRepository;

  @Override
  public Flowable<CurrencyRate> listAllCurrencyRate() {
    return Flowable.fromIterable(currencyRateRepository.findAll());
  }

  @Override
  public Maybe<CurrencyRate> finOneById(Long id) {
    return Maybe.just(currencyRateRepository.findById(id).get());
  }

  @Override
  public Maybe<CurrencyRateResponse> convertCurrency(String originCurrencyId, double amount,
                                                     String destinationCurrencyId) {
    return Maybe.just( currencyRateRepository.findByName(originCurrencyId))
            .flatMap(currencyRateOrigin -> Maybe.just(currencyRateRepository.findByName(destinationCurrencyId))
                    .map(currencyRateDestination -> CurrencyRateBuilder
                            .builderCurrencyToResponse(currencyRateOrigin,
                                    currencyRateDestination, amount)));
  }

  @Override
  public Maybe<CurrencyRate> createCurrencyRate(CurrencyRate currencyrate) {
    return Maybe.just(currencyRateRepository.save(currencyrate));
  }
}

