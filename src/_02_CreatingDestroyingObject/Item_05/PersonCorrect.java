package _02_CreatingDestroyingObject.Item_05;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class PersonCorrect {
	
	private final Date birthDate = null ;
	// Other fields, methods, and constructor omitted
	/**
	* The starting and ending dates of the baby boom.
	*/
	private static final Date BOOM_START;
	private static final Date BOOM_END;
	
	static {
		Calendar gmtCal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
		
		gmtCal.set(1946, Calendar.JANUARY, 1, 0, 0, 0);
		BOOM_START = gmtCal.getTime();
		
		gmtCal.set(1965, Calendar.JANUARY, 1, 0, 0, 0);
		BOOM_END = gmtCal.getTime();
	}
		
	public boolean isBabyBoomer() {
		
		return birthDate.compareTo(BOOM_START) >= 0 && birthDate.compareTo(BOOM_END) < 0;
	}

}

// cara di-atas membuat instance dari Calendar
// dan dua buah jenis Date menjadi di-inisialisasi
// cukup sekali saja, dan itu sangat membantu dari
// segi performa waktu eksekusi kode program.
