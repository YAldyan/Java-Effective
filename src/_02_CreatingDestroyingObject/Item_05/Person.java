package _02_CreatingDestroyingObject.Item_05;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class Person {
	
	private final Date birthDate = null;
	// Other fields, methods, and constructor omitted
	
	// DON'T DO THIS!
	public boolean isBabyBoomer() {
	
		// Unnecessary allocation of expensive object
		Calendar gmtCal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
	
		gmtCal.set(1946, Calendar.JANUARY, 1, 0, 0, 0);
	
		Date boomStart = gmtCal.getTime();
		gmtCal.set(1965, Calendar.JANUARY, 1, 0, 0, 0);

		Date boomEnd = gmtCal.getTime();
		
		return birthDate.compareTo(boomStart) >= 0 && birthDate.compareTo(boomEnd) < 0;
	}

}


// tiap kali method isBabyBoomer di-panggil
// dia akan menciptakan Calendar dan 2 Date.
// dan itu akan menyebabkan in-efisiensi pada
// memori, jadi cara di-atas jangan dilakukan.

// cara untuk menghindari kesalahan di-atas
// adalah dengan menggunakan inisialisasi yang
// static, contoh di kelas PersonCorrect 
