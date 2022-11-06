package com.example.bankapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.bankapp.adapters.DBAdapter;
import com.example.bankapp.adapters.ListAdapter;
import com.example.bankapp.R;
import com.example.bankapp.models.Transaction;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    DBAdapter dbAdapter ;
    ArrayList<Transaction> transactionsList;
    ListAdapter listAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ListView listView =  findViewById(R.id.listview);
        FloatingActionButton addBtnFloating = (FloatingActionButton) findViewById(R.id.floatingActionButton);
        Intent i = getIntent();

        // get all transactions from sqllite
        dbAdapter = new DBAdapter(getApplicationContext());
        transactionsList = new ArrayList<Transaction>();
        transactionsList.addAll(dbAdapter.getAllTransactions());
        listAdapter = new ListAdapter(this,transactionsList);
        listView.setAdapter(listAdapter);

        listView.setClickable(true);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(getApplicationContext(), TransactionActivity.class);
                int pos = position;
                Transaction transaction =  listAdapter.getItem(position);
                i.putExtra("TRANSACTION_ID",position+1);
                i.putExtra("serviceType","sqlite");
                startActivity(i);

            }
        });


        addBtnFloating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), AddActivity.class);
                startActivity(i);
            }
        });

    }


}