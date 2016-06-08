package calendar.DAL;

import java.util.List;

import calendar.model.Attendance;

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
	
	//Select all Attendances by an AccountId
	public List<Attendance> selectAttendancesByAccountId(int accountId);
}
