package com.gridview;

 
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
 
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class ImageAdaptor extends BaseAdapter {

	private Context ResimlerinKucukGorunumleri;
	private Integer [] resimler = {
			R.drawable.cartoon001,
			R.drawable.cartoon003,
		 
		 
			R.drawable.cartoon014,
		 
			R.drawable.cartoon015,
		 
			R.drawable.cartoon018,
			R.drawable.cartoon019,
			 
	};
	
	public ImageAdaptor(Context c){
		ResimlerinKucukGorunumleri = c;
		
	}	

	
	public int getCount() {
		
		return resimler.length;
	}
	
	

	@Override
	public Object getItem(int arg0) {
		
		return null;
		
		
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		ImageView imajnesnesi;
		
		if(convertView==null){
			
			imajnesnesi = new ImageView(ResimlerinKucukGorunumleri);
			imajnesnesi.setLayoutParams(new GridView.LayoutParams(130,130));
			imajnesnesi.setScaleType(ImageView.ScaleType.CENTER_CROP);
			imajnesnesi.setPadding(20, 20, 20, 20);
			
		}
		else{
			
			imajnesnesi = (ImageView) convertView;
			
		}
		
		imajnesnesi.setImageResource(resimler[position]);
		
		return imajnesnesi;
	}

}
