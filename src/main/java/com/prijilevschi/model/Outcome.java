package com.prijilevschi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "outcome")
public class Outcome extends AbstractDatedBudgetaryEntity {
    private static final long serialVersionUID = 1628173176177631703L;

    @Column(columnDefinition = "TEXT")
    private String comment;

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
    
}
