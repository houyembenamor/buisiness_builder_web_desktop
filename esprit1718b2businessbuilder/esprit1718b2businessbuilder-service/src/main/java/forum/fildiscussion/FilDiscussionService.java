package forum.fildiscussion;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


import tn.esprit.b2.esprit1718b2businessbuilder.entities.Candidate;
import tn.esprit.b2.esprit1718b2businessbuilder.entities.Comment;
import tn.esprit.b2.esprit1718b2businessbuilder.entities.FilDiscussion;


/**
 * Session Bean implementation class FilDiscussionService
 */
@Stateless
public class FilDiscussionService  implements FilDiscussionServiceRemote, FilDiscussionServiceLocal {

    /**
     * Default constructor. 
     */
	@PersistenceContext
	private EntityManager em;
    public FilDiscussionService() {
   
    }

	@Override
	public void save(FilDiscussion e) {
		em.persist(e);
		
	}

	@Override
	public void delete(FilDiscussion e) {
		em.remove(em.merge(e));
		
	}

	@Override
	public void update(FilDiscussion e) {
		em.merge(e);
	}

	@Override
	public FilDiscussion find(int idFilDiscussion ) {
		return em.find(FilDiscussion.class, idFilDiscussion);
	}

@Override
public List<FilDiscussion> findAll() {
	return em.createQuery("select e from FilDiscussion e",FilDiscussion.class).getResultList();
}



@Override
public List<FilDiscussion> findBycategory(int idcategory ) {

	return em.createQuery("select p from FilDiscussion p where p.category.idCategory=:c",FilDiscussion.class).setParameter("c", idcategory )
			.getResultList();
}
/*
@Override
public List<FilDiscussion> findByDate(Date dateDiscussion ) {

	return em.createQuery("select p from FilDiscussion p where p.dateDiscussion=:c order by p.dateDiscussion=:c desc",FilDiscussion.class).setParameter("c", dateDiscussion )
			.getResultList();
}

*/



/*
@Override
public List<FilDiscussion> search(String recherche) {
String rechNonSpace = recherche.replaceAll("\\s+", "");
String parames = "1=0";
String[] parts = recherche.split(" ");
if (rechNonSpace.length() > 0) {
    for (int i = 0; i < parts.length; i++) {
        parames = parames + " or c.contents LIKE :param" + i;

    }
}
    SessionFactory.getCurrentSession().beginTransaction();
    Query query = SessionFactory.getCurrentSession().createQuery("  from FilDiscussion c where " + parames + " order by c.dateDiscussion desc");
    if (rechNonSpace.length() > 0) {
        for (int i = 0; i < parts.length; i++) {

            query.setParameter("param" + i, "%" + parts[i] + "%");
        }
    }
    return query.list();
}

*/
}
