package com.prijilevschi.model;

import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "outcome")
public class Outcome extends AbstractDatedBudgetaryEntity {
    private static final long serialVersionUID = 1628173176177631703L;


}
