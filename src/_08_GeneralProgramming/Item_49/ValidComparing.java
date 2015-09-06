package _08_GeneralProgramming.Item_49;

import java.util.Comparator;

public class ValidComparing {

	static Comparator<Integer> naturalOrder = new Comparator<Integer>() {
		public int compare(Integer first, Integer second) {
			int f = first; // Auto-unboxing
			int s = second; // Auto-unboxing
		
			return f < s ? -1 : (f == s ? 0 : 1); // No unboxing
		}
	};
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(naturalOrder.compare(new Integer(42), new Integer(42)));
	}

}
