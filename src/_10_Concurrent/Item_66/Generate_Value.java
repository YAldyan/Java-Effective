package _10_Concurrent.Item_66;

import java.util.concurrent.atomic.AtomicLong;

public class Generate_Value {

	private static final AtomicLong nextSerialNum = new AtomicLong();
	
	// using sinkronisasi
	public static long generateSerialNumber() {
		return nextSerialNum.getAndIncrement();
	}

}
