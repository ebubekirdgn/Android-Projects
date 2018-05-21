package com.example.dgn13.menus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText e1,e2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        e1 = (EditText) findViewById(R.id.Sec1);
        e2 = (EditText)findViewById(R.id.Sec2);
        registerForContextMenu(e1);
        registerForContextMenu(e2);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
       getMenuInflater().inflate(R.menu.option_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.a1 : Toast.makeText(this,"Ebubekir",Toast.LENGTH_SHORT).show();
            case R.id.a2 : Toast.makeText(this,"Doğan",Toast.LENGTH_SHORT).show();
            case R.id.a3 : Toast.makeText(this,"İstanbul",Toast.LENGTH_SHORT).show();

        }
        return true;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.context_menu,menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.a1 : Toast.makeText(this,"Ebubekir",Toast.LENGTH_SHORT).show();
            case R.id.a2 : Toast.makeText(this,"Doğan",Toast.LENGTH_SHORT).show();
            case R.id.a3 : Toast.makeText(this,"İstanbul",Toast.LENGTH_SHORT).show();

        }


        return true;
    }

    public void PressMe(View v) {
        if (v.getId()==R.id.btn)
        {
            PopupMenu p1 = new PopupMenu(this,findViewById(R.id.btn));
            p1.getMenuInflater().inflate(R.menu.popup_menu,p1.getMenu());
            p1.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem item) {
                    switch (item.getItemId())
                    {
                        case R.id.a1 :Toast.makeText(MainActivity.this,"Ebubekir",Toast.LENGTH_LONG).show();break;
                        case R.id.a2 :Toast.makeText(MainActivity.this,"Alihan",Toast.LENGTH_LONG).show();break;
                        case R.id.a3 :Toast.makeText(MainActivity.this,"Ömer",Toast.LENGTH_LONG).show();break;
                    }
                    return true;
                }
            });
            p1.show();
        }

    }
}
