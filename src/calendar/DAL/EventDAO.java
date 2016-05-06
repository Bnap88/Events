package calendar.DAL;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import calendar.model.Event;

import java.sql.Timestamp;
import java.util.List;

public class EventDAO implements IEventDAO {
	
	private SessionFactory sessionFactory;
	
	public Session session(){
		return sessionFactory.getCurrentSession();
	}
	
	public EventDAO(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
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

	/*
	@Override
	public Boolean insertEvent(Event event) {
		
		String sql = "INSERT INTO EVENT " +
		"(creatorAccountId, eventName, eventStreetAddress, eventCity, eventState, eventTime) " +
		"VALUES (?, ?, ?, ?, ?, ?)";
		
		int result = getJdbcTemplate().update(sql, new Object[] {event.getCreatorAccountId(),
				event.getEventName(), event.getEventStreetAddress(), event.getEventCity(), event.getEventState(),
				Timestamp.valueOf(event.getEventTime()) });
		
		if (result == 1)
			return true;
		else
			return false;
	}

	@Override
	public Boolean updateEvent(Event event) {
		
		String sql = "SET eventName = ?, eventStreetAddress = ?, " +
				"eventCity = ?, eventState = ?, eventTime = ?";
		
		int result = getJdbcTemplate().update(sql, new Object[] { event.getEventName(), event.getEventStreetAddress(), 
				event.getEventCity(), event.getEventState(), Timestamp.valueOf(event.getEventTime()) });
		
		if (result == 1)
			return true;
		else
			return false;
	}

	@Override
	public Boolean deleteEvent(int eventId) {
		String sql = "DELETE FROM Event WHERE eventId = ?";
		
		int result = getJdbcTemplate().update(sql, eventId);
		
		if (result == 1)
			return true;
		else
			return false;
	}

	@SuppressWarnings("unchecked")
	public Event selectEventById(int eventId) {
		
		String sql = "SELECT * FROM Event WHERE eventId = ?";
		
		return (Event) getJdbcTemplate().queryForObject(sql, new Object[] { eventId }, new EventRowMapper());
	}
	
	@SuppressWarnings("unchecked")
	public List<Event> selectEventsByCreatorId(int creatorId) {
		
		String sql = "SELECT * FROM Event WHERE creatorAccountId = ?";
		
		return getJdbcTemplate().query(sql, new Object[] { creatorId }, new EventRowMapper());
	}

	@SuppressWarnings("unchecked")
	public List<Event> selectAllEvents() {
		
		String sql = "SELECT * FROM Event";
	
		return getJdbcTemplate().query(sql, new EventRowMapper());
	}
	*/
}