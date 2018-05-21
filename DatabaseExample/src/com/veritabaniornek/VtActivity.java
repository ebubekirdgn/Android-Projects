package com.veritabaniornek;

import android.os.Bundle;
import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
 import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class VtActivity extends Activity {

	private vtolustur kisiler;
		
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_vt);
		
		kisiler=new vtolustur(this, null, null, 1);
		 
		final EditText txtadi=(EditText)findViewById(R.id.txtadi);		 
		final EditText txtsoyadi=(EditText)findViewById(R.id.txtsoyadi);
		Button kaydetbuton=(Button)findViewById(R.id.button1);
		kaydetbuton.setOnClickListener(new View.OnClickListener() {
		public void onClick(View v) {
		// TODO Auto-generated method stub
		kayitekle(txtadi.getText().toString(),txtsoyadi.getText().toString());
		//kayitekle methodu �al��t�r�l�yor, i�erisine txtadi ve txtsoyadi parametreleri giriliyor.
		Cursor cursor = KayitGetir();	 
		//cursor tan�mlan�yor. (imle�) tablo i�erisindeki verilerde dola�mak i�in kullan�lan bi nesne
		KayitGoster(cursor);	 
		//kayitgoster methodu �a��r�l�yor. 
						}
		});
		 
		 
		}
 
	    //kayitekle methodunu olu�turuyoruz 
		public void kayitekle(String adi,String soyadi)
		{
		SQLiteDatabase db=kisiler.getWritableDatabase();
		//yaz�labilir olarak dbyi tan�ml�yoruz. 
		ContentValues veriler = new ContentValues();
		//i�erikleri girmek i�in veriler adl� ContentValues olu�turuyoruz. 
		veriler.put("adi", adi);		 
		//adi alan�na adi parametresi kaydedilecek 
		veriler.put("soyadi",soyadi);
		//soyadi alan�na soyadi parametresi kaydedilecek
		db.insertOrThrow("kisiler", null, veriler);
		//ogrenci tablosunda insert komutunu �al��t�r�yoruz.a
		}
		
		private String[] SELECT = {"adi", "soyadi"}; 
		//select dizi stringine g�sterilecek alanlar� ekliyoruz.
		private Cursor KayitGetir(){
		SQLiteDatabase db = kisiler.getReadableDatabase(); 
		Cursor cursor = db.query("kisiler", SELECT, null, null, null, null, null);
		return cursor;
		} 
		//cursor i�in kullan�lan method.
		 
		private void KayitGoster(Cursor cursor)
		 {
		StringBuilder builder = new StringBuilder("Telefonunuzdaki Kayitlar:\n");
		//stringbuilderdan builder nesnesini olu�turuyoruz ve ilk �nce kay�tlar yazd�r�yoruz.
		while(cursor.moveToNext()){
		//veritaban�ndaki t�m sat�rlar d�ng� i�erisinde �a��r�l�yor 
		String adi = cursor.getString((cursor.getColumnIndex("adi")));
		String soyadi = cursor.getString((cursor.getColumnIndex("soyadi"))); 
		//adi ve soyadi de�i�kenleri olu�turulup tablodaki kay�tlar ald�r�l�yor. 
		builder.append("\nAd�:").append(adi);
		builder.append("\nSoyad�:").append(soyadi);
		//builder i�erisine sat�r bo�luklar�(n) b�rak�larak veritaban�ndan de�erler eklettiriliyor. 
		}
	    TextView sonuc=(TextView)findViewById(R.id.sonuc);
	    sonuc.setText(builder);
	    //sonuc textviewine builderdaki bilgiler aktar�l�yor.
			}
		}
