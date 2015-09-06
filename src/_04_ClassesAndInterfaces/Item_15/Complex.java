package _04_ClassesAndInterfaces.Item_15;

//Public class with exposed immutable fields - questionable
/*
 * kelas ini tidak memiliki mutator sehingga tidak ada 
 * celah untuk memodifikasi nilai dari tiap-tiap fieldnya.
 * kita hanya bisa menggunakan nilai di field-field itu
 * untuk di-operasikan dengan objek Complex buatan kita sendiri,
 * dengan menggunakan operasi aritmatika yang telah disediakan.
 */
public final class Complex {

	private final double re;

	private final double im;

	public Complex(double re, double im) {
		this.re = re;
		this.im = im;
	}	

	// Accessors with no corresponding mutators
	public double realPart() { return re; }
	
	public double imaginaryPart() { return im; }

	public Complex add(Complex c) {
		return new Complex(re + c.re, im + c.im);
	}

	public Complex subtract(Complex c) {
		return new Complex(re - c.re, im - c.im);
	}

	public Complex multiply(Complex c) {
		return new Complex(re * c.re - im * c.im, re * c.im + im * c.re);
	}

	public Complex divide(Complex c) {
		double tmp = c.re * c.re + c.im * c.im;
		
		return new Complex((re * c.re + im * c.im) / tmp, (im * c.re - re * c.im) / tmp);
	}

	@Override 
	public boolean equals(Object o) {
		if (o == this)
			return true;

		if (!(o instanceof Complex))
			return false;

		Complex c = (Complex) o;

		// See page 43 to find out why we use compare instead of ==
		return Double.compare(re, c.re) == 0 && Double.compare(im, c.im) == 0;
	}	
	
	@Override 
	public int hashCode() {
		int result = 17 + hashDouble(re);
		
		result = 31 * result + hashDouble(im);
			
		return result;
	}
		
	private int hashDouble(double val) {
			
		long longBits = Double.doubleToLongBits(re);
			
		return (int) (longBits ^ (longBits >>> 32));
	}
		
	@Override
	public String toString() {	
	
		return "(" + re + " + " + im + "i)";
	}
}