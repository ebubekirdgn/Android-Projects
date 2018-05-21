package com.example.ebubekir.actionbar;

import android.graphics.Color;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar ab = getSupportActionBar();
        ab.setTitle("Ebubekir");
        ab.setSubtitle("Doğan");
    ab.setBackgroundDrawable(getResources().getDrawable(R.drawable.arkaplan));

    }
}
