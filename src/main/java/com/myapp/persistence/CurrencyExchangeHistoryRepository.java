package com.myapp.persistence;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * CurrencyExchangeHistoryRepository to save the currency and get the history 
 * 
 
 */
@Repository
public interface CurrencyExchangeHistoryRepository extends JpaRepository<CurrencyExchangeEntity, Long> {

	@Cacheable("exchangerates")
    List<CurrencyExchangeEntity> findTop10ByUsernameOrderByIdDesc(String username);
}
