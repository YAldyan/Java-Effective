package _11_Serializable.Item_75;

import java.io.Serializable;

//Good candidate for default serialized form
public class Name implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8578111759949052990L;

	/**
	 * Last name. Must be non-null.
	 * @serial
	 */
	@SuppressWarnings("unused")
	private String lastName;

	/**
	 * First name. Must be non-null.
	 * @serial
	 */
	@SuppressWarnings("unused")
	private String firstName;

	/**
	 * Middle name, or null if there is none.
	 * @serial	
	 */

	@SuppressWarnings("unused")
	private String middleName;
	// Remainder omitted
}

