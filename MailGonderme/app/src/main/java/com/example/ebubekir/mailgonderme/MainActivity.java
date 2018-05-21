package com.example.ebubekir.mailgonderme;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText editTextAdres = (EditText) findViewById(R.id.editTextAdres);
        final EditText editTextIcerik = (EditText) findViewById(R.id.editTextIcerik);
        final EditText editTextKonu = (EditText) findViewById(R.id.editTextKonu);
        Button mailgonder = (Button) findViewById(R.id.button);

        mailgonder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                mailGonder(editTextAdres.getText().toString(),editTextKonu.getText().toString(),editTextIcerik.getText().toString());
            }


        });
    }
    private void mailGonder(String Adres, String Konu, String Icerik)
    {
        Intent mailIntent = new Intent(Intent.ACTION_SEND);
        mailIntent.setType("message/rfc822");
        mailIntent.putExtra(Intent.EXTRA_EMAIL,new String[]{Adres});
        mailIntent.putExtra(Intent.EXTRA_SUBJECT,new String[]{Konu});
        mailIntent.putExtra(Intent.EXTRA_TEXT,new String[]{Icerik});

        try
        {
            startActivity(mailIntent);
        }
        catch (ActivityNotFoundException hata)
        {
            Toast.makeText(MainActivity.this,"Hata Oluştu!\n"+hata.getMessage(),Toast.LENGTH_SHORT).show();
        }

    }
}
