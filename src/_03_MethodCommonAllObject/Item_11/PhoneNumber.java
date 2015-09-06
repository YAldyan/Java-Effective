package _03_MethodCommonAllObject.Item_11;

public class PhoneNumber implements Cloneable {
	
	@SuppressWarnings("unused")
	private final short areaCode;
	
	@SuppressWarnings("unused")
	private final short prefix;
	
	@SuppressWarnings("unused")
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
	
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#clone()
	 * proses cloning yang kita lakukan pada method di bawah
	 * hanya menggunakan super.clone(), kenapa seperti itu
	 * karena seluruh field yang ada pada object Phone Number
	 * merupakan tipe data primitif, sehingga cukup dengan
	 * super.clone() saja.
	 */
	@Override 
	public PhoneNumber clone() {
		try {
			return (PhoneNumber) super.clone();
		} catch(CloneNotSupportedException e) {
			throw new AssertionError(); // Can't happen
		}
	}
	
}
