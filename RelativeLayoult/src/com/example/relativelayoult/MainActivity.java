package com.example.relativelayoult;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		final EditText adisoyadi = (EditText) findViewById(R.id.editText1);
		final EditText eposta = (EditText) findViewById(R.id.editText2);
		final EditText adres = (EditText) findViewById(R.id.editText3);
		final Button tikla = (Button) findViewById(R.id.button1);
		tikla.setOnClickListener(new OnClickListener() {
			
		
			public void onClick(View arg0) {
			 
				Toast.makeText(MainActivity.this, "Adýnýz :" + adisoyadi.getText() + "\n" +"eposta :" + eposta.getText() + "\n"+"adres :" + adres.getText() + "\n"  , Toast.LENGTH_LONG).show();
			}
		});
		
	}
 
}
