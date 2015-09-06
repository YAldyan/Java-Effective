package _06_EnumAndAnnotation.Item_30;

/*
 * kelemahan dari kelas enum ini
 * adalah jika kita menambahkan
 * tipe operasi baru dan lupa
 * untuk menambahkan case, maka
 * akan menyebabkan error
 */
public enum Operation {

	PLUS, MINUS, TIMES, DIVIDE;

	// Do the arithmetic op represented by this constant
	double apply(double x, double y) {

		switch(this) {
			case PLUS: return x + y;
			case MINUS: return x - y;
			case TIMES: return x * y;
			case DIVIDE: return x / y;
		}
		
		throw new AssertionError("Unknown op: " + this);
	}
}