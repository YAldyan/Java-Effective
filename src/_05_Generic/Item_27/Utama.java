package _05_Generic.Item_27;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Utama {
	
	// Uses raw types - unacceptable! (Item 23)
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Set union(Set s1, Set s2) {
		Set result = new HashSet(s1);
	
		result.addAll(s2);
	
		return result;
	}

	/*
	 * generic method di bawah ini memudahkan untuk kita menentukan
	 * tipe-nya yang pada method di-bawah menjadi simbol E.
	 */
	// Generic method
	public static <E>Set<E>generic_union(Set<E>s1, Set<E>s2) {
	
		Set<E>result = new HashSet<E>(s1);
	
		result.addAll(s2);
	
		return result;
	}

	// Generic static factory method
	public static <K,V> HashMap<K,V> newHashMap() {
		return new HashMap<K,V>();
	}
	
	/*
	 * Fungsionalitas dari generic singleton pattern
	 */
	
	// Generic singleton factory pattern
	private static UnaryFunction<Object> IDENTITY_FUNCTION =
		new UnaryFunction<Object>() {
			public Object apply(Object arg) {
				return arg; 
			}
	};


	// IDENTITY_FUNCTION is stateless and its type parameter is
	// unbounded so it's safe to share one instance across all types.
	@SuppressWarnings("unchecked")
	public static <T> UnaryFunction<T> identityFunction() {
		return (UnaryFunction<T>) IDENTITY_FUNCTION;
	}

	// Sample program to exercise generic singleton
	public static void exerciseOfGenericSingleton(){
		
		String[] strings = { "jute", "hemp", "nylon" };
			
		UnaryFunction<String> sameString = identityFunction();
			
		for (String s : strings)
			System.out.println(sameString.apply(s));
			
		Number[] numbers = { 1, 2.0, 3L };
			
		UnaryFunction<Number> sameNumber = identityFunction();
			
		for (Number n : numbers)
			System.out.println(sameNumber.apply(n));

	}
	
	/*
	 * recursive type bound
	 * recursive type bound untuk membuat proses compare nilai 
	 * dengan interface comparable menjadi lebih baik, efektif 
	 * dan berkualitas
	 */
	
	// Returns the maximum value in a list - uses recursive type bound
	public static <T extends Comparable<T>> T max(List<T> list) {
		Iterator<T> i = list.iterator();
		
		T result = i.next();
	
		while (i.hasNext()) {
			T t = i.next();
			if (t.compareTo(result) > 0)
				result = t;
		}
	
		return result;
	}

	public static void exerciseOfRecursiveTypeBound(){
		
		List<Integer> list = new ArrayList<Integer>();
		
		list.add(11);
		list.add(23);
		list.add(25);
		list.add(67);
		list.add(99);
		list.add(17);
		
		System.out.println(max(list));
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * kode program di bawah ini adalah cara bagaimana
		 * membuat sebuah instance dengan menggunakan generic
		 * static factory method, tanpa konstruktor dan tanpa
		 * perlu menuliskan secara eksplisit tipe dari key dan
		 * tipe dari value-nya.
		 */
		// Parameterized type instance creation with static factory
		@SuppressWarnings("unused")
		Map<String, List<String>> anagrams = newHashMap();
		
		/*
		 * testing untuk sebuah singleton pattern yang bersifat generic
		 * kita bisa menentukan tipe dari objek singleton menjadi apa
		 * saja dan tidak memberikan dampak buruk dengan menggunakan
		 * konsep generic
		 */
		exerciseOfGenericSingleton();
		
		/*
		 * testing untuk mencari nilai terbesar di dalam sebuah list
		 * menggunakan generic recursive type bound
		 */
		exerciseOfRecursiveTypeBound();
	}

}
