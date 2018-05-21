package com.example.androiduzakdbbaglanti;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import android.util.Log;

public class UzakBaglanti {
	/*Global nesne ve de�i�kenlerimizi tan�ml�yoruz:*/
    static Connection baglanti = null;
    static Statement statement = null;
    /*
     * Ba�lanaca��m�z sunucuya ait ip adresi ve mysql port numaras�n� belirtiyoruz.
     * Ama �ncesinde kulland���m�z veritaban�na ait JDBC anahtar s�zc���n� belirtiyoruz.
     * Benim kulland���m mysql portu "3306" varsay�lan portudur.
     * Sizde farkl�l�k g�sterebilir.
     * Sunucu linkini belirttikten sonra veritaban� ad�n� belirtmemiz gerekiyor.
     * G�venlik nedeniyle sunucu bilgilerim yerine temsili bilgiler verilmi�tir.
     */
    static String DB_URL = "jdbc:mysql://ip_adresi:3306/VeritabaniAdi";
    /*Veritaban�na ait kullan�c� ad�:*/
    static String DB_KADI = "root"; 
    /*Veritaban�na ait �ifre:*/
    static String DB_SIFRE ="123456";  
    
	public UzakBaglanti(){
		//Constructor
	}
	
	public StringBuilder uzakBaglantiVeriGetir(){
		ResultSet sonuclarKumesi =null;
		StringBuilder str = new StringBuilder();
	    try {
	    	/*JDBC yi belirtiyoruz:*/
	    	Class.forName("com.mysql.jdbc.Driver").newInstance();
	    	/*Veritaban�na ba�lant� olu�turuyoruz:*/
			baglanti = DriverManager.getConnection(DB_URL, DB_KADI, DB_SIFRE);
	        statement = baglanti.createStatement();
	        /*Sql sorgusu:*/
	        String sorgu ="SELECT *FROM TabloAdi"; 
	        /*Sorguyu �al��t�r�yoruz ve geri d�nen sorgu de�erini "ResultSet" nesnesine aktar�yoruz:*/
	        sonuclarKumesi = statement.executeQuery(sorgu);
	        /*Bir d�ng� vas�tas�yla t�m kay�tlara tek tek eri�iyoruz:*/
	        while(sonuclarKumesi.next()){
	        	/*Sonu� k�mesi i�ersinde tutulan de�erlere veri t�rlerini belirterek elde ediyoruz:*/
		         int id     = sonuclarKumesi.getInt("id"); 
		         String adi  = sonuclarKumesi.getString("Adi");
		         String soyadi  = sonuclarKumesi.getString("Soyadi");
		         String email  = sonuclarKumesi.getString("EMail");
		         str.append(String.valueOf(id) +" "+adi +" "+ soyadi +" " +email +"\n");
		       }
	    }catch(Exception e){
	       Log.e("HATA", e.getMessage());
	     return null;
	    }
	    return str;
	}

}
