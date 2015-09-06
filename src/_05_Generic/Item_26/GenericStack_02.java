package _05_Generic.Item_26;

import java.util.Arrays;
import java.util.EmptyStackException;

//Initial attempt to generify Stack = won’t compile!
public class GenericStack_02<E>{

	private Object[] elements;

	private int size = 0;

	private static final int DEFAULT_INITIAL_CAPACITY = 16;

	public GenericStack_02() {
		elements = new Object[DEFAULT_INITIAL_CAPACITY];
	}

	public void push(E e) {
		ensureCapacity();
		elements[size++] = e;
	}

	public E pop() {
		if (size==0)
			throw new EmptyStackException();

		// E result = elements[--size];
		
		@SuppressWarnings("unchecked")
		E result = (E) elements[--size];

		elements[size] = null; // Eliminate obsolete reference

		return result;
	}
	
	private void ensureCapacity() {
		if (elements.length == size)
			elements = Arrays.copyOf(elements, 2 * size + 1);
	}
	// no changes in isEmpty or ensureCapacity
}


