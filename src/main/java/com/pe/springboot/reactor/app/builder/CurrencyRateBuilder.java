package com.pe.springboot.reactor.app.builder;

import com.pe.springboot.reactor.app.model.CurrencyRate;
import com.pe.springboot.reactor.app.model.CurrencyRateResponse;
import com.pe.springboot.reactor.app.model.DetailAmount;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CurrencyRateBuilder {

  private CurrencyRateBuilder() {
  }

  public static CurrencyRateResponse builderCurrencyToResponse(CurrencyRate origin,
                                                               CurrencyRate destination,
                                                               double amount) {

    return CurrencyRateResponse.builder()
            .origin(DetailAmount.builder()
                    .amount(amount)
                    .exchangeRate(origin.getInUsd())
                    .currency(origin.getName())
                    .build())
            .destination(DetailAmount.builder()
                    .modifiedAmount(roundTwoDecimal((amount*destination.getInUsd())/origin.getInUsd(),4))
                    .exchangeRate(destination.getInUsd())
                    .currency(destination.getName())
                    .build())
            .build();
  }

  private static Double roundTwoDecimal(Double amount, int numberDecimal) {
    return new BigDecimal(amount.toString()).setScale(numberDecimal, RoundingMode.HALF_UP).doubleValue();
  }
}