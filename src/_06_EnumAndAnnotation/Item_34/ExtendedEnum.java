package _06_EnumAndAnnotation.Item_34;

public class ExtendedEnum {

	public static void main(String[] args) {
		
		double x = Double.parseDouble("2");
		
		double y = Double.parseDouble("4");
		
		test(ExtendedOperation.class, x, y);
		
	}
	
	private static <T extends Enum<T> & Operation> void test(
		
			Class<T> opSet, double x, double y) {
		
				for (Operation op : opSet.getEnumConstants())
					System.out.printf("%f %s %f = %f%n",x, op, y, op.apply(x, y));
	}

}
