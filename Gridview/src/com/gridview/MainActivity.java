package com.gridview;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		GridView izgaranesnesi = (GridView) findViewById(R.id.gridView1);
		izgaranesnesi.setAdapter(new ImageAdaptor(this));
		izgaranesnesi.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> ismet, View gorunum, int sirasi,
					long id) {
				
				Toast.makeText(MainActivity.this, "Seçilen Resim:"+sirasi , Toast.LENGTH_SHORT).show();
				
			}
		});
		
	}

	

}
