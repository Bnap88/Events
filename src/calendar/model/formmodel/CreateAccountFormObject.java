package calendar.model.formmodel;

public class CreateAccountFormObject {
	String accountUsername;
	String accountEmail;
	String accountPassword;
	String passwordMatch;
	
	public CreateAccountFormObject(String accountUsername, String accountEmail, String accountPassword,
			String passwordMatch) {
		super();
		this.accountUsername = accountUsername;
		this.accountEmail = accountEmail;
		this.accountPassword = accountPassword;
		this.passwordMatch = passwordMatch;
	}
	public String getAccountUsername() {
		return accountUsername;
	}
	public void setAccountUsername(String accountUsername) {
		this.accountUsername = accountUsername;
	}
	public String getAccountEmail() {
		return accountEmail;
	}
	public void setAccountEmail(String accountEmail) {
		this.accountEmail = accountEmail;
	}
	public String getAccountPassword() {
		return accountPassword;
	}
	public void setAccountPassword(String accountPassword) {
		this.accountPassword = accountPassword;
	}
	public String getPasswordMatch() {
		return passwordMatch;
	}
	public void setPasswordMatch(String passwordMatch) {
		this.passwordMatch = passwordMatch;
	}
}
