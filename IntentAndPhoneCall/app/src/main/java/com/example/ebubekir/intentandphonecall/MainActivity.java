package com.example.ebubekir.intentandphonecall;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    EditText et;
    ImageView call;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et = (EditText) findViewById(R.id.editText);
        call = (ImageView) findViewById(R.id.imageView);

        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!TextUtils.isEmpty(et.getText()))
                {
                    Intent niyet = new Intent(Intent.ACTION_CALL);
                    niyet.setData(Uri.parse("tel:" + et.getText().toString()));
                    startActivity(niyet);
                }
                else
                {
                    Toast.makeText(MainActivity.this, "Lütfen Telefon numarasını giriniz.", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
