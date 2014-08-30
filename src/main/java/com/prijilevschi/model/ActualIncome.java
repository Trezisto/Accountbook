package com.prijilevschi.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "actual_income")
public class ActualIncome extends AbstractDatedBudgetaryEntity {
    private static final long serialVersionUID = 7030205425880527993L;
    
    @OneToOne
    @JoinColumn(name = "income_type_id")
    private IncomeType incomeType;

	public IncomeType getIncomeType() {
		return incomeType;
	}

	public void setIncomeType(IncomeType incomeType) {
		this.incomeType = incomeType;
	}
    
}
