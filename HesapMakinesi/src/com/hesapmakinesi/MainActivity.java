package com.hesapmakinesi;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.app.Activity;

public  class MainActivity extends Activity implements OnClickListener{

	 private float ilkDeger =0;
	 private double sonuc =0;
	 private String islem;
	
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		final TextView txtview = (TextView) findViewById(R.id.textView1);
		Button btn1 = (Button) findViewById(R.id.Btn1);
		Button btn2 = (Button) findViewById(R.id.Btn2);
		Button btn3 = (Button) findViewById(R.id.Btn3);
		Button btn4 = (Button) findViewById(R.id.Btn4);
		Button btn5 = (Button) findViewById(R.id.Btn5);
		Button btn6 = (Button) findViewById(R.id.Btn6);
		Button btn7 = (Button) findViewById(R.id.Btn7);
		Button btn8 = (Button) findViewById(R.id.Btn8);
		Button btn9 = (Button) findViewById(R.id.Btn9);
		Button btn0 = (Button) findViewById(R.id.Btn0);
		Button BtnBol = (Button) findViewById(R.id.BtnBol);
		Button BtnCarp = (Button) findViewById(R.id.BtnCarp);
		Button BtnEsittir = (Button) findViewById(R.id.BtnEsittir);
		Button Btncikar = (Button) findViewById(R.id.Btncikar);
		Button Btnsil = (Button) findViewById(R.id.Btnsil);
		Button BtnTopla = (Button) findViewById(R.id.BtnTopla);
		
		
		
		btn1.setOnClickListener(new OnClickListener() {
 
			public void onClick(View v) {
				txtview.setText(txtview.getText() + "1");
				
			}
		});
		
	btn2.setOnClickListener(new OnClickListener() {
			
 
			public void onClick(View v) {
				txtview.setText(txtview.getText() + "2");
				
			}
		});
	btn3.setOnClickListener(new OnClickListener() {
		
		
		public void onClick(View v) {
			txtview.setText(txtview.getText() + "3");
			
		}
	});
	btn4.setOnClickListener(new OnClickListener() {
		
		
		public void onClick(View v) {
			txtview.setText(txtview.getText() + "4");
			
		}
	});
	btn5.setOnClickListener(new OnClickListener() {
 
		public void onClick(View v) {
			txtview.setText(txtview.getText() + "5");
			
		}
	});
	btn6.setOnClickListener(new OnClickListener() {
		
 
		public void onClick(View v) {
			txtview.setText(txtview.getText() + "6");
			
		}
	});
	btn7.setOnClickListener(new OnClickListener() {
		

		public void onClick(View v) {
			txtview.setText(txtview.getText() + "7");
			
		}
	});
	btn8.setOnClickListener(new OnClickListener() {
		
 
		public void onClick(View v) {
			txtview.setText(txtview.getText() + "8");
			
		}
	});
	btn9.setOnClickListener(new OnClickListener() {
		
 
		public void onClick(View v) {
			txtview.setText(txtview.getText() + "9");
			
		}
	});
	btn0.setOnClickListener(new OnClickListener() {
		
		public void onClick(View v) {
			txtview.setText(txtview.getText() + "0");
			
		}
	});
	
	 try {
		Btnsil.setOnClickListener(new View.OnClickListener() {
			
 
			public void onClick(View v) {
			ilkDeger = 0;
			sonuc =0;
			txtview.setText("");
			}
		});
		 
		 
	} catch (Exception c) 
	 {
		
		 
	 }
	 //Toplama Ýþlemi 
	 try
	 {
		  BtnTopla.setOnClickListener(new OnClickListener() {
			
 
			public void onClick(View arg0) {
				
				 if(!txtview.getText().toString().equals(""))
				 {
					 ilkDeger = Float.parseFloat(txtview.getText().toString());
					 txtview.setText("");
					 islem = "Toplama";
					 
				 }
				
			}
		});
		 
		
	} 
	 
	 catch (Exception e)
	 {
		 
	 }
	 //Çýkarma Ýþlemi
	 try
	 {
		  Btncikar.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				
				 if(!txtview.getText().toString().equals(""))
				 {
					 ilkDeger = Float.parseFloat(txtview.getText().toString());
					 txtview.setText("");
					 islem = "Cikarma";
					 
				 }
				
			}
		});
		 
		
	} 
	 
	 catch (Exception e)
	 {
		 
	 }
	 // Çarpma Ýþlemi
	
	 
	 try
	 {
		  BtnCarp.setOnClickListener(new OnClickListener() {
			
 
			public void onClick(View arg0) {
				
				 if(!txtview.getText().toString().equals(""))
				 {
					 ilkDeger = Float.parseFloat(txtview.getText().toString());
					 txtview.setText("");
					 islem = "Carpma"; 
				 }	
			}
		});
		 
		
	} 
	 
	 catch (Exception e)
	 {
		 
	 }
	 // Bolme iþlemi
	 
	 try
	 {
		  BtnBol.setOnClickListener(new OnClickListener() {
		
			public void onClick(View arg0) {
				
				 if(!txtview.getText().toString().equals(""))
				 {
					 ilkDeger = Float.parseFloat(txtview.getText().toString());
					 txtview.setText("");
					 islem = "Bolme";
					 
				 }
				
			}
		});
		 
		
	} 
	 
	 catch (Exception e)
	 {
		 
	 }
	 
	 BtnEsittir.setOnClickListener(new OnClickListener() {
		
 
		public void onClick(View v) {
			
			if(!txtview.getText().toString().equals("") && !String.valueOf(ilkDeger).equals("0"))
			{
				 if(islem.equals("Toplama"))
				 {
					 sonuc = ilkDeger + Float.parseFloat(txtview.getText().toString());
				 }
				 else if(islem.equals("Cikarma"))
				 {
					 
					 sonuc = ilkDeger - Float.parseFloat(txtview.getText().toString());
				 }
				 else if(islem.equals("Carpma"))
				 {
					 
					 sonuc = ilkDeger * Float.parseFloat(txtview.getText().toString());
				 }
				 else if(islem.equals("Bolme"))
				 {
					 
					 sonuc = ilkDeger / Float.parseFloat(txtview.getText().toString());
				 }
				 
				 txtview.setText(String.valueOf(sonuc));
				 ilkDeger =0;
				 sonuc=0;
				
			}
			else
			{
				txtview.setText("Deðer Girilmedi.");
				
			}
			if(R.id.Btnsil == v.getId())
			{
				ilkDeger =0;
				sonuc=0;
			 
				txtview.setText("");
				
			}
			
		}
	});
	 
 
		
	}
	public void onClick(View v) {
		
	}
 
}
