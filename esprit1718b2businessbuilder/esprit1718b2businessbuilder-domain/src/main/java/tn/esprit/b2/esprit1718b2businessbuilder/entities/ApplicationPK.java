package tn.esprit.b2.esprit1718b2businessbuilder.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embeddable;
@Embeddable
public class ApplicationPK implements Serializable {
private int idOffer;
private int idUser;
private Date applicationDate;
private static final long serialVersionUID = 1L;

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + idOffer;
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
	ApplicationPK other = (ApplicationPK) obj;
	if (idOffer != other.idOffer)
		return false;
	if (idUser != other.idUser)
		return false;
	return true;
}
public int getIdOffer() {
	return idOffer;
}
public void setIdOffer(int idOffer) {
	this.idOffer = idOffer;
}
public int getIdUser() {
	return idUser;
}
public void setIdUser(int idUser) {
	this.idUser = idUser;
}
public Date getApplicationDate() {
	return applicationDate;
}
public void setApplicationDate(Date applicationDate) {
	this.applicationDate = applicationDate;
}

}
