package com.myapp.bean;

import java.math.BigDecimal;
import java.util.Map;

/**
 * Currency response bean class.
 * 
 
 */
public class CurrenyResponse {
	private String success;
	private String timestamp;
	private String source;
	private Map<String, BigDecimal> quotes;

	public String getSuccess() {
		return success;
	}

	public void setSuccess(String success) {
		this.success = success;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public Map<String, BigDecimal> getQuotes() {
		return quotes;
	}

	public void setQuotes(Map<String, BigDecimal> quotes) {
		this.quotes = quotes;
	}

	@Override
	public String toString() {
		return "CurrenyResponse [success=" + success + ", timestamp=" + timestamp + ", source=" + source + ", quotes="
				+ quotes + "]";
	}
}
