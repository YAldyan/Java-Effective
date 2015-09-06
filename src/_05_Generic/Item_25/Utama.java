package _05_Generic.Item_25;

import java.util.ArrayList;
import java.util.List;

public class Utama {

	public void differentOfGeneric(){
		
		// This code fragment is legal:
		// Fails at runtime!
		Object[] objectArray = new Long[1];
		objectArray[0] = "I don't fit in"; // Throws ArrayStoreException
			
		// but this one is not:
		// Won't compile!
		// List<Object> ol = new ArrayList<Long>(); // Incompatible types
		// ol.add("I don't fit in");

	}
	
	public void dangerOfArray(){
		
		// Why generic array creation is illegal - won't compile!
		// List<String>[] stringLists = new List<String>[1];       // (1)
		// List<Integer> intList = Arrays.asList(42); 	            // (2)
		// Object[] objects = stringLists;                         // (3)
		// objects[0] = intList;                                   // (4)
		// String s = stringLists[0].get(0);                       // (5)        

	}
	
	// Reduction without generics, and with concurrency flaw!
	@SuppressWarnings("rawtypes")
	public static Object reduce(List list, Function f, Object initVal) {
		
			synchronized(list) {
				Object result = initVal;
				
				for (Object o : list)
					result = f.apply(result, o);
		
				return result;
			}
	}
	
	// Reduction without generics or concurrency flaw
	@SuppressWarnings("rawtypes")
	public static Object reduceNoConcurrency(List list, Function f, Object initVal) {
		
		@SuppressWarnings("unused")
		Object[] snapshot = list.toArray(); // Locks list internally
		
		Object result = initVal;
		
		for (Object o : list)
			result = f.apply(result, o);
		
		return result;
	}

	//Naive generic version of reduction - won't compile!
	public static <E> E genericReduce(List<E> list, GenericFunction<E> f, E initVal) {

		@SuppressWarnings("unchecked")
		E[] snapshot = (E[])list.toArray(); // Locks list

		E result = initVal;

		for (E e : snapshot)
			result = f.apply(result, e);

		return result;
	}
	
	// List-based generic reduction
	public static <E> E reduceGenericListBased(List<E> list, GenericFunction<E> f, E initVal) {
	
		List<E> snapshot;
	
		synchronized(list) {
			snapshot = new ArrayList<E>(list);
		}
	
		E result = initVal;
		
		for (E e : snapshot)
			result = f.apply(result, e);
	
		return result;
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
