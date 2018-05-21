package com.sistemodevi;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class databaseIslemleri {

	String databaseCreateSorgu = "Create TABLE REHBER(id integer primary key autoincrement,"
			+ "adi text," + "soyadi text," + "tel text" + ");";

	String databaseIsmi = "veritabani";
	String tabloIsmi = "REHBER";
	int databaseVer = 1;
	SQLiteDatabase db;

	public databaseIslemleri(Context context) {
		try {
			db = context.openOrCreateDatabase(databaseIsmi, databaseVer, null);
			db.execSQL(databaseCreateSorgu);
		} catch (Exception e) {
			Log.d("hata", e.toString());
		}
	}

	public void close() {
		db.close();
	};

	public void satirEkle(String adi, String soyadi, String tcNo) {
		ContentValues cv = new ContentValues();
		cv.put("adi", adi);
		cv.put("soyadi", soyadi);
		cv.put("tel", tcNo);
		db.insert(tabloIsmi, null, cv);
	}

	public void satirDegistir(String adi, String soyadi, String tcNo,
		int satirId) {
		ContentValues cv = new ContentValues();
		cv.put("adi", adi);
		cv.put("soyadi", adi);
		cv.put("tel", adi);
		db.update(tabloIsmi, cv, "id=" + satirId, null);
	}

	public void satirSil(int satirId) {
		db.delete(tabloIsmi, "id=" + satirId, null);
	}

	public Cursor satirlariGetir() {
		return db.query(tabloIsmi, new String[] { "id,adi,soyadi,tel" }, null,
				null, null, null, null);
	}
}
