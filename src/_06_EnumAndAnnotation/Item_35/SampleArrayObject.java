package _06_EnumAndAnnotation.Item_35;

import java.util.ArrayList;
import java.util.List;

public class SampleArrayObject {
	// Code containing an annotation with an array parameter
	@ExceptionTestArrayObject({ IndexOutOfBoundsException.class, NullPointerException.class })
	public static void doublyBad() {
		List<String> list = new ArrayList<String>();
	
		// The spec permits this method to throw either
		// IndexOutOfBoundsException or NullPointerException
		list.addAll(5, null);
	}
}

