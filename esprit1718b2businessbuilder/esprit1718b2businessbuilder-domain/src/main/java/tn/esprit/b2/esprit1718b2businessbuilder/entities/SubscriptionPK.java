package tn.esprit.b2.esprit1718b2businessbuilder.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embeddable;

@Embeddable
public class SubscriptionPK implements Serializable {

	private int idUser;
	private int idEvent;
	private Date subscriptionDate;

	public SubscriptionPK() {
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public int getIdEvent() {
		return idEvent;
	}

	public void setIdEvent(int idEvent) {
		this.idEvent = idEvent;
	}

	public SubscriptionPK(int idUser, int idEvent) {
		super();
		this.idUser = idUser;
		this.idEvent = idEvent;
		this.subscriptionDate = new Date();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idEvent;
		result = prime * result + idUser;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SubscriptionPK other = (SubscriptionPK) obj;
		if (idEvent != other.idEvent)
			return false;
		if (idUser != other.idUser)
			return false;
		return true;
	}

	public Date getSubscriptionDate() {
		return subscriptionDate;
	}

	public void setSubscriptionDate(Date subscriptionDate) {
		this.subscriptionDate = subscriptionDate;
	}

	private static final long serialVersionUID = 1L;

}
