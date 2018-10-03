package com.myapp.service;

import java.util.Date;
import java.util.List;

import com.myapp.persistence.Address;
import com.myapp.persistence.City;
import com.myapp.persistence.CompanyDetailsEntity;
import com.myapp.persistence.CurrencyExchangeEntity;
import com.myapp.persistence.UserEntity;


public interface CurrencyService {

    List<CurrencyExchangeEntity> getLastCurrencyExchanges(UserEntity user);

    void save(CompanyDetailsEntity details);
    void save(City city);
   
	CurrencyExchangeEntity requestConversion(String from, String to, Date date, int amt, String username);

	List<CompanyDetailsEntity> getCompanyDetails();

	Address getAddressDetails(String username);
}
