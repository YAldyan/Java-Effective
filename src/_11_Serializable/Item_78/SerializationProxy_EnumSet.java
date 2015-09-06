package _11_Serializable.Item_78;

import java.io.Serializable;
import java.util.EnumSet;

//EnumSet's serialization proxy
class SerializationProxy_EnumSet <E extends Enum<E>> implements Serializable {

	@SuppressWarnings("rawtypes")
	private static final Enum[] EMPTY_ENUM_ARRAY = null;

	//The element type of this enum set.
	private final Class<E> elementType = null;

	//The elements contained in this enum set.
	@SuppressWarnings("rawtypes")
	private final Enum[] elements;

	SerializationProxy_EnumSet(EnumSet<E> set) {
		// elementType = set.elementType;
		elements = set.toArray(EMPTY_ENUM_ARRAY); // (Item 43)
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private Object readResolve() {

		EnumSet<E> result = EnumSet.noneOf(elementType);

		for (Enum e : elements)
			result.add((E)e);
			return result;
	}

	private static final long serialVersionUID = 362491234563181265L;
}

