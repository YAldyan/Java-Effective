package _11_Serializable.Item_75;

import java.io.Serializable;

//Awful candidate for default serialized form
public final class StringList implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6861274126228918210L;

	@SuppressWarnings("unused")
	private int size = 0;

	@SuppressWarnings("unused")
	private Entry head = null;

	@SuppressWarnings("serial")
	private static class Entry implements Serializable {

		@SuppressWarnings("unused")
		String data;
		@SuppressWarnings("unused")
		Entry next;
		@SuppressWarnings("unused")
		Entry previous;
	}
	// Remainder omitted
}

