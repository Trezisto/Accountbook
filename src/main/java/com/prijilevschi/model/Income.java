package com.prijilevschi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "income")
public class Income extends AbstractDatedBudgetaryEntity {
    private static final long serialVersionUID = 7030205425880527993L;

    @Column
    @OneToOne
    private IncomeType incomeType;
}
