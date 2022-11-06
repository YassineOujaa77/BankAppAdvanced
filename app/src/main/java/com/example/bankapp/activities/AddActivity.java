package com.example.bankapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.bankapp.adapters.DBAdapter;
import com.example.bankapp.R;
import com.example.bankapp.models.Transaction;

public class AddActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        EditText nameProfile = (EditText) findViewById(R.id.nameEditText);
        EditText priceProfile = (EditText) findViewById(R.id.priceEditText);
        EditText dateProfile = (EditText) findViewById(R.id.dateEditText);
        Button addBtn = (Button) findViewById(R.id.addBtn);


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