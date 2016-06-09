package calendar.service;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import calendar.DAL.IAttendanceDAO;
import calendar.model.Account;
import calendar.model.Attendance;
import calendar.model.Event;

@Service("attendanceService")
public class DefaultAttendanceService implements AttendanceService {
	
	@Inject private IAttendanceDAO attendanceDAO;
	@Inject private AccountService accountService;
	@Inject private EventService eventService;

	@Override
	@Transactional
	public Boolean insertAttendance(Attendance attendance) {
		return attendanceDAO.insertAttendance(attendance);
	}

	@Override
	@Transactional
	public Boolean updateAttendance(Attendance attendance) {
		return attendanceDAO.updateAttendance(attendance);
	}

	@Override
	@Transactional
	public Boolean deleteAttendance(int accountId, int eventId) {
		return attendanceDAO.deleteAttendance(accountId, eventId);
	}

	@Override
	@Transactional
	public Attendance selectAttendanceByIds(int accountId, int eventId) {
		return attendanceDAO.selectAttendanceByIds(accountId, eventId);
	}

	@Override
	@Transactional
	public List<Attendance> selectAttendancesByEventId(int eventId) {
		return attendanceDAO.selectAttendancesByEventId(eventId);
	}

	@Override
	@Transactional
	public List<Event> selectCorrespondingLikedEventsByAccountId(int accountId) {
		
		List<Attendance> attendances = attendanceDAO.selectAttendancesByAccountId(accountId);
		List<Event> eventList = new ArrayList<Event>();
		
		for (Attendance attendance : attendances)
		{
			Event event = eventService.selectEventById(attendance.getEventId());
			eventList.add(event);
		}
		
		return eventList;
	}

	@Override
	@Transactional
	public List<Attendance> selectAttendanceByAccountId(int accountId) {
		return attendanceDAO.selectAttendancesByAccountId(accountId);
	}

	@Override
	@Transactional
	public List<String> getAttendeeNamesViaEventId(int eventId) {
		List<Attendance> attendance = attendanceDAO.selectAttendancesByEventId(eventId);
		List<String> nameList = new ArrayList<String>();
		
		for (Attendance a : attendance)
		{
			Account account = accountService.selectAccountById(a.getAccountId());
			nameList.add(account.getAccountName());
		}
		
		return nameList;

	}
}
