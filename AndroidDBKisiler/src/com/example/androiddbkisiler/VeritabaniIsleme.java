package com.example.androiddbkisiler;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class VeritabaniIsleme extends SQLiteOpenHelper {

	/*Veritabaný Versiyon:
	 * Bu bilgiyi belirtmek zorundayýz.Çünkü bu sýnýfa ait yapýlandýrýcý içersinde
	 * super methodu kullanýlarak "SQLiteOpenHelper"'e bazý bilgiler gönderilir.
	 * Bu bilgiler arasýnda veritabaný versiyon bilgisi de bulunur.
	 * Versiyon bilgisi tamamen bizim insiyatifimize baðlýdýr.
	 * Dilediðiniz deðeri belirtmekte serbestsiniz.
	 * */
	private static final int DATABASE_VERSIYON = 1;

	/*Veritabaný adý:
	 *Veri tablolarýnýn tutulacaðý veritabaný ismi belirtilmelidir.
	 *Ayný isimle birden fazla veritabaný tanýmlamak mümkün deðildir.
	 **/	
	private static final String VERITABANI_ISMI = "DBRehber";

	/*Tablo adý:
	 * Veri sütunlarýn tutulduðu tablo isimi belirtilmelidir.
	 * Ayný veritabaný içersinde ayný isimle birden fazla tablo tanýmlamak
	 * mümkün deðildir.
	 * */
	private static final String TABLO_ISMI = "Kisiler";

	/*Tablo Sutun isimleri:*/
	private static final String KISI_ID = "ID";
	private static final String KISI_ADISOYADI = "Adi_Soyadi";
	private static final String KISI_TELNO = "Tel_No";
	private static final String KISI_EMAIL ="EMail";

	public VeritabaniIsleme(Context context) {
		/*Veritabaný ismi ve Veritabaný versiyon bilgisini üst sýnýfa ilet:*/
		super(context, VERITABANI_ISMI, null, DATABASE_VERSIYON);
	}

	/*Tablo Oluþtur:
	 * Normal bir aktivite'nin çalýþma noktasý "onCreate" methodu idi.
	 * "SQLiteOpenHelper" sýnýfýndan extends edilmiþ her sýnýf
	 * iki adet event(olay)'i tanýmlamak zorundadýr.
	 * Bunlardan birisi "onCreate",diðeri ise "onUpgrade" eventleridir.
	 * Sýnýf ilk çalýþtýðýnda "onCreate" methodu çaðrýlýr.
	 * Burada yapýlmasýný istediðimiz iþlemleri kodlayabiliriz.
	 * Biz de veritabaný tablosu oluþturmayý bu event içersinde tanýmladýk.
	 * Dolayýsýyla bu sýnýftan bir nesne üretilir üretilmez "onCreate" methodu çalýþacaktýr.
	 * Böylece "kayitEkle" methodundan önce veritabanýnda tablomuz oluþacaktýr.
	 * Peki,veritabaný nezaman oluþtu ?
	 * cevap:super methodunu veritabanýný oluþturmasý için kullandýk...
	 **/
	@Override
	public void onCreate(SQLiteDatabase db) {
		String KISILER_TABLOSU_OLUSTUR = "CREATE TABLE " + TABLO_ISMI + "("
				+ KISI_ID + " INTEGER PRIMARY KEY," + KISI_ADISOYADI + " TEXT,"
				+ KISI_TELNO + " TEXT" + ","+ KISI_EMAIL +" TEXT" + ")";
		db.execSQL(KISILER_TABLOSU_OLUSTUR);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		/*Veritabaný sürüm yükseltildiðinde eski tabloyu sil:
		 * Bu event bize mevcut veritabaný dýþýnda iki adet deðer döndürür.
		 * Bunlardan biri veritabanýna ait eski versiyon bilsisi,diðeri ise
		 * yeni versiyon bilgisini içerir.*/
		db.execSQL("DROP TABLE IF EXISTS " + TABLO_ISMI);
		/*Yeni tablo oluþtur:*/
		onCreate(db);
	}

	/*Yeni kayýt oluþtur:*/
	void kayitEkle(Kisiler _kisi) {
		/*Okunabilen,yazýlabilen veritabaný nesnesi oluþtur:*/
		SQLiteDatabase db = this.getWritableDatabase();
        /*Tabloya eklenecek veri'yi tanýmla:*/
		ContentValues kisi = new ContentValues();
		kisi.put(KISI_ADISOYADI, _kisi.getAdiSoyadi()); 
		kisi.put(KISI_TELNO, _kisi.getTelNo());  
		kisi.put(KISI_EMAIL, _kisi.getEmail()); 
		/*Satýr ekle:*/
		db.insert(TABLO_ISMI, null, kisi);
		/*Veritabaný baðlantýsýný kapat:*/
		db.close(); 
	}

	/*Belirtilen ID'e sahip kaydý getir:*/
	Kisiler kayitGetir(int id) {
		SQLiteDatabase db = this.getReadableDatabase();

		Cursor cursor = db.query(TABLO_ISMI, new String[] { KISI_ID,
				KISI_ADISOYADI, KISI_TELNO,KISI_EMAIL }, KISI_ID + "=?",
				new String[] { String.valueOf(id) }, null, null, null, null);
		if (cursor != null)
			cursor.moveToFirst();
/*Cursor içersinde her kayýt dizi mantýðýnda tutulur.
 * Dolayýsýyla ilk kayýt için "0",ikinci kayýt için "1" deðeri kullanýlmalýdýr.
 * Farklý yapýlar kullanýlarak index yerine sütun isimleri belirtilerek
 * cursor içersinden kayýt çekilebilir.
 */
		Kisiler kisiKayitlar = new Kisiler(Integer.parseInt(cursor.getString(0)),
				cursor.getString(1), cursor.getString(2),cursor.getString(3));
		return kisiKayitlar;
	}
	
	/*Tüm kayýtlarý getir:*/
	public List<Kisiler> kayitlariGetir() {
		List<Kisiler> kisilerListesi = new ArrayList<Kisiler>();
		/*tüm kayýtlara sorgu oluþtur:*/
		String selectQuery = "SELECT  * FROM " + TABLO_ISMI;

		SQLiteDatabase db = this.getWritableDatabase();
		Cursor cursor = db.rawQuery(selectQuery, null);
		if (cursor.moveToFirst()) {//ilk kayýt
			do {
				Kisiler kisi = new Kisiler();
				kisi.setID(Integer.parseInt(cursor.getString(0)));
				kisi.setAdiSoyadi(cursor.getString(1));
				kisi.setTelNo(cursor.getString(2));
				kisi.setEmail(cursor.getString(3));
				/*Kiþiler listesine ekle:*/
				kisilerListesi.add(kisi);
			} while (cursor.moveToNext());
		}
		return kisilerListesi;
	}

	/*Kayit güncelle:*/
	public int kayitGuncelle(Kisiler _kisi) {
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues kayit = new ContentValues();
		kayit.put(KISI_ADISOYADI, _kisi.getAdiSoyadi());
		kayit.put(KISI_TELNO, _kisi.getTelNo());
       int durum = db.update(TABLO_ISMI, kayit, KISI_ID + " = ?",
				new String[] { String.valueOf(_kisi.getID()) });
		return durum;
	}

	/*Kayýt sil:*/
	public void kayitSil(Kisiler _kisi) {
		SQLiteDatabase db = this.getWritableDatabase();
		db.delete(TABLO_ISMI, KISI_ID + " = ?",
				new String[] { String.valueOf(_kisi.getID()) });
		db.close();
	}

	/*Kayýt sayýsýný getir:*/
	public int kayitSayisi() {
		String sorgu = "SELECT  * FROM " + TABLO_ISMI;
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor cursor = db.rawQuery(sorgu, null);
		cursor.close();
		int sayi = cursor.getCount();
		return sayi;
	}

}
