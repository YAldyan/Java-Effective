package _04_ClassesAndInterfaces.Item_18;

import java.util.Map;
import java.util.Map.Entry;

/*
 * di bawah ini adalah sebuah abstract kelas yang diciptakan dengan
 * fungsionalitas interface, karena kelas abstract di bawah ini telah
 * meng-implement sebuah interface, tujuannya adalah ketika kita perlu
 * fungsionalitas dari interface, tapi hanya ingin sebagian saja dari
 * seluruh fungsionalitasnya, kita bisa menggunakan cara di bawah ini
 * karena kalo kita implement interface secara langsung, maka kita
 * wajib untuk membawa semua fungsionalitasnya, dalam artian method-nya
 * sedangkan untuk abstract kelas, kita bisa saja hanya meng-override
 * sebagian saja tidak seluruhnya.
 */
public abstract class AbstractMapEntry <K,V> implements Map.Entry<K,V> {
	
	// Primitive operations
	public abstract K getKey();
	public abstract V getValue();

	// Entries in modifiable maps must override this method
	public V setValue(V value) {
		throw new UnsupportedOperationException();
	}

	// Implements the general contract of Map.Entry.equals
	@Override 
	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (! (o instanceof Map.Entry))
			return false;

		Map.Entry<?,?> arg = (Entry<?, ?>) o;

		return equals(getKey(), arg.getKey()) && equals(getValue(), arg.getValue());
	}
	
	private static boolean equals(Object o1, Object o2) {
		return o1 == null ? o2 == null : o1.equals(o2);
	}
	
	// Implements the general contract of Map.Entry.hashCode
	@Override
	public int hashCode() {
		return hashCode(getKey()) ^ hashCode(getValue());
	}
	
	private static int hashCode(Object obj) {
		return obj == null ? 0 : obj.hashCode();
	}
}
