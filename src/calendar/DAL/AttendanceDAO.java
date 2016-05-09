package calendar.DAL;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import calendar.model.Account;
import calendar.model.Attendance;
import calendar.model.Event;

public class AttendanceDAO implements IAttendanceDAO {
	
	@PersistenceUnit
	EntityManagerFactory entityManagerFactory;
	
	public AttendanceDAO() {}
	
	public AttendanceDAO(EntityManagerFactory entityManagerFactory)
	{
		this.entityManagerFactory = entityManagerFactory;
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
}