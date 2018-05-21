package com.example.ebubekirdoan.idealkilo;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private TextView boy_tv, ideal_tv, durum_tv, kilo_tv;
    private SeekBar seekBar;
    private RadioGroup radioGroup;
    private boolean erkekmi = true;
    private double boy = 0.0;
    private int kilo = 50;
    InterstitialAd mInterstitialAd;
    private RadioGroup.OnCheckedChangeListener radioGrupOlayIsleyicisi = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup radioGroup, int checkedID) {

            if (checkedID == R.id.Bay)
                erkekmi = true;
            else if (checkedID == R.id.Bayan)
                erkekmi = false;
            guncelle();
        }
    };


    private SeekBar.OnSeekBarChangeListener seekBarOlayIsleyicisi = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
            kilo = 30 + progress;
            guncelle();
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    };

    private TextWatcher editTextOlayIsleyicisi = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence s, int i, int i1, int i2) {

            try {
                boy = Double.parseDouble(s.toString()) / 100.0;
            } catch (NumberFormatException e) {
                boy = 0.0;
            }
            guncelle();
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.editText3);
        boy_tv = (TextView) findViewById(R.id.BoyTxt);
        ideal_tv = (TextView) findViewById(R.id.IdealKiloSonuc);
        durum_tv = (TextView) findViewById(R.id.DurumTxtSonuc);
        kilo_tv = (TextView) findViewById(R.id.Kilo_tv);
        seekBar = (SeekBar) findViewById(R.id.seekBar2);
        radioGroup = (RadioGroup) findViewById(R.id.radioGrup);

        editText.addTextChangedListener(editTextOlayIsleyicisi);
        seekBar.setOnSeekBarChangeListener(seekBarOlayIsleyicisi);
        radioGroup.setOnCheckedChangeListener(radioGrupOlayIsleyicisi);

        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
        reklamYukle();
        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                super.onAdClosed();
                reklamYukle();
            }

            

            @Override
            public void onAdLoaded() {
                super.onAdLoaded();
                mInterstitialAd.show();
            }
        });


        guncelle();
    }

    private void reklamYukle()
    {
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();

        mInterstitialAd.loadAd(adRequest);
    }

    private void guncelle() {
        kilo_tv.setText(String.valueOf(kilo) + " kg");
        boy_tv.setText(String.valueOf(boy) + " m");
        int ideal_kiloBay = (int) (50 + 2.3 * (boy * 100 * 0.4 - 60));
        int ideal_kiloBayan = (int) (45.5 + 2.3 * (boy * 100 * 0.4 - 60));
        double vki = kilo / (boy * boy);


        if (erkekmi) {
            ideal_tv.setText(String.valueOf(ideal_kiloBay));
            if (vki <= 20.7) {
                durum_tv.setBackgroundResource(R.color.zayif);
                durum_tv.setText(R.string.zayif);
            } else if (vki > 20.7 && vki <= 26.4) {
                durum_tv.setBackgroundResource(R.color.durum_ideal);
                durum_tv.setText(R.string.ideal_kilo);
            } else if (vki >26.4 && vki <= 27.8) {
                durum_tv.setBackgroundResource(R.color.durum_idealden_fazla);
                durum_tv.setText(R.string.fazlakilo);
            } else if (vki > 27.8 && vki <= 31.1 ) {
                durum_tv.setBackgroundResource(R.color.durum_fazla_kilolu);
                durum_tv.setText(R.string.durumfazlakilo);
            } else if (vki > 31.1 && vki <= 34.9) {
                durum_tv.setBackgroundResource(R.color.durum_obez);
                durum_tv.setText(R.string.obez);
            } else {
                durum_tv.setBackgroundResource(R.color.durum_doktora);
                durum_tv.setText(R.string.durum_doktora);
            }

        } else {
            ideal_tv.setText(String.valueOf(ideal_kiloBayan));
            if (vki <= 19.1) {
                durum_tv.setBackgroundResource(R.color.zayif);
                durum_tv.setText(R.string.zayif);
            } else if (vki > 19.1 && vki <= 25.8) {
                durum_tv.setBackgroundResource(R.color.durum_ideal);
                durum_tv.setText(R.string.ideal_kilo);
            } else if (vki > 25.8 && vki <= 27.3) {
                durum_tv.setBackgroundResource(R.color.durum_idealden_fazla);
                durum_tv.setText(R.string.fazlakilo);
            } else if (vki > 27.3 && vki <= 32.3) {
                durum_tv.setBackgroundResource(R.color.durum_fazla_kilolu);
                durum_tv.setText(R.string.durumfazlakilo);
            } else if (vki > 32.3 && vki <= 34.9) {
                durum_tv.setBackgroundResource(R.color.durum_obez);
                durum_tv.setText(R.string.obez);
            } else {
                durum_tv.setBackgroundResource(R.color.durum_doktora);
                durum_tv.setText(R.string.durum_doktora);
            }
        }
    }
}
