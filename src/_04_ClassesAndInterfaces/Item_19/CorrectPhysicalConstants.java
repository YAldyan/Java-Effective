package _04_ClassesAndInterfaces.Item_19;

/*
 * seandainya-pun mutlak butuh, lebih baik gunakan
 * kelas yang tidak bisa di-instansiasi atau cara terbaik
 * gunakanlah tipe enum
 */

//Constant utility class
public class CorrectPhysicalConstants {
	
	private CorrectPhysicalConstants() { } // Prevents instantiation

	public static final double AVOGADROS_NUMBER = 6.02214199e23;
	public static final double BOLTZMANN_CONSTANT = 1.3806503e-23;
	public static final double ELECTRON_MASS = 9.10938188e-31;
}

