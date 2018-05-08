/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.b2.esprit1718b2businessbuilder.mBeans;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import forum.category.CategoryService;
import forum.category.CategoryServiceLocal;
import forum.fildiscussion.FilDiscussionService;
import forum.fildiscussion.FilDiscussionServiceLocal;

import tn.benamor.businessbuilder.services.JobOfferServiceLocal;
import tn.esprit.b2.esprit1718b2businessbuilder.entities.Category;
import tn.esprit.b2.esprit1718b2businessbuilder.entities.FilDiscussion;
import tn.esprit.b2.esprit1718b2businessbuilder.entities.JobOffer;
import tn.esprit.b2.esprit1718b2businessbuilder.entities.User;


@ManagedBean(name = "PublicationBean")

@ViewScoped
public class PublicationBean implements Serializable {

	private static final long serialVersionUID = 1L;
	////    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-beans.xml");
    private User currentUser;
   @EJB
    private JobOfferServiceLocal categoryMetier;
    private List<JobOffer> categories;
    @EJB
    private FilDiscussionServiceLocal filDiscussionMetier;

    private FilDiscussion filDiscussion;
    private List<FilDiscussion>filDiscussions;
    private int idCategorySelected;
    
    @PostConstruct
    public void init() {
    	  filDiscussion = new FilDiscussion();  
    	  filDiscussions=filDiscussionMetier.findAll();
   //categoryMetier = (CategoryMetier) this.context.getBean("categoryMetier");
    categories = categoryMetier.findAll();

//        filDiscussionMetier = (FilDiscussionMetier) this.context.getBean("filDiscussionMetier");
          
        idCategorySelected=0;
    }

    public PublicationBean() {

    }


    public List<JobOffer> getCategories() {
         categories = categoryMetier.findAll();
        return categories;
    }

  

    public FilDiscussion getFilDiscussion() {
         
        return filDiscussion;
    }

    public void setFilDiscussion(FilDiscussion filDiscussion) {
        this.filDiscussion = filDiscussion;
    }

    public int getIdCategorySelected() {
        return idCategorySelected;
    }

    public void setIdCategorySelected(int idCategorySelected) {
        this.idCategorySelected = idCategorySelected;
    }

    public String dateFilDiscussion(java.util.Date d2) {
        java.util.Date d1 = new java.util.Date();
        long time = ((d1.getTime() - d2.getTime()) / 60000);
        if (time < 60) {
            return time + " min";
        } else if (time >= 60 && time < 1440) {
            return (time / 60) + " h";
        } else {
            return d2.toString();

        }

    }

    public String onPostPers() {
     
      //  currentUser = new User();
    // currentUser.setIdUser();
        
       JobOffer c=categoryMetier.findJobOfferById(idCategorySelected);
        filDiscussion.setCategory(c);
        filDiscussion.setDateDiscussion(new java.util.Date());

       this.filDiscussionMetier.update(this.filDiscussion);
     return"Forum";
    }
    
    
    
    
       public int sizeOfList(Set t) {
        if (t != null) {
            return t.size();
        } else {
            return 0;
        }
    }

public void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
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

public void setCategories(List<JobOffer> categories) {
	this.categories = categories;
}

public FilDiscussionServiceLocal getFilDiscussionMetier() {
	return filDiscussionMetier;
}

public void setFilDiscussionMetier(FilDiscussionServiceLocal filDiscussionMetier) {
	this.filDiscussionMetier = filDiscussionMetier;
}

public void setFilDiscussionMetier(FilDiscussionService filDiscussionMetier) {
	this.filDiscussionMetier = filDiscussionMetier;
}


/*public List<FilDiscussion> search(String recherche) {
    String rechNonSpace = recherche.replaceAll("\\s+", "");
    String parames = "1=0";
    String[] parts = recherche.split(" ");
    if (rechNonSpace.length() > 0) {
        for (int i = 0; i < parts.length; i++) {
            parames = parames + " or c.contents LIKE :param" + i;

        }
    }
  filDiscussionMetier.findByDate(dateDiscussion);
    if (rechNonSpace.length() > 0) {
        for (int i = 0; i < parts.length; i++) {

            query.setParameter("param" + i, "%" + parts[i] + "%");
        }
    }
    return query.list();
}

*/

}
