package calendar.DAL;

import calendar.model.Event;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;

import org.springframework.stereotype.Component;

@Component("eventDAO")
public class EventDAO implements IEventDAO {
	
	@PersistenceContext
	EntityManager entityManager;
	
	public EventDAO() {}

	@Override
	public Boolean insertEvent(Event event) {
		
		try {
			entityManager.persist(event);
			return true;
		} catch (Exception e)
		{
			return false;
		}
	}

	@Override
	public Boolean updateEvent(Event event) {
		
		try {
			entityManager.merge(event);
			return null;
		} catch (Exception e)
		{
			return false;
		}
	}

	@Override
	public Boolean deleteEvent(int eventId) {
		
		int result = entityManager.createQuery("DELETE FROM Event a WHERE a.eventId = :eventId").setParameter("eventId", eventId).executeUpdate();
		
		if (result == 1)
			return true;
		else
			return false;
	}

	@Override
	public Event selectEventById(int eventId) {
		
		Query query =  entityManager.createQuery("SELECT p FROM Event p WHERE p.eventId = :eventId", Event.class);
		query.setParameter("eventId", eventId);
		
		try {
			Event event = (Event) query.getSingleResult();
			return event;
		}
		catch (javax.persistence.NoResultException e)
		{
			return null;
		}
	}

	@Override
	public List<Event> selectEventsByCreatorId(int creatorId) {
		
		TypedQuery<Event> query =  entityManager.createQuery("SELECT p FROM Event p WHERE p.creatorAccountId = :creatorAccountId", Event.class);
		query.setParameter("creatorAccountId", creatorId);
		
		List<Event> events = query.getResultList();
		return events;

	}

	@Override
	public List<Event> selectAllEvents() {
	    
		CriteriaQuery<Event> criteria = entityManager.getCriteriaBuilder().createQuery(Event.class);
	    criteria.select(criteria.from(Event.class));
	    
	    List<Event> ListOfEvents = entityManager.createQuery(criteria).getResultList();
	    
	    return ListOfEvents;
	    
	}
}