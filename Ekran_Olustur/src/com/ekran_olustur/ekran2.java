package com.ekran_olustur;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ekran2 extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ekran2);
		
		Button geri = (Button) findViewById(R.id.button1);
	  geri.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			Intent sayfa = new Intent(ekran2.this,MainActivity.class);
			startActivity(sayfa);
		}
	});
	}

}
