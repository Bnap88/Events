package calendar.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Attendance implements Serializable {
	
    private static final long serialVersionUID = 1L;
    
    private Integer attendanceId;
	private Integer eventId;
	private Integer accountId;
	
	public Attendance() {}
	
	public Attendance(Integer accountId, Integer eventId) {
		this.eventId = eventId;
		this.accountId = accountId;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getAttendanceId() {
		return attendanceId;
	}

	public void setAttendanceId(Integer attendanceId) {
		this.attendanceId = attendanceId;
	}
	
	@Basic(optional = false)
	public Integer getEventId() {
		return eventId;
	}
	
	public void setEventId(Integer eventId) {
		this.eventId = eventId;
	}
	
	@Basic(optional = false)
	public Integer getAccountId() {
		return accountId;
	}
	
	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

}
