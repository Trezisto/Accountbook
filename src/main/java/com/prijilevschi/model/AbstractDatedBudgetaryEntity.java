/*******************************************************************************
*
* © Copyright by Endava 2014.
*
* All Rights Reserved
*
* Endava – Internal Use Only
*
*******************************************************************************/
package com.prijilevschi.model;

import javax.persistence.Embedded;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class AbstractDatedBudgetaryEntity extends AbstractEntity {
    private static final long serialVersionUID = -8504105266571283984L;

    @Embedded
    private Payment payment;

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }


}
