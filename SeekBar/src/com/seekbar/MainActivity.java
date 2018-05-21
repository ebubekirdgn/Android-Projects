package com.seekbar;

import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.app.Activity;
 

public class MainActivity extends Activity {

	SeekBar sb1,sb2,sb3;
	RelativeLayout rlv1;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		sb1 = (SeekBar) findViewById(R.id.seekBar1);
		sb2 = (SeekBar) findViewById(R.id.seekBar2);
		sb3 = (SeekBar) findViewById(R.id.seekBar3);
  rlv1 = (RelativeLayout) findViewById(R.id.background);
    
  sb1.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
	
 
	public void onStopTrackingTouch(SeekBar arg0) {
		// TODO Auto-generated method stub
		
	}
	 
	public void onStartTrackingTouch(SeekBar arg0) {
		// TODO Auto-generated method stub
		
	}
	
 
	public void onProgressChanged(SeekBar arg0, int progress, boolean fromUser) {
		
		sb1.setMax(255);
		int oran = android.graphics.Color.rgb(0, 0, progress);
		rlv1.setBackgroundColor(oran);
		
	}
});
  
  
  
  sb2.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
		
	 
	public void onStopTrackingTouch(SeekBar arg0) {
		// TODO Auto-generated method stub
		
	}
	
	 
	public void onStartTrackingTouch(SeekBar arg0) {
		// TODO Auto-generated method stub
		
	}
	
 
	public void onProgressChanged(SeekBar arg0, int progress, boolean fromUser) {
		
		sb1.setMax(255);
		int oran = android.graphics.Color.rgb(0, progress,0 );
		rlv1.setBackgroundColor(oran);
		
	}
});
  
  
  sb3.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
	public void onStopTrackingTouch(SeekBar arg0) {
		// TODO Auto-generated method stub
	}
	public void onStartTrackingTouch(SeekBar arg0) {
		// TODO Auto-generated method stub
	}	 
	public void onProgressChanged(SeekBar arg0, int progress, boolean fromUser) {
		
		sb1.setMax(255);
		int oran = android.graphics.Color.rgb(progress, 0,0 );
		rlv1.setBackgroundColor(oran);
	}
});
  
	}
  

 

}
