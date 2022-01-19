package com.pe.springboot.reactor.app.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class DetailAmount {
  private String currency;
  private double amount;
  private double modifiedAmount;
  private double exchangeRate;


}
