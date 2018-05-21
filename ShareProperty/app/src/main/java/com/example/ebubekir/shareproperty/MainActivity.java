
package com.example.ebubekir.shareproperty;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView tv = (TextView) findViewById(R.id.mesaj);
        Button btn = (Button) findViewById(R.id.Paylas);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
               CharSequence mesaj = tv.getText();
                paylasMesaj(mesaj);
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

}
