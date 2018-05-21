package com.example.androiduzakdbbaglanti;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.os.StrictMode;
import android.util.Log;
import android.widget.Toast;

public class LocalBaglanti {
	JSONArray jsonDizi = null;
	String sonuc = null; 
	StringBuilder sb = null;
	InputStream is = null;
	
	public LocalBaglanti(){
		//Constructor
		/*A� ba�lant� sorunlar� ya�ayabilirsiniz.
		 *Bunun i�in a�a��daki kod par�as�n� kullanman�z soruna ��z�m olabilir.
		 */
		StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
		StrictMode.setThreadPolicy(policy);
	}
	
public StringBuilder localBaglantiVeriGetir(){
	try{
		/*Ba�lant� nesnesi:*/
	     HttpClient httpBaglanti = new DefaultHttpClient();
	     /*�stek olu�turuluyor.B�ylece php dosyas� �al��acak ve
	      * veritaban�na sorgu ger�ekle�tirecektir.
	      */
	     HttpPost httpIstek = new HttpPost("http://10.0.2.2/baglanti.php");
	     /*D�nen cevab� kar��lamak i�in nesne olu�turuluyor:*/
	     HttpResponse httpCevap = httpBaglanti.execute(httpIstek);
	     /*cevap olarak d�nen mesaj� elde ediyoruz:*/
	     HttpEntity httpCevapMesaji = httpCevap.getEntity();
	     is = httpCevapMesaji.getContent();
	     }catch(Exception e){
	         Log.e("LocalBaglanti", "Ba�lant� Hatas�"+e.toString());
	    }
	//
	try{
		/*Standart dosya okuma i�lemi-y�ntemi:*/
		InputStreamReader isr = new InputStreamReader(is);
	      BufferedReader okuyucu = new BufferedReader(isr,8);
	       sb = new StringBuilder();
	       sb.append(okuyucu.readLine() + "\n");

	       String satir;
	       while ((satir = okuyucu.readLine()) != null) {
	           sb.append(satir + "\n");
	        }
	        is.close();
	        sonuc=sb.toString();
	        }catch(Exception e){
	              Log.e("LocalBaglanti", "Okuma Hatas� "+e.toString());
	        }

 
	StringBuilder str = new StringBuilder();
	try{
		/*Json ayr��t�rma i�lemi:*/
	      jsonDizi = new JSONArray(sonuc);
	      JSONObject jsonVeri;
	      for(int i=0;i<jsonDizi.length();i++){
	    	jsonVeri = jsonDizi.getJSONObject(i);
	        int id = jsonVeri.getInt("id");
	        String adi=jsonVeri.getString("Adi");
	        String soyadi=jsonVeri.getString("Soyadi"); 
	        String email=jsonVeri.getString("EMail"); 
	        str.append(String.valueOf(id) + " "+adi +" " + soyadi +" " + email +"\n");
	         }
	     
	      }
	      catch(Exception e1){
	    	  Log.e("LocalBaglanti", "JSON Ayr��t�rma Hatas� "+e1.toString());
	    	  return null;
	      }
	 return str;
	}
 
}
