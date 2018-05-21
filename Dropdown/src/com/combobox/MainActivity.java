package com.combobox;

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
		
		Spinner acilanListe = (Spinner) findViewById(R.id.spinner1);
		
		/*dizi sýralama iþlemi yapýlýyor sequence sýralamak demektir*/ 
		ArrayAdapter<CharSequence>Listemiz = ArrayAdapter.createFromResource(MainActivity.this, R.array.SehirAdlari,android.R.layout.simple_spinner_dropdown_item);
		acilanListe.setAdapter(Listemiz);
		acilanListe.setOnItemSelectedListener(new OnItemSelectedListener() {
 
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) 
			{
			Toast.makeText(MainActivity.this, "Secilen :" + arg0.getItemIdAtPosition(arg2)/*iþaretlemeye sýfýrdan baþla ve yerleþtir.arg2 otomatik atar ve seçimi istediðimiz yerden yapmamýzý saðlar.ben istediðim itemi seçerim demektir.*/, Toast.LENGTH_LONG).show(); /**/	
			}
			public void onNothingSelected(AdapterView<?> arg0) {
				 
				Toast.makeText(MainActivity.this, "Henüz Secim Yapýlmadý :", Toast.LENGTH_LONG).show();	
			}
		});		
	}
	
 

}
