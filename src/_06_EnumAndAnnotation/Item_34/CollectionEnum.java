package _06_EnumAndAnnotation.Item_34;

import java.util.Arrays;
import java.util.Collection;

public class CollectionEnum {

	public static void main(String[] args) {
		
		double x = Double.parseDouble("2");
		
		double y = Double.parseDouble("4");
		
		test(Arrays.asList(ExtendedOperation.values()), x, y);
	}
	
	private static void test(Collection<? extends Operation> opSet,
		
			double x, double y) {
		
				for (Operation op : opSet)
					System.out.printf("%f %s %f = %f%n",x, op, y, op.apply(x, y));
	}

}
