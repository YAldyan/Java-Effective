package _11_Serializable.Item_77;

import java.io.Serializable;

public class ElvisStealer implements Serializable {

	static Failed_Elvis impersonator;

	private Failed_Elvis payload;

	private Object readResolve() {

		// Save a reference to the "unresolved" Elvis instance
		impersonator = payload;

		// Return an object of correct type for favorites field
		return new String[] { "A Fool Such as I" };
	}

	private static final long serialVersionUID = 0;
}

