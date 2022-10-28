package com.example.bankapp;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {
    public static final String TABLE_NAME = "transaction";
    public DBHelper (Context context){
        super(context,"transaction.db",null,1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE" +TABLE_NAME+"(" +
                "transaction_id INTEGER PRIMARY KEY ," +
                "name TEXT ," +
                "price TEXT ," +
                "date TEXT " +
                ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public Cursor getdata ()
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("SELECT * FROM"+ TABLE_NAME,null);
        return cursor;
    }
}
