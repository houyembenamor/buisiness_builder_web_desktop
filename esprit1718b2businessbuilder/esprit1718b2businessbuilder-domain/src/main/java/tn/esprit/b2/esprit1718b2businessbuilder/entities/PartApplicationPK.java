package tn.esprit.b2.esprit1718b2businessbuilder.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;
@Embeddable
public class PartApplicationPK implements Serializable {
private int idPartnershipOffer;
private int idUser;
private static final long serialVersionUID = 1L;

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + idPartnershipOffer;
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
	PartApplicationPK other = (PartApplicationPK) obj;
	if (idPartnershipOffer != other.idPartnershipOffer)
		return false;
	if (idUser != other.idUser)
		return false;
	return true;
}

}
