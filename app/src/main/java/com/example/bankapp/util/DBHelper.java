package com.example.bankapp.util;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;
import java.util.List;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {

    private static final String TABLE_NAME = "transactions";
    private static final String DATABASE_NAME = "transaction.db";
    private static final int DATABASE_VERSION = 1 ;


    public Context context ;


    public DBHelper (@Nullable Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
        this.context = context;
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " +TABLE_NAME+" (" +
                "transaction_id INTEGER PRIMARY KEY ," +
                "name TEXT ," +
                "price TEXT ," +
                "date TEXT " +
                ");");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME);
        onCreate(db);
    }



}
