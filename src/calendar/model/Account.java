package calendar.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Account")
public class Account implements Serializable{

    private static final long serialVersionUID = 1L;
    
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
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getAccountId() {
		return accountId;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

	@Basic(optional = false)
	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	@Basic(optional = false)
	public String getAccountEmail() {
		return accountEmail;
	}

	public void setAccountEmail(String accountEmail) {
		this.accountEmail = accountEmail;
	}

	@Basic(optional = false)
	public byte[] getAccountPasswordHash() {
		return accountPasswordHash;
	}

	public void setAccountPasswordHash(byte[] accountPasswordHash) {
		this.accountPasswordHash = accountPasswordHash;
	}

	@Basic(optional = false)
	public byte[] getAccountSalt() {
		return accountSalt;
	}

	public void setAccountSalt(byte[] accountSalt) {
		this.accountSalt = accountSalt;
	}

	@Basic(optional = false)
	public Boolean getAccountActiveState() {
		return accountActiveState;
	}

	public void setAccountActiveState(Boolean accountActiveState) {
		this.accountActiveState = accountActiveState;
	}

	@Basic(optional = false)
	public LocalDateTime getAccountCreated() {
		return accountCreated;
	}

	public void setAccountCreated(LocalDateTime accountCreated) {
		this.accountCreated = accountCreated;
	}
	
}
