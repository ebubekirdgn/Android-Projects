package com.ekran_olustur;

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
		Button sayfa2 = (Button) findViewById(R.id.button1);
		sayfa2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				 
				Intent sayfa = new Intent(MainActivity.this , ekran2.class);
				startActivity(sayfa);
				
				
			}
		});
	}

 
}
