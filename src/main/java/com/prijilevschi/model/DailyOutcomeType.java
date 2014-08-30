package com.prijilevschi.model;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "outcome_type")
public class DailyOutcomeType extends AbstractNamedEntity {
	private static final long serialVersionUID = 5092021179972336580L;

	@OneToOne(mappedBy = "dailyOutcomeType")
	private DailyOutcome dailyOutcome;

	public DailyOutcome getDailyOutcome() {
		return dailyOutcome;
	}

	public void setDailyOutcome(DailyOutcome dailyOutcome) {
		this.dailyOutcome = dailyOutcome;
	}
}
