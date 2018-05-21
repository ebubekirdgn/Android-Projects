/*
 * 
 * UYGULAMA GELİŞTİRİCİ 
 * ----TUĞRUL AŞIK----
 * 
 * WEB SITE : tugrulasik.wordpress.com
 * 
 * 
 * GELİŞTİRMELERİNİZDE YARDIMCI OLMASI DİLEĞİYLE...
 * 
 * 
 */


package DBOrnek.NotDefteri;

import java.util.ArrayList;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

class CustomListAdapter extends BaseAdapter {

	private LayoutInflater mInflater;
	private ArrayList<Not> notlar;
	private NotDefteriDatabase dba;

	public CustomListAdapter(Context context) {
		// Her defasında tekrardan sorulmasından kaçınmak için LayoutInflate'i belleğe alıyoruz.
		mInflater = LayoutInflater.from(context);
		notlar = new ArrayList<Not>();
		
		//Veritabanından tüm notları al ve notlar isimli ArrayList'e ata.
		dba = new NotDefteriDatabase(context);		
		dba.ac();
		notlar=dba.tumNotlar();		
		dba.kapat();
	}

	public int getCount() {
		return notlar.size();
	}

	public long getItemId(int position) {
		return position;
	}

	public Not getItem(int i) {
		return notlar.get(i);
	}

	public ArrayList<Not> notListesi() {
		return notlar;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		
		/* ViewHolder'ı  diğer görsellerin referansını tutmak için kullanıyoruz.
		 * Bu sayede belirli tekniklerle her defasında findViewById() çağrımından kaçınıyoruz.
		 */
		ViewHolder holder;

	
		/*
		 * convertView null değilse tekrardan inflate yapmadan etkin bir şekilde çağırıyoruz,
		 * eğer null ise viewholder'daki referanslar ilkleniyor.
		 * 
		 */
		if (convertView == null) {
			//adapterin kullanıldığı durumlarda  notsatiri.xml dosyasının yapısı kullanılacak.
			convertView = mInflater.inflate(R.layout.notsatiri, null);

			//viewholder oluştur ve  değerleri bağla.
			holder = new ViewHolder();			
			holder.mKonu = (TextView) convertView.findViewById(R.id.konuText);
			holder.mTarih = (TextView) convertView.findViewById(R.id.tarihText);

			
		} else {
			
			//var olan viewholder'ı etkin bir şekilde geri çağırıyoruz.
			holder = (ViewHolder) convertView.getTag();
		}
		
		/*
		 * veritabanındaki her değeri custom olarak belirlediğimiz ve 2 adet textview'den oluşan
		 * layouttaki tv'lere atıyoruz. 
		 */
				
		holder.mTarih.setText(notlar.get(position).kayittarihi);
		holder.mKonu.setText(notlar.get(position).konu);

		// holder'ı bağla, getTag olarak erişebileceğiz.
		convertView.setTag(holder);

		return convertView;
	}
		
     //TextView tipinde iki değeri tutuyoruz.
	public class ViewHolder {
		TextView mKonu;
		TextView mTarih;
	}

}
