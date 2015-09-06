package _05_Generic.Item_26;

public class Utama {

	// Little program to exercise our generic Stack
	public static void main(String[] args) {
	
		String[] args1 = {"ahmad","arif","riswanto"};
		
		GenericStack<String> stack = new GenericStack<String>();
		
		for (String arg : args1)
			stack.push(arg);
	
		while (!stack.isEmpty())
			System.out.println(stack.pop().toUpperCase());
	}


}
