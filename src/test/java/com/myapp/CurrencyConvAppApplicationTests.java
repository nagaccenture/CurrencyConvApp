package com.myapp;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.math.MathContext;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.expression.ParseException;
import org.springframework.test.context.junit4.SpringRunner;

import com.myapp.persistence.CurrencyExchangeEntity;
import com.myapp.persistence.CurrencyExchangeHistoryRepository;
import com.myapp.persistence.UserEntity;
import com.myapp.persistence.UserRepository;
import com.myapp.service.impl.CurrencyServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CurrencyConvAppApplicationTests {
	
	
    @Autowired()
    private CurrencyServiceImpl currencyService;
    
    @Autowired
    private   CurrencyExchangeHistoryRepository  repository;
    
  

    public static final String PASSWORD = "aBc@123";
    public static final String USERNAME = "test@gmail.com";
    public static final String FIRSTNAME = "firstname";
    public static final String LSTNAME = "lastname";

    @Autowired
    private   UserRepository userRepository;
    
  
     
    @Test
    public void saveAndFindUser() {
        UserEntity entity = createAndSaveUserEntity();

        assertNotNull(entity.getId());
        assertEquals(USERNAME, entity.getUsername());
        assertEquals(PASSWORD, entity.getPassword());

        assertEquals(entity.getId(), userRepository.findByUsername(USERNAME).getId());
    }

  

    private UserEntity createAndSaveUserEntity() {
        UserEntity entity = new UserEntity();
        entity.setUsername(USERNAME);
        entity.setPassword(PASSWORD);
        entity.setFirstname(FIRSTNAME);
        entity.setLastname(LSTNAME);

        return userRepository.save(entity);
    }
    
    private void createandsaveHistory()
    {
    for (int i = 0; i < 20; i++) {
        CurrencyExchangeEntity entity = new CurrencyExchangeEntity();
        entity.setFromCode("EUR");
        entity.setToCode("EUR");
        entity.setExchangeDate(new Date());
        entity.setUsername(USERNAME);
        entity.setRate(BigDecimal.ONE);
        entity.setConAmt(BigDecimal.TEN);

        repository.save(entity);
    }
    }
     
    @Test
    public void  getLast10EntriesOrderedById() {
       
    	createandsaveHistory();
        List<CurrencyExchangeEntity> entities = repository.findTop10ByUsernameOrderByIdDesc(USERNAME);
        assertEquals(10, entities.size());
        for (int i = 0; i < 9; i++) {
            assertTrue(entities.get(i).getId() > entities.get(i+1).getId());
        }
    }
    
   
    
    @Test
    public void shouldReturnLastCurrencyExchanges() {
    	//createAndSaveUserEntity();
        UserEntity userEntity= userRepository.findByUsername(USERNAME);
        List<CurrencyExchangeEntity> history = new ArrayList<>();

       
        //createandsaveHistory();
        history= repository.findTop10ByUsernameOrderByIdDesc(USERNAME);
        List<CurrencyExchangeEntity> entities=currencyService.getLastCurrencyExchanges(userEntity);
        assertTrue(entities.equals(history));
    }
    
    @Test
     public void requestEURUSDExchangeRate() {
    	
    	
        CurrencyExchangeEntity entity = currencyService.requestConversion("EUR", "USD", new Date(),4,USERNAME);
    	BigDecimal amount=entity.getConAmt();
    	assertNotNull(entity.getRate());
        assertNotNull(amount);
        
    }

    @Test
    public void requestEURUSD_2011_01_01_ExchangeRate() throws ParseException, java.text.ParseException {
        Date exchangeDate = new SimpleDateFormat("yyyy/MM/dd").parse("2018/08/02");
        CurrencyExchangeEntity entity = currencyService.requestConversion("EUR", "USD", exchangeDate,4,"test");
        BigDecimal rate=entity.getRate();
        System.out.println(rate.round(MathContext.DECIMAL32));
        BigDecimal amount=entity.getConAmt();
    	assertNotNull(entity.getRate());
        assertNotNull(amount);
        assertTrue(new BigDecimal(1.158453, MathContext.DECIMAL32).compareTo(rate.round(MathContext.DECIMAL32)) == 0);
    }

   
}
