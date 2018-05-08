package forum.category;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.b2.esprit1718b2businessbuilder.entities.Category;

@Local
public interface CategoryServiceLocal {
	public void save(Category e) ;
	public void delete(Category e);
	public void update(Category e);
	public Category find(int idCategory);
	public List<Category> findAll() ;
}
