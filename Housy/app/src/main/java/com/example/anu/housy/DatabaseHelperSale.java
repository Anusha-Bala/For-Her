package com.example.anu.housy;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by anu on 4/6/15.
 */
public class DatabaseHelperSale extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "housy2.db";
    private static final String TABLE_NAME2 = "sale_ad";
    private static final String COLUMN_ID1 = "id";
    private static final String COLUMN_NAME2 = "name";
    private static final String COLUMN_AMOUNT2 = "amount";
    private static final String COLUMN_ADDRESS2 = "address";
    private static final String COLUMN_CITY2 = "city";
    private static final String COLUMN_PHONE2 = "phone";

    public DatabaseHelperSale(Context context) {
        super(context, DATABASE_NAME, null, 1);

    }
    @Override
    public void onCreate(SQLiteDatabase dbsale) {
        dbsale.execSQL("create table " + TABLE_NAME2 + " (Id INTEGER PRIMARY KEY AUTOINCREMENT,Name TEXT,Amount TEXT,Address TEXT,City TEXT,Phone TEXT)");
        // Log.d("Table created",TABLE_NAME1);
    }
    @Override
    public void onUpgrade(SQLiteDatabase dbsale, int oldVersion, int newVersion) {
        dbsale.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME2);
        onCreate(dbsale);
    }

    //****************************************
//for post sale table insertion
//****************************************
    public boolean insertpostsale(String namee, String amountt, String addresss, String cityy, String phonee) {
        SQLiteDatabase dbsale = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_NAME2, namee);
        contentValues.put(COLUMN_AMOUNT2, amountt);
        contentValues.put(COLUMN_ADDRESS2, addresss);
        contentValues.put(COLUMN_CITY2, cityy);
        contentValues.put(COLUMN_PHONE2,phonee);
        long result1 = dbsale.insert(TABLE_NAME2, null, contentValues);
        if(result1 == -1)
            return false;
        else
            return true;
    }
    //****************************************
// retrive city from postrent table
//****************************************
//    public Cursor getCitysale(DatabaseHelperSale myDbSale){
//        SQLiteDatabase dbsale = myDbSale.getReadableDatabase();
//        String[]col2 = {COLUMN_NAME2,COLUMN_AMOUNT2,COLUMN_ADDRESS2,COLUMN_CITY2,COLUMN_PHONE2};
//        Cursor res2 = dbsale.query(TABLE_NAME2, col2, null, null, null, null, null);
//        return res2;
//    }
}
