package com.myapp.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.myapp.persistence.CurrencyExchangeEntity;
import com.myapp.persistence.UserEntity;
import com.myapp.service.CurrencyService;
import com.myapp.service.impl.CurrencyValidator;

@Controller
public class CurrencyController {

	@Autowired
	private CurrencyService currencyService;
	
	@Autowired
	private CurrencyValidator currencyvalidator;

	/* provides the list of currencies to UI dropdown*/
	@ModelAttribute("currencies")
	public List<String> currencies() {
		List<String> currencies = new ArrayList<String>();
		currencies.add("EUR");
		currencies.add("AUD");
		currencies.add("GBP");
		currencies.add("JPY");
		currencies.add("USD");
		currencies.add("UAH");
		return currencies;
	}

	@RequestMapping("/")
	public String login(Model model) {
		model.addAttribute("userForm", new UserEntity());
		return "login";
	}
	/* loads the currency converter page */
	@RequestMapping(value = { "/currency-converter" }, method = RequestMethod.GET)
	public String currencyConverter(Model model, HttpServletRequest req) {
		if (req.getSession().getAttribute("user") != null) {
			ExchangeRateRequest exchangeRateRequest = new ExchangeRateRequest();
			exchangeRateRequest.setFrom("EUR");
			exchangeRateRequest.setTo("USD");
			model.addAttribute("exchangeRateRequest", exchangeRateRequest);

			return "currency-converter";
		} else
			return "login";
	}

	/* saving the currency conversion in to DB and returns the currency converter page */
	@RequestMapping(value = "/currency-converter", method = RequestMethod.POST)
	public String currencyConverter(@ModelAttribute("exchangeRateRequest") ExchangeRateRequest request,
			BindingResult bindingResult, Model model, HttpServletRequest req) {
		if (req.getSession().getAttribute("user") != null) {
			currencyvalidator.validate(request, bindingResult);
			if (bindingResult.hasErrors()) {
				return "currency-converter";
			}
			UserEntity user = (UserEntity) req.getSession().getAttribute("user");
			CurrencyExchangeEntity exchangeRate = currencyService.requestConversion(request.getFrom(), request.getTo(),
					request.getHistoryDate(),request.getAmt(), user.getUsername());
			
			  if (exchangeRate == null) { return "currency-converter"; }
			  List<CurrencyExchangeEntity> currencyExchanges = new ArrayList<CurrencyExchangeEntity>();
			  currencyExchanges.add(exchangeRate);
			  model.addAttribute("presentCurrencyExchanges", currencyExchanges);
				ExchangeRateRequest exchangeRateRequest = new ExchangeRateRequest();
				exchangeRateRequest.setFrom("EUR");
				exchangeRateRequest.setTo("USD");
				model.addAttribute("exchangeRateRequest", exchangeRateRequest);
			 
			return "currency-converter";
		} else
			return "login";
	}
	
	/* loads the user conversion history */
	@RequestMapping(value ={ "/history" }, method = RequestMethod.GET)
	public String getHistoryConversion(Model model, HttpServletRequest req)
	{
		List<CurrencyExchangeEntity> currencyExchanges = new ArrayList<CurrencyExchangeEntity>();
		if (req.getSession().getAttribute("user") != null) {
			UserEntity user = (UserEntity) req.getSession().getAttribute("user");
			currencyExchanges = currencyService.getLastCurrencyExchanges(user);
			if( currencyExchanges.isEmpty())
			{
				model.addAttribute("nohistory", "there is no history for the user");
				ExchangeRateRequest exchangeRateRequest = new ExchangeRateRequest();
				exchangeRateRequest.setFrom("EUR");
				exchangeRateRequest.setTo("USD");
				model.addAttribute("exchangeRateRequest", exchangeRateRequest);
			}
			else
			{
			model.addAttribute("lastCurrencyExchanges", currencyExchanges);
			ExchangeRateRequest exchangeRateRequest = new ExchangeRateRequest();
			exchangeRateRequest.setFrom("EUR");
			exchangeRateRequest.setTo("USD");
			model.addAttribute("exchangeRateRequest", exchangeRateRequest);
			}
			return "currency-converter";
		} else
			return "login";
		}
	
	
}
