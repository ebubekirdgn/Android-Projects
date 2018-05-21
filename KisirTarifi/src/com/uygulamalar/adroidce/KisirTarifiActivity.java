package com.uygulamalar.adroidce;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class KisirTarifiActivity extends Activity implements OnClickListener {
    /** Called when the activity is first created. */
    Button button1,button2;
    ImageView imgView1;
    TextView textView1,textView2;
    
    
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        imgView1 = (ImageView) findViewById(R.id.imageView1);
        textView1 = (TextView) findViewById(R.id.textView1);
        textView2 = (TextView) findViewById(R.id.textView2);
        
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
               
	}
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(v.getId()==R.id.button1)
			textView2.setText(R.string.malzemeler);
		else if(v.getId()==R.id.button2)
			textView2.setText(R.string.hazirlanisi);
		
		
	}


	
}