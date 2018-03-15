package tn.saidi.businessbuilder.services;

import java.util.Date;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Session Bean implementation class Event
 */
@Stateless
@LocalBean
public class Event implements EventRemote, EventLocal {

    /**
     * Default constructor. 
     */
	@PersistenceContext
	private EntityManager em;
    public Event() {
        // TODO Auto-generated constructor stub
    }
	@Override
	public void addEvent(Event e) {
		em.persist(e);
		
	}
	@Override
	public List<Event> findAllEvents() {
		
		return em.createQuery("select e from Event e",Event.class).getResultList();
	}
	@Override
	public void updateEvent(Event e) {
		em.merge(e);
		
	}
	@Override
	public void removeEvent(Event e) {
		
		em.remove(em.merge(e));
	}
	@Override
	public List<Event> getEventByDate(Date d) {
		Query q = em.createQuery("select e from Event e where e.dateEvent = :p");
		q.setParameter("p", d);
	return q.getResultList();
	}
	@Override
	public List<Event> getEventBytitle() {
		// TODO Auto-generated method stub
		return null;
	}
    
	
}
