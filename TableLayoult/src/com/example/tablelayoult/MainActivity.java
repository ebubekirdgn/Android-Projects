package com.example.tablelayoult;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	
	
	
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		final EditText adisoyadi = (EditText) findViewById(R.id.editText1);
		final EditText adres = (EditText) findViewById(R.id.editText3);
		final EditText tel = (EditText) findViewById(R.id.editText2);
		final EditText mail = (EditText) findViewById(R.id.editText5);
		final EditText tarih = (EditText) findViewById(R.id.editText4);
		final Button tikla = (Button) findViewById(R.id.button1);
		tikla.setOnClickListener(new OnClickListener() {
			
 
			public void onClick(View arg0) {
				 Toast.makeText(MainActivity.this, "Adýnýz : " + adisoyadi.getText()+"\n"+"Adresiniz : " + adres.getText()+"\n"+
						 "Telefon : " + tel.getText()+"\n" +"Mail : " + mail.getText()+"\n"+"Tarih : " + tarih.getText()+"\n"
						 , Toast.LENGTH_SHORT).show();
				
			}
		});
		
	}

 

}
