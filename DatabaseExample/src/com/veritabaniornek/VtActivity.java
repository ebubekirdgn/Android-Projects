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
		//kayitekle methodu çalýþtýrýlýyor, içerisine txtadi ve txtsoyadi parametreleri giriliyor.
		Cursor cursor = KayitGetir();	 
		//cursor tanýmlanýyor. (imleç) tablo içerisindeki verilerde dolaþmak için kullanýlan bi nesne
		KayitGoster(cursor);	 
		//kayitgoster methodu çaðýrýlýyor. 
						}
		});
		 
		 
		}
 
	    //kayitekle methodunu oluþturuyoruz 
		public void kayitekle(String adi,String soyadi)
		{
		SQLiteDatabase db=kisiler.getWritableDatabase();
		//yazýlabilir olarak dbyi tanýmlýyoruz. 
		ContentValues veriler = new ContentValues();
		//içerikleri girmek için veriler adlý ContentValues oluþturuyoruz. 
		veriler.put("adi", adi);		 
		//adi alanýna adi parametresi kaydedilecek 
		veriler.put("soyadi",soyadi);
		//soyadi alanýna soyadi parametresi kaydedilecek
		db.insertOrThrow("kisiler", null, veriler);
		//ogrenci tablosunda insert komutunu çalýþtýrýyoruz.a
		}
		
		private String[] SELECT = {"adi", "soyadi"}; 
		//select dizi stringine gösterilecek alanlarý ekliyoruz.
		private Cursor KayitGetir(){
		SQLiteDatabase db = kisiler.getReadableDatabase(); 
		Cursor cursor = db.query("kisiler", SELECT, null, null, null, null, null);
		return cursor;
		} 
		//cursor için kullanýlan method.
		 
		private void KayitGoster(Cursor cursor)
		 {
		StringBuilder builder = new StringBuilder("Telefonunuzdaki Kayitlar:\n");
		//stringbuilderdan builder nesnesini oluþturuyoruz ve ilk önce kayýtlar yazdýrýyoruz.
		while(cursor.moveToNext()){
		//veritabanýndaki tüm satýrlar döngü içerisinde çaðýrýlýyor 
		String adi = cursor.getString((cursor.getColumnIndex("adi")));
		String soyadi = cursor.getString((cursor.getColumnIndex("soyadi"))); 
		//adi ve soyadi deðiþkenleri oluþturulup tablodaki kayýtlar aldýrýlýyor. 
		builder.append("\nAdý:").append(adi);
		builder.append("\nSoyadý:").append(soyadi);
		//builder içerisine satýr boþluklarý(n) býrakýlarak veritabanýndan deðerler eklettiriliyor. 
		}
	    TextView sonuc=(TextView)findViewById(R.id.sonuc);
	    sonuc.setText(builder);
	    //sonuc textviewine builderdaki bilgiler aktarýlýyor.
			}
		}
