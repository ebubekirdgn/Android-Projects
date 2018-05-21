package com.projeandroid;


 
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.app.Activity;
import android.content.Intent;
 

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Button arama = (Button) findViewById(R.id.buttonArama);
		Button kisi_ekle = (Button) findViewById(R.id.buttonkisi_ekle);
		Button sms = (Button) findViewById(R.id.buttonsms_gonder);
		
 
		
		arama.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
			 
				Intent arama = new Intent(MainActivity.this,arama.class);
				startActivity(arama);
				
			}
		});
		
	kisi_ekle.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
			 
				Intent arama = new Intent(MainActivity.this,kisi_ekle.class);
				startActivity(arama);
				
			}
		});
    sms.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
		 
			Intent arama = new Intent(MainActivity.this,sms.class);
			startActivity(arama);
			
		}
	}); 
	
		
	}

 
}
