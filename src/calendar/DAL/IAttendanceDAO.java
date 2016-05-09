package calendar.DAL;

import java.util.List;

import calendar.model.Account;
import calendar.model.Attendance;
import calendar.model.Event;

public interface IAttendanceDAO {
	//Insert an Attendance
	public Boolean insertAttendance(Attendance attendance);
	
	//Update an Attendance
	public Boolean updateAttendance(Attendance attendance);
	
	//Delete an Attendance
	public Boolean deleteAttendance(int accountId, int eventId);
	
	//Select one Attendance
	public Attendance selectAttendanceByIds(int accountId, int eventId);
	
	//Select all Attendances by an EventId
	public List<Attendance> selectAttendancesByEventId(int eventId);
	
	//Select corresponding Events a user has liked by a given accountId
	public List<Event> selectCorrespondingLikedEventsByAccountId(int accountId);
	
	//Select all Attendances by an AccountId
	public List<Attendance> selectAttendanceByAccountId(int accountId);
	
	//Select all Attendee names via an EventId
	public List<Account> getAttendeeNamesViaEventId(int eventId);
}
