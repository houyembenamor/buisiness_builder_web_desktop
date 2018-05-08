package forum.comment;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.b2.esprit1718b2businessbuilder.entities.Comment;

@Local
public interface CommentServiceLocal {
	public void save(Comment e) ;
	public void delete(Comment e);
	public void update(Comment e);
	public Comment find(int idComment);
	public List<Comment> findAllbyid(int idComment) ;
	public List<Comment> findAll() ;
}
