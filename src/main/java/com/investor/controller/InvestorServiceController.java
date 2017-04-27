package com.investor.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.investor.service.InvestorService;

@Controller
@RequestMapping(value="/investorService",produces = {"application/json"})
@PropertySource("classpath:/url.properties")
public class InvestorServiceController {
	protected final Logger log = LoggerFactory.getLogger(getClass());

	@Autowired
	InvestorService investorService;

	@Value("${dbservices.url}")
	private String urlToGetCompanyList;

	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public @ResponseBody JSONObject listCompanies()
			throws Exception {
		log.info("Enters into .................");
		JSONObject iResponse=(JSONObject)investorService.displayStartUps(urlToGetCompanyList);
		return iResponse;

	}

}