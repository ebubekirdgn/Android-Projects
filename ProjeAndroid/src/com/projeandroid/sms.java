package com.projeandroid;

import android.app.Activity;
 
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
 
import android.widget.Toast;

public class sms extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sms);
		 
		 final EditText mesaj = (EditText) findViewById(R.id.numarasi);
		 final EditText numara = (EditText) findViewById(R.id.adi);
		 Button gonder = (Button) findViewById(R.id.buttonmusic);
		 
		
		 
		 
		 gonder.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				 
				android.telephony.SmsManager sms = android.telephony.SmsManager.getDefault();
				sms.sendTextMessage(numara.getText().toString(), null, mesaj.getText().toString(), null, null);
				Toast.makeText(sms.this, "Mesajýnýz " + numara.getText() + " numaralý hatta Gönderildi", Toast.LENGTH_SHORT).show();
				
			}
		});
	}

  
}
 