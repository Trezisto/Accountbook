package com.prijilevschi.model;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "actual_funds")
@AttributeOverrides({
	@AttributeOverride(name = "payment.pay", column = @Column(name = "actual_total") ),
	@AttributeOverride(name = "payment.effectiveDate", column = @Column(name = "date") )
})
public class ActualFunds extends AbstractDatedBudgetaryEntity {
	private static final long serialVersionUID = 2908233300986525271L;

}
