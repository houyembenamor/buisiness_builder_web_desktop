package tn.esprit.b2.esprit1718b2businessbuilder.entities;
// Generated 25 fevr. 2015 16:41:06 by Hibernate Tools 3.6.0


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * FilDiscussion generated by hbm2java
 */
@Entity
@Table(name="fil_discussion"

)
public class FilDiscussion  implements java.io.Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue(strategy=IDENTITY)
     private Integer idFilDiscussion;
    @ManyToOne
     private User user;
    @ManyToOne
     private JobOffer category;
     private String subject;
     private String contents;
     private String type;
     @Column(name="timeStamp", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
     @Temporal(TemporalType.TIMESTAMP)
     private Date dateDiscussion;
     private  String status;
     @OneToMany(fetch=FetchType.LAZY, mappedBy="filDiscussion")
     private Set<Comment> comments = new HashSet<Comment>(0);

    public FilDiscussion() {
    }

	
    public FilDiscussion(User user, JobOffer category, String subject, String contents, String type, Date dateDiscussion,  String status) {
        this.user = user;
        this.category = category;
        this.subject = subject;
        this.contents = contents;
        this.type = type;
        this.dateDiscussion = dateDiscussion;
        this.status = status;
    }
    public FilDiscussion(User user, JobOffer category, String subject, String contents, String type, Date dateDiscussion,  String status, Set<Comment> comments) {
       this.user = user;
       this.category = category;
       this.subject = subject;
       this.contents = contents;
       this.type = type;
       this.dateDiscussion = dateDiscussion;
       this.status = status;
       this.comments = comments;
    }
   

    public Integer getIdFilDiscussion() {
        return this.idFilDiscussion;
    }
    
    public void setIdFilDiscussion(Integer idFilDiscussion) {
        this.idFilDiscussion = idFilDiscussion;
    }


    public User getUser() {
        return this.user;
    }
    
    public void setUser(User user) {
        this.user = user;
    }




    

    public JobOffer getCategory() {
		return category;
	}


	public void setCategory(JobOffer category) {
		this.category = category;
	}


	public String getSubject() {
        return this.subject;
    }
    
    public void setSubject(String subject) {
        this.subject = subject;
    }

    

    public String getContents() {
        return this.contents;
    }
    
    public void setContents(String contents) {
        this.contents = contents;
    }

    

    public String getType() {
        return this.type;
    }
    
    public void setType(String type) {
        this.type = type;
    }


    public Date getDateDiscussion() {
        return this.dateDiscussion;
    }
    
    public void setDateDiscussion(Date dateDiscussion) {
        this.dateDiscussion = dateDiscussion;
    }


    public String getStatus() {
        return this.status;
    }
    
    public void setStatus( String status) {
        this.status = status;
    }


    public Set<Comment> getComments() {
        return this.comments;
    }
    
    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }


public String toString(){
    return "[id:"+this.idFilDiscussion+",subject:"+this.subject +",type:"+this.type+"]";
}

}


