package calendar.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import calendar.DAL.AccountDAO;
import calendar.model.Account;

@Service("accountsService")
public class DefaultAccountService implements AccountService {

	@Inject private AccountDAO accountDAO;
   
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public Boolean updateAccount(Account account) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public Boolean deleteAccount(int accountId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public List<Account> selectAllAccounts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public Boolean checkIfAccountNameExists(String name) {
		// TODO Auto-generated method stub
		return null;
	}	
}
