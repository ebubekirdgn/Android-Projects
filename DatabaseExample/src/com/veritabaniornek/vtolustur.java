package com.veritabaniornek;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class vtolustur extends SQLiteOpenHelper {

	public vtolustur(Context context, String name, CursorFactory factory,
			int version) {
		super(context, "rehber", null, 1);
		 
        //www.arifceylan.com
 
        // TODO Auto-generated constructor stub
 
    }
    @Override
 
    public void onCreate(SQLiteDatabase db) {
 
        // TODO Auto-generated method stub
 
        db.execSQL("CREATE TABLE IF NOT EXISTS kisiler (id INTEGER PRIMARY KEY  NOT NULL  UNIQUE , adi VARCHAR, soyadi VARCHAR, telefon VARCHAR);");
 
    }
    @Override
 
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
 
        // TODO Auto-generated method stub
 
        db.execSQL("DROP TABLE IF EXIST kisiler;");
 
        onCreate(db);
 
    }
 
 
}
