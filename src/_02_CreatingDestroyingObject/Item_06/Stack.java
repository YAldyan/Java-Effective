package _02_CreatingDestroyingObject.Item_06;

import java.util.Arrays;
import java.util.EmptyStackException;

public class Stack {
	
	private Object[] elements;
	private int size = 0;
	
	private static final int DEFAULT_INITIAL_CAPACITY = 16;
	
	public Stack() {
		elements = new Object[DEFAULT_INITIAL_CAPACITY];
	}
	
	public void push(Object e) {
	
		ensureCapacity();
		elements[size++] = e;
	}
	
	public Object pop() {
		if (size == 0)
			throw new EmptyStackException();
	
		// kode sebelum-nya, membuat memori jadi leak.
		//return elements[--size];
		
		// kode setelah diperbaiki.
		Object result = elements[--size];
		elements[size] = null; // Eliminate obsolete reference
		
		return result ;
	}
	/**
	* Ensure space for at least one more element, roughly
	* doubling the capacity each time the array needs to grow.
	*/
	private void ensureCapacity() {
	
		if (elements.length == size)
			elements = Arrays.copyOf(elements, 2 * size + 1);
		
	}

}

// kalo kita running kode ini, tidak akan terjadi
// hal-hal yang aneh, hanya saja kita akan membu-
// tuhkan waktu yang cukup lama karena memori leak
// akibat masih ada reference ke objek yang sudah
// tidak dipakai lagi.

// lalu di bagian mana yang membuat-nya jadi lambat.
// ada di dalam method pop, kita akan modifikasi
// method tersebut.
