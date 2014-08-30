package com.prijilevschi.model;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "income_type")
public class IncomeType extends AbstractNamedEntity {
    private static final long serialVersionUID = -1421496095532548801L;

    @OneToOne(mappedBy = "incomeType")
    private ActualIncome income;

	public ActualIncome getIncome() {
		return income;
	}

	public void setIncome(ActualIncome income) {
		this.income = income;
	}

}
