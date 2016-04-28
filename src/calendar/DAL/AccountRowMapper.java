package calendar.DAL;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import calendar.model.Account;

public class AccountRowMapper implements RowMapper {

	@Override
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		Account account = new Account();
		
		account.setAccountId(rs.getInt("accountId"));
		account.setAccountName(rs.getString("accountName"));
		account.setAccountEmail(rs.getString("accountEmail"));
		account.setAccountPasswordHash(rs.getBytes("accountPasswordHash"));
		account.setAccountSalt(rs.getBytes("accountSalt"));
		account.setAccountCreated(rs.getTimestamp("accountCreated").toLocalDateTime());
		account.setAccountActiveState(rs.getBoolean("accountActiveState"));
		
		return account;
	}

}
