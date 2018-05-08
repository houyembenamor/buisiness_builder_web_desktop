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
import forum.fildiscussion.FilDiscussionService;
import forum.fildiscussion.FilDiscussionServiceLocal;
import tn.benamor.businessbuilder.services.JobOfferServiceLocal;
import tn.esprit.b2.esprit1718b2businessbuilder.entities.Category;
import tn.esprit.b2.esprit1718b2businessbuilder.entities.FilDiscussion;
import tn.esprit.b2.esprit1718b2businessbuilder.entities.JobOffer;


@ManagedBean(name = "CategoryBean")

@ViewScoped
public class CategoryBean implements Serializable {


    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EJB
    private JobOfferServiceLocal categoryMetier;
    private List<JobOffer> categories;
    @EJB
    private FilDiscussionServiceLocal filDiscussionMetier;
    private List<FilDiscussion> filDiscussions;
    private String rechercheValue;

    private String idUrlCategorie;//récupérer l'id url à partire de la catégorie pour trie les publication par cat

    @PostConstruct
    public void init() {


    }

    public CategoryBean() {

    }






    public List<FilDiscussion> getFilDiscussions() {

 //get id fill discussion {publication} from url
        Map<String, String> urlParams;//parametre passe en URL
        urlParams = FacesContext.getCurrentInstance().
                getExternalContext().getRequestParameterMap();
        idUrlCategorie = urlParams.get("idCat");

        if (idUrlCategorie != null && !"".equals(idUrlCategorie)) {

            filDiscussions = filDiscussionMetier.findBycategory(Integer.parseInt(idUrlCategorie));
            //idUrlCategorie = null;
        } else 
        if (rechercheValue == null && !"".equals(rechercheValue)) {
            filDiscussions = filDiscussionMetier.findAll();
        }
        rechercheValue = null;
        return filDiscussions;
    }

    public void setFilDiscussions(List<FilDiscussion> filDiscussions) {
        this.filDiscussions = filDiscussions;
    }

    public String getRechercheValue() {
        return rechercheValue;
    }

    public void setRechercheValue(String rechercheValue) {
        this.rechercheValue = rechercheValue;
    }

    public String getIdUrlCategorie() {
        return idUrlCategorie;
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

  /*  public void rechercher() {

        if (rechercheValue != null) {
            filDiscussions = filDiscussionMetier.search(rechercheValue);
        }

    }*/

	public void setIdUrlCategorie(String idUrlCategorie) {
		this.idUrlCategorie = idUrlCategorie;
	}



	public FilDiscussionServiceLocal getFilDiscussionMetier() {
		return filDiscussionMetier;
	}

	public void setFilDiscussionMetier(FilDiscussionServiceLocal filDiscussionMetier) {
		this.filDiscussionMetier = filDiscussionMetier;
	}

	public JobOfferServiceLocal getCategoryMetier() {
		return categoryMetier;
	}

	public void setCategoryMetier(JobOfferServiceLocal categoryMetier) {
		this.categoryMetier = categoryMetier;
	}

	public List<JobOffer> getCategories() {
		return categories;
	}

	public void setCategories(List<JobOffer> categories) {
		this.categories = categories;
	}
    
    
}
