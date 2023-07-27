package com.orderinventory.entities;


public class JwtRequest {
	private String email;
	private String password;
	/**
	 * @param email
	 * @param password
	 */
	public JwtRequest(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
	/**
	 * 
	 */
	public JwtRequest() {
		super();
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

}
