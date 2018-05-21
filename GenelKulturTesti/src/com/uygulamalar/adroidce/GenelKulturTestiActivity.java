package com.uygulamalar.adroidce;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class GenelKulturTestiActivity extends Activity implements OnClickListener {
    /** Called when the activity is first created. */
    
	MediaPlayer dc,yc;
	Button cvp11,cvp12,cvp21,cvp22,cvp31,cvp32;
	ImageView imageView1;
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
       
        cvp11 = (Button) findViewById(R.id.cvp11);
        cvp12 = (Button) findViewById(R.id.cvp12);
        cvp21 = (Button) findViewById(R.id.cvp21);
        cvp22 = (Button) findViewById(R.id.cvp22);
        cvp31 = (Button) findViewById(R.id.cvp31);
        cvp32 = (Button) findViewById(R.id.cvp32);
        imageView1= (ImageView) findViewById(R.id.imageView1);
        
        yc = MediaPlayer.create(this,R.raw.yanliscevap);
        dc = MediaPlayer.create(this,R.raw.dogrucevap);
       
        cvp11.setOnClickListener(this);
        cvp12.setOnClickListener(this);
        cvp21.setOnClickListener(this);
        cvp22.setOnClickListener(this);
        cvp31.setOnClickListener(this);
        cvp32.setOnClickListener(this);
        
        
    }
	@Override
	public void onClick(View v) {
		switch(v.getId())
		{
		 case R.id.cvp11:
		 case R.id.cvp22:
		 case R.id.cvp31:
		 yc.start();
		 break;

		 case R.id.cvp12:
		 case R.id.cvp21:
		 case R.id.cvp32:
		 dc.start();
		 break;

		}
		
	}
	
}