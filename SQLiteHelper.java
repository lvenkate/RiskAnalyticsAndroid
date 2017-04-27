package com.cmpe277.investor;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by laksh on 9/26/2016.
 */
public class SQLiteHelper extends SQLiteOpenHelper {
    private static final String DB_NAME="myLogindb";
    public static final String TABLE_NAME="Login";
    private static final  int DB_VERSION=1;
    public static final String user="user";
    public static final String password="password";
    private static String create_table="CREATE TABLE " + TABLE_NAME + "("+user+" VARCHAR (250), "+password+" VARCHAR(250) )";
    Context context;
    public SQLiteHelper(Context context){
        super(context,DB_NAME,null,DB_VERSION);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL(create_table);
        Toast.makeText(context,"On Create called", Toast.LENGTH_LONG).show();
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldversion, int newVersion){

    }
}
