package com.example.bankapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;

public class TransactionActivity extends AppCompatActivity {






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction);

        ImageView iconProfile =  findViewById(R.id.transaction_profile_icon);
        TextView nameProfile = (TextView) findViewById(R.id.transaction_profile_name);
        TextView priceProfile = (TextView) findViewById(R.id.transaction_profile_price);
        TextView dateProfile = (TextView) findViewById(R.id.transaction_profile_date);

        Intent intent = this.getIntent();

        if(intent != null ){
            String name = intent.getStringExtra("name");
            String price = intent.getStringExtra("price");
            String date = intent.getStringExtra("date");
            int iconId = intent.getIntExtra("iconId",R.drawable.ic_baseline_wifi_24);

            nameProfile.setText(name);
            priceProfile.setText(price);
            dateProfile.setText(date);
            iconProfile.setImageResource(iconId);


        }


    }
}