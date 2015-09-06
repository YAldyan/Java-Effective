package _03_MethodCommonAllObject.Item_12;

@SuppressWarnings("rawtypes")
public class PhoneNumber implements Comparable {
	
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
	public int compareTo(Object phone_number) {
		
		PhoneNumber pn = (PhoneNumber) phone_number ;
		
		// Compare area codes
		if (areaCode < pn.areaCode)
		return -1;

		if (areaCode > pn.areaCode)
		return 1;
			// Area codes are equal, compare prefixes
		if (prefix < pn.prefix)
		return -1;

		if (prefix > pn.prefix)
		return 1;

		// Area codes and prefixes are equal, compare line numbers
		if (lineNumber < pn.lineNumber)
		return -1;

		if (lineNumber > pn.lineNumber)
		return 1;

		return 0; // All fields are equal
	}
	
	public int compareTo(PhoneNumber pn) {
		// Compare area codes
		int areaCodeDiff = areaCode - pn.areaCode;
		if (areaCodeDiff != 0)
			return areaCodeDiff;
		
		// Area codes are equal, compare prefixes
		int prefixDiff = prefix - pn.prefix;
		if (prefixDiff != 0)
			return prefixDiff;
		
		// Area codes and prefixes are equal, compare line numbers
		return lineNumber - pn.lineNumber;
	}

	
}
