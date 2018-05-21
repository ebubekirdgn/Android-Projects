package com.radiobutton;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		TextView TuttugunuzTakim = (TextView) findViewById(R.id.txtTuttugunuzTakim);
		RadioButton rbfb = (RadioButton) findViewById(R.id.rbfb);
		RadioButton rbgs = (RadioButton) findViewById(R.id.rbgs);
		RadioButton rbsamsun = (RadioButton) findViewById(R.id.rbsamsun);
		
		Button gonder = (Button) findViewById(R.id.button1);
 
		 OnClickListener secilenDugme = new OnClickListener() {
			
		
			public void onClick(View v) {
				// TODO Auto-generated method stub
				RadioButton secilenDugme = (RadioButton) v;
	Toast.makeText(MainActivity.this, "Takýmýnýz :" + secilenDugme.getText() + "Seçildi", Toast.LENGTH_LONG).show();
				
			}
		};
    
    
      
		
	}

 

}
