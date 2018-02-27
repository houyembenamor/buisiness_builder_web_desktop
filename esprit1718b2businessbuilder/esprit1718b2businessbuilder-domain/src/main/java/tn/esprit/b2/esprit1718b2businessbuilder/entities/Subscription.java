package tn.esprit.b2.esprit1718b2businessbuilder.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Subscription
 *
 */
@Entity

public class Subscription implements Serializable {
	@EmbeddedId
	private  SubscriptionPK subscriptionPK;
	private int grade;
	private Date subscriptionDate;
	private static final long serialVersionUID = 1L;
    
	public SubscriptionPK getSubscriptionPK() {
		return subscriptionPK;
	}

	public void setSubscriptionPK(SubscriptionPK subscriptionPK) {
		this.subscriptionPK = subscriptionPK;
	}

	public Subscription() {
		super();
	}   
	
	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public Date getSubscriptionDate() {
		return this.subscriptionDate;
	}

	public void setSubscriptionDate(Date subscriptionDate) {
		this.subscriptionDate = subscriptionDate;
	}
   
}
