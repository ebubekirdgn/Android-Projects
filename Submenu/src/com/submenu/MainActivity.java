package com.submenu;

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
    
	
	public boolean onOptionsItemSelected(MenuItem item)
	{
		
		switch (item.getItemId()) {
		case R.id.item1:menuSecildi(item.getTitle());break;
		case R.id.item2:menuSecildi(item.getTitle());break;
		case R.id.item3:menuSecildi();break;
		case R.id.item4:break;
		case R.id.item5:break;
		case R.id.item6:break;
		case R.id.item7:break;
		case R.id.item8:menuSecildi();break;
		case R.id.item9:break;
		case R.id.item10:break;
		case R.id.item11:menuSecildi();break;
		case R.id.item12:break;
		case R.id.item13:break;
		case R.id.item14:break;
		case R.id.item15:menuSecildi();break;
		case R.id.item16:menuSecildi();break;
		case R.id.item17:break;
		case R.id.item18:menuSecildi();break;
		case R.id.item19:break;
		case R.id.item20:break;
		case R.id.item21:break;
		case R.id.item22:menuSecildi("Ebubekir Doðan"); break;
		case R.id.item23:menuSecildi();break;
		case R.id.item24:menuSecildi();break;
		

		default:
			break;
		}
		return super.onContextItemSelected(item);
	}
	
	private void menuSecildi(CharSequence charSequence) {
		 
		Toast.makeText(MainActivity.this,charSequence + "Secildi", Toast.LENGTH_LONG).show();	}

	private void menuSecildi()
	{
		Toast.makeText(MainActivity.this, "Herhangi Bir Menu Secildi", Toast.LENGTH_LONG).show();
		
	}
	

	 

}
