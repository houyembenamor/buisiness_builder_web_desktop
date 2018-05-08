package forum.comment;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.b2.esprit1718b2businessbuilder.entities.Comment;
import tn.esprit.b2.esprit1718b2businessbuilder.entities.FilDiscussion;
import tn.esprit.b2.esprit1718b2businessbuilder.entities.JobOffer;

/**
 * Session Bean implementation class CommentService
 */
@Stateless
public class CommentService implements CommentServiceRemote, CommentServiceLocal {

    /**
     * Default constructor. 
     */
	@PersistenceContext
	private EntityManager em;
    public CommentService() {
      
    }
	@Override
	public void save(Comment e) {
		em.persist(e);
		
	}
	@Override
	public void delete(Comment e) {
		em.remove(em.merge(e));
		
	}
	@Override
	public void update(Comment e) {
		em.merge(e);
		
	}
	@Override
	public Comment find(int idComment) {
		return em.find(Comment.class, idComment);
	}
	@Override
	public List<Comment> findAllbyid(int idComment ) {

		return em.createQuery("select p from Comment p where p.idComment=:c",Comment.class).setParameter("c", idComment )
				.getResultList();
	}
	
	@Override
	public List<Comment> findAll() {
		return em.createQuery("select e from Comment e",Comment.class).getResultList();
	}

}
