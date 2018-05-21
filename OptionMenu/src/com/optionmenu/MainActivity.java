package com.optionmenu;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;
import android.app.Activity;
 

public class MainActivity extends Activity {


	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
		public boolean onCreateOptionsMenu(Menu menu)
		{
			
			MenuInflater menuDoldurma = getMenuInflater();
			menuDoldurma.inflate(R.menu.option_menusu, menu);
			return true;
		
		}
		public boolean onOptionsItemSelected(MenuItem item)
		{
			switch (item.getItemId()) {
			case R.id.item1:
				Toast.makeText(MainActivity.this, "Birinci Menu Secildi", Toast.LENGTH_SHORT).show();
			break;
			
			case R.id.item2:
				Toast.makeText(MainActivity.this, "Ýkinci Menu Secildi", Toast.LENGTH_SHORT).show();
			break;

			case R.id.item3:
				Toast.makeText(MainActivity.this, "Ücüncü Menu Secildi", Toast.LENGTH_SHORT).show();
			break;
			
			default:
				break;
				
				 
			}
			return true;
		}
	
	}

 

