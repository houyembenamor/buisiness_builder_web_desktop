/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.b2.esprit1718b2businessbuilder.mBeans;


import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;


import forum.category.CategoryService;
import forum.category.CategoryServiceLocal;
import forum.comment.CommentService;
import forum.comment.CommentServiceLocal;
import forum.fildiscussion.FilDiscussionService;
import forum.fildiscussion.FilDiscussionServiceLocal;
import tn.benamor.businessbuilder.services.JobOfferServiceLocal;
import tn.esprit.b2.esprit1718b2businessbuilder.entities.Category;
import tn.esprit.b2.esprit1718b2businessbuilder.entities.Comment;
import tn.esprit.b2.esprit1718b2businessbuilder.entities.FilDiscussion;
import tn.esprit.b2.esprit1718b2businessbuilder.entities.JobOffer;
import tn.esprit.b2.esprit1718b2businessbuilder.entities.User;


@ManagedBean(name = "PubcommentBean")

@ViewScoped
public class PubcommentBean implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	////    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-beans.xml");
   private User currentUser;//utilisateur connecté
    @EJB
    private JobOfferServiceLocal categoryMetier;
    private List<JobOffer> categories;

    String idFD;
    @EJB
    private FilDiscussionServiceLocal filDiscussionMetier;
    private FilDiscussion filDiscussion;

    @EJB
    private CommentServiceLocal CommentMetier;
    private List<Comment> comments;
	private List<FilDiscussion>fils;
    private Comment commentaire;
	private boolean showForm;

    @PostConstruct
    public void init() {
        commentaire = new Comment();
       fils= filDiscussionMetier.findAll();
       comments=CommentMetier.findAll();
   	showForm = false;
    }

    public PubcommentBean() {
    }

 
	public void doSelect() {
		showForm = true;
	}
    public List<JobOffer> getCategories() {
        categories = categoryMetier.findAll();
        return categories;
    }



 

    public FilDiscussion getFilDiscussion() {
        if (idFD == null || "".equals(idFD)) {
            //get id fill discussion {publication} from url
            Map<String, String> urlParams;//parametre passe en URL
            urlParams = FacesContext.getCurrentInstance().
                    getExternalContext().getRequestParameterMap();
            String parameterOne = urlParams.get("id");

            if (parameterOne != null && !parameterOne.equals("")) {
                idFD = parameterOne;
                filDiscussion = filDiscussionMetier.find(Integer.parseInt(parameterOne));
            }
        } else {
            filDiscussion = filDiscussionMetier.find(Integer.parseInt(idFD));
        }
        return filDiscussion;
    }

    public void setFilDiscussion(FilDiscussion filDiscussion) {
        this.filDiscussion = filDiscussion;
    }

 

    public List<Comment> getComments() {
        if (idFD == null || idFD.equals("")) {
            //get id fill descussion {publication} from url
            Map<String, String> urlParams;//parametre passe en URL
            urlParams = FacesContext.getCurrentInstance().
                    getExternalContext().getRequestParameterMap();
            String parameterOne = urlParams.get("id");

            if (parameterOne != null && !parameterOne.equals("")) {
                idFD = parameterOne;
                comments = CommentMetier.findAllbyid(Integer.parseInt(parameterOne));
            }
        } else {
            comments = CommentMetier.findAllbyid(Integer.parseInt(idFD));
        }

        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    /**/
    public String getIdFD() {
        return idFD;
    }

    public void setIdFD(String idFD) {
        this.idFD = idFD;
    }

    public Comment getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(Comment commentaire) {
        this.commentaire = commentaire;
    }

    public String onPostCommentPers() {

      //  currentUser = new User();
      //  currentUser.setIdUser(5);
        commentaire.setDateComment(new java.util.Date());
      //  FilDiscussion f = new FilDiscussion();

        filDiscussion.setIdFilDiscussion(Integer.parseInt(idFD));
        
        commentaire.setFilDiscussion(filDiscussion);
        this.CommentMetier.update(this.commentaire);
return"";
    }

    public int sizeOfList(Set t) {
        if (t != null) {
            return t.size();
        } else {
            return 0;
        }
    }

   public String dateToString(java.util.Date d2) {
        java.util.Date d1 = new java.util.Date();
        long time = ((d1.getTime() - d2.getTime()) / 60000);
        if (time == 0) {
            return "À l’instant";
        } else if (time < 60) {
            return time + " min";
        } else if (time >= 60 && time < 1440) {
            return (time / 60) + " h";
        } else {
            return d2.toString();

        }

    }

	public User getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(User currentUser) {
		this.currentUser = currentUser;
	}







	public JobOfferServiceLocal getCategoryMetier() {
		return categoryMetier;
	}

	public void setCategoryMetier(JobOfferServiceLocal categoryMetier) {
		this.categoryMetier = categoryMetier;
	}

	public List<FilDiscussion> getFils() {
		return fils;
	}

	public void setFils(List<FilDiscussion> fils) {
		this.fils = fils;
	}

	public boolean isShowForm() {
		return showForm;
	}

	public void setShowForm(boolean showForm) {
		this.showForm = showForm;
	}

	public void setCategories(List<JobOffer> categories) {
		this.categories = categories;
	}

	public FilDiscussionServiceLocal getFilDiscussionMetier() {
		return filDiscussionMetier;
	}

	public void setFilDiscussionMetier(FilDiscussionServiceLocal filDiscussionMetier) {
		this.filDiscussionMetier = filDiscussionMetier;
	}

	public CommentServiceLocal getCommentMetier() {
		return CommentMetier;
	}

	public void setCommentMetier(CommentServiceLocal commentMetier) {
		CommentMetier = commentMetier;
	}






    
}
