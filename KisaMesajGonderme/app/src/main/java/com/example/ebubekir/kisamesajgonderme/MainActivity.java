
package com.example.ebubekir.kisamesajgonderme;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText numara;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView tv = (TextView) findViewById(R.id.mesaj);
        Button btn = (Button) findViewById(R.id.Paylas);
        numara =(EditText)findViewById(R.id.editTextTelno);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                CharSequence mesaj = tv.getText();
                //paylasMesaj(mesaj);
               // smsGonder(mesaj);
                smsDirekGonder(mesaj);
            }


        });
    }




    private void paylasMesaj(CharSequence mesaj)
    {
        Intent paylas = new Intent(Intent.ACTION_SEND);
        paylas.setType("text/plain");
        paylas.putExtra(Intent.EXTRA_TEXT,mesaj);
        startActivity(Intent.createChooser(paylas,"Paylaş"));

    }
    private void smsGonder(CharSequence mesaj)
    {

        Intent smsGonder = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:44444444"));
        smsGonder.putExtra("sms_body",mesaj);

        startActivity(smsGonder);
    }

    private void smsDirekGonder(CharSequence mesaj)
    {
        SmsManager manager = SmsManager.getDefault();
        manager.sendTextMessage(String.valueOf(Integer.parseInt(numara.getText().toString())),null,mesaj.toString(),null,null);

    }
}
