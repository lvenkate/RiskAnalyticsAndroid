package com.cmpe277.investor;

import java.util.ArrayList;

/**
 * Created by laksh on 10/5/2016.
 */
public class JSONResponse {

    String response;

    public String getResponse() {
        return response;
    }

    public ArrayList<Investor> getList() {
        return list;
    }

    ArrayList<Investor> list;

}
