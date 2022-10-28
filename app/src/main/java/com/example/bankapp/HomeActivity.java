package com.example.bankapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;

public class HomeActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ListView listView =  findViewById(R.id.listview);
        int[] iconsId = {R.drawable.ic_baseline_wifi_24,R.drawable.ic_baseline_credit_card_24,R.drawable.ic_baseline_code_24};
        String[] names = {"wifi bill","credit card  ","code bill"};
        String[] prices = {"220","250","100"};
        String[] dates = {"15/12/22","18/04/04","17/02/22"};

        ArrayList<Transaction> transactionArrayList = new ArrayList<>();

        for(int i=0 ; i<iconsId.length ; i++){
            Transaction transaction = new Transaction(iconsId[i],names[i],prices[i],dates[i]);
            transactionArrayList.add(transaction);
        }

        ListAdapter listAdapter = new ListAdapter(this,transactionArrayList);

        listView.setAdapter(listAdapter);
        listView.setClickable(true);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(getApplicationContext(),TransactionActivity.class);
                i.putExtra("iconId",iconsId[position]);
                i.putExtra("name",names[position]);
                i.putExtra("price",prices[position]);
                i.putExtra("date",dates[position]);
                startActivity(i);

            }
        });

    }
}