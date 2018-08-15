package com.myapp.service;

import java.util.Date;
import java.util.List;

import com.myapp.persistence.CurrencyExchangeEntity;
import com.myapp.persistence.UserEntity;


public interface CurrencyService {

    List<CurrencyExchangeEntity> getLastCurrencyExchanges(UserEntity user);

   
   
	CurrencyExchangeEntity requestConversion(String from, String to, Date date, int amt, String username);
}
