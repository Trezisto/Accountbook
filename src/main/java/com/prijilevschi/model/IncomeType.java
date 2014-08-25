package com.prijilevschi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "income_type")
public class IncomeType extends AbstractNamedEntity {
    private static final long serialVersionUID = -1421496095532548801L;

    @OneToOne
    @Column
    private Income income;

    public Income getIncome() {
        return income;
    }

    public void setIncome(Income income) {
        this.income = income;
    }
}
