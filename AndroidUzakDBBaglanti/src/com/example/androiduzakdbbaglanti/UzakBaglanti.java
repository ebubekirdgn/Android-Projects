package com.example.androiduzakdbbaglanti;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import android.util.Log;

public class UzakBaglanti {
	/*Global nesne ve deðiþkenlerimizi tanýmlýyoruz:*/
    static Connection baglanti = null;
    static Statement statement = null;
    /*
     * Baðlanacaðýmýz sunucuya ait ip adresi ve mysql port numarasýný belirtiyoruz.
     * Ama öncesinde kullandýðýmýz veritabanýna ait JDBC anahtar sözcüðünü belirtiyoruz.
     * Benim kullandýðým mysql portu "3306" varsayýlan portudur.
     * Sizde farklýlýk gösterebilir.
     * Sunucu linkini belirttikten sonra veritabaný adýný belirtmemiz gerekiyor.
     * Güvenlik nedeniyle sunucu bilgilerim yerine temsili bilgiler verilmiþtir.
     */
    static String DB_URL = "jdbc:mysql://ip_adresi:3306/VeritabaniAdi";
    /*Veritabanýna ait kullanýcý adý:*/
    static String DB_KADI = "root"; 
    /*Veritabanýna ait þifre:*/
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
	    	/*Veritabanýna baðlantý oluþturuyoruz:*/
			baglanti = DriverManager.getConnection(DB_URL, DB_KADI, DB_SIFRE);
	        statement = baglanti.createStatement();
	        /*Sql sorgusu:*/
	        String sorgu ="SELECT *FROM TabloAdi"; 
	        /*Sorguyu çalýþtýrýyoruz ve geri dönen sorgu deðerini "ResultSet" nesnesine aktarýyoruz:*/
	        sonuclarKumesi = statement.executeQuery(sorgu);
	        /*Bir döngü vasýtasýyla tüm kayýtlara tek tek eriþiyoruz:*/
	        while(sonuclarKumesi.next()){
	        	/*Sonuç kümesi içersinde tutulan deðerlere veri türlerini belirterek elde ediyoruz:*/
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
