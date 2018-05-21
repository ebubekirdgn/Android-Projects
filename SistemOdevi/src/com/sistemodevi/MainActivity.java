package com.sistemodevi;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;
import android.database.Cursor;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {

	private EditText edAd, edSoyad, edTc;
	private Button buttonKaydet, buttonDegistir, buttonSil;
	private ListView lwKayitlar;
	private databaseIslemleri dbIslem;
	private int secilenSatirId = 0;
	private rehberNesne[] rehberNesne = null;
	
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		final MediaPlayer buttonsesi = MediaPlayer.create(MainActivity.this, R.raw.btn_sound);
		try {
			edAd = (EditText) findViewById(R.id.editTextAD);
			edSoyad = (EditText) findViewById(R.id.editTextSOYAD);
			edTc = (EditText) findViewById(R.id.editTextTel);
			buttonKaydet = (Button) findViewById(R.id.buttonKaydet);
			buttonDegistir = (Button) findViewById(R.id.buttonDegistir);
			buttonSil = (Button) findViewById(R.id.buttonSil);
			lwKayitlar = (ListView) findViewById(R.id.listViewKayitlar);
			dbIslem = new databaseIslemleri(getApplicationContext());

			buttonKaydet.setOnClickListener(new View.OnClickListener() {
 
				public void onClick(View v) {
				 buttonsesi.start();
					dbIslem.satirEkle(edAd.getText().toString(), edSoyad
							.getText().toString(), edTc.getText().toString());
					kayitlariYenile();
					Toast.makeText(MainActivity.this, "Kaydedildi", Toast.LENGTH_SHORT).show();
				}
			});

			buttonDegistir.setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View v) {
					 buttonsesi.start();
					dbIslem.satirDegistir(edAd.getText().toString(), edSoyad
							.getText().toString(), edTc.getText().toString(),
							secilenSatirId);
					kayitlariYenile();
					Toast.makeText(MainActivity.this, "Güncellendi", Toast.LENGTH_SHORT).show();
				}
			});
			buttonSil.setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View v) {
					 buttonsesi.start();
					dbIslem.satirSil(secilenSatirId);
					kayitlariYenile();
					Toast.makeText(MainActivity.this, "Silindi", Toast.LENGTH_SHORT).show();
				}
			});

			lwKayitlar.setOnItemClickListener(new OnItemClickListener() {
 
				public void onItemClick(AdapterView<?> arg0, View arg1,
						int arg2, long arg3) {
					secilenSatirId = rehberNesne[arg2].id;
					edAd.setText(rehberNesne[arg2].adi);
					edSoyad.setText(rehberNesne[arg2].soyadi);
					edTc.setText(rehberNesne[arg2].tel);
				}
			});
			kayitlariYenile();
		} catch (Exception e) {
			Toast.makeText(getApplicationContext(), e.toString(),Toast.LENGTH_SHORT).show();
		}
	}

	class rehberNesne extends Object {
		public int id;
		public String adi;
		public String soyadi;
		public String tel;
	}

	private void kayitlariYenile() {
		String[] rehberDizi = null;
		Cursor cRehber = dbIslem.satirlariGetir();
		if (cRehber != (Cursor) null) {
			cRehber.moveToFirst();/*birinci elemana kadar anlamýnda*/
			rehberDizi = new String[cRehber.getCount()];
			rehberNesne = new rehberNesne[cRehber.getCount()];
			int tSayac = 0;
			
			while (!cRehber.isAfterLast()) {
				/*rehber nesnemizin bir sonraki iþlemine kadar devam diyoruz*/
				rehberDizi[tSayac] = cRehber.getString(1);
				rehberNesne tNesne = new rehberNesne();
				tNesne.id = cRehber.getInt(0);
				tNesne.adi = cRehber.getString(1);
				tNesne.soyadi = cRehber.getString(2);
				tNesne.tel = cRehber.getString(3);
				rehberNesne[tSayac] = tNesne;
				tSayac++;
				cRehber.moveToNext();
			}
			cRehber.close();
		}

		ArrayAdapter<String> adapter = new ArrayAdapter<String>(/**/
				getApplicationContext(),
				android.R.layout.simple_list_item_single_choice,
				android.R.id.text1, rehberDizi);

		lwKayitlar.setAdapter(adapter);
	}
}
