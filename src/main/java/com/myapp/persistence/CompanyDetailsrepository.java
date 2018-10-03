package com.myapp.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyDetailsrepository extends JpaRepository<CompanyDetailsEntity, Long> {
	
	//void save(CompanyDetailsEntity details);
	
    //List<CurrencyExchangeEntity> findTop10ByUsernameOrderByIdDesc(String username);

	
	//List<CompanyDetailsEntity> findall();
}
