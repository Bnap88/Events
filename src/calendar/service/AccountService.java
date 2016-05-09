package calendar.service;

import java.util.List;

import calendar.DAL.AccountDAO;
import calendar.model.Account;

public interface AccountService {
	
	public Account selectAccountById(int id);
	
	public Account selectAccountByName(String name);
	
	public Boolean insertAccount(Account account);
	
	public Boolean updateAccount(Account account);
	
	public Boolean deleteAccount(int accountId);
	
	public List<Account> selectAllAccounts();
	
	public Boolean checkIfAccountNameExists(String name);

}
