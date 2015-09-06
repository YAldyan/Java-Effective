package _11_Serializable.Item_78;

import java.io.Serializable;
import java.util.Date;

//Serialization proxy for Period class
class SerializationProxy implements Serializable {

	@SuppressWarnings("unused")
	private final Date start;

	@SuppressWarnings("unused")
	private final Date end;

	SerializationProxy(Period p) {
		this.start = p.start;
		this.end = p.end;
	}

	private static final long serialVersionUID = 234098243823485285L; // Any number will do (Item 75)

}

