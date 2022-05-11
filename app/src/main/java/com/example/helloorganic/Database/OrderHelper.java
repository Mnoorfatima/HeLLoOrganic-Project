package com.example.helloorganic.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.helloorganic.DatabaseHelper;

public class OrderHelper extends SQLiteOpenHelper {

    public static  final  int DATABASE_VERSION=1;
    public  static final String DAtABASE_NAME="ord.db";

    public OrderHelper( Context context) {
        super(context, DAtABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL_TABLE="CREATE TABLE "+OrderContract.OrderEntry.TABLE_NAME+"("
                + OrderContract.OrderEntry._ID+"INTEGER PRIMARY KEY AUTOINCREMENT,"
                +OrderContract.OrderEntry.TABLE_NAME+"TEXT NOT NULL,"
                +OrderContract.OrderEntry.COLUMN_QUANTITY+"TEXT NOT NULL,"
                +OrderContract.OrderEntry.COLUMN_PRICE+"TEXT NOT NULL,"
                +OrderContract.OrderEntry.COLUMN_BASKET+"TEXT NOT NULL,"
                +OrderContract.OrderEntry.COLUMN_BAG+"TEXT NOT NULL);";

                db.execSQL(SQL_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
