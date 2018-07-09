package com.example.bhargav.shopforme;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by user on 26-02-2017.
 */

public class UserDbHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "table_name.db";
    String PRODUCT_NAME = product_detail.x;
    int PRODUCT_COUNT=0;
    String stringProductCount = Integer.toString(PRODUCT_COUNT);
    private static final int DATABASE_VERSION = 1;
   private static final String CREATE_QUERY = "CREATE TABLE "+ UserContract.NewUserInfo.TABLE_NAME+"("+ UserContract.NewUserInfo.scanneditem+"  TEXT, "+ UserContract.NewUserInfo.counter+" TEXT);";

    String ENTRY_QUERY = "INSERT INTO table_name(productName,numberOfProducts) VALUES(" + PRODUCT_NAME + "," + PRODUCT_COUNT + ")";

    public UserDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        Log.e("DATABASE OPERATIONS", "DATABASE CREATED/OPENED...");

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_QUERY);
        Log.e("DATABASE OPERATIONS", "TABLE CREATED...");
    }

    public String addInformation(String scanned, String c, SQLiteDatabase db) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(UserContract.NewUserInfo.scanneditem, scanned);
        contentValues.put(UserContract.NewUserInfo.counter, c);
        db.insert(UserContract.NewUserInfo.TABLE_NAME, null, contentValues);
        Log.e("DATABASE OPERATIONS", "ONE ROW INSERTED...");

        return db.getPath();

    }
    public Cursor getinformation(SQLiteDatabase db)
    {
        Cursor cursor;
        String[] projections={UserContract.NewUserInfo.scanneditem,UserContract.NewUserInfo.counter};
        cursor=db.query(UserContract.NewUserInfo.TABLE_NAME,projections,null,null,null,null,null);
        return cursor;
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}
