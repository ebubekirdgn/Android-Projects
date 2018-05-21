package com.example.dgn13.activitylifecycle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this,"oncreate Finished",Toast.LENGTH_LONG).show();
        Log.i("MainActivity","onCreate");
    }

    protected void onStart()
    {
        super.onStart();
        Toast.makeText(this,"onStart Finished",Toast.LENGTH_LONG).show();
        Log.i("MainActivity","onStart");
    }
    protected void onResume()
    {
        super.onResume();
        Toast.makeText(this,"onResume Finished",Toast.LENGTH_LONG).show();
        Log.i("MainActivity","onResume");
    }
    protected void onPause()
    {
        super.onPause();
        Toast.makeText(this,"onPause Finished",Toast.LENGTH_LONG).show();
        Log.i("MainActivity","onPause");
    }
    protected void onStop()
    {
        super.onStop();
        Toast.makeText(this,"onStop Finished",Toast.LENGTH_LONG).show();
        Log.i("MainActivity","onStop");
    }
    protected void onRestart()
    {
        super.onRestart();
        Toast.makeText(this,"onRestart Finished",Toast.LENGTH_LONG).show();
        Log.i("MainActivity","onRestart");
    }
    protected void onDestroy()
    {
        super.onDestroy();
        Toast.makeText(this,"onDestroy Finished",Toast.LENGTH_LONG).show();
        Log.i("MainActivity","onDestroy");
    }
}
