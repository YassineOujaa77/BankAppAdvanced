package com.example.bankapp.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.content.Context;

import com.example.bankapp.R;
import com.example.bankapp.models.Transaction;

import java.util.ArrayList;
import java.util.List;

public class ListAdapter extends ArrayAdapter<Transaction> {

    List<Transaction> items;

    public ListAdapter (Context context , List<Transaction> transactionArrayList){
        super(context, R.layout.list_item,transactionArrayList);
        items = transactionArrayList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        Transaction transaction = getItem(position);
        if(convertView == null){

            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);
        }


        //ImageView icon = convertView.findViewById(R.id.transaction_id);
        TextView name = convertView.findViewById(R.id.transaction_name);
        TextView price = convertView.findViewById(R.id.transaction_price);
        TextView date = convertView.findViewById(R.id.transaction_date);

        //icon.setImageResource(transaction.iconId);
        name.setText(transaction.getName());
        price.setText(transaction.getPrice());
        date.setText(transaction.getDate());


        return convertView;
    }


}
