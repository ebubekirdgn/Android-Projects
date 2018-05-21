package com.example.ebubekirdogan.sharedpreference91;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText name ,age;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = (EditText) findViewById(R.id.edit1);
        age = (EditText) findViewById(R.id.edit2);
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences sh1 = getSharedPreferences("MyOwnShared",MODE_PRIVATE);
        String s1 = sh1.getString("user","");
        int s2 = sh1.getInt("age",0);

        name.setText(s1);
        age.setText(String.valueOf(s2));

    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences sh  = getSharedPreferences("",MODE_PRIVATE);
        SharedPreferences.Editor myEdit = sh.edit();
        myEdit.putString("user",name.getText().toString());
        myEdit.putInt("aget",Integer.parseInt(age.getText().toString()));
        myEdit.commit();


    }
}
