package _08_GeneralProgramming.Item_49;

import java.util.Comparator;

public class InvalidComparing {

	// Broken comparator - can you spot the flaw?
	static Comparator<Integer> naturalOrder = new Comparator<Integer>() {
		public int compare(Integer first, Integer second) {
			return first < second ? -1 : (first == second ? 0 : 1);
		}
	};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(naturalOrder.compare(new Integer(42), new Integer(42)));
	}

}
