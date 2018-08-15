package com.myapp.service.impl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

@Component("passwordvalidator")
public class PasswordValidator {
	private Pattern pattern;
	private Matcher matcher;

	private static final String PASSWORD_PATTERN = 
            "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})";
	
	public PasswordValidator() {
		pattern = Pattern.compile(PASSWORD_PATTERN);
	}

	public boolean valid(final String pasword) {
		matcher = pattern.matcher(pasword);
		return matcher.matches();
	}

}



