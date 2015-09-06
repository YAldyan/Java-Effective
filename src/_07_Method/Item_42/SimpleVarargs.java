package _07_Method.Item_42;

import java.util.Arrays;
import java.util.List;

public class SimpleVarargs {

	// Simple use of varargs
	static int sum(int... args) {
		int sum = 0;
		
		for (int arg : args)
			sum += arg;
		
		return sum;
	}
	
	// The WRONG way to use varargs to pass one or more arguments!
	static int min(int... args) {
		
		if (args.length == 0)
			throw new IllegalArgumentException("Too few arguments");
	
		int min = args[0];
	
		for (int i = 1; i < args.length; i++)
			if (args[i] < min)
				min = args[i];
	
		return min;
	}
	
	// The right way to use varargs to pass one or more arguments
	static int min(int firstArg, int... remainingArgs) {
	
		int min = firstArg;
	
		for (int arg : remainingArgs)
			if (arg < min)
				min = arg;
	
		return min;
	}
	
	// the correct way to convert group of argument/parameter become a good list type
	@SafeVarargs
	public static <T> List<T> gather(T... args) {
		return Arrays.asList(args);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(SimpleVarargs.sum(1,2,3));
		System.out.println(SimpleVarargs.sum());
	}

}
