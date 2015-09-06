package _04_ClassesAndInterfaces.Item_19;

/*
 * jangan pernah gunakan interface untuk mendefinisikan 
 * field apapun, itu tidak ada gunanya
 */
//Constant interface antipattern - do not use!
public interface PhysicalConstants {

	//Avogadro's number (1/mol)
	static final double AVOGADROS_NUMBER = 6.02214199e23;

	//Boltzmann constant (J/K)
	static final double BOLTZMANN_CONSTANT = 1.3806503e-23;

	//Mass of the electron (kg)
	static final double ELECTRON_MASS = 9.10938188e-31;
}

