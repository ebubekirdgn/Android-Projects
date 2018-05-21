package com.projeandroid;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
 

public class arama extends Activity {
 
	 private String numara;

	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.arama_ekrani);
		
		Button ara = (Button) findViewById(R.id.buttonislem);
		final EditText numaraKutusu = (EditText) findViewById(R.id.editText1);
		
		ara.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				 

				
				numara = numaraKutusu.getText().toString();
				
				Intent i = new Intent(Intent.ACTION_CALL);
				i.setData(Uri.parse("tel:" + numara));
				startActivity(i);
				
			}
		});
		
	}
	
	 

}
