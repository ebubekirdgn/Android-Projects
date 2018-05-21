package com.example.ebubekir.contextmenu;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.ContextMenu;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView lst;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String personel[] = getResources().getStringArray(R.array.personel);
        lst = (ListView) findViewById(R.id.listView);


        adapter = new ArrayAdapter<String>(getApplicationContext(),R.layout.listemiz,personel);
        lst.setAdapter(adapter);
        registerForContextMenu(lst);


    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo)
    {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.menu_context, menu);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_context, menu);
        return true;
    }

    @Override
    public boolean onContextItemSelected(MenuItem item)
    {
        AdapterView.AdapterContextMenuInfo menuInfo = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
   switch (item.getItemId())
   {
       case R.id.Sil : //silme işlemi yapılacak
           TextView tv = (TextView) menuInfo.targetView;
           Toast.makeText(MainActivity.this,"Seçilen Personel : " + tv.getText().toString(),Toast.LENGTH_SHORT).show();
           return true;
       case R.id.Duzenle : //Düzenleme işlemi yapılacak
           return true;
       case R.id.Paylas : //Paylas işlemi yapılacak
           return true;
   }

        return super.onContextItemSelected(item);
       }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }


        return super.onOptionsItemSelected(item);
    }
}
