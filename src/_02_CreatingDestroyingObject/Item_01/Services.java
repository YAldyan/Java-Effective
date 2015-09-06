package _02_CreatingDestroyingObject.Item_01;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

//Service provider framework sketch

//Service interface
interface Service {
	// Service-specific methods go here
}

//Service provider interface
interface Provider {
	Service newService();
}

//Noninstantiable class for service registration and access
public class Services {

	private Services() { } // Prevents instantiation

	//Maps service names to services
	private static final Map<String, Provider> providers = new ConcurrentHashMap<String, Provider>();

	public static final String DEFAULT_PROVIDER_NAME = "<def>";

	//Provider registration API
	public static void registerDefaultProvider(Provider p) {
		registerProvider(DEFAULT_PROVIDER_NAME, p);
	}

	public static void registerProvider(String name, Provider p){
		providers.put(name, p);
	}

	//Service access API
	public static Service newInstance() {
		return newInstance(DEFAULT_PROVIDER_NAME);
	}

	public static Service newInstance(String name) {
		Provider p = providers.get(name);
		if (p == null) 
			throw new IllegalArgumentException( "No provider registered with name: " + name);

		return p.newService();
	}
}

// kode program di-atas menjelaskan tentang point nomer 3 pada Chapter 2.
// Bahwa static factory bisa me-return objek yang merupakan turunan dari 
// objek yang seharusnya di-return, tidak seperti constructor yang hanya
// bisa me-return satu jenis objek saja.

// contoh di-atas menjelaskan bahwa kelas Services akan mengembalikan
// objek Service ketika menggunakan static factory method newInstance.
// Objek Service merupakan sebuah Interface yang sebenarnya implemtasi
// -nya tersembunyi.
// kelas service tidak di-izinkan untuk dilakukan instansiasi, satu-satu
// -nya cara adalah dengan menggunakan method newInstance sebagai static
// factory method.

// Kelas Service merupakan wadah yang digunakan untuk mendaftarkan objek
// Service dan juga cara untuk mengakses objek tersebut, jadi kelas Services
// tidak menciptakan Objek Services tapi menciptakan objek Service, dan
// menyediakan cara untuk mengaksesnya.