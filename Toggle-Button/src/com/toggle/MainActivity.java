package com.toggle;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.ToggleButton;
import android.app.Activity;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
	   final ToggleButton Ciftdurumludugme = (ToggleButton) findViewById(R.id.tgbtnkilitli);
	   final EditText kullaniciadi = (EditText) findViewById(R.id.Etkullaniciadi);
	   final EditText parola = (EditText) findViewById(R.id.EtParolasi);
		
	   final Button onayladugmesi = (Button) findViewById(R.id.button1);
	   kullaniciadi.setEnabled(false);
	   parola.setEnabled(false);
	   onayladugmesi.setEnabled(false);
	    
		Ciftdurumludugme.setOnClickListener(new OnClickListener() {
	 
			public void onClick(View v) {
			 
				if(Ciftdurumludugme.isChecked())
				{
					Toast.makeText(MainActivity.this, "AÇIK", Toast.LENGTH_LONG).show();
					kullaniciadi.setEnabled(true);
					parola.setEnabled(true);
				    onayladugmesi.setEnabled(true);
				}
				else
				{
					Toast.makeText(MainActivity.this, "KAPALI", Toast.LENGTH_LONG).show();
					kullaniciadi.setEnabled(false);
					parola.setEnabled(false);
				    onayladugmesi.setEnabled(false);
				}	
			}
		});
		onayladugmesi.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				 
				Toast.makeText(MainActivity.this,"Kullanýcý Adý :" + kullaniciadi.getText().toString() + "\n" + " Parola " + parola.getText(), Toast.LENGTH_LONG).show();
				
			}
		});
		
	}

}
