package calendar.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import calendar.DAL.IEventDAO;
import calendar.model.Event;

@Service("eventService")
public class DefaultEventService implements EventService {

	@Inject private IEventDAO eventDAO;

	@Override
	@Transactional
	public Boolean insertEvent(Event event) {
		return eventDAO.insertEvent(event);
	}

	@Override
	@Transactional
	public Boolean updateEvent(Event event) {
		return eventDAO.updateEvent(event);
	}

	@Override
	@Transactional
	public Boolean deleteEvent(int eventId) {
		return eventDAO.deleteEvent(eventId);
	}

	@Override
	@Transactional
	public Event selectEventById(int eventId) {
		return eventDAO.selectEventById(eventId);
	}

	@Override
	@Transactional
	public List<Event> selectEventsByCreatorId(int creatorId) {
		return eventDAO.selectEventsByCreatorId(creatorId);
	}

	@Override
	@Transactional
	public List<Event> selectAllEvents() {
		return eventDAO.selectAllEvents();
	}

}
