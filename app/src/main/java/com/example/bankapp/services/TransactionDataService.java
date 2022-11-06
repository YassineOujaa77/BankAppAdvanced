package com.example.bankapp.services;

import android.app.ProgressDialog;
import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.example.bankapp.activities.MainActivity;
import com.example.bankapp.models.Transaction;
import com.example.bankapp.util.SingletonHelper;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class TransactionDataService {

    public static final String URL = "https://restfullapiy.herokuapp.com/api/v0/transactions";
    Context context ;
    public ProgressDialog progressDialog;

    public TransactionDataService(Context context) {
        this.context = context;
    }

    public interface VolleyResponseListener {
        void onError(String message);

        void onResponse(List<Transaction> transactions);
    }


    public void getTransactions(VolleyResponseListener volleyResponseListener){
        String url = URL;
        List<Transaction> transactionList = new ArrayList<Transaction>();


        // we are expecting Json array
        JsonArrayRequest request =
                new JsonArrayRequest(Request.Method.GET,url,null, new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {

                        //  get json object

                        int length = response.length();

                        try {

                            for(int i = 0; i < length ; i++){
                                JSONObject data = (JSONObject) response.get(i);
                                Transaction transaction = new Transaction();
                                transaction.setId(data.getInt("id"));
                                transaction.setName(data.getString("name"));
                                transaction.setPrice(data.getString("price"));
                                transaction.setDate(data.getString("date"));
                                transactionList.add(transaction);
                            }


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                        //Toast.makeText(context, , Toast.LENGTH_LONG).show();
                        volleyResponseListener.onResponse(transactionList);
                    }
                },new Response.ErrorListener(){
                    @Override
                    public void onErrorResponse(VolleyError error){
                        Toast.makeText(context,"Something wrong",Toast.LENGTH_SHORT).show();
                        volleyResponseListener.onError("Something wrong");
                    }
                });

        // queue.add(request);
        // Add a request (in this example, called stringRequest) to your RequestQueue.
        SingletonHelper.getInstance(context).addToRequestQueue(request);

        progressDialog = new ProgressDialog(context);
        progressDialog.setMessage("processing results");
        progressDialog.setCancelable(false);
        progressDialog.show();

    }






}
