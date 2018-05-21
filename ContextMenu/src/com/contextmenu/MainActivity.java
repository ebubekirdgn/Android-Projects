package com.contextmenu;

import java.util.Arrays;
import android.R.menu;
import android.R.string;
import android.os.Bundle;
import android.preference.PreferenceActivity.Header;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.app.Activity;

public class MainActivity extends Activity {

	private static final AdapterContextMenuInfo MenuInfo = null;
	private String ogrDizisi[];
	 
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
 ogrDizisi = getResources().getStringArray(R.array.OgrenciListesi);
 Arrays.sort(ogrDizisi);
 
 ListView listviewnesnesi = (ListView) findViewById(R.id.listView1);
 /*add cast iþlemi yapýldý*/
 
 ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.listemiz,ogrDizisi);
 listviewnesnesi.setAdapter(adapter);
 registerForContextMenu(listviewnesnesi);
 
		
	}
 
	public void onCreateContextMenu(ContextMenu menu , View v , ContextMenuInfo menuinfo)
	{
		if(v.getId()==R.id.listView1)
		{
		 AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) MenuInfo;
		 menu.setHeaderTitle(ogrDizisi[info.position]);
		 String [] menuItems = getResources().getStringArray(R.array.OgrenciListesi);
		
		 for(int i =0; i <=menuItems.length;i++)
		 {
			 menu.add(Menu.NONE , i , i, menuItems[i]);	
			
		 }
			
		}
		
		
	}
	public boolean onContextItemSelected(MenuItem item)
	{
		 AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
		 int menuItemIndex = item.getItemId();
		 String [] menuItems = getResources().getStringArray(R.array.OgrenciListesi);
		 
		 String menudenGelenIsim = menuItems[menuItemIndex];
		 
		 String listedenGelenIsým = ogrDizisi[info.position];
		 
		 TextView textview = (TextView) findViewById(R.id.textView1);
		 
		 textview.setText("Listeden Seçilen Öðrenci : " + listedenGelenIsým +"\n Context Menuden Seçilen Ýsim :" + menudenGelenIsim);
		 
		 return true;		
	}

	 
}
