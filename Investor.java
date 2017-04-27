package com.cmpe277.investor;

import android.content.Context;
import android.util.Log;

import java.io.InputStream;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Investor {

  public static final String TAG = Investor.class.getSimpleName();

  public String getCompanyId() {
    return companyId;
  }

  public void setCompanyId(String companyId) {
    this.companyId = companyId;
  }

  public String companyId;
  public String dependent;

  public String getDependent() {
    return dependent;
  }

  public void setDependent(String dependent) {
    this.dependent = dependent;
  }

  public String getpOrS() {
    return pOrS;
  }

  public void setpOrS(String pOrS) {
    this.pOrS = pOrS;
  }

  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }
  public String shortdesc;
  public String image;
  public String pOrS;
  public String url;

  public String getShortdesc() {
    return shortdesc;
  }

  public void setShortdesc(String shortdesc) {
    this.shortdesc = shortdesc;
  }

  public static ArrayList<Investor> getInvestorsFromFile(String filename, Context context){
    final ArrayList<Investor> investorList = new ArrayList<>();

    try {

     String jsonString = loadJsonFromAsset("investors.json", context);
     JSONObject json = new JSONObject(jsonString);
      JSONArray investors = json.getJSONArray("investor");

      // Get Recipe objects from data
      for(int i = 0; i < investors.length(); i++){
        Investor investor = new Investor();

      //  Log.d(TAG, investor.title + " ");
        investor.companyId = investors.getJSONObject(i).getString("title");

        investor.image = investors.getJSONObject(i).getString("image");
        investor.url = investors.getJSONObject(i).getString("url");
        investor.pOrS = investors.getJSONObject(i).getString("pOrS");
        investor.shortdesc=investors.getJSONObject(i).getString("shortdesc");
        investorList.add(investor);
      }
    } catch (JSONException e) {
      e.printStackTrace();
    }

    return investorList;
  }

  private static String loadJsonFromAsset(String filename, Context context) {
    String json = null;

    try {
      InputStream is = context.getAssets().open(filename);
      int size = is.available();
      byte[] buffer = new byte[size];
      is.read(buffer);
      is.close();
      json = new String(buffer, "UTF-8");
    }
    catch (java.io.IOException ex) {
      ex.printStackTrace();
      return null;
    }

    return json;
  }

}
