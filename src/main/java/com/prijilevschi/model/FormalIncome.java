package com.prijilevschi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "formal_income")
public class FormalIncome extends AbstractDatedBudgetaryEntity {
	private static final long serialVersionUID = 6773812574979853630L;

	@Column
	private Boolean actual;
	
	@OneToOne
	@JoinColumn(name = "user_id")
	private User userId;

	public Boolean getActual() {
		return actual;
	}

	public void setActual(Boolean actual) {
		this.actual = actual;
	}

	public User getUserId() {
		return userId;
	}

	public void setUserId(User userId) {
		this.userId = userId;
	}
}
