package calendar.model.viewmodel;

import java.util.ArrayList;
import java.util.List;

import calendar.model.Event;

public class EventListing {

	private Event event;
	private String accountCreatorName;
	private List<String> attendees;
	
	void EventList() {
		event = new Event();
		attendees = new ArrayList<String>();
	}
	
	public Event getEvent() {
		return event;
	}
	public void setEvent(Event event) {
		this.event = event;
	}
	public String getAccountCreatorName() {
		return accountCreatorName;
	}
	public void setAccountCreatorName(String accountCreatorName) {
		this.accountCreatorName = accountCreatorName;
	}
	public List<String> getAttendees() {
		return attendees;
	}
	public void setAttendees(List<String> attendees) {
		this.attendees = attendees;
	}
}
