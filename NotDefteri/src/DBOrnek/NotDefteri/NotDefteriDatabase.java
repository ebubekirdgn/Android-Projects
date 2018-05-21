/*
 * 
 * UYGULAMA GELİŞTİRİCİ 
 * ----TUĞRUL AŞIK----
 * 
 * WEB SITE : tugrulasik.wordpress.com
 * 
 * 
 * GELİŞTİRMELERİNİZDE YARDIMCI OLMASI DİLEĞİYLE...
 * 
 * 
 */

package DBOrnek.NotDefteri;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.util.Log;

public class NotDefteriDatabase {

	private SQLiteDatabase db;
	private final Context context;
	private final NotDefteriDBhelper dbhelper;
	
	
	//constructer
	public NotDefteriDatabase(Context c) {
		context = c;
		//Dphelper opjesiyle yeni veritabanı oluşturuluyor.
		dbhelper = new NotDefteriDBhelper(context, Sabitler.DATABASE, null,
				Sabitler.DATABASE_VERSION);
	}

	/*
	 * Veritabanını operasyonlara kapatmak 
	 * için kullandığımız method.
	 */
	public void kapat() {
		db.close();
	}
	/*
	 * Veritabanını yazma ve okuma için açtığımız method
	 *  **!** 
	 *  ->yazmak için aç, yazma operasyonu değilse exception ver catch bloğunda okumak için aç
	 */
	public void ac() throws SQLiteException {
		try {
			db = dbhelper.getWritableDatabase();
		} catch (SQLiteException ex) {
			Log.v("Open database exception caught", ex.getMessage());
			db = dbhelper.getReadableDatabase();
		}
	}

	/*
	 * Veritabanına not eklediğimiz method.
	 * insert Yapısı:
	 * ----db.insert(String table, String nullColumnHack, ContentValues icerikDegerleri)
	 */
	public long notEkle(String konu, String icerik) {
		try {
			ContentValues yeniDegerler = new ContentValues();

			yeniDegerler.put(Sabitler.KONU, konu);
			yeniDegerler.put(Sabitler.ICERIK, icerik);
			yeniDegerler.put(Sabitler.TARIH,
					java.lang.System.currentTimeMillis());
			return db.insert(Sabitler.TABLO, null, yeniDegerler);

		} catch (SQLiteException ex) {

			Log.v("Veritabanina ekleme isleminde hata tespit edildi !",
					ex.getMessage());
			return -1;
		}
	}
	
	/*
	 * Seçilen bir notu güncellemek için kullandığımız method
	 * Update yapısı:
	 * ------update(String table, ContentValues icerikDegerleri, String whereCumlecigi, 
	 *       String[] whereArgumanlari)
	 */

	public void notGuncelle(int id, String konu, String icerik) {
		
		
		ContentValues guncelDegerler = new ContentValues();
		String[] idArray = { String.valueOf(id) };

		guncelDegerler.put(Sabitler.KONU, konu);
		guncelDegerler.put(Sabitler.ICERIK, icerik);
		guncelDegerler
				.put(Sabitler.TARIH, java.lang.System.currentTimeMillis());
		db.update(Sabitler.TABLO, guncelDegerler, Sabitler.KEY_ID + "=?",
				idArray);
	}
	
	/*
	 * Veritabanından tüm notları keyID azalan sırada getirmek için 
	 * kullandığımız method. 
	 * Son eklenen notun ilk sırada gelmesi için.(Aynı işlem için Tarih bazında da sıralayabilirdik!)
	 * 
	 * query yapısı :
	 * ---db.query(String table, String[] columns, String selection, String[] selectionArgs, 
	 *     String groupBy, String having, String orderBy)
	 */

	public Cursor tumNotlariGetir() {

		Cursor c = db.query(Sabitler.TABLO, null, null, null, null, null,
				Sabitler.KEY_ID + " desc");

		return c;
	}
	
	public ArrayList<Not> tumNotlar() {
		ArrayList<Not> notlar=new ArrayList<Not>();

		Cursor c = tumNotlariGetir();
		//Curson tipinde gelen notları teker teker dolaşıyoruz
		if (c.moveToFirst()) {
			do {
				int id1 = c.getInt(c.getColumnIndex(Sabitler.KEY_ID));
				String konu = c.getString(c.getColumnIndex(Sabitler.KONU));

				String icerik = c.getString(c.getColumnIndex(Sabitler.ICERIK));
				DateFormat dateFormat = DateFormat.getDateTimeInstance();
				String tarih = dateFormat.format(new Date(c.getLong(c
						.getColumnIndex(Sabitler.TARIH))).getTime());
				Not gecici = new Not(id1, konu, icerik, tarih);
				//Veritabanındaki tüm notları birer birer ArrayList'e kaydediyoruz.
				notlar.add(gecici);

			} while (c.moveToNext());
		}
		return notlar;
	}
	
	/*
	 * Seçilen bir notu silmek için kullandığımız method.
	 *Delete Yapısı :
	 * ------delete(String table, String whereCumlecigi, String[] whereArgumanları)
	 */

	public void idIleNotSil(int id) {
		
		db.delete(Sabitler.TABLO, Sabitler.KEY_ID + "=" + id, null);
		
	}
}
