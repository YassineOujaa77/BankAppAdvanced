package com.example.bankapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.bankapp.R;

public class ChoiceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice);

        Button dataFromArray = (Button) findViewById(R.id.dataFromArrayBtn);
        Button dataFromSqlite = (Button) findViewById(R.id.dataFromSQLitebtn);
        Button dataFromWebService = (Button) findViewById(R.id.dataFromWebServicebtn);


        dataFromArray.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), HomeActivity.class);
                i.putExtra("operation","dataFromArrays");
                startActivity(i);
            }
        });

        dataFromSqlite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),HomeActivity.class);
                i.putExtra("operation","dataFromSqlite");
                startActivity(i);
            }
        });

        dataFromWebService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),HomeForWebServiceActivity.class);
                i.putExtra("operation","dataFromWebService");
                startActivity(i);
            }
        });



    }
}