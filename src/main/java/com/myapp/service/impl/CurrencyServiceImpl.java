package com.myapp.service.impl;

import java.math.BigDecimal;
import java.math.MathContext;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import com.myapp.bean.CurrenyResponse;
import com.myapp.persistence.CurrencyExchangeEntity;
import com.myapp.persistence.CurrencyExchangeHistoryRepository;
import com.myapp.persistence.UserEntity;
import com.myapp.service.CurrencyService;


@Service
public class CurrencyServiceImpl implements CurrencyService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CurrencyServiceImpl.class);

    private static final String GET_LIVE_CURRENCY_URI = "http://apilayer.net/api/live?access_key=5357279608e0fdb983caedc5fe9f1873&currencies=%s,%s&format=1";
    private static final String GET_HISTORICAL_CURRENCY_URI = "http://apilayer.net/api/historical?access_key=5357279608e0fdb983caedc5fe9f1873&currencies=%s,%s&format=1&date=%s";
    private static final String DEFAULT_SOURCE = "USD";

   
    @Autowired
    RestTemplate restTemplate;
    @Autowired
    private CurrencyExchangeHistoryRepository currencyExchangeHistoryRepository;

    @Override
    public List<CurrencyExchangeEntity> getLastCurrencyExchanges(UserEntity user) {
        String loggedInUsername = user.getUsername();
        if (!StringUtils.isEmpty(loggedInUsername)) {
            return currencyExchangeHistoryRepository.findTop10ByUsernameOrderByIdDesc(loggedInUsername);
        }

        return Collections.emptyList();
    }

   
    @Override
	public CurrencyExchangeEntity requestConversion(String from, String to, Date date,int amt,String username) {
        BigDecimal exchangeRate = getExternalExchangeRate(from, to, date);
        if (exchangeRate == null) {
            return null;
        }

        CurrencyExchangeEntity exhangerate = new CurrencyExchangeEntity();
        exhangerate.setFromCode(from);
        exhangerate.setToCode(to);
        exhangerate.setRate(exchangeRate);
        exhangerate.setConAmt(exchangeRate.multiply(new BigDecimal(amt)));
        exhangerate.setExchangeDate(date == null ? new Date() : date);
        exhangerate.setUsername(username);

        currencyExchangeHistoryRepository.save(exhangerate);

        return exhangerate;
    }
    public  BigDecimal getExternalExchangeRate(String from, String to, Date date) {
        try {
        	 String uri;
	      //  if (date != null && date.before(new Date())) {
   	       if (date != null && new SimpleDateFormat("YYYY-MM-dd").format(date).equals(new SimpleDateFormat("YYYY-MM-dd").format(new Date()))) {

	            uri = String.format(GET_LIVE_CURRENCY_URI, from, to);


	        } else {
	            uri = String.format(GET_HISTORICAL_CURRENCY_URI, from, to, new SimpleDateFormat("YYYY-MM-dd").format(date));


	        }
           
            System.out.println("URI :::"+uri);
	        CurrenyResponse res = restTemplate.getForObject(uri, CurrenyResponse.class);
	        System.out.println("Response "+res.toString());
            BigDecimal usdFrom = res.getQuotes().get(DEFAULT_SOURCE + from);
            BigDecimal usdTo = res.getQuotes().get(DEFAULT_SOURCE + to);
            return usdTo.divide(usdFrom, MathContext.DECIMAL32);
        } catch (Exception e) {
            LOGGER.error("Exception has been occurred: ", e);
            return null;
        }
    }

}
