package _11_Serializable.Item_78;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.util.Date;

//Immutable class that uses defensive copying
public final class Period {

	final Date start;
	final Date end;

	/**
	 * @param start the beginning of the period
	 * @param end the end of the period; must not precede start
	 * @throws IllegalArgumentException if start is after end
	 * @throws NullPointerException if start or end is null
	 */

	public Period(Date start, Date end) {

		this.start = new Date(start.getTime());
		this.end = new Date(end.getTime());

		if (this.start.compareTo(this.end) > 0) throw new IllegalArgumentException(
				start + " after " + end);
	}

	public Date start () { return new Date(start.getTime()); }
	public Date end () { return new Date(end.getTime()); }
	public String toString() { return start + " - " + end; }
	// Remainder omitted
	
	// writeReplace method for the serialization proxy pattern
	private Object writeReplace() {
		return new SerializationProxy(this);
	}
	
	// readObject method for the serialization proxy pattern
	private void readObject(ObjectInputStream stream) throws InvalidObjectException {
		throw new InvalidObjectException("Proxy required");
	}
	
	// readResolve method for Period.SerializationProxy
	private Object readResolve() {
		return new Period(start, end); // Uses public constructor
	}


}

