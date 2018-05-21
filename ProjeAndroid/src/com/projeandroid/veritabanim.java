package com.projeandroid;

import android.content.Context;
 
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class veritabanim extends SQLiteOpenHelper{
	
	private static final int SURUM = 1;
	private static final String VERITABANI = "rehber";

	public veritabanim(Context con)
	{
		super(con,VERITABANI,null,SURUM);
		
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		
		db.execSQL("CREATE TABLE kisiler(id INTEGER PRIMARY KEY AUTOINCREMENT,adi TEXT,numara INTEGER)");
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int arg1, int arg2) {
		db.execSQL("DROP TABLE IF EXIST telefonrehberi");
		onCreate(db);
		
	}
	 
}
