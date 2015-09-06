package _05_Generic.Item_28;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Utama {
	
	@SuppressWarnings("unused")
	public static void pushAllStackWithoudWildcard(){
		Stack<Number> numberStack = new Stack<Number>();
		
		List<Integer> integers = new ArrayList<Integer>();
		
		/*
		 * jikalau kode program di-bawah di-uncommented
		 * kita akan memperoleh error, karena tipe integer
		 * tidak match dengan tipe number pada stack
		 */
		//numberStack.pushAll(integers);

	}
	
	public static void pushAllStackWithWildcard(){
		Stack<Number> numberStack = new Stack<Number>();
		
		List<Integer> integers = new ArrayList<Integer>();
		
		/*
		 * kode program di-bawah akan running dengan baik
		 * karena sesuai dengan method pushAllWildcard
		 * integer merupakan extends dari number sehingga
		 * mereka masih satu jenis dan match dengan number
		 */
		numberStack.pushAllWildcard(integers);

	}
	
	@SuppressWarnings("unused")
	public static void popAllStackWithoudWildcard(){
		Stack<Number> numberStack = new Stack<Number>();	
		
		List<Object> objects = new ArrayList<Object>() ;

		/*
		 * jikalau kode program di-bawah di-uncommented
		 * kita akan memperoleh error, karena tipe object
		 * tidak match dengan tipe number pada stack
		 */
		//numberStack.popAll(objects);;

	}

	public static void popAllStackWithWildcard(){
		Stack<Number> numberStack = new Stack<Number>();	
		
		List<Object> objects = new ArrayList<Object>() ;

		/*
		 * method akan running dengan baik karena
		 * object adalah induk dari tipe data
		 * number, sehingga mereka akan match
		 * sesuai dengan parameter yang digunakan
		 * oleh method popAllWildcard
		 */
		numberStack.popAllWildcard(objects);

	}
	
	public static <E> void unionWithWildcard(){
		Set<Integer> integers = new HashSet<Integer>();
		Set<Double> doubles = new HashSet<Double>() ;
		
		integers.add(12);
		integers.add(23);
		
		doubles.add(11.0);
		doubles.add(10.0);
		
		@SuppressWarnings("unchecked")
		Set<? super Number> numbers = (Set<? super Number>) Stack.union(integers, doubles);
		
		Iterator<? super Number> iterator = numbers.iterator() ;
		
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}

	}
	
	public static void exerciseOfRecursiveTypeBound(){
		
		List<Integer> list = new ArrayList<Integer>();
		
		list.add(11);
		list.add(23);
		list.add(25);
		list.add(67);
		list.add(99);
		list.add(17);
		
		System.out.println(Stack.max(list));
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		unionWithWildcard();
		
		exerciseOfRecursiveTypeBound() ;

	}

}
