package com.myapp.service.impl;

import java.util.Date;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.myapp.controller.ExchangeRateRequest;

@Component("currencyvalidator") 
public class CurrencyValidator implements Validator{

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		 return ExchangeRateRequest.class.equals(arg0);
	}

	@Override
	public void validate(Object o, Errors errors) {
		// TODO Auto-generated method stub
		ExchangeRateRequest request = (ExchangeRateRequest) o;

		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "amt", "NotEmpty");
		
		if ( request.getHistoryDate()== null)
		{
       	 errors.rejectValue("historyDate", "valid.exchangeRateRequest.historyDatenull");

		}
		
		 if (null != request.getHistoryDate() && request.getHistoryDate().after(new Date()))
	        {
	        	 errors.rejectValue("historyDate", "valid.exchangeRateRequest.historyDate");
	        }
	}

}
