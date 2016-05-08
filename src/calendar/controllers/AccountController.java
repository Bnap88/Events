package calendar.controllers;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import calendar.DAL.AccountDAO;
import calendar.DAL.IAccountDAO;
import calendar.helper.PasswordUtility;
import calendar.model.Account;
import calendar.model.formmodel.LogInFormObject;

@Controller
@RequestMapping("account")
public class AccountController {
	
	private IAccountDAO accountDAO;
	
	public AccountController(IAccountDAO accountDAO) {
		this.accountDAO = accountDAO;
	}
	
	@RequestMapping(value="login", method=RequestMethod.GET)
	public String showLoginForm(HttpSession session, Model model) {
		
		if (session.getAttribute("username") != null)
            return "redirect:/events";   
		else
		{
			LogInFormObject logInFormObject = new LogInFormObject();
			model.addAttribute("loginForm", logInFormObject);
			
			return "account/login";
		}
	}
	
	@RequestMapping(value="logout", method=RequestMethod.GET)
	public String logout(HttpSession session) {
		
		session.invalidate();
		return "redirect:/events";
	}
	
	@RequestMapping(value="register", method=RequestMethod.GET)
	public String showRegisterForm(HttpSession session) {

		if (session.getAttribute("username") != null)
            return "redirect:/events";   
		else
			return "account/register";
	}
	
	@RequestMapping(value="register", method=RequestMethod.POST)
	private String createAccount(HttpServletRequest request) 
	{
		HttpSession session = request.getSession();
		
		if (session.getAttribute("username") != null)
        {
            return "redirect:/events";
        }
        
		String username = request.getParameter("accountUsername");
		String email = request.getParameter("accountEmail");
		String password = request.getParameter("accountPassword");
		
		if (username.equals("") || email.equals("") || password.equals(""))
		{
			request.setAttribute("createFailed", true);
		    return "register";
		} 
		else if (accountDAO.checkIfAccountNameExists(username)) 
		{
			request.setAttribute("duplicateName", true);  
		    return "register";
		}
		
		addAccount(username, email, password);
		
		request.changeSessionId();
        session.setAttribute("username", username);
        return "redirect:/events";
		
	}
	
	@RequestMapping(value="login", method=RequestMethod.POST)
	private String authenticateAccount(HttpServletRequest request, HttpSession session, @ModelAttribute("loginForm") LogInFormObject logInFormObject,
			BindingResult result, Model model) 
	{	
		if (session.getAttribute("username") != null)
        {
            return "redirect:/events";
        }
            
		boolean authenticated = false;
		
		String username = logInFormObject.getAccountUsername();
        String password = logInFormObject.getAccountPassword();
        
        if (username.equals("") && password.equals(""))
        {
        	request.setAttribute("incomplete", true);
        	return "account/login";
        }
        
       authenticated = authenticateCredentials(username, password);

        if(authenticated == false)
        {
            request.setAttribute("loginFailed", true);
            return "account/login";
        }
        else
        {
        	request.changeSessionId();
            session.setAttribute("username", username);
            return "redirect:/events";
        }
	}
	
	private boolean authenticateCredentials(String username, String password) {
		boolean authenticated = false;
		
		if (accountDAO.checkIfAccountNameExists(username))    		
		{	
			Account account = accountDAO.selectAccountByName(username);
			
			byte[] salt = account.getAccountSalt();
			byte[] passwordDBHash = account.getAccountPasswordHash();
			byte[] passwordTestHash = PasswordUtility.generatePasswordHash(salt, password);
			
			if (Arrays.equals(passwordDBHash, passwordTestHash))
			{
				authenticated = true;
			}
		}
		   	
		return authenticated;
	}
	
	private void addAccount(String username, String email, String password)
	{
		//Get current LocalDateTime instance
		LocalDate date = LocalDate.now();
		LocalTime time = LocalTime.now();
		LocalDateTime dateTime = LocalDateTime.of(date, time);
		
		byte[] salt = PasswordUtility.generateSalt();
		byte[] passwordHash = PasswordUtility.generatePasswordHash(salt, password);
		
		Account account = new Account(username, email, passwordHash, salt, dateTime);
		accountDAO.insertAccount(account);
	}
}
