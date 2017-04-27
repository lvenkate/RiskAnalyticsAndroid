package com.investor.model;

import java.util.ArrayList;

public class JSONResponse {

 private String response;
 private String getResponse() {
	return response;
}

public void setResponse(String response) {
	this.response = response;
}

public ArrayList<Investor> list;

public ArrayList<Investor> getInvestors() {
	return list;
}


}

