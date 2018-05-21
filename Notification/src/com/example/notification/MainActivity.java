package com.example.notification;

import android.os.Bundle;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	       
		Button btn_bildirim1 = (Button)findViewById(com.example.notification.R.id.button_bildirim1);
		Button btn_bildirim2 = (Button)findViewById(com.example.notification.R.id.button_bildirim2);
		
		btn_bildirim1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
			 bildirim1();				
			}
		});
		btn_bildirim2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				bildirim2();
			}
		});
	}//onCreate

private void bildirim1() {
	/*bildirim yöneticisi oluþturuluyor:*/
NotificationManager bildiri_yoneticisi =(NotificationManager) getSystemService(NOTIFICATION_SERVICE);
/*Bildirimde kullanýlacak NOT oluþturuluyor:*/
Notification not = new Notification(R.drawable.android, "Yeni Bir Bildirim...", System.currentTimeMillis()/*dilediðiniz zamanda çalýþmasýný burda belirleyebilirsiniz*/);
/*Zaman ayarlý bir Intent oluþturuluyor.Bu,belirlediðiniz saate çalýþacak bir Intent türüdür.Alarm veya hatýrlatýcý uygulamalar bu Intent'i kullanýr.
 *Ayrýca içersinde bir Intent oluþturuluyor.Bu,bildiriyi týkladýðýmýzda tekrardan uygulamamýza dönebilmemize yarar.Dilediðiniz Aktivite veya servisi burada belirleyip
  bildiri týklandýðýnda çalýþmasýný saðlayabilirsiniz.*/
PendingIntent intent_zaman_ayarli = PendingIntent.getActivity(this, 0, new Intent(this, MainActivity.class), Notification.FLAG_ONGOING_EVENT);
/*Not belirleniyor:*/
not.setLatestEventInfo(this, "kodlab.com", "Biliþim Yayýncýlýðýnýn Yeni Yüzü.", intent_zaman_ayarli);
/*yapýlan tüm ayarlamalar set ediliyor:*/
bildiri_yoneticisi.notify(1, not);
}//bildirim1
	  
private void bildirim2(){
	/*bildirim1'in farklý bir yaklaþýmýla tekrardan geliþtiriyoruz..*/
	
NotificationManager bildiri_yoneticisi = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);	
Intent intent = new Intent(getApplicationContext(), MainActivity.class);
PendingIntent intent_zaman_ayarli = PendingIntent.getActivity(getApplicationContext(), 0, intent, 0);
Notification not = new Notification.Builder(getApplicationContext()) 
  .setContentTitle("Yeni Bir Bildirim Aldýnýz...")
  .setContentText("www.kodlab.com").setSmallIcon(R.drawable.bildiri)
  .setContentIntent(intent_zaman_ayarli)
  /*birden fazla aksiyon tanýmlanýyor.Herbirine ayrýca bir Intent tanýmlanabilir.*/
  .addAction(R.drawable.android, "Ýleri Düzey Android", intent_zaman_ayarli)
  .addAction(R.drawable.bulut, "Bulut biliþim", intent_zaman_ayarli)
  .addAction(R.drawable.info_icon, "Detaylý Bilgi", intent_zaman_ayarli).build();
  /*bildirimi týkladýktan sonra otomatik kapatýlmasý-gizlenmesi için:*/
  not.flags |= Notification.FLAG_AUTO_CANCEL;
  /*yapýlan tüm ayarlamalar set ediliyor:*/
  bildiri_yoneticisi.notify(0, not);
}//bildirim2

}//class
