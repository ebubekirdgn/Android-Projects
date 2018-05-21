package com.example.ebubekirdogan.telefonrehberi.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.example.ebubekirdogan.telefonrehberi.Adapter.ListeAdapter;
import com.example.ebubekirdogan.telefonrehberi.Database.Database;
import com.example.ebubekirdogan.telefonrehberi.Model.Kisi;
import com.example.ebubekirdogan.telefonrehberi.R;

import java.util.List;

public class ListRehber extends AppCompatActivity {

    RecyclerView listView;
    List<Kisi> Kisiler;

    @Override
    protected void onStart() {
        super.onStart();

        update();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_rehber);

        listView = (RecyclerView)findViewById(R.id.listRecycle);
        listView.setLayoutManager(new LinearLayoutManager(this));

        RecyclerView.ItemDecoration ıtemDecoration = new DividerItemDecoration(this,DividerItemDecoration.VERTICAL);
        listView.addItemDecoration(ıtemDecoration);

        update();

    }


    public void update(){

        Database db = new Database(this);
        Kisiler = db.KisiListele();
        ListeAdapter adapter = new ListeAdapter(Kisiler,this);
        listView.setAdapter(adapter);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_rehber,menu);
        return super.onCreateOptionsMenu(menu);
    }




    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if(id == R.id.menuEkle){

            Intent i = new Intent(ListRehber.this,EkleRehber.class);
            startActivity(i);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

