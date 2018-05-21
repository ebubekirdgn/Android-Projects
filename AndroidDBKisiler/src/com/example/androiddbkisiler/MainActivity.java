package com.example.androiddbkisiler;

import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//
		Button btn_kayitekle = (Button)findViewById(com.example.androiddbkisiler.R.id.button_kayitekle);
		Button btn_kayitlistele = (Button)findViewById(com.example.androiddbkisiler.R.id.button_kayitlistele);
		
	btn_kayitekle.setOnClickListener(new View.OnClickListener() {
		@Override
		public void onClick(View v) {
		Intent intent = new Intent(getApplicationContext(),ActivityEkle.class);
		startActivity(intent);
		}
	});
	btn_kayitlistele.setOnClickListener(new View.OnClickListener() {
		@Override
		public void onClick(View v) {
			Intent intent = new Intent(getApplicationContext(),ActivityListele.class);
			startActivity(intent);			
		}
	});
	
	}//onCreate

 

}
