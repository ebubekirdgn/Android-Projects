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

class Not {
	
	public Not(int id,String k, String i, String t) {
		_id=id;
		konu = k;
		icerik = i;
		kayittarihi = t;
	}
	public int _id;
	public String konu;
	public String icerik;
	public String kayittarihi;
}
