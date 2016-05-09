package calendar.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import calendar.DAL.EventDAO;
import calendar.model.Event;

@Service("eventService")
public class DefaultEventService implements EventService {

	@Inject private EventDAO eventDAO;

	@Override
	@Transactional
	public Boolean insertEvent(Event event) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public Boolean updateEvent(Event event) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public Boolean deleteEvent(int eventId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public Event selectEventById(int eventId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public List<Event> selectEventsByCreatorId(int creatorId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public List<Event> selectAllEvents() {
		// TODO Auto-generated method stub
		return null;
	}

}
