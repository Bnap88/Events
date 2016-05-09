package calendar.service;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import calendar.DAL.AttendanceDAO;
import calendar.DAL.IAttendanceDAO;
import calendar.model.Account;
import calendar.model.Attendance;
import calendar.model.Event;

@Service("attendanceService")
public class DefaultAttendanceService implements AttendanceService {
	
	@Inject private IAttendanceDAO attendanceDAO;

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
		return attendanceDAO.selectCorrespondingLikedEventsByAccountId(accountId);
	}

	@Override
	@Transactional
	public List<Attendance> selectAttendanceByAccountId(int accountId) {
		return attendanceDAO.selectAttendanceByAccountId(accountId);
	}

	@Override
	@Transactional
	public List<String> getAttendeeNamesViaEventId(int eventId) {
		List<Account> tempList = attendanceDAO.getAttendeeNamesViaEventId(eventId);
		List<String> nameList = new ArrayList<String>();
		
		for (Account account : tempList)
		{
			nameList.add(account.getAccountName());
		}
		
		return nameList;
	}
}
