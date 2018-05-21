package com.projeandroid;


 
import com.projeandroid.veritabanim;
import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
 
import android.widget.Button;
import android.widget.EditText;
 
import android.widget.TextView;
import android.widget.Toast;
 

public class kisi_ekle extends Activity {
 
	 private veritabanim rehber;
	
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.kisi_ekle);
		
		rehber = new veritabanim(this); 
		Button kaydet = (Button) findViewById(R.id.buttonKaydet);
		final EditText adi = (EditText) findViewById(R.id.adi);
		final EditText numarasi = (EditText) findViewById(R.id.numarasi);
		
		 
		
		
         kaydet.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				try
				{
					KayitEkle(adi.getText().toString(),numarasi.getText().toString());
					Cursor cursor = KayitGetir();
					KayitGoster(cursor);
				}
				finally
				{
					rehber.close();
				}
			
			}	
		});	
	}

			private void KayitEkle(String adi, String numarasi) {
				
				SQLiteDatabase db = rehber.getWritableDatabase();
				ContentValues veriler= new ContentValues();
				veriler.put("adi",adi);
				veriler.put("numara",numarasi);
		 
				db.insertOrThrow("kisiler", null, veriler);
			 
				 Toast.makeText(kisi_ekle.this,"Kayýt Edildi",Toast.LENGTH_SHORT).show();
			 
				
				
			}
			
			private String[] SELECT ={"id","adi","numara"};
			@SuppressWarnings("deprecation")
			
			private Cursor KayitGetir() {
				SQLiteDatabase db = rehber.getReadableDatabase();
			 	
				Cursor cursor = db.query("kisiler",SELECT, null, null, null, null, null);
			    startManagingCursor(cursor);
				
				return cursor;
			}
		
         
		
			private void KayitGoster(Cursor cursor) {
				StringBuilder builder  =new StringBuilder("Kayitlar:\n");
				
				while(cursor.moveToNext())
				{
						long id = cursor.getLong(cursor.getColumnIndex("id"));
						String ad = cursor.getString(cursor.getColumnIndex("adi"));
						int numara = cursor.getInt(cursor.getColumnIndex("numara"));
						builder.append(id).append("Adý :");
						builder.append(ad).append("Soyadi :");
						builder.append(numara).append("\n");
				 
		 
			 
				}
				TextView text = (TextView) findViewById(R.id.textViewsonucgoster);
				text.setText(builder);
					
					
				}
			
}
 
