package com.bahsis_uygulamasi;

import android.os.Bundle;
import android.app.Activity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Chronometer;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.Spinner;
import android.widget.TextView;

public class BahsisUygulama extends Activity {

	private static final String toplam_fatura = "toplam_fatura";
	private static final String bahsis = "bahsis";
	private static final String bahsissiz_fatura = "Bahsissiz_fatura";
	
	
	private double sadeceFatura;
	private double bahsisToplam;
	private double toplamFatura;
	
	
	EditText sadeceFaturaET;
	EditText bahsisToplamEt;
	EditText toplamFaturaEt;
	
	SeekBar bahsisSeekBar;
	
	private int[] checkListEleman = new int[12];
	CheckBox HizmetGuzelCheckBox;
	CheckBox HizmetOrtaCheckBox;
	CheckBox HizmetKotuCheckBox;
	
	RadioGroup urunRadioGrup;
	
	RadioButton GuzelRadio;
	RadioButton OrtaRadio;
	RadioButton KotuRadio;
	
	Spinner problemSpinner;
	
	Button baslatButton;
	Button durdurButton;
	Button bitirButton;
	
	
	Chronometer HizmetSuresiChronometer;
	
	
	long beklenensaniye=0;
	
	TextView HizmetSuresi;
	
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_bahsis_uygulama);
		
		if(savedInstanceState==null)
		{
			sadeceFatura=0.0;
			bahsisToplam=0.15;
			toplamFatura=0.0;
		}
		else
		{
			sadeceFatura = savedInstanceState.getDouble(toplam_fatura);
			bahsisToplam = savedInstanceState.getDouble(bahsis);
			toplamFatura = savedInstanceState.getDouble(bahsissiz_fatura);
		}
		
		sadeceFaturaET =(EditText) findViewById(R.id.Fatura_editText);
		bahsisToplamEt =(EditText) findViewById(R.id.Bahsis_editText);
		toplamFaturaEt =(EditText) findViewById(R.id.Toplam_editText);
		
		bahsisSeekBar =(SeekBar) findViewById(R.id.Bahsis_seekBar);
		
		HizmetGuzelCheckBox = (CheckBox) findViewById(R.id.GuzelcheckBox);
		HizmetOrtaCheckBox = (CheckBox) findViewById(R.id.Orta_CheckBox);
		HizmetKotuCheckBox = (CheckBox) findViewById(R.id.Kotu_CheckBox);
		
		sadeceFaturaET.addTextChangedListener(sadeceFaturaListener);
		bahsisSeekBar.setOnSeekBarChangeListener(bahsisSeekBarListener);
		
	}

	private TextWatcher sadeceFaturaListener = new TextWatcher()
	{
		public void afterTextChanged(Editable s)
		{
		}
		public void beforeTextChanged(CharSequence s, int arg1, int arg2,int arg3) 
		{	
		}
		public void onTextChanged(CharSequence s, int arg1, int arg2,int arg3) 
	    { 
			try
			{
			sadeceFatura = Double.parseDouble(s.toString());
			}
			catch(NumberFormatException e)
			{
				sadeceFatura = 0.0;
			}
			faturavebahsisGuncelle();
		}
	};
	private void faturavebahsisGuncelle()
	{
		
	   double bahsisToplam = Double.parseDouble(bahsisToplamEt.getText().toString());
	   double toplamFatura = sadeceFatura + (sadeceFatura * bahsisToplam);
	   toplamFaturaEt.setText(String.format("%.02f", toplamFatura)); 
	}
	
	protected void onSaveInstanceState(Bundle outState)
	{
		super.onSaveInstanceState(outState);
		
		outState.putDouble(toplam_fatura, toplamFatura);
		outState.putDouble(bahsis, bahsisToplam);
		outState.putDouble(bahsissiz_fatura, sadeceFatura);
	}
	
	private OnSeekBarChangeListener bahsisSeekBarListener = new OnSeekBarChangeListener()
	{

		@Override
		public void onProgressChanged(SeekBar arg0, int arg1, boolean arg2) {
			 
			bahsisToplam=(bahsisSeekBar.getProgress())*.01;
			bahsisToplamEt.setText(String.format("%.02f", bahsisToplam)); 
			faturavebahsisGuncelle();
		}

		@Override
		public void onStartTrackingTouch(SeekBar arg0) {
		 
			
		}

		@Override
		public void onStopTrackingTouch(SeekBar arg0) {
			 
		}
	};
	
 
}
