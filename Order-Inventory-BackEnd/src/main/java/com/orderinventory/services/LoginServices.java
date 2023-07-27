package com.orderinventory.services;

import java.sql.Date;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.orderinventory.entities.Login;
import com.orderinventory.repo.LoginRepository;

@Service
public class LoginServices implements UserDetailsService{
	
	@Autowired
	private LoginRepository loginRepository;
	
	
	 @Autowired
	 private PasswordEncoder passwordEncoder;
	 
	 
//	public boolean validateLogIn(Login frontEndLogin) {
//		Login backEndLogin = loginRepository.findByEmailAddress(frontEndLogin.getEmailAddress());
//		if(backEndLogin!=null) {
//		if(backEndLogin.getEmailAddress().equals(frontEndLogin.getEmailAddress()) && backEndLogin.getPassword().equals(frontEndLogin.getPassword())) {
//			backEndLogin.setActive(true);
//			return true;
//			}
//		}
//		return false;
//	}

	@Override
	public UserDetails loadUserByUsername(String emailAddress) throws UsernameNotFoundException {
		//Loading user from Database
		Login login = loginRepository.findByEmailAddress(emailAddress).orElseThrow(()-> new RuntimeException("User Not Found !!!"));
		return login;
	}
	
	public Login createLogin(Login login) {
		LocalDate currentDate = LocalDate.now();
		Date date = Date.valueOf(currentDate);
		String encryptedPassword = passwordEncoder.encode(login.getPassword());
		login.setPassword(encryptedPassword);
		login.setCreatedOn(date);
		
		return loginRepository.save(login);
	}
}
