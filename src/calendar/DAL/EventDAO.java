package calendar.DAL;

import calendar.model.Event;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;

public class EventDAO implements IEventDAO {
	
	@PersistenceUnit
	EntityManagerFactory entityManagerFactory;
	
	public EventDAO() {}
	
	public EventDAO(EntityManagerFactory entityManagerFactory)
	{
		this.entityManagerFactory = entityManagerFactory;
	}

	@Override
	public Boolean insertEvent(Event event) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean updateEvent(Event event) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean deleteEvent(int eventId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Event selectEventById(int eventId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Event> selectEventsByCreatorId(int creatorId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Event> selectAllEvents() {
		// TODO Auto-generated method stub
		return null;
	}
}