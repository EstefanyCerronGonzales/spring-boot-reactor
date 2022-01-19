package com.pe.springboot.reactor.app.model;

import java.math.BigDecimal;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CurrencyRateResponse {

  private DetailAmount origin;
  private DetailAmount destination;
}
