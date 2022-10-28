package com.example.bankapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

import butterknife.BindView;
import butterknife.OnClick;


public class MainActivity extends AppCompatActivity {

    // create references




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView username = (TextView) findViewById(R.id.username);
        TextView password = (TextView) findViewById(R.id.password);
        MaterialButton loginbtn = (MaterialButton) findViewById(R.id.loginbtn);
        CheckBox rememberMe = (CheckBox) findViewById(R.id.rememberMe);
        // admin and admin user

        // verify if already login
        SharedPreferences preferences = getSharedPreferences("checkbox",MODE_PRIVATE);
        String remeberMeCheckbox = preferences.getString("remember","");
        if(remeberMeCheckbox.equals("true")){
            Intent intent = new Intent(MainActivity.this,HomeActivity.class);
            startActivity(intent);
        }else if(remeberMeCheckbox.equals("true")){
            Toast.makeText(this,"Please login",Toast.LENGTH_SHORT).show();
        }

        // event listener for log in click

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(username.getText().toString().equals("admin") && password.getText().toString().equals("admin")){
                    Intent intent = new Intent(getApplicationContext(),HomeActivity.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(MainActivity.this,"LOGIN FAILED !!! ",Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Shared Prefrences
        SharedPreferences.Editor editor = preferences.edit();

        rememberMe.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(buttonView.isChecked()){

                    editor.putString("remember","true");
                    editor.apply();
                    Toast.makeText(MainActivity.this,"CHECKED ",Toast.LENGTH_SHORT).show();

                }else if(!buttonView.isChecked()){

                    editor.putString("remember","false");
                    editor.apply();
                    Toast.makeText(MainActivity.this,"CHECKED ",Toast.LENGTH_SHORT).show();

                }
            }
        });




    }
}