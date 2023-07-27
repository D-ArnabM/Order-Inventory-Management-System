package com.orderinventory.entities;


public class JwtResponse {
	private String jwtToken;
	private String username;
	/**
	 * 
	 */
	public JwtResponse() {
		super();
	}
	/**
	 * @param jwtToken
	 * @param username
	 */
	public JwtResponse(String jwtToken, String username) {
		super();
		this.jwtToken = jwtToken;
		this.username = username;
	}
	/**
	 * @return the jwtToken
	 */
	public String getJwtToken() {
		return jwtToken;
	}
	/**
	 * @param jwtToken the jwtToken to set
	 */
	public void setJwtToken(String jwtToken) {
		this.jwtToken = jwtToken;
	}
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	
	 public static JwtResponseBuilder builder() {
	        return new JwtResponseBuilder();
	    }

	    public static class JwtResponseBuilder {
	        private String jwtToken;
	        private String username;

	        private JwtResponseBuilder() {
	        }

	        public JwtResponseBuilder jwtToken(String jwtToken) {
	            this.jwtToken = jwtToken;
	            return this;
	        }

	        public JwtResponseBuilder username(String username) {
	            this.username = username;
	            return this;
	        }

	        public JwtResponse build() {
	            return new JwtResponse(jwtToken, username);
	        }
	    }
}
