package calendar.DAL;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Component;

import calendar.model.Attendance;

@Component("attendanceDAO")
public class AttendanceDAO implements IAttendanceDAO {
	
	@PersistenceContext
	EntityManager entityManager;
	
	public AttendanceDAO() {}

	@Override
	public Boolean insertAttendance(Attendance attendance) {
		
		try {
		entityManager.persist(attendance);
		return true;
		} catch (Exception e)
		{
			return false;
		}
	}

	@Override
	public Boolean updateAttendance(Attendance attendance) {
		
		try {
		entityManager.merge(attendance);
		return true;
		} catch (Exception e)
		{
			return false;
		}
	}

	@Override
	public Boolean deleteAttendance(int accountId, int eventId) {
		
		Integer result = entityManager.createQuery("DELETE FROM Attendance a WHERE a.accountId = :accountId AND a.eventId = :eventId").
			setParameter("accountId", accountId).
			setParameter("eventId", eventId).
			executeUpdate();
		
		if (result == 1)
			return true;
		else
			return false;
	}

	@Override
	public Attendance selectAttendanceByIds(int accountId, int eventId) {
		
		Query query =  entityManager.createQuery("SELECT p FROM Attendance p WHERE p.accountId = :accountId AND p.eventId = :eventId", Attendance.class).
		setParameter("accountId", accountId).
		setParameter("eventId", eventId);
		
		try {
			Attendance attendance = (Attendance) query.getSingleResult();
			return attendance;
		}
		catch (javax.persistence.NoResultException e)
		{
			return null;
		}
	}

	@Override
	public List<Attendance> selectAttendancesByEventId(int eventId) {
		
		TypedQuery<Attendance> query =  entityManager.createQuery("SELECT p FROM Attendance p WHERE p.eventId = :eventId", Attendance.class);
		query.setParameter("eventId",eventId);
		
		List<Attendance> attendances = query.getResultList();

		return attendances;
		
	}

	@Override
	public List<Attendance> selectAttendancesByAccountId(int accountId) {
		
		TypedQuery<Attendance> query =  entityManager.createQuery("SELECT p FROM Attendance p WHERE p.accountId = :accountId", Attendance.class);
		query.setParameter("accountId",accountId);
		
		try {
			List<Attendance> attendances = query.getResultList();
			return attendances;
		} catch (org.hibernate.exception.SQLGrammarException e)
		{
			return null;
		}
	}
}