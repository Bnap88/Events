package calendar.DAL;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.transaction.annotation.Transactional;

import calendar.model.Account;

@Transactional
public class AccountDAO implements IAccountDAO {
	
	@PersistenceUnit
	EntityManagerFactory entityManagerFactory;
	
	public AccountDAO() {}
	
	public AccountDAO(EntityManagerFactory entityManagerFactory)
	{
		this.entityManagerFactory = entityManagerFactory;
	}
	
	/*
	@Override
	public Boolean insertAccount(Account account) {
		
		
		String sql = "INSERT INTO Account " +
		"(accountName, accountEmail, accountPasswordHash, accountSalt, accountCreated, accountActiveState) " +
		"VALUES (?, ?, ?, ?, ?, ?)";
		
		int result = getJdbcTemplate().update(sql, new Object[] { account.getAccountName(), 
				account.getAccountEmail(), account.getAccountPasswordHash(), account.getAccountSalt(), 
				Timestamp.valueOf(account.getAccountCreated()), account.getAccountActiveState() });
		
		if (result == 1)
			return true;
		else
			return false;
			
	}*/

	/*
	@Override
	public Boolean updateAccount(Account account) {
		
		String sql = "UPDATE Account SET accountName = ?, accountEmail = ?, " +
		"accountPasswordHash = ?, accountSalt = ?, accountCreated = ?, accountActiveState = ?, WHERE accountId = ?";
		
		int result = getJdbcTemplate().update(sql, new Object[] { account.getAccountName(), account.getAccountEmail(),
				account.getAccountPasswordHash(), account.getAccountSalt(), Timestamp.valueOf(account.getAccountCreated()),
				account.getAccountActiveState() });
		
		if (result == 1)
			return true;
		else
			return false;
	}*/

	/*
	@Override
	public Boolean deleteAccount(int accountId) {
		
		String sql = "DELETE FROM Account WHERE accountId = ?";
		
		int result = getJdbcTemplate().update(sql, accountId);
		
		if (result == 1)
			return true;
		else
			return false;
	}*/

	@Override
	public Account selectAccountById(int accountId) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Account> query = builder.createQuery(Account.class);
        Root<Account> root = query.from(Account.class);

        return (Account) entityManager.createQuery(
                query.select(root).where(builder.equal(root.get("accountId"), accountId))
        ).getSingleResult();
	}
	
	@Override
	public Account selectAccountByName(String accountName) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Account> query = builder.createQuery(Account.class);
        Root<Account> root = query.from(Account.class);

        return entityManager.createQuery(
                query.select(root).where(builder.equal(root.get("accountName"), accountName))
        ).getSingleResult();
	}

	@Override
	public Boolean insertAccount(Account account) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean updateAccount(Account account) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean deleteAccount(int accountId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Account> selectAllAccounts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean checkIfAccountNameExists(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	@Override
	public List<Account> selectAllAccounts() {
		
		String sql = "SELECT * FROM Account";
		
		List<Account> accounts = getJdbcTemplate().query(sql, new BeanPropertyRowMapper<Account>(Account.class));
		
		return accounts;
	}*/

	/*
	@Override
	public Boolean checkIfAccountNameExists(String accountName) {
		
		String sql = "SELECT COUNT(1) FROM Account WHERE accountName = ?";
		Boolean result = false;
		
		int count = getJdbcTemplate().queryForObject(sql, new Object[] { accountName }, Integer.class );
		
		if (count > 0)
			result = true;
		
		return result;
	}*/
}
