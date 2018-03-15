package tn.saidi.businessbuilder.services;

import java.util.Date;
import java.util.List;

import javax.ejb.Remote;

@Remote
public interface EventRemote {
public void addEvent(Event e);
public List <Event>  findAllEvents();
public void updateEvent(Event e);
public void removeEvent(Event e);
public List <Event> getEventByDate(Date d);
public List <Event> getEventBytitle();
}
