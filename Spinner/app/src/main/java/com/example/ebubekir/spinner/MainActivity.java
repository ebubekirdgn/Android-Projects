package com.example.ebubekir.spinner;

import android.graphics.Color;
import android.os.Bundle;

import android.support.annotation.StringRes;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        final RelativeLayout zemin = (RelativeLayout) findViewById(R.id.rl);

        final String renkler[] = getResources().getStringArray(R.array.renkler);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(),R.layout.spinner_gorunumu,renkler);
        spinner.setAdapter(adapter);



//        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int pozisyon, long id)
//            {
//                Toast.makeText(MainActivity.this,"Secilen renk :"+renkler[pozisyon],Toast.LENGTH_SHORT).show();
//
//                switch (pozisyon)
//                {
//                    case 0: zemin.setBackgroundColor(Color.RED);break;
//                    case 1: zemin.setBackgroundColor(Color.GREEN);break;
//                    case 2: zemin.setBackgroundColor(Color.GRAY);break;
//                }
//
//
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//
//            }
//        });



    }


}
