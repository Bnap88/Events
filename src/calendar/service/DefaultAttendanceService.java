package calendar.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import calendar.DAL.AttendanceDAO;
import calendar.model.Account;
import calendar.model.Attendance;
import calendar.model.Event;

@Service("attendanceService")
public class DefaultAttendanceService implements AttendanceService {
	
	@Inject private AttendanceDAO attendanceDAO;

	@Override
	@Transactional
	public Boolean insertAttendance(Attendance attendance) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public Boolean updateAttendance(Attendance attendance) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public Boolean deleteAttendance(int accountId, int eventId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public Attendance selectAttendanceByIds(int accountId, int eventId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public List<Attendance> selectAttendancesByEventId(int eventId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public List<Event> selectCorrespondingLikedEventsByAccountId(int accountId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public List<Attendance> selectAttendanceByAccountId(int accountId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public List<String> getAttendeeNamesViaEventId(int eventId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public List<Account> selectAllAccounts() {
		// TODO Auto-generated method stub
		return null;
	}
}
