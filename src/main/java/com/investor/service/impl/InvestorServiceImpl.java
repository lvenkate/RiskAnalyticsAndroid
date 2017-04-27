package com.investor.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;

import com.investor.integration.RestClient;
import com.investor.model.Investor;
import com.investor.model.JSONResponse;
import com.investor.service.InvestorService;

@Service
public class InvestorServiceImpl implements InvestorService {

	protected final Logger log = LoggerFactory.getLogger(getClass());

	@Autowired
	RestClient restClient;

	@Value("${dbservices.url}")
	private String urlToGetCompanyList;

	@Override
	public JSONObject displayStartUps(String URL) {

		JSONObject jo = null;
		try {
			jo = getStartUpList(URL);
		} catch (Exception e) {
			log.error("Exception" + e);
		}
		return jo;
	}

	public JSONObject getStartUpList(String URL) throws Exception {

		JSONResponse resObj = (JSONResponse) restClient.getRequestByUrl(URL);
		ArrayList<Investor> list = resObj.getInvestors();
		JSONArray jsa = new JSONArray();
		JSONObject result = new JSONObject();
		Iterator<Investor> iterator = list.iterator();
		while (iterator.hasNext()) {
			Investor investor = iterator.next();
			{
				Float dependentf = Float.parseFloat(investor.getDependent());
				String dependent = null;
				if (dependentf >= 0.0 && dependentf <= 0.3) {
					dependent = new String("High Risk");
				} else if (dependentf >= 0.31 && dependentf <= 0.6) {
					dependent = new String("Moderate Risk");
				} else if (dependentf >= 0.61 && dependentf <= 0.8) {
					dependent = new String("Safe");
				} else if (dependentf >= 0.81 && dependentf <= 1) {
					dependent = new String("Great Returns");
				}
				JSONObject jo = new JSONObject();
				jo.put("companyId", investor.getCompanyId());
				jo.put("dependent", dependent);
				jo.put("url", investor.getUrl());
				jo.put("image", investor.getImage());
				jo.put("pOrS", investor.getpOrS());
				jo.put("shortdesc", investor.getShortdesc());
				jsa.add(jo);
			}
		}

		if (jsa != null && jsa.size() > 0) {
			result.put("response", "ok");
			result.put("list", jsa);

		} else {
			result.put("response", "704");
			result.put("list", "empty");
		}
		return result;
	}

}
