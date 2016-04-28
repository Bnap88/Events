package calendar.DAL;

import java.util.List;

import calendar.model.Event;

public interface IEventDAO {

	//Insert an Event
	public Boolean insertEvent(Event event);
	
	//Update an Event
	public Boolean updateEvent(Event event);
	
	//Delete an Event
	public Boolean deleteEvent(int eventId);
	
	//Select one Event
	public Event selectEventById(int eventId);
	
	//Select all Events created by a given a creatorAccountId
	public List<Event> selectEventsByCreatorId(int creatorId);
	
	//Select all Event
	public List<Event> selectAllEvents();
	
}
