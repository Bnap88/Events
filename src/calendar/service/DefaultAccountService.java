package calendar.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import calendar.DAL.IAccountDAO;
import calendar.model.Account;

@Service("accountService")
public class DefaultAccountService implements AccountService {

	@Inject private IAccountDAO accountDAO;
   
    @Override
    @Transactional
    public Account selectAccountById(int id) {
        return accountDAO.selectAccountById(id);
    }
   
    @Override
    @Transactional
    public Account selectAccountByName(String name) {
        return accountDAO.selectAccountByName(name);
    }

	@Override
	@Transactional
	public Boolean insertAccount(Account account) {
		return accountDAO.insertAccount(account);
	}

	@Override
	@Transactional
	public Boolean updateAccount(Account account) {
		return accountDAO.updateAccount(account);
	}

	@Override
	@Transactional
	public Boolean deleteAccount(int accountId) {
		return accountDAO.deleteAccount(accountId);
	}

	@Override
	@Transactional
	public List<Account> selectAllAccounts() {
		return accountDAO.selectAllAccounts();
	}

	@Override
	@Transactional
	public Boolean checkIfAccountNameExists(String name) {
		return accountDAO.checkIfAccountNameExists(name);
	}	
}
