package com.prijilevschi.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.prijilevschi.enums.ExchangeRateType;


@Embeddable
public class Payment {
    @Column(name = "effective_date")
    private Date effectiveDate;

    @Column(name = "pay")
    private BigDecimal pay;

    @Column(name = "exchange_rate")
    @Enumerated(EnumType.STRING)
    private ExchangeRateType exchangeRate;


    public Date getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(Date effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public BigDecimal getPay() {
        return pay;
    }

    public void setPay(BigDecimal pay) {
        this.pay = pay;
    }

    public ExchangeRateType getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(ExchangeRateType exchangeRate) {
        this.exchangeRate = exchangeRate;
    }


}
