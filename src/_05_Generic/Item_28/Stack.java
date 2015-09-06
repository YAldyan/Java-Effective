package _05_Generic.Item_28;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Stack<E> {

	public Stack(){}

	// Suppose we want to add a method that takes a sequence of elements and
	// pushes them all onto the stack. Here’s a first attempt:
	// pushAll method without wildcard type - deficient!
	public void pushAll(Iterable<E> src) {
		for (E e : src)
			push(e);
	}
	
	// Wildcard type for parameter that serves as an E producer
	public void pushAllWildcard(Iterable<? extends E>src) {
		for (E e : src)
			push(e);
	}

	
	// popAll method without wildcard type - deficient!
	public void popAll(Collection<E> dst) {
		while (!isEmpty())
			dst.add(pop());
	}
	
	// Wildcard type for parameter that serves as an E consumer
	public void popAllWildcard(Collection<? super E>dst) {
		while (!isEmpty())
			dst.add(pop());
	}

	public static <E> Set<? super E> union(Set<? extends E> s1, Set<? extends E> s2) {

		Set<? super E> result = new HashSet<E>(s1);
		
		result.addAll(s2);
	
		return result;
	}

	public static <T extends Comparable<? super T>> T max( List<? extends T>list) {
		Iterator<? extends T> i = list.iterator();
		
		T result = i.next();
	
		while (i.hasNext()) {
			T t = i.next();
			if (t.compareTo(result) > 0)
				result = t;
		}
	
		return result;
	}
	
	public static void swap(List<?> list, int i, int j) {
		swapHelper(list, i, j);
	}
		
	// Private helper method for wildcard capture
	private static <E> void swapHelper(List<E> list, int i, int j) {
		list.set(i, list.set(j, list.get(i)));
	}
	
	public void push(E e){}
	
	public E pop(){return null;}

	public boolean isEmpty(){return false;}
}

