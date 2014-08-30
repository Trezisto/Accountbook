package com.prijilevschi.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import com.prijilevschi.enums.CurrencyType;

@Entity
@Table(name = "exchange_rate")
public class ExchangeRate extends AbstractEntity {
	private static final long serialVersionUID = -1280462314339793856L;

	@Column
	private Date date;
	
	@Column
	@Enumerated(EnumType.STRING)
	private CurrencyType currency;
	
	@Column
	private BigDecimal rate;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public CurrencyType getCurrency() {
		return currency;
	}

	public void setCurrency(CurrencyType currency) {
		this.currency = currency;
	}

	public BigDecimal getRate() {
		return rate;
	}

	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}
}
