package com.myapp.persistence;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "CURRENCY_EXCHANGE_HISTORY")

public class CurrencyExchangeEntity {

   

	@Id
    @GeneratedValue
    private Long id;
    private String fromCode;
    private String toCode;
    private BigDecimal rate;
    private BigDecimal conAmt;
    
    public BigDecimal getConAmt() {
		return conAmt;
	}

	public void setConAmt(BigDecimal conAmt) {
		this.conAmt = conAmt;
	}

	private Date exchangeDate;
    private String username;

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFromCode() {
		return fromCode;
	}

	public void setFromCode(String fromCode) {
		this.fromCode = fromCode;
	}

	public String getToCode() {
		return toCode;
	}

	public void setToCode(String toCode) {
		this.toCode = toCode;
	}

	public BigDecimal getRate() {
		return rate;
	}

	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}

	public Date getExchangeDate() {
		return exchangeDate;
	}

	public void setExchangeDate(Date exchangeDate) {
		this.exchangeDate = exchangeDate;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Transient
    public BigDecimal getDisplayRate() {
        return rate.setScale(2, RoundingMode.HALF_EVEN);
    }

    @Transient
    public String getDisplayExchangeDate() {
        return new SimpleDateFormat("dd-MM-YYYY").format(getExchangeDate());
    }
    @Override
   	public int hashCode() {
   		final int prime = 31;
   		int result = 1;
   		result = prime * result + ((conAmt == null) ? 0 : conAmt.hashCode());
   		result = prime * result + ((exchangeDate == null) ? 0 : exchangeDate.hashCode());
   		result = prime * result + ((fromCode == null) ? 0 : fromCode.hashCode());
   		result = prime * result + ((id == null) ? 0 : id.hashCode());
   		result = prime * result + ((rate == null) ? 0 : rate.hashCode());
   		result = prime * result + ((toCode == null) ? 0 : toCode.hashCode());
   		result = prime * result + ((username == null) ? 0 : username.hashCode());
   		return result;
   	}

   	@Override
   	public boolean equals(Object obj) {
   		if (this == obj)
   			return true;
   		if (obj == null)
   			return false;
   		if (getClass() != obj.getClass())
   			return false;
   		CurrencyExchangeEntity other = (CurrencyExchangeEntity) obj;
   		if (conAmt == null) {
   			if (other.conAmt != null)
   				return false;
   		} else if (!conAmt.equals(other.conAmt))
   			return false;
   		if (exchangeDate == null) {
   			if (other.exchangeDate != null)
   				return false;
   		} else if (!exchangeDate.equals(other.exchangeDate))
   			return false;
   		if (fromCode == null) {
   			if (other.fromCode != null)
   				return false;
   		} else if (!fromCode.equals(other.fromCode))
   			return false;
   		if (id == null) {
   			if (other.id != null)
   				return false;
   		} else if (!id.equals(other.id))
   			return false;
   		if (rate == null) {
   			if (other.rate != null)
   				return false;
   		} else if (!rate.equals(other.rate))
   			return false;
   		if (toCode == null) {
   			if (other.toCode != null)
   				return false;
   		} else if (!toCode.equals(other.toCode))
   			return false;
   		if (username == null) {
   			if (other.username != null)
   				return false;
   		} else if (!username.equals(other.username))
   			return false;
   		return true;
   	}
}
