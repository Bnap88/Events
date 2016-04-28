package calendar.model;

public class Attendance {

	private Integer eventId;
	private Integer accountId;
	
	public Attendance() {}
	
	public Attendance(Integer accountId, Integer eventId) {
		this.eventId = eventId;
		this.accountId = accountId;
	}
	
	public Integer getEventId() {
		return eventId;
	}
	public void setEventId(Integer eventId) {
		this.eventId = eventId;
	}
	public Integer getAccountId() {
		return accountId;
	}
	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}
}
