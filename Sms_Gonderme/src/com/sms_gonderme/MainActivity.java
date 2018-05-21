package com.sms_gonderme;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.app.Activity;
 

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	final EditText telno = (EditText) findViewById(R.id.editText1);
	final EditText mesaj = (EditText) findViewById(R.id.editText2);
	
	Button gonder = (Button) findViewById(R.id.button1);
	
	gonder.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
		 
			android.telephony.SmsManager sms = android.telephony.SmsManager.getDefault();
			sms.sendTextMessage(telno.getText().toString(), null , mesaj.getText().toString(), null, null);
			Toast.makeText(MainActivity.this, telno.getText().toString() + "\n Mesajýnýz Gönderildi", Toast.LENGTH_LONG).show();
			
		}
	});
	}

 

}
