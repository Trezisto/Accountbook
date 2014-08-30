package com.prijilevschi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User extends AbstractEntity {
        private static final long serialVersionUID = -556137194429173858L;

	private String userName;
	private String password;

	@OneToOne(mappedBy = "user")
	private DailyOutcome dailyOutcome;
	
	@OneToOne(mappedBy = "user")
	private ActualFunds actualFunds;
	
	@OneToOne(mappedBy = "user")
	private FormalIncome formalIncome;
	
	@Column(name = "username", unique = true)
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "password")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public DailyOutcome getDailyOutcome() {
		return dailyOutcome;
	}

	public void setDailyOutcome(DailyOutcome dailyOutcome) {
		this.dailyOutcome = dailyOutcome;
	}

	public ActualFunds getActualFunds() {
		return actualFunds;
	}

	public void setActualFunds(ActualFunds actualFunds) {
		this.actualFunds = actualFunds;
	}

	public FormalIncome getFormalIncome() {
		return formalIncome;
	}

	public void setFormalIncome(FormalIncome formalIncome) {
		this.formalIncome = formalIncome;
	}

}
