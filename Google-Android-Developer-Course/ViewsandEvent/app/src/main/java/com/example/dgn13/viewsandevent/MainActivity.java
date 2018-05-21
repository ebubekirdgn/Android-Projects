package com.example.dgn13.viewsandevent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TextView t1;
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t1 = (TextView)findViewById(R.id.YourText);
        b1 =(Button)findViewById(R.id.change1);

        b1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
   t1.setText("You click Change 1 button");
    }
    public void doSomething(View v) {
        t1.setText("You click Change 2 button");
    }

}
