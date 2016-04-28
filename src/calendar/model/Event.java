package calendar.model;

import java.time.LocalDateTime;

public class Event implements Comparable<Event> {
	
	private Integer eventId;
	private Integer creatorAccountId;
	private String eventName;
	private String eventStreetAddress;
	private String eventCity;
	private String eventState;
	private LocalDateTime eventTime;
	
	public Integer getEventId() {
		return eventId;
	}

	public void setEventId(Integer eventId) {
		this.eventId = eventId;
	}
	
	public Integer getCreatorAccountId() {
		return creatorAccountId;
	}

	public void setCreatorAccountId(Integer creatorAccountId) {
		this.creatorAccountId = creatorAccountId;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String getEventStreetAddress() {
		return eventStreetAddress;
	}

	public void setEventStreetAddress(String eventStreetAddress) {
		this.eventStreetAddress = eventStreetAddress;
	}

	public String getEventCity() {
		return eventCity;
	}

	public void setEventCity(String eventCity) {
		this.eventCity = eventCity;
	}

	public String getEventState() {
		return eventState;
	}

	public void setEventState(String eventState) {
		this.eventState = eventState;
	}

	public LocalDateTime getEventTime() {
		return eventTime;
	}

	public void setEventTime(LocalDateTime eventTime) {
		this.eventTime = eventTime;
	}
	
	public Event(){}
	
	public Event(Integer accountId, String name,String streetAddress, String city, String state, LocalDateTime time)
	{
		this.creatorAccountId = accountId;
		this.eventName = name;
		this.eventCity = city;
		this.eventState = state;
		this.eventStreetAddress = streetAddress;
		this.eventTime = time;
	}
	
	@Override
	public int compareTo(Event o) {
		// TODO Auto-generated method stub
		return this.getEventTime().compareTo(o.getEventTime());
	}
}