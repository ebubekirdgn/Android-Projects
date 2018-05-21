package com.example.dgn13.implicitintent;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void doSomething(View v) {
        switch (v.getId())
        {
            case R.id.openweb:
                Intent i1 = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"));
                startActivity(i1);
                break;
            case R.id.opencall:
                Intent i2 = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:05333333333333"));
                startActivity(i2);
                break;
            case R.id.openMap:
                Intent i3= new Intent(Intent.ACTION_DIAL, Uri.parse("geo=41.279703,36.336067"));
                startActivity(i3);
                break;
        }
    }
}
