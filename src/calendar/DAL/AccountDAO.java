package calendar.DAL;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import calendar.model.Account;

public class AccountDAO extends JdbcDaoSupport implements IAccountDAO {

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
	}

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
	}

	@Override
	public Boolean deleteAccount(int accountId) {
		
		String sql = "DELETE FROM Account WHERE accountId = ?";
		
		int result = getJdbcTemplate().update(sql, accountId);
		
		if (result == 1)
			return true;
		else
			return false;
	}

	@Override
	public Account selectAccountById(int accountId) {
		
		String sql = "SELECT * FROM Account WHERE accountId = ?";
		
		Account account = (Account) getJdbcTemplate().queryForObject(sql, new Object[] { accountId }, new AccountRowMapper());
		
		return account;
	}
	
	@Override
	public Account selectAccountByName(String accountName) {
		
		String sql = "SELECT * FROM Account WHERE accountName = ?";
		try {
		Account account = (Account) getJdbcTemplate().queryForObject(sql, new Object[] { accountName }, new AccountRowMapper());
		
		return account;
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
	public List<Account> selectAllAccounts() {
		
		String sql = "SELECT * FROM Account";
		
		List<Account> accounts = getJdbcTemplate().query(sql, new BeanPropertyRowMapper<Account>(Account.class));
		
		return accounts;
	}

	@Override
	public Boolean checkIfAccountNameExists(String accountName) {
		
		String sql = "SELECT COUNT(1) FROM Account WHERE accountName = ?";
		Boolean result = false;
		
		int count = getJdbcTemplate().queryForObject(sql, new Object[] { accountName }, Integer.class );
		
		if (count > 0)
			result = true;
		
		return result;
	}
}
