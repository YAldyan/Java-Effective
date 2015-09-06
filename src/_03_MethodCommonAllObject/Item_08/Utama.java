package _03_MethodCommonAllObject.Item_08;

import java.awt.Color;

public class Utama {
	
	public static void testSymmetry(){
		
		CaseInsensitiveString cis = new CaseInsensitiveString("Polish");
		
		String s = "polish";
		
		System.out.println(cis.equals(s));
		
		System.out.println(s.equals(cis));
		
	}

	public static void testTransitive(){
		
		Point p = new Point(1, 2);
		
		ColorPoint cp = new ColorPoint(1, 2, Color.RED);
		
		System.out.println(p.equals(cp));
		
		System.out.println(cp.equals(p));
		
	}
	
	public static void testTransitiveSubclass(){
		ColorPoint p1 = new ColorPoint(1, 2, Color.RED);
		Point p2 = new Point(1, 2);
		ColorPoint p3 = new ColorPoint(1, 2, Color.BLUE);
		
		System.out.println(p1.equals(p2));
		
		System.out.println(p2.equals(p3));
		
		System.out.println(p1.equals(p3));
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Utama.testSymmetry();
		
		// hasilnya tidak konsisten
		// true dan false, berarti
		// method equals di buat
		// dengan kesalahan.
		
		// kenapa yang pertama true
		// karena saat Point vs ColorPoint
		// mereka memiliki posisi yang sama
		// nilai x dan y sama, sedangkan
		// saat ColorPoint vs Point, 
		// equals() di ColorPoint, menambah-
		// kan conditional Warna, yang mana
		// Objek Point tidak memilikinya
		// sehingga hasilnya false.
		Utama.testTransitive();
		
		// hasilnya true, true, false
		// karena pada dua kondisi awal
		// yang dibandingkah adalah hanya
		// posisi saja, yang terakhir,
		// color juga dibandingkan, karena
		// bentuknya adalah ColorPoint objek
		// karen warnanya tidak sama, maka
		// nilainya false, dan disinilah
		// terlihat bahwa syarat utama 
		// override method equals gagal
		// karena seharusnya, subclass-nya
		// pun harus true, dan ketiganya
		// haruslah konsisten, sama semua
		// nilainya.
		Utama.testTransitiveSubclass();
	}

}
