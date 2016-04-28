package calendar.model.formmodel;

public class CreateEventFormObject {

	String eventName;
	String eventStreetAddress;
	String eventCity;
	String eventState;
	String year;
	String month;
	String day;
	String hour;
	String minute;
	
	public CreateEventFormObject(String eventName, String eventStreetAddress, String eventCity, String eventState,
			String year, String month, String day, String hour, String minute) {
		super();
		this.eventName = eventName;
		this.eventStreetAddress = eventStreetAddress;
		this.eventCity = eventCity;
		this.eventState = eventState;
		this.year = year;
		this.month = month;
		this.day = day;
		this.hour = hour;
		this.minute = minute;
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

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getHour() {
		return hour;
	}

	public void setHour(String hour) {
		this.hour = hour;
	}

	public String getMinute() {
		return minute;
	}

	public void setMinute(String minute) {
		this.minute = minute;
	}
}
