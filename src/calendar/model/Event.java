package calendar.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Basic;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Event implements Serializable {
	
    private static final long serialVersionUID = 1L;
    
	private Integer eventId;
	private Integer creatorAccountId;
	private String eventName;
	private String eventStreetAddress;
	private String eventCity;
	private String eventState;
	private LocalDateTime eventTime;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getEventId() {
		return eventId;
	}

	public void setEventId(Integer eventId) {
		this.eventId = eventId;
	}
	
	@Basic(optional = false)
	public Integer getCreatorAccountId() {
		return creatorAccountId;
	}

	public void setCreatorAccountId(Integer creatorAccountId) {
		this.creatorAccountId = creatorAccountId;
	}

	@Basic(optional = false)
	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	@Basic(optional = false)
	public String getEventStreetAddress() {
		return eventStreetAddress;
	}

	public void setEventStreetAddress(String eventStreetAddress) {
		this.eventStreetAddress = eventStreetAddress;
	}

	@Basic(optional = false)
	public String getEventCity() {
		return eventCity;
	}

	public void setEventCity(String eventCity) {
		this.eventCity = eventCity;
	}

	@Basic(optional = false)
	public String getEventState() {
		return eventState;
	}

	public void setEventState(String eventState) {
		this.eventState = eventState;
	}

	@Basic(optional = false)
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
	
	public int compareTo(Event o) {
		// TODO Auto-generated method stub
		return this.getEventTime().compareTo(o.getEventTime());
	}

}
