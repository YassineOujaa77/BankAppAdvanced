package com.example.bankapp.adapters;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.example.bankapp.util.DBHelper;
import com.example.bankapp.models.Transaction;

import java.util.ArrayList;

public class DBAdapter {

    private DBHelper dbHelper ;

    private static final String TABLE_NAME = "transactions";
    private static final String DATABASE_NAME = "transaction.db";
    private static final int DATABASE_VERSION = 1 ;


    public DBAdapter(Context context) {
        dbHelper = new DBHelper(context);

    }

    public void addTransaction(Transaction transaction) {
        SQLiteDatabase db = dbHelper.getWritableDatabase(); // to write on out table
        ContentValues cv = new ContentValues(); // where we going to store our data

        // we store data in cv object
        cv.put("name",transaction.getName());
        cv.put("price",transaction.getPrice());
        cv.put("date",transaction.getDate());

        // insert data
        long result = db.insert(TABLE_NAME,null,cv);
        if(result == -1 ){
            Toast.makeText(dbHelper.context,"FAILED ",Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(dbHelper.context,"Added successfully " ,Toast.LENGTH_SHORT).show();
        }
    }

    public ArrayList<Transaction> getAllTransactions(){
        ArrayList<Transaction> transactions = new ArrayList<Transaction>();
        String query = "SELECT * FROM " + TABLE_NAME ;
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        Cursor cursor = db.rawQuery(query,null);
        if(cursor.getCount() == 0 ){
            Toast.makeText(dbHelper.context,"No data ",Toast.LENGTH_LONG).show();
        }else{
            while (cursor.moveToNext()){
                transactions.add(new Transaction(
                        cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3)));
            }
        }


        cursor.close();
        db.close();
        return transactions;
    }

    public Transaction getTransaction(int id){
        String query = "SELECT * FROM " + TABLE_NAME + " WHERE transaction_id ="+id ;
        SQLiteDatabase db = dbHelper.getReadableDatabase();


        Cursor cursor = db.rawQuery(query,null);
        cursor.moveToFirst();
        Transaction transaction = new Transaction(
               cursor.getInt(0),
               cursor.getString(1),
               cursor.getString(2),
               cursor.getString(3));


        cursor.close();
        db.close();
        return transaction;
    }
}
