package calendar.DAL;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import calendar.model.Account;
import calendar.model.Attendance;
import calendar.model.Event;

public class AttendanceDAO implements IAttendanceDAO {
	
	private SessionFactory sessionFactory;
	
	public Session session(){
		return sessionFactory.getCurrentSession();
	}
	
	public AttendanceDAO(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Boolean insertAttendance(Attendance attendance) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean updateAttendance(Attendance attendance) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean deleteAttendance(int accountId, int eventId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Attendance selectAttendanceByIds(int accountId, int eventId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Attendance> selectAttendancesByEventId(int eventId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Event> selectCorrespondingLikedEventsByAccountId(int accountId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Attendance> selectAttendanceByAccountId(int accountId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getAttendeeNamesViaEventId(int eventId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Account> selectAllAccounts() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	@Override
	public Boolean insertAttendance(Attendance attendance) {
		String sql = "INSERT INTO ATTENDANCE (accountId, eventId) VALUES (?, ?)";
		
		int result = getJdbcTemplate().update(sql, new Object[] { attendance.getAccountId(), attendance.getEventId() });
		
		if (result == 1)
			return true;
		else
			return false;
	}

	@Override
	public Boolean updateAttendance(Attendance attendance) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean deleteAttendance(int accountId, int eventId) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Attendance selectAttendanceByIds(int accountId, int eventId) {
		String sql = "SELECT * FROM Attendance WHERE accountId = ? AND eventId = ?";
		
		try {
			Attendance attendance = (Attendance) getJdbcTemplate().queryForObject(sql, new Object[] { accountId, eventId }, new AttendanceRowMapper() );
			
			return attendance;
		}
		catch(EmptyResultDataAccessException e)
		{
			return null;
		}
		catch(Exception e)
		{
			return null;
		}	
	}

	@Override
	public List<Attendance> selectAttendancesByEventId(int eventId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Attendance> selectAttendanceByAccountId(int accountId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<Event> selectCorrespondingLikedEventsByAccountId(int accountId) {
		String sql = "SELECT Event.eventId, Event.creatorAccountId, Event.eventName, Event.eventStreetAddress," +
					" Event.eventCity, Event.eventState, Event.eventTime FROM Event JOIN Attendance ON " +
					"Event.eventId = Attendance.eventId WHERE Attendance.accountId = ?";
		
		@SuppressWarnings("unchecked")
		List<Event> likedEvents = (List<Event>) getJdbcTemplate().query(sql, new Object[] { accountId },
				new EventRowMapper());
		
		return likedEvents;
	}

	public List<String> getAttendeeNamesViaEventId(int eventId) {
		
		List<String> attendeeNames = new ArrayList<String>();
		
		String sql = "SELECT Account.accountName FROM Account JOIN Attendance ON Account.accountId=Attendance.accountId " +
		"WHERE Attendance.eventId = ?";
		
		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql, new Object[] { eventId });
		
		for (Map<String, Object> row : rows)
		{
			String name = (String) row.get("accountName");
			attendeeNames.add(name);
		}
		
		return attendeeNames;
	}
	
	@Override
	public List<Account> selectAllAccounts() {
		// TODO Auto-generated method stub
		return null;
	}
	
	*/
}