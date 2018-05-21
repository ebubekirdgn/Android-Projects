package com.example.androiddbkisiler;

import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class ActivityListele extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_listele);
		//
		TextView text = (TextView)findViewById(com.example.androiddbkisiler.R.id.textView1);
		//
        /*tüm kayýtlarý oku:*/
		 VeritabaniIsleme veritabani = new VeritabaniIsleme(this);
        List<Kisiler> kisilerListesi = veritabani.kayitlariGetir();       
        StringBuilder str = new StringBuilder();
        for (Kisiler kisi : kisilerListesi) {
               String kayit = "Id: "+kisi.getID()+"\nAdýSoyadý: " + kisi.getAdiSoyadi() + "\nTel No: " + kisi.getTelNo() + "\n,Email: "+kisi.getEmail();
                str.append(kayit+"\n-----------------------\n");
        }//for
        text.setText(str);
	}//onCreate

}
