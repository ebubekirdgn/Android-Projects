package com.progressbar1;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	private ProgressBar ilerlemeCubugu;
	private CheckBox onayKutusu;
	private Button onayDugmesi;
	private Handler handler;
	private Runnable r;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		handler = new Handler();
		ilerlemeCubugu = (ProgressBar) findViewById(R.id.progressBar1);
		onayKutusu = (CheckBox) findViewById(R.id.checkBox1);
		onayDugmesi = (Button) findViewById(R.id.button1);
		
		ilerlemeCubugu.setProgress(75);
		onayKutusu.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				
				if(((CheckBox)v).isChecked()){
					
					AlertDialog.Builder alertKutusu = new AlertDialog.Builder(MainActivity.this);
					alertKutusu.setMessage("Yükleme iþlemi baþlatýlsýnmý ?");
					alertKutusu.setPositiveButton("Evet", new DialogInterface.OnClickListener() {
						
						@Override
						public void onClick(DialogInterface arg0, int arg1) {
							
							onayDugmesi.setEnabled(true);
							ilerlemeCubugu.setProgress(75);
							Toast.makeText(MainActivity.this, "Evet Düðmesine basýldý" + ilerlemeCubugu.getProgress(), Toast.LENGTH_SHORT).show();
							
						}
					});
					alertKutusu.show();
					
					alertKutusu.setNegativeButton("Ýptal", new DialogInterface.OnClickListener() {
						
						@Override
						public void onClick(DialogInterface arg0, int arg1) {
							
							onayDugmesi.setEnabled(false);
							ilerlemeCubugu.setProgress(0);							
							Toast.makeText(MainActivity.this, "Ýptal Düðmesine basýldý" + ilerlemeCubugu.getProgress(), Toast.LENGTH_SHORT).show();
						}
					});
					alertKutusu.show();
					
				}
				else {
					
					onayKutusu.setEnabled(false);
					onayDugmesi.setEnabled(false);
					ilerlemeCubugu.setProgress(0);
				}
				
				onayDugmesi.setOnClickListener(new OnClickListener() {
					
					

					@Override
					public void onClick(View v) {
						
						handler.post(r);
						onayDugmesi.setText("Yükleniyor...");
					}
				});
				Runnable runnable = new Runnable() {
					
					@Override
					public void run() {
						
						ilerlemeCubugu.setProgress(ilerlemeCubugu.getProgress()+1);
						if(ilerlemeCubugu.getProgress()<100){
							
							handler.postDelayed(r, 100);/*100 milisaniye gecikme*/
							
						}
						else
						{
							
							handler.removeCallbacks(r);/*gecikme olmaadan çýk*/
							
						}
						
					}
				};
				
			}
		});
		
	}



}
