package calendar.model;

import java.time.LocalDateTime;

public class Account {

	private Integer accountId;
	private String accountName;
	private String accountEmail;
	private byte[] accountPasswordHash;
	private byte[] accountSalt;
	private LocalDateTime accountCreated;
	private Boolean accountActiveState;
	
	/**
	 * These fields will be for the upcoming feature of resetting an account password
	 * 
	private String accountPasswordResetToken;
	private Boolean accountPasswordResetTokenState;
	private LocalDateTime accountPasswordResetTokenActivated;
	**/
	
	public Account(){}
	
	public Account(String accountName, String accountEmail, byte[] accountPasswordHash,
			byte[] accountSalt, LocalDateTime accountCreated) {
		
		this.accountName = accountName;
		this.accountEmail = accountEmail;
		this.accountPasswordHash = accountPasswordHash;
		this.accountSalt = accountSalt;
		this.accountCreated = accountCreated;
		this.accountActiveState = true;
	}
	
	public Integer getAccountId() {
		return accountId;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getAccountEmail() {
		return accountEmail;
	}

	public void setAccountEmail(String accountEmail) {
		this.accountEmail = accountEmail;
	}

	public byte[] getAccountPasswordHash() {
		return accountPasswordHash;
	}

	public void setAccountPasswordHash(byte[] accountPasswordHash) {
		this.accountPasswordHash = accountPasswordHash;
	}

	public byte[] getAccountSalt() {
		return accountSalt;
	}

	public void setAccountSalt(byte[] accountSalt) {
		this.accountSalt = accountSalt;
	}

	public Boolean getAccountActiveState() {
		return accountActiveState;
	}

	public void setAccountActiveState(Boolean accountActiveState) {
		this.accountActiveState = accountActiveState;
	}

	public LocalDateTime getAccountCreated() {
		return accountCreated;
	}

	public void setAccountCreated(LocalDateTime accountCreated) {
		this.accountCreated = accountCreated;
	}
}