package com.splushekrani;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.acilisekrani);
		
		Thread acilisekrani = new Thread()
		{
			public void run()
			{
				try 
				{
				sleep(3000);
				Intent i = new Intent(MainActivity.this , acilisekrani.class);
                   startActivity(i);
					
				} catch (Exception e) {
					
					e.printStackTrace();
				}
				finally 
				{
					
					finish();
				}
				
			}
			
			
		};
		
		acilisekrani.start();
		
		
	}
 

}
