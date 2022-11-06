package com.example.bankapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.bankapp.adapters.DBAdapter;
import com.example.bankapp.R;
import com.example.bankapp.models.Transaction;

public class TransactionActivity extends AppCompatActivity {


    DBAdapter dbAdapter ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction);

        ImageView iconProfile =  findViewById(R.id.transaction_profile_icon);
        EditText nameProfile = (EditText) findViewById(R.id.nameEditText);
        EditText priceProfile = (EditText) findViewById(R.id.priceEditText);
        EditText dateProfile = (EditText) findViewById(R.id.dateEditText);
        Button addBtn = (Button) findViewById(R.id.addBtn);


        dbAdapter = new DBAdapter(getApplicationContext());

        Intent intent = this.getIntent();

        if(intent != null ){
            int id = intent.getIntExtra("TRANSACTION_ID",0);
            if(intent.getStringExtra("serviceType").equals("api")){

                nameProfile.setText(intent.getStringExtra("name"));
                priceProfile.setText(intent.getStringExtra("price"));
                dateProfile.setText(intent.getStringExtra("date"));

            }else if(intent.getStringExtra("serviceType").equals("sqlite")){

                Transaction transaction1 = dbAdapter.getTransaction(id);
                if(transaction1 != null){
                    nameProfile.setText(transaction1.getName());
                    priceProfile.setText(transaction1.getPrice());
                    dateProfile.setText(transaction1.getDate());
                }

            }

        }




        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Transaction transaction = new Transaction();
                transaction.setName(nameProfile.getText().toString().trim());
                transaction.setPrice(priceProfile.getText().toString().trim());
                transaction.setDate(dateProfile.getText().toString().trim());
                DBAdapter dbAdapter = new DBAdapter(getApplicationContext());
                dbAdapter.addTransaction(transaction);
            }
        });



    }



}