package calendar.DAL;

import calendar.model.Event;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component("eventDAO")
@Transactional
public class EventDAO implements IEventDAO {
	
	@PersistenceUnit
	EntityManagerFactory entityManagerFactory;
	
	public EventDAO() {}
	
	public EventDAO(EntityManagerFactory entityManagerFactory)
	{
		this.entityManagerFactory = entityManagerFactory;
	}

	@Override
	public Boolean insertEvent(Event event) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
		entityManager.persist(event);
		entityManager.getTransaction().commit();
		
		return null;
	}

	@Override
	public Boolean updateEvent(Event event) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
		entityManager.merge(event);
		entityManager.getTransaction().commit();
		
		return null;
	}

	@Override
	public Boolean deleteEvent(int eventId) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
		entityManager.createQuery("DELETE FROM Event a WHERE a.eventId = :eventId").setParameter("eventId", eventId).executeUpdate();
		entityManager.getTransaction().commit();
		
		return null;
	}

	@Override
	public Event selectEventById(int eventId) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Event> query = builder.createQuery(Event.class);
        Root<Event> root = query.from(Event.class);

        return (Event) entityManager.createQuery(
                query.select(root).where(builder.equal(root.get("eventId"), eventId))
        ).getSingleResult();
	}

	@Override
	public List<Event> selectEventsByCreatorId(int creatorId) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Event> query = builder.createQuery(Event.class);
        Root<Event> root = query.from(Event.class);

        return (List<Event>) entityManager.createQuery(
                query.select(root).where(builder.equal(root.get("creatorId"), creatorId))
        ).getResultList();
	}

	@Override
	public List<Event> selectAllEvents() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();	
	    
		CriteriaQuery<Event> criteria = entityManager.getCriteriaBuilder().createQuery(Event.class);
	    criteria.select(criteria.from(Event.class));
	    List<Event> ListOfEvents = entityManager.createQuery(criteria).getResultList();
	    
	    return ListOfEvents;
	}
}