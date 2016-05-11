package calendar.DAL;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import calendar.model.Account;

@Component("accountDAO")
public class AccountDAO implements IAccountDAO {
	
	@PersistenceUnit
	EntityManagerFactory entityManager;
	
	public AccountDAO() {}
	
	public AccountDAO(EntityManagerFactory entityManagerFactory)
	{
		this.entityManagerFactory = entityManagerFactory;
	}

	@Override
	public Account selectAccountById(int accountId) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		Query query =  entityManager.createQuery("SELECT p FROM Account p WHERE p.accountId = :accountId");
		query.setParameter("accountId", accountId);
		
		try {
			Account account = (Account) query.getSingleResult();
			return account;
		}
		catch (javax.persistence.NoResultException e)
		{
			return null;
		}
	}
	
	@Override
	public Account selectAccountByName(String accountName) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		Query query =  entityManager.createQuery("SELECT p FROM Account p WHERE p.accountName = :accountName");
		query.setParameter("accountName", accountName);
		
		try {
			Account account = (Account) query.getSingleResult();
			return account;
		}
		catch (javax.persistence.NoResultException e)
		{
			return null;
		}
	}

	@Override
	public Boolean insertAccount(Account account) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		System.out.println("AccountDAO InsertAccount called");
		entityManager.persist(account);
		
		return null;
	}

	@Override
	public Boolean updateAccount(Account account) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		entityManager.merge(account);
		
		return null;
	}

	@Override
	public Boolean deleteAccount(int accountId) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		entityManager.createQuery("DELETE FROM Account a WHERE a.accountId = :accountId").setParameter("accountId", accountId).executeUpdate();
		
		return null;
	}

	@Override
	public List<Account> selectAllAccounts() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();	
	    
		CriteriaQuery<Account> criteria = entityManager.getCriteriaBuilder().createQuery(Account.class);
	    criteria.select(criteria.from(Account.class));
	    
	    List<Account> ListOfAccounts = entityManager.createQuery(criteria).getResultList();
	    return ListOfAccounts;
	}

	@Override
	public Boolean checkIfAccountNameExists(String name) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Account> query = builder.createQuery(Account.class);
        Root<Account> root = query.from(Account.class);

        try {
        Account result = entityManager.createQuery(
                query.select(root).where(builder.equal(root.get("accountName"), name))
        ).getSingleResult();
        
        if (result == null)
        	return false;
        else
        	return true;
        
        } catch (javax.persistence.NoResultException e)
        {
        	return false;
        }
        
	}
}
