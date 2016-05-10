package calendar.DAL;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import calendar.model.Account;
import calendar.model.Attendance;
import calendar.model.Event;

@Component("attendanceDAO")
@Transactional
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
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
		entityManager.persist(attendance);
		entityManager.getTransaction().commit();
		
		return null;
	}

	@Override
	public Boolean updateAttendance(Attendance attendance) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
		entityManager.merge(attendance);
		entityManager.getTransaction().commit();
		
		return null;
	}

	@Override
	public Boolean deleteAttendance(int accountId, int eventId) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
		entityManager.createQuery("DELETE FROM Attendance a WHERE a.accountId = :accountId AND a.eventId = :eventId").
			setParameter("accountId", accountId).
			setParameter("eventId", eventId).executeUpdate();
		entityManager.getTransaction().commit();
		
		return null;
	}

	@Override
	public Attendance selectAttendanceByIds(int accountId, int eventId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Attendance> selectAttendancesByEventId(int eventId) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Attendance> query = builder.createQuery(Attendance.class);
        Root<Attendance> root = query.from(Attendance.class);

        return (List<Attendance>) entityManager.createQuery(
                query.select(root).where(builder.equal(root.get("eventId"), eventId))
        ).getResultList();
	}

	@Override
	public List<Event> selectCorrespondingLikedEventsByAccountId(int accountId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Attendance> selectAttendanceByAccountId(int accountId) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Attendance> query = builder.createQuery(Attendance.class);
        Root<Attendance> root = query.from(Attendance.class);

        return (List<Attendance>) entityManager.createQuery(
                query.select(root).where(builder.equal(root.get("accountId"), accountId))
        ).getResultList();
	}

	@Override
	public List<Account> getAttendeeNamesViaEventId(int eventId) {
		// TODO Auto-generated method stub
		return null;
	}
}