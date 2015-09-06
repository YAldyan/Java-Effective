package _03_MethodCommonAllObject.Item_08;

// Broken - violates symmetry!
// Aturan symmetry
// untuk setiap nilai yang reference tidak 
// null x dan y simetri adalah x.equals(y) 
// mengembalikan nilai true jika dan hanya 
// jika y.equals(x) juga mengembalikan nilai 
// true.

public final class CaseInsensitiveString {

	private final String s;

	public CaseInsensitiveString(String s) {
		if (s == null)
			throw new NullPointerException();

		this.s = s;
	}

	//Broken - violates symmetry!
	@Override 
	public boolean equals(Object o) {
		
		if (o instanceof CaseInsensitiveString)
			return s.equalsIgnoreCase( ((CaseInsensitiveString) o).s);

		// if (o instanceof String) // One-way interoperability!
		//		return s.equalsIgnoreCase((String) o);

		return false;
	}
	// Remainder omitted
}

// penerapan simetri yang salah seperti method di-atas.
// seandainya kita melakukan perbandingan, hasilnya tidak
// simetri, object vs string = true tapi sebaliknya tidak
// string vs object = false, kode program di Utama.
// sekali kita melanggar ketentua simetri untuk equals.
// kita tidak akan tahu bagaimana method equals akan
// berperilaku untuk object-object lain.

// untuk membuat method menjadi konsisten hasilnya
// kita harus membuat conditional untuk object dgn
// tipe String, analisis berikutnya, hanya objek
// dengan tipe kelas di-atas yang akan memberikan
// hasil true saat dibandingkan, asalkan field s
// yang bertipe String memiliki value yang sama.
