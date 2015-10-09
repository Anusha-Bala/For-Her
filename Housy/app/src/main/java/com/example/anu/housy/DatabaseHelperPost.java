package com.example.anu.housy;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by anu on 2/6/15.
 */
public class DatabaseHelperPost extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "housy1.db";
    private static final String TABLE_NAME1 = "post_ad";
    private static final String COLUMN_ID1 = "id";
    private static final String COLUMN_NAME1 = "name";
    private static final String COLUMN_AMOUNT = "amount";
    private static final String COLUMN_ADDRESS = "address";
    private static final String COLUMN_CITY = "city";
    private static final String COLUMN_PHONE = "phone";

    public DatabaseHelperPost(Context context) {
        super(context, DATABASE_NAME, null, 1);

    }
    @Override
    public void onCreate(SQLiteDatabase dbpost) {
        dbpost.execSQL("create table " + TABLE_NAME1 + " (Id INTEGER PRIMARY KEY AUTOINCREMENT,Name TEXT,Amount TEXT,Address TEXT,City TEXT,Phone TEXT)");
       // Log.d("Table created",TABLE_NAME1);
    }
    @Override
    public void onUpgrade(SQLiteDatabase dbpost, int oldVersion, int newVersion) {
        dbpost.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME1);
        onCreate(dbpost);
    }

    //****************************************
//for post rent table insertion
//****************************************
    public boolean insertpostrent(String name, String amount, String address, String city, String phone) {
        SQLiteDatabase dbpost = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_NAME1, name);
        contentValues.put(COLUMN_AMOUNT, amount);
        contentValues.put(COLUMN_ADDRESS, address);
        contentValues.put(COLUMN_CITY, city);
        contentValues.put(COLUMN_PHONE,phone);
        long result1 = dbpost.insert(TABLE_NAME1, null, contentValues);
        if(result1 == -1)
            return false;
        else
            return true;
    }
//****************************************
// retrive city from postrent table
//****************************************
    public Cursor getCity(DatabaseHelperPost myDbPost){
        SQLiteDatabase dbpost = myDbPost.getReadableDatabase();
        String[]col1 = {COLUMN_NAME1,COLUMN_AMOUNT,COLUMN_ADDRESS,COLUMN_CITY,COLUMN_PHONE};
        Cursor res1 = dbpost.query(TABLE_NAME1, col1, null, null, null, null, null);
        return res1;
    }
}
