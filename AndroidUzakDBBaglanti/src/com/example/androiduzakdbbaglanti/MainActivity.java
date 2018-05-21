package com.example.androiduzakdbbaglanti;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.jdbc.ResultSetMetaData;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//
		TextView txt = (TextView)findViewById(com.example.androiduzakdbbaglanti.R.id.textView1);
		//
		
		/*Local Baðlantý:*/
		LocalBaglanti _localBaglanti = new LocalBaglanti();
		String local_veri = _localBaglanti.localBaglantiVeriGetir().toString();
		txt.setText(_localBaglanti.toString());
		
		/*Uzak Baðlantý:*/
		UzakBaglanti _uzakBaglanti = new UzakBaglanti();
		String uzak_veri =_uzakBaglanti.uzakBaglantiVeriGetir().toString();
		txt.setText(uzak_veri);
		

	}//onCreate

 

}
