package com.prijilevschi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "day_outcome")
public class DailyOutcome extends AbstractDatedBudgetaryEntity {
	private static final long serialVersionUID = 9207121018704621433L;

	@OneToOne
	@JoinColumn(name = "daily_outcome_type_id")
	private DailyOutcomeType dailyOutcomeType;
	
	@Column(columnDefinition = "TEXT")
	private String comment;
	
	@OneToOne
	@JoinColumn(name = "user_id")
	private User user;

	public DailyOutcomeType getDailyOutcomeType() {
		return dailyOutcomeType;
	}

	public void setDailyOutcomeType(DailyOutcomeType dailyOutcomeType) {
		this.dailyOutcomeType = dailyOutcomeType;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
