package com.example.androiddbkisiler;

import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ActivityEkle extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
	   super.onCreate(savedInstanceState);
	   setContentView(R.layout.activity_ekle);
		//
	  final EditText edit_adisoyadi = (EditText)findViewById(com.example.androiddbkisiler.R.id.edit_adiSoyadi);
	  final EditText edit_telno = (EditText)findViewById(com.example.androiddbkisiler.R.id.edit_telno);
	  final EditText edit_email = (EditText)findViewById(com.example.androiddbkisiler.R.id.edit_email);
	   Button btn_yeni = (Button)findViewById(com.example.androiddbkisiler.R.id.button_yeni);
	   Button btn_ekle = (Button)findViewById(com.example.androiddbkisiler.R.id.button_ekle);
 
	   btn_yeni.setOnClickListener(new View.OnClickListener() {
		@Override
		public void onClick(View v) {
         edit_adisoyadi.setText("");
         edit_telno.setText("");
         edit_email.setText("");
         
		}
	});
	   btn_ekle.setOnClickListener(new View.OnClickListener() {
		@Override
		public void onClick(View v) {
         String adi_soyadi = edit_adisoyadi.getText().toString();
         String tel_no = edit_telno.getText().toString();
         String email = edit_email.getText().toString();
         
        VeritabaniIsleme veritabani = new VeritabaniIsleme(getApplicationContext());
	   /*kayýt ekle:*/
	   veritabani.kayitEkle(new Kisiler(adi_soyadi,tel_no,email));
 
		}
	});
	   //
	
	
	}//onCreate
	

}
