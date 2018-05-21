package com.example.ebubekir.hatamesajlari;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private final String TAG = this.getClass().getSimpleName();
    private int sayi = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "debug hata ayıklama logu");
        Log.e(TAG, "error hata ayıklama logu");
        Log.i(TAG, "info hata ayıklama logu");
        Log.w(TAG, "warning hata ayıklama logu");
        Log.wtf(TAG, "ciddi bir hata oluştu");


        Button btn = (Button) findViewById(R.id.button2);
        final TextView t = (TextView) findViewById(R.id.textView);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    t.setText(sayi);

                } catch (Exception e) {
                    Log.e(TAG, e.getMessage());
                    Log.e(TAG, e.toString());
                    Log.e(TAG, e.getLocalizedMessage());
                }
                finally//hata olsada olmasada işleyecek blog budur.
                {

                }


            }
        });
    }

}
