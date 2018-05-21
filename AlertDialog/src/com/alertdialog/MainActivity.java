package com.alertdialog;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Application;
import android.content.DialogInterface;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity 
{
	 
	public void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Button dugme1 = (Button) findViewById(R.id.button1);
		dugme1.setOnClickListener(new OnClickListener()
		{
			
			@Override
			public void onClick(View arg0) 
			{
				AlertDialog.Builder alertPencereNesnesi = new AlertDialog.Builder(MainActivity.this);
				alertPencereNesnesi.setMessage("Tek Düðmeli alert dialog");
				
				alertPencereNesnesi.setNeutralButton("Evet", new DialogInterface.OnClickListener() 
				{
					
					@Override
					public void onClick(DialogInterface dialog, int which)
					{
						
						Toast.makeText(MainActivity.this, "Evet Düðmesine Basýldý", Toast.LENGTH_SHORT).show();
						
						
					}
				});
				
				alertPencereNesnesi.show();
				
			}
			
		});
	 
	
	Button dugme2 = (Button) findViewById(R.id.button2);
		dugme2.setOnClickListener(new OnClickListener() 
		{
			
			@Override
			public void onClick(View arg0) 
			{
				AlertDialog.Builder alertPencereNesnesi = new AlertDialog.Builder(MainActivity.this);
				alertPencereNesnesi.setMessage("Ýki Düðmeli alert dialog");
				
				alertPencereNesnesi.setPositiveButton("Evet", new DialogInterface.OnClickListener()
				{
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						
						Toast.makeText(MainActivity.this, "Evet Düðmesine Basýldý", Toast.LENGTH_SHORT).show();
						
						
					}
				});
				
				alertPencereNesnesi.setNegativeButton("Hayýr", new DialogInterface.OnClickListener()
				{
					
					@Override
					public void onClick(DialogInterface dialog, int which)
					{
						
						Toast.makeText(MainActivity.this, "Hayýr Düðmesine Basýldý", Toast.LENGTH_SHORT).show();
						
						
					}
				
				});
				
				
				alertPencereNesnesi.show();
			}
			
		});
			
				
				Button dugme3 = (Button) findViewById(R.id.button3);
				dugme3.setOnClickListener(new OnClickListener()
				{
					
					@Override
					public void onClick(View v) 
					{
						final CharSequence items[] = {"Ýsmet","Emine","ali","bekir","Burak"};
						
						final AlertDialog.Builder alertPencereNesnesi = new AlertDialog.Builder(MainActivity.this);
						
						alertPencereNesnesi.setTitle("isimler");
						
						alertPencereNesnesi.setItems(items, new DialogInterface.OnClickListener() 
						{						 
							
						
							public void onClick(DialogInterface dialog, int secilen) 
							{
						
						
						Toast.makeText(MainActivity.this, items[secilen], Toast.LENGTH_SHORT).show();
						
					       }					
				});
						
						alertPencereNesnesi.show();
						
					 
						Button dugme4 = (Button) findViewById(R.id.button4);
						dugme4.setOnClickListener(new OnClickListener()
{
							
							@Override
							public void onClick(View v) 
							{
								final CharSequence[] items = {"Ýsmet","Emine","nermin","bekir","Burak"};
								
								final AlertDialog.Builder alertPencereNesnesi = new AlertDialog.Builder(MainActivity.this);
								
								alertPencereNesnesi.setTitle("isimler");
								
								alertPencereNesnesi.setItems(items, new DialogInterface.OnClickListener()
								{						 
									
								
									public void onClick(DialogInterface dialog, int secilen) 
									{
								
								
								Toast.makeText(MainActivity.this, items[secilen], Toast.LENGTH_SHORT).show();
								
							}					
						});
								
								alertPencereNesnesi.show();
								
							}
						});

					}
			
				});
	}
}

