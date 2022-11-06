package com.example.bankapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.example.bankapp.R;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.example.bankapp.adapters.ListAdapter;
import com.example.bankapp.models.Transaction;
import com.example.bankapp.services.TransactionDataService;
import com.example.bankapp.util.SingletonHelper;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class HomeForWebServiceActivity extends AppCompatActivity {


    String url = "https://restfullapiy.herokuapp.com";
    ListView listViewTransaction;
    ListAdapter listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_for_web_service);


        listViewTransaction = findViewById(R.id.listview);
        List<JSONObject> transactionList = new ArrayList<JSONObject>();
        TransactionDataService transactionDataService = new TransactionDataService(HomeForWebServiceActivity.this);
        transactionDataService.getTransactions(new TransactionDataService.VolleyResponseListener() {
            @Override
            public void onError(String message) {
                transactionDataService.progressDialog.dismiss();
            }

            @Override
            public void onResponse(List<Transaction> transactions) {
                transactionDataService.progressDialog.dismiss();

                // put the entire list in listview
                listAdapter = new ListAdapter(HomeForWebServiceActivity.this,transactions);
                listViewTransaction.setAdapter(listAdapter);

                listViewTransaction.setClickable(true);
                listViewTransaction.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent i2 = new Intent(getApplicationContext(), TransactionActivity.class);
                        int pos = position;
                        Transaction transaction =  listAdapter.getItem(position);
                        //i.putExtra("TRANSACTION_ID",position+1);
                        i2.putExtra("name",transactions.get(position).getName());
                        i2.putExtra("price",transactions.get(position).getPrice());
                        i2.putExtra("date",transactions.get(position).getDate());



                        i2.putExtra("serviceType","api");
                        startActivity(i2);
                    }
                });

            }
        });



















        // Instantiate the RequestQueue.
        // RequestQueue queue = Volley.newRequestQueue(this);
        // Get a RequestQueue


        /*
        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                        Toast.makeText(HomeForWebServiceActivity.this,response,Toast.LENGTH_SHORT).show();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(HomeForWebServiceActivity.this,"Error occured !",Toast.LENGTH_SHORT).show();
            }
        });

        // Add the request to the RequestQueue.
        queue.add(stringRequest);


         */







    }
}