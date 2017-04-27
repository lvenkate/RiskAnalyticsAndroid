package com.investor.integration;

import java.io.IOException;
import java.util.Map;

import org.json.simple.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.investor.model.JSONResponse;


@Component
public class RestClient {

	public Object getRequestByUrl(String url) throws IOException {
		try {
			RestTemplate restTemplate = new RestTemplate();
			Object object = restTemplate.getForObject(url, JSONResponse.class);
			return object;
		} catch (HttpStatusCodeException e) {
			e.getResponseBodyAsString();
			// to whatever you want
		} catch (RestClientException e) {
			System.out.println("Exception");
			throw e;
		}
		return null;
	}

}
