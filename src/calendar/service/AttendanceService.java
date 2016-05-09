package calendar.service;

import java.util.List;

import calendar.model.Account;
import calendar.model.Attendance;
import calendar.model.Event;

public interface AttendanceService {
	
	public Boolean insertAttendance(Attendance attendance);
	
	public Boolean updateAttendance(Attendance attendance);
	
	public Boolean deleteAttendance(int accountId, int eventId);
	
	public Attendance selectAttendanceByIds(int accountId, int eventId);

	public List<Attendance> selectAttendancesByEventId(int eventId);
	
	public List<Event> selectCorrespondingLikedEventsByAccountId(int accountId);
	
	public List<Attendance> selectAttendanceByAccountId(int accountId);
	
	public List<String> getAttendeeNamesViaEventId(int eventId);
	
	public List<Account> selectAllAccounts();
}
