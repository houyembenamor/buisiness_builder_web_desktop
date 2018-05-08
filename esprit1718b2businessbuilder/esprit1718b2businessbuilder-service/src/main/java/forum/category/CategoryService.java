package forum.category;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.b2.esprit1718b2businessbuilder.entities.Category;
import tn.esprit.b2.esprit1718b2businessbuilder.entities.Comment;

/**
 * Session Bean implementation class CategoryService
 */
@Stateless
public class CategoryService implements CategoryServiceRemote, CategoryServiceLocal {

    /**
     * Default constructor. 
     */
	@PersistenceContext
	private EntityManager em;
    public CategoryService() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void save(Category e) {
		em.persist(e);
		
	}

	@Override
	public void delete(Category e) {
		em.remove(em.merge(e));
		
	}

	@Override
	public void update(Category e) {
		em.merge(e);
		
	}

	@Override
	public Category find(int idCategory) {
		return em.find(Category.class, idCategory);
	}

	@Override
	public List<Category> findAll() {
		return em.createQuery("select e from Category e",Category.class).getResultList();
	}

}
