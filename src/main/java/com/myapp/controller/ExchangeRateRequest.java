package com.myapp.controller;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * ExchangeRateRequest bean 
 * 
 
 */
public class ExchangeRateRequest {

    public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public Date getHistoryDate() {
		return historyDate;
	}

	public void setHistoryDate(Date historyDate) {
		this.historyDate = historyDate;
	}

	private String from;
    private String to;
    
    private int amt;
    public int getAmt() {
		return amt;
	}

	public void setAmt(int amt) {
		this.amt = amt;
	}
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date historyDate;
}
