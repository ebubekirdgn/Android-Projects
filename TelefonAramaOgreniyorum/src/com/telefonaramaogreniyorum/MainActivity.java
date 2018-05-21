package com.telefonaramaogreniyorum;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
 
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {
 private String numara;	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Button ara = (Button) findViewById(R.id.ara);
	    final EditText numaraKutusu = (EditText) findViewById(R.id.numara);
		
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
