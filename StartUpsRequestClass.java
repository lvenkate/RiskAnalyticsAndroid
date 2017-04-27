package com.cmpe277.investor;

import android.content.Context;
import android.util.Log;
import android.widget.ListView;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;




import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by laksh on 10/5/2016.
 */
 public class StartUpsRequestClass extends android.os.AsyncTask<Void,Void,ArrayList<Investor>> {


    InvestorActivity object;
    ArrayList<Investor> result= null;

    StartUpsRequestClass(InvestorActivity object){
        this.object=object;
    }
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
   }
    @Override
    @JsonIgnoreProperties(ignoreUnknown = true)
    protected ArrayList<Investor> doInBackground(Void... params) {


        try {
            final String url = "http://ec2-54-191-3-213.us-west-2.compute.amazonaws.com:9999/investorService/list";
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
            JSONResponse jsa =  restTemplate.getForObject(url, JSONResponse.class);
            String response= "ok";
            ArrayList<Investor> list=jsa.list;
           return list;
        } catch (Exception e) {
            Log.e("StartUpList", e.getMessage(), e);
        }
        return null;
    }

    @Override
    protected void onPostExecute(ArrayList<Investor> list) {


        Iterator<Investor> iterator = list.iterator();
                while(iterator.hasNext()){
                    Investor investor = iterator.next();
                    Log.d("CompanyId ", ": " + investor.companyId);
                    Log.d("Dependent",":" + investor.dependent);
                }
        this.object.setResult(list);
        super.onPostExecute(list);
    }
}


