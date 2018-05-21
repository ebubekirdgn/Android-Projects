package com.example.dgn13.explicitntent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView txt1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        txt1 =(TextView) findViewById(R.id.yazi);
        Bundle b1 = getIntent().getExtras();
        String s1 = b1.getString("user");
        txt1.setText(s1);
    }

    public void GoBack(View view) {
        Intent i1 = new Intent(this,MainActivity.class);
        startActivity(i1);
    }
}
