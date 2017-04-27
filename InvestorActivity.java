package com.cmpe277.investor;

import android.app.IntentService;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;
import android.widget.*;
import android.widget.AdapterView.OnItemClickListener;
import android.content.Intent;
import android.content.Context;

public class InvestorActivity extends AppCompatActivity {

  public static final String TAG = InvestorActivity.class.getSimpleName();
  ArrayList<Investor> investorList=null;
  private ListView mListView;
  final Context context = this;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_investor);
    StartUpsRequestClass startUpsRequestClass = new StartUpsRequestClass(this);

    startUpsRequestClass.execute();
    Intent intent = new Intent(this,LoginActivity.class);
    startActivity(intent);

  }
  public void onStart(){
    super.onStart();
  }
  void setResult(ArrayList<Investor> result){

    investorList = result;
    InvestorAdapter adapter = new InvestorAdapter(this, investorList);

    // Create list view
    mListView = (ListView) findViewById(R.id.investor_list_view);
    mListView.setAdapter(adapter);

    // Set what happens when a list view item is clicked
    mListView.setOnItemClickListener(new OnItemClickListener() {

      @Override
      public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Investor selectedInvestor = investorList.get(position);

        Intent detailIntent = new Intent(context, InvestorDetailActivity.class);
        detailIntent.putExtra("companyId", selectedInvestor.companyId);
        detailIntent.putExtra("url", selectedInvestor.url);
       startActivity(detailIntent);
      }

    });


  }

}
