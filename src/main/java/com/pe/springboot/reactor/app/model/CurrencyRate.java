package com.pe.springboot.reactor.app.model;

import lombok.*;

import javax.persistence.*;


@Getter
@Setter
@Builder
@Entity
@Table(name ="currencyrate")
@AllArgsConstructor
@NoArgsConstructor
public class CurrencyRate {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;
	private double inUsd;
	//private double perUsd;

	public CurrencyRate(String name, double inUsd, double perUsd) {
	this.name=name;
	this.inUsd = inUsd;
	//this.perUsd = perUsd;
	}
}
