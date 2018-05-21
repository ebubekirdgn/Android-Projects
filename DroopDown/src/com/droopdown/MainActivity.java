package com.droopdown;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;
 
import android.app.Activity;
 

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Spinner listee = (Spinner) findViewById(R.id.spinner1);
		
		ArrayAdapter<CharSequence> listemiz = ArrayAdapter.createFromResource(MainActivity.this,R.array.Dersler, android.R.layout.simple_dropdown_item_1line);
		listee.setAdapter(listemiz);
		
		listee.setOnItemSelectedListener(new OnItemSelectedListener() {
 
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				 Toast.makeText(MainActivity.this, "Seçilen Menu :" + arg0.getItemAtPosition(arg2), Toast.LENGTH_SHORT).show();
				
			}

		 
			public void onNothingSelected(AdapterView<?> arg0) {
				 Toast.makeText(MainActivity.this, "Henüz Seçim Yapmadýnýz", Toast.LENGTH_SHORT).show();
				
			}
		});
	}

 

}
