package com.example.ebubekirdoan.texttospeech;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    public ImageButton voice_button;
    public EditText multiline_txt;
    public Button send_bttn;
    public Intent intent;
    public static final int request_code_voice = 1;
    public SpeechRecognizer recognizer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        voice_button = (ImageButton) findViewById(R.id.voice_button);
        multiline_txt = (EditText) findViewById(R.id.voice_txt);
        send_bttn = (Button) findViewById(R.id.bttn_send);

        multiline_txt.setEnabled(false);

        InternetKontrol();

        voice_button.setOnClickListener(new View.OnClickListener() { // image button a tıklama olayı

            @Override
            public void onClick(View v) {
                if (!internetBaglantisiVarMi()) {
                    AlertDialog.Builder builder1 = new AlertDialog.Builder(MainActivity.this);
                    builder1.setMessage("Lütfen telefonunuzun internete bağlı olduğundan emin olunuz!")
                            .setTitle("Uyarı!")
                            .setIcon(R.drawable.warning)
                            .setPositiveButton("TAMAM", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                }
                            });
                    AlertDialog alert = builder1.create();
                    alert.show();

                } else {
                    intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH); // intent i oluşturduk sesi tanıyabilmesi için
                    intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);

                    try {
                        startActivityForResult(intent, request_code_voice);  // activityi başlattık belirlediğimiz sabit değer ile birlikte
                    } catch (ActivityNotFoundException e) {
                        // activity bulunamadığı zaman hatayı göstermek için alert dialog kullandım
                        e.printStackTrace();


                        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                        builder.setMessage("Üzgünüz Telefonunuz bu sistemi desteklemiyor!!!")
                                .setTitle("Mobilhanem")
                                .setPositiveButton("TAMAM", new DialogInterface.OnClickListener() {


                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {

                                    }
                                });
                        AlertDialog alert1 = builder.create();
                        alert1.show();
                    }
                }


            }


        });

        send_bttn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Paylaş();

            }
        });


    }

    private void InternetKontrol() {
        if (!internetBaglantisiVarMi()) {
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setMessage("Lütfen telefonunuzun internete bağlı olduğundan emin olunuz!")
                    .setTitle("Uyarı!")
                    .setIcon(R.drawable.warning)
                    .setPositiveButton("TAMAM", new DialogInterface.OnClickListener() {


                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
            AlertDialog alert = builder.create();
            alert.show();
        }
    }

    protected void Paylaş() {


        String txt = multiline_txt.getText().toString();

        if (txt.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Boş paylaşım yapılamaz!! Lütfen Speech to Text kullanın", Toast.LENGTH_LONG).show();
        } else {
            Intent share_intent = new Intent(android.content.Intent.ACTION_SEND); // intenti oluşturuyoruz
            share_intent.setType("text/plain");
            share_intent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Deneme Yazisi");        // mesaj konusu olarak, Deneme Yazisi yazdık
            share_intent.putExtra(android.content.Intent.EXTRA_TEXT, multiline_txt.getText().toString()); // mesaj içeriği olarak, söylediğimiz söz gönderilecek
            startActivity(Intent.createChooser(share_intent, "Paylaşmak için bir uygulama seçiniz!"));  // paylaşmak istediğimiz platformu seçiyoruz
        }


    }

    boolean internetBaglantisiVarMi() {

        ConnectivityManager conMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        if (conMgr.getActiveNetworkInfo() != null

                && conMgr.getActiveNetworkInfo().isAvailable()

                && conMgr.getActiveNetworkInfo().isConnected()) {

            return true;

        } else {

            return false;

        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case request_code_voice: {

                if (resultCode == RESULT_OK && data != null) {
                    // intent boş olmadığında ve sonuç tamam olduğu anda konuşmayı alıp listenin içine attık
                    ArrayList<String> speech = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);

                    multiline_txt.setText(speech.get(0));
                }
                break;
            }

        }
    }

}