package com.example.bankapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.content.Context;
import java.util.ArrayList;

public class ListAdapter extends ArrayAdapter<Transaction> {

    public ListAdapter (Context context , ArrayList<Transaction> transactionArrayList){
        super(context,R.layout.list_item,transactionArrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        Transaction transaction = getItem(position);
        if(convertView == null){

            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);
        }


        ImageView icon = convertView.findViewById(R.id.transaction_id);
        TextView name = convertView.findViewById(R.id.transaction_name);
        TextView price = convertView.findViewById(R.id.transaction_price);
        TextView date = convertView.findViewById(R.id.transaction_date);

        icon.setImageResource(transaction.iconId);
        name.setText(transaction.name);
        price.setText(transaction.price);
        date.setText(transaction.date);






        return convertView;
    }
}
