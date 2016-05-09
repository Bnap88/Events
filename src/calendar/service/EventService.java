package calendar.service;

import java.util.List;

import calendar.model.Event;

public interface EventService {

	public Boolean insertEvent(Event event);
	
	public Boolean updateEvent(Event event);
	
	public Boolean deleteEvent(int eventId);
	
	public Event selectEventById(int eventId);
	
	public List<Event> selectEventsByCreatorId(int creatorId);
	
	public List<Event> selectAllEvents();
}
