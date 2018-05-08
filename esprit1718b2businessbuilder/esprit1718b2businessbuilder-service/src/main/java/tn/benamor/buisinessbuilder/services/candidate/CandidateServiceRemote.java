package tn.benamor.buisinessbuilder.services.candidate;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.b2.esprit1718b2businessbuilder.entities.Candidate;


@Remote
public interface CandidateServiceRemote  {

	
		public void add(Candidate e);
		public List <Candidate>  findAll();
		public void update(Candidate e);
		public void remove(Candidate e);
		public boolean updateCandidate(int idUser,String firstName,String lastName,String email,String userName ,String password,int phoneNumber,String nationality,String domain);
		public Candidate findCandidateById(int idUser);
		public Boolean addPhoto(Candidate c, byte[] photo);
		public Candidate findCandidateByEmail(String email);
		public void addcandidatetojoboffer(int idUser,int idOffer);
		public void addcandidatetojoboffer2(int idUser,int idOffer);
}
