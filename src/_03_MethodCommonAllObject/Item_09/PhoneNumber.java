package _03_MethodCommonAllObject.Item_09;

public class PhoneNumber {
	
	private final short areaCode;
	private final short prefix;
	private final short lineNumber;
	
	public PhoneNumber(int areaCode, int prefix, int lineNumber) {
		
		rangeCheck(areaCode, 999, "area code");
		
		rangeCheck(prefix, 999, "prefix");
		
		rangeCheck(lineNumber, 9999, "line number");
	
		this.areaCode = (short) areaCode;
		
		this.prefix = (short) prefix;
		
		this.lineNumber = (short) lineNumber;
	}
	
	private static void rangeCheck(int arg, int max, String name) {
		
		if (arg < 0 || arg > max)
			throw new IllegalArgumentException(name +": " + arg);
	}
	
	@Override 
	public boolean equals(Object o) {
	
		if (o == this)
			return true;
		
		if (!(o instanceof PhoneNumber))
			return false;
		
		PhoneNumber pn = (PhoneNumber)o;
		
		return pn.lineNumber == lineNumber && pn.prefix == prefix && pn.areaCode == areaCode;
	}
	
	//1. Broken - no hashCode method!
	/*
	 *  no hash code method.
	 */
	
	//2. The worst possible legal hash function - never use!
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 * Dengan hascode di bawah, memang masalah terkesan selesai
	 * tapi sebenarnya belum, karena setipa kali objek di-create
	 * akan memiliki objek yang sama, sehingga akan tidak mungkin
	 * untuk melakukan retrieve dengan perbandingan hascode, tapi
	 * hash code memiliki nilai yang salah, hasil yang di dapat
	 * kemungkinan akan lebih sering salah. Kita harus memastikan
	 * bahwa tiap objek yang di-create akan memiliki nilai hashcode
	 * yang selalu berbeda, dengan kata lain identik.
	 */
	/*
	 	public int hashCode() { 		
			return 42; 
		}
	*/
	
	// 3. normal hash function
	/*
	@Override 
	public int hashCode() {
		
		int result = 17;
		
		result = 31 * result + areaCode;
		result = 31 * result + prefix;
		result = 31 * result + lineNumber;
		
		return result;
	}
	*/
	
	// 4. Lazily initialized, cached hashCode
	/*
	 * Jika kelas bersifat immutable dan resource untuk
	 * melakukan computing hash code banyak, serta makan
	 * banyak sumber daya komputer, maka kita bisa pikir
	 * untuk menggunakan cache, jadi nilai hash code 
	 * dilakukan caching seperti code di bawah ini.
	 */
	private volatile int hashCode; // (See Item 71)
	
	@Override
	public int hashCode() {
		
		int result = hashCode;
	
		if (result == 0) {
			
			result = 17;
			result = 31 * result + areaCode;
			result = 31 * result + prefix;
			result = 31 * result + lineNumber;
			
			hashCode = result;
		}
	
		return result;
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 * sebenarnya materi tentang override toString adalah
	 * topik bahasan dari item nomer 10, tapi karena dikit
	 * materinya, saya akan kombinasikan di sini saja.
	 * method ini di-anjurkan untuk di-override, karena
	 * akan membantu kita memberitahukan kepada user
	 * tentang informasi yang mungkin seharusnya mereka
	 * tahu, default format dari java, tidak user friendly
	 * jadi membacanya akan membingungkan.
	 */
	@Override 
	public String toString() {
		return String.format("(%03d) %03d-%04d", areaCode, prefix, lineNumber);
	}
	
}
