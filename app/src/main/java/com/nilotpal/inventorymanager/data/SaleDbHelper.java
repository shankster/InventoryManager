package com.nilotpal.inventorymanager.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.nilotpal.inventorymanager.data.SaleContract.SaleEntry;

public class SaleDbHelper extends SQLiteOpenHelper {
    public static final String LOG_TAG=SaleDbHelper.class.getSimpleName();
    private static final String DATABSE_NAME="sale.db";
    private static final int DATABASE_VERSION = 1;

    public SaleDbHelper(Context context) {
        super(context,DATABSE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL_CREATE_SALE_TABLE="CREATE TABLE "+ SaleEntry.TABLE_NAME +" ("
                +SaleEntry._ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "
                +SaleEntry.COLUMN_ITEM_NAME+" TEXT NOT NULL, "
                +SaleEntry.COLUMN_ITEM_DESCRIPTION+" TEXT, "
                +SaleEntry.COLUMN_ITEM_IN_STOCK+" TEXT, "
                +SaleEntry.COLUMN_ITEM_QUANTITY+" TEXT NOT NULL DEFAULT 0);";
        Log.e(LOG_TAG,"The SQL entry is \n"+SQL_CREATE_SALE_TABLE);
        db.execSQL(SQL_CREATE_SALE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
