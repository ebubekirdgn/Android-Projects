package com.example.androiddbkisiler;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class VeritabaniIsleme extends SQLiteOpenHelper {

	/*Veritaban� Versiyon:
	 * Bu bilgiyi belirtmek zorunday�z.��nk� bu s�n�fa ait yap�land�r�c� i�ersinde
	 * super methodu kullan�larak "SQLiteOpenHelper"'e baz� bilgiler g�nderilir.
	 * Bu bilgiler aras�nda veritaban� versiyon bilgisi de bulunur.
	 * Versiyon bilgisi tamamen bizim insiyatifimize ba�l�d�r.
	 * Diledi�iniz de�eri belirtmekte serbestsiniz.
	 * */
	private static final int DATABASE_VERSIYON = 1;

	/*Veritaban� ad�:
	 *Veri tablolar�n�n tutulaca�� veritaban� ismi belirtilmelidir.
	 *Ayn� isimle birden fazla veritaban� tan�mlamak m�mk�n de�ildir.
	 **/	
	private static final String VERITABANI_ISMI = "DBRehber";

	/*Tablo ad�:
	 * Veri s�tunlar�n tutuldu�u tablo isimi belirtilmelidir.
	 * Ayn� veritaban� i�ersinde ayn� isimle birden fazla tablo tan�mlamak
	 * m�mk�n de�ildir.
	 * */
	private static final String TABLO_ISMI = "Kisiler";

	/*Tablo Sutun isimleri:*/
	private static final String KISI_ID = "ID";
	private static final String KISI_ADISOYADI = "Adi_Soyadi";
	private static final String KISI_TELNO = "Tel_No";
	private static final String KISI_EMAIL ="EMail";

	public VeritabaniIsleme(Context context) {
		/*Veritaban� ismi ve Veritaban� versiyon bilgisini �st s�n�fa ilet:*/
		super(context, VERITABANI_ISMI, null, DATABASE_VERSIYON);
	}

	/*Tablo Olu�tur:
	 * Normal bir aktivite'nin �al��ma noktas� "onCreate" methodu idi.
	 * "SQLiteOpenHelper" s�n�f�ndan extends edilmi� her s�n�f
	 * iki adet event(olay)'i tan�mlamak zorundad�r.
	 * Bunlardan birisi "onCreate",di�eri ise "onUpgrade" eventleridir.
	 * S�n�f ilk �al��t���nda "onCreate" methodu �a�r�l�r.
	 * Burada yap�lmas�n� istedi�imiz i�lemleri kodlayabiliriz.
	 * Biz de veritaban� tablosu olu�turmay� bu event i�ersinde tan�mlad�k.
	 * Dolay�s�yla bu s�n�ftan bir nesne �retilir �retilmez "onCreate" methodu �al��acakt�r.
	 * B�ylece "kayitEkle" methodundan �nce veritaban�nda tablomuz olu�acakt�r.
	 * Peki,veritaban� nezaman olu�tu ?
	 * cevap:super methodunu veritaban�n� olu�turmas� i�in kulland�k...
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
		/*Veritaban� s�r�m y�kseltildi�inde eski tabloyu sil:
		 * Bu event bize mevcut veritaban� d���nda iki adet de�er d�nd�r�r.
		 * Bunlardan biri veritaban�na ait eski versiyon bilsisi,di�eri ise
		 * yeni versiyon bilgisini i�erir.*/
		db.execSQL("DROP TABLE IF EXISTS " + TABLO_ISMI);
		/*Yeni tablo olu�tur:*/
		onCreate(db);
	}

	/*Yeni kay�t olu�tur:*/
	void kayitEkle(Kisiler _kisi) {
		/*Okunabilen,yaz�labilen veritaban� nesnesi olu�tur:*/
		SQLiteDatabase db = this.getWritableDatabase();
        /*Tabloya eklenecek veri'yi tan�mla:*/
		ContentValues kisi = new ContentValues();
		kisi.put(KISI_ADISOYADI, _kisi.getAdiSoyadi()); 
		kisi.put(KISI_TELNO, _kisi.getTelNo());  
		kisi.put(KISI_EMAIL, _kisi.getEmail()); 
		/*Sat�r ekle:*/
		db.insert(TABLO_ISMI, null, kisi);
		/*Veritaban� ba�lant�s�n� kapat:*/
		db.close(); 
	}

	/*Belirtilen ID'e sahip kayd� getir:*/
	Kisiler kayitGetir(int id) {
		SQLiteDatabase db = this.getReadableDatabase();

		Cursor cursor = db.query(TABLO_ISMI, new String[] { KISI_ID,
				KISI_ADISOYADI, KISI_TELNO,KISI_EMAIL }, KISI_ID + "=?",
				new String[] { String.valueOf(id) }, null, null, null, null);
		if (cursor != null)
			cursor.moveToFirst();
/*Cursor i�ersinde her kay�t dizi mant���nda tutulur.
 * Dolay�s�yla ilk kay�t i�in "0",ikinci kay�t i�in "1" de�eri kullan�lmal�d�r.
 * Farkl� yap�lar kullan�larak index yerine s�tun isimleri belirtilerek
 * cursor i�ersinden kay�t �ekilebilir.
 */
		Kisiler kisiKayitlar = new Kisiler(Integer.parseInt(cursor.getString(0)),
				cursor.getString(1), cursor.getString(2),cursor.getString(3));
		return kisiKayitlar;
	}
	
	/*T�m kay�tlar� getir:*/
	public List<Kisiler> kayitlariGetir() {
		List<Kisiler> kisilerListesi = new ArrayList<Kisiler>();
		/*t�m kay�tlara sorgu olu�tur:*/
		String selectQuery = "SELECT  * FROM " + TABLO_ISMI;

		SQLiteDatabase db = this.getWritableDatabase();
		Cursor cursor = db.rawQuery(selectQuery, null);
		if (cursor.moveToFirst()) {//ilk kay�t
			do {
				Kisiler kisi = new Kisiler();
				kisi.setID(Integer.parseInt(cursor.getString(0)));
				kisi.setAdiSoyadi(cursor.getString(1));
				kisi.setTelNo(cursor.getString(2));
				kisi.setEmail(cursor.getString(3));
				/*Ki�iler listesine ekle:*/
				kisilerListesi.add(kisi);
			} while (cursor.moveToNext());
		}
		return kisilerListesi;
	}

	/*Kayit g�ncelle:*/
	public int kayitGuncelle(Kisiler _kisi) {
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues kayit = new ContentValues();
		kayit.put(KISI_ADISOYADI, _kisi.getAdiSoyadi());
		kayit.put(KISI_TELNO, _kisi.getTelNo());
       int durum = db.update(TABLO_ISMI, kayit, KISI_ID + " = ?",
				new String[] { String.valueOf(_kisi.getID()) });
		return durum;
	}

	/*Kay�t sil:*/
	public void kayitSil(Kisiler _kisi) {
		SQLiteDatabase db = this.getWritableDatabase();
		db.delete(TABLO_ISMI, KISI_ID + " = ?",
				new String[] { String.valueOf(_kisi.getID()) });
		db.close();
	}

	/*Kay�t say�s�n� getir:*/
	public int kayitSayisi() {
		String sorgu = "SELECT  * FROM " + TABLO_ISMI;
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor cursor = db.rawQuery(sorgu, null);
		cursor.close();
		int sayi = cursor.getCount();
		return sayi;
	}

}
