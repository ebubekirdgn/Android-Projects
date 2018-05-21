package com.bluetooth;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;
import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
 

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Button ac = (Button) findViewById(R.id.button1);
		final BluetoothAdapter adapter = BluetoothAdapter.getDefaultAdapter();
		ac.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(adapter==null)
				{
					Toast.makeText(getApplicationContext(), "Aygýt Bulunamadý", Toast.LENGTH_LONG).show();
				}
				else
				{
					 if(adapter.isEnabled())
					 {
						 Intent i  =  new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
						 startActivityForResult(i, 1);
						 
					 }
					 else
					 {
						 adapter.disable();
						 
					 }
					
				}
			}
		});
	}
 
}
