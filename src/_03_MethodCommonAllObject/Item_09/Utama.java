package _03_MethodCommonAllObject.Item_09;

import java.util.HashMap;
import java.util.Map;

public class Utama {
	
	public static void retrievePhoneWithoutHashcode(){
		
		Map<PhoneNumber, String> m = new HashMap<PhoneNumber, String>();
		
		m.put(new PhoneNumber(707, 867, 5309), "Jenny");
		
		System.out.println(m.get(new PhoneNumber(707, 867, 5309)));
		
		/* ketika method ini dijalankan, sebagian dari kita pasti berpikir
		 * bahwa kode akan mengembalikan Jenny sebagai nilai yang di-retrieve
		 * nyatanya kita mendapatkan nilau null, itu karena kita tidak override
		 * method hashcode, padahal kita meng-override method equals. Akibatnya
		 * saat retrieve, nilai hashcode akan di-cek dan didapati berbeda, sehingga
		 * mengembalikan nilai null
		 */
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Utama.retrievePhoneWithoutHashcode();
	}

}
