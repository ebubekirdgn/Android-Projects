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
	/*bildirim y�neticisi olu�turuluyor:*/
NotificationManager bildiri_yoneticisi =(NotificationManager) getSystemService(NOTIFICATION_SERVICE);
/*Bildirimde kullan�lacak NOT olu�turuluyor:*/
Notification not = new Notification(R.drawable.android, "Yeni Bir Bildirim...", System.currentTimeMillis()/*diledi�iniz zamanda �al��mas�n� burda belirleyebilirsiniz*/);
/*Zaman ayarl� bir Intent olu�turuluyor.Bu,belirledi�iniz saate �al��acak bir Intent t�r�d�r.Alarm veya hat�rlat�c� uygulamalar bu Intent'i kullan�r.
 *Ayr�ca i�ersinde bir Intent olu�turuluyor.Bu,bildiriyi t�klad���m�zda tekrardan uygulamam�za d�nebilmemize yarar.Diledi�iniz Aktivite veya servisi burada belirleyip
  bildiri t�kland���nda �al��mas�n� sa�layabilirsiniz.*/
PendingIntent intent_zaman_ayarli = PendingIntent.getActivity(this, 0, new Intent(this, MainActivity.class), Notification.FLAG_ONGOING_EVENT);
/*Not belirleniyor:*/
not.setLatestEventInfo(this, "kodlab.com", "Bili�im Yay�nc�l���n�n Yeni Y�z�.", intent_zaman_ayarli);
/*yap�lan t�m ayarlamalar set ediliyor:*/
bildiri_yoneticisi.notify(1, not);
}//bildirim1
	  
private void bildirim2(){
	/*bildirim1'in farkl� bir yakla��m�la tekrardan geli�tiriyoruz..*/
	
NotificationManager bildiri_yoneticisi = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);	
Intent intent = new Intent(getApplicationContext(), MainActivity.class);
PendingIntent intent_zaman_ayarli = PendingIntent.getActivity(getApplicationContext(), 0, intent, 0);
Notification not = new Notification.Builder(getApplicationContext()) 
  .setContentTitle("Yeni Bir Bildirim Ald�n�z...")
  .setContentText("www.kodlab.com").setSmallIcon(R.drawable.bildiri)
  .setContentIntent(intent_zaman_ayarli)
  /*birden fazla aksiyon tan�mlan�yor.Herbirine ayr�ca bir Intent tan�mlanabilir.*/
  .addAction(R.drawable.android, "�leri D�zey Android", intent_zaman_ayarli)
  .addAction(R.drawable.bulut, "Bulut bili�im", intent_zaman_ayarli)
  .addAction(R.drawable.info_icon, "Detayl� Bilgi", intent_zaman_ayarli).build();
  /*bildirimi t�klad�ktan sonra otomatik kapat�lmas�-gizlenmesi i�in:*/
  not.flags |= Notification.FLAG_AUTO_CANCEL;
  /*yap�lan t�m ayarlamalar set ediliyor:*/
  bildiri_yoneticisi.notify(0, not);
}//bildirim2

}//class
