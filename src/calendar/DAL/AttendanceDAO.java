package calendar.DAL;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import calendar.model.Account;
import calendar.model.Attendance;
import calendar.model.Event;

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
		
		Integer result = entityManager.createQuery("DELETE FROM Attendance a WHERE a.accountId = :accountId AND a.eventId = :eventId", Attendance.class).
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
		
		System.out.println("||||||| Line 96 CALLED in AttendanceDAO - Begin");
		//query.setHint("javax.persistence.query.timeout", 2000);
		List<Attendance> attendances = query.getResultList();
		System.out.println("||||||| Line 99 CALLED in AttendanceDAO - end");

		return attendances;
		
	}

	@Override
	public List<Attendance> selectAttendancesByAccountId(int accountId) {
		
		TypedQuery<Attendance> query =  entityManager.createQuery("SELECT p FROM Attendance p WHERE p.accountId = :accountId", Attendance.class);
		query.setParameter("accountId",accountId);
		
		//TODO
		try {
			List<Attendance> attendances = query.getResultList();
			return attendances;
		} catch (org.hibernate.exception.SQLGrammarException e)
		{
			return null;
		}
	}
}