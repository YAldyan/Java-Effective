package _04_ClassesAndInterfaces.Item_15;

/*
 * method valueOf memungkinkan kita untuk membuat banyak implementation
 * dari package yang berbeda sekalipun, membuat nilai-nya tetap immutable
 * karena maisng-masing field sudah bersifat final
 */
public class ComplexStaticFactory {
	
	@SuppressWarnings("unused")
	private final double re;
	
	@SuppressWarnings("unused")
	private final double im;
	
	private ComplexStaticFactory(double re, double im) {
		this.re = re;
	
		this.im = im;
	}
	
	public static Complex valueOf(double re, double im) {
		return new Complex(re, im);
	}
	// Remainder unchanged

}
