package forum.fildiscussion;

import java.util.Date;
import java.util.List;

import javax.ejb.Remote;

import tn.esprit.b2.esprit1718b2businessbuilder.entities.FilDiscussion;



@Remote
public interface FilDiscussionServiceRemote {
	public void save(FilDiscussion e) ;
	public void delete(FilDiscussion e);
	public void update(FilDiscussion e);
	public FilDiscussion find(int idFilDiscussion);
	public List<FilDiscussion> findAll();
//	public List<FilDiscussion> search(String recherche);
	
	public List<FilDiscussion> findBycategory(int idcategory );
	//public List<FilDiscussion> findByDate(Date dateDiscussion );
}
