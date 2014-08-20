package com.prijilevschi.model;

import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "income")
public class Income extends AbstractEntity {
    private static final long serialVersionUID = 7030205425880527993L;

    //Can we use Yoda time? :D
    private Date effectiveDate;

    private Double pay;

    private ExchangeRate exchangeRate;

    private Double total;
}
