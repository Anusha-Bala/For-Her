package com.example.anu.housy;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by anu on 26/5/15.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "housy.db";
    private static final String TABLE_NAME = "user_details";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_UNAME = "uname";
    private static final String COLUMN_EMAIL = "email";
    private static final String COLUMN_PSWD = "pswd";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + " (Id INTEGER PRIMARY KEY AUTOINCREMENT,Name TEXT,Uname TEXT,Email TEXT,Pswd TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);

    }
//****************************************
//for login table insertion
//****************************************
    public boolean insertData(String name, String uname, String email, String pswd) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_NAME, name);
        contentValues.put(COLUMN_UNAME, uname);
        contentValues.put(COLUMN_EMAIL, email);
        contentValues.put(COLUMN_PSWD, pswd);
        long result = db.insert(TABLE_NAME, null, contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }

//****************************************
// retrive uname,pass from user_details table
//****************************************

    public Cursor getAllData(DatabaseHelper myDb){
        SQLiteDatabase db = myDb.getReadableDatabase();
        String[]col = {COLUMN_NAME,COLUMN_UNAME,COLUMN_EMAIL,COLUMN_PSWD,};
        Cursor res = db.query(TABLE_NAME, col, null, null, null, null, null);
        return res;
    }
}

