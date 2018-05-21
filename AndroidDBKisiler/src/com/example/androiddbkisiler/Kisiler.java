package com.example.androiddbkisiler;

public class Kisiler {

	int ID;
	String ADI_SOYADI;
	String TEL_NO;
	String E_MAIL;
	
	/*Constructor(Yapýlandýrýcý):1*/
	public Kisiler(){
		//varsayýlan...
	}
	/*Constructor(Yapýlandýrýcý):2*/
	public Kisiler(int _ID, String _adisoyadi, String _telno,String _email){
		this.ID = _ID;
		this.ADI_SOYADI = _adisoyadi;
		this.TEL_NO = _telno;
		this.E_MAIL = _email;
	}
	
	/*Constructor(Yapýlandýrýcý):3*/
	public Kisiler(String _adisoyadi, String _telno,String _email){
		this.ADI_SOYADI = _adisoyadi;
		this.TEL_NO = _telno;
		this.E_MAIL = _email;
	}
	
	/*ID ayarla:*/
	public void setID(int _ID){
		this.ID = _ID;
    }
		
	/*ID bilgisini çaðýr:*/
	public int getID(){
		return this.ID;
	}
	
	/*Adý soyadý ayarla:*/
	public void setAdiSoyadi(String _adisoyadi){
		this.ADI_SOYADI = _adisoyadi;
	}
	/*Adý soyadý bilgisini çaðýr:*/
	public String getAdiSoyadi(){
		return this.ADI_SOYADI;
	}	
	
	/*Telefon numarasý ayarla:*/
	public void setTelNo(String _telno){
			this.TEL_NO = _telno;
	}
	/*Telefon numarasý bilgisini çaðýr:*/
	public String getTelNo(){
		return this.TEL_NO;
	}
	
	/*Email bilgisi ayarla:*/
	public void setEmail(String _email){
		this.E_MAIL = _email;
	}
	/*Email bilgisini çaðýr:*/
	public String getEmail(){
		return this.E_MAIL;
	}
}
