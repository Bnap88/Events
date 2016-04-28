package calendar.DAL;

import java.util.List;

import calendar.model.Account;

public interface IAccountDAO {

	//Insert an Account
	public Boolean insertAccount(Account account);
	
	//Update an Account
	public Boolean updateAccount(Account account);
	
	//Delete an Account
	public Boolean deleteAccount(int accountId);
	
	//Select one Account by accountId
	public Account selectAccountById(int accountId);
	
	//Select one Account by accountName
	public Account selectAccountByName(String accountName);
	
	//Select all Accounts
	public List<Account> selectAllAccounts();
	
	//Select Account by accountName
	public Boolean checkIfAccountNameExists(String name);
	
}
