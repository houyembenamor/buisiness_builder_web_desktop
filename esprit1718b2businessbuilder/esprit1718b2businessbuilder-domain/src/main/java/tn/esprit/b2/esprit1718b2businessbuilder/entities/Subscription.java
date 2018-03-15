package tn.esprit.b2.esprit1718b2businessbuilder.entities;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Entity implementation class for Entity: Subscription
 *
 */
@Entity

public class Subscription implements Serializable {

	@EmbeddedId
	private SubscriptionPK subscriptionPK;
	private int grade;

	@ManyToOne
	@JoinColumn(name = "idUser", referencedColumnName = "idUser", updatable = false, insertable = false)
	private PartnerResearcher partnerResearcher;
	@ManyToOne
	@JoinColumn(name = "idEvent", referencedColumnName = "idEvent", updatable = false, insertable = false)
	private Event event;
	private static final long serialVersionUID = 1L;

	public SubscriptionPK getSubscriptionPK() {
		return subscriptionPK;
	}

	public Subscription(int grade, PartnerResearcher partnerResearcher, Event event) {
		super();
		this.grade = grade;
		this.partnerResearcher = partnerResearcher;
		this.event = event;
		this.subscriptionPK = new SubscriptionPK(partnerResearcher.getIdUser(), event.getIdEvent());
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

}
