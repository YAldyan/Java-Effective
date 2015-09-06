package _11_Serializable.Item_76;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;

public class MutablePeriod {
	
	// A period instance
	public final Period period;
	
	// period's start field, to which we shouldn't have access
	public final Date start;
	
	// period's end field, to which we shouldn't have access
	public final Date end;
	
	public MutablePeriod() {
	
		try {
	
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			ObjectOutputStream out = new ObjectOutputStream(bos);
	
			// Serialize a valid Period instance
			out.writeObject(new Period(new Date(), new Date()));
	
			/*
			 * Append rogue "previous object refs" for internal
			 * Date fields in Period. For details, see "Java
			 * Object Serialization Specification," Section 6.4.
			 */
			byte[] ref = { 0x71, 0, 0x7e, 0, 5 }; // Ref #5
			bos.write(ref); // The start field
			ref[4] = 4; // Ref # 4
			bos.write(ref); // The end field
	
			// Deserialize Period and "stolen" Date references
			ObjectInputStream in=new ObjectInputStream
					(new ByteArrayInputStream(bos.toByteArray()));
			
			readObject(in);
			
			period = (Period) in.readObject();
	
			start = (Date) in.readObject();
			end = (Date) in.readObject();
		} catch (Exception e) { throw new AssertionError(e);
		}
	}
	
	// readObject method with defensive copying and validity checking
	private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
	
		s.defaultReadObject();
	
		// Defensively copy our mutable components
		Date start_copy = new Date(start.getTime());
		Date end_copy = new Date(end.getTime());
	
		// Check that our invariants are satisfied
		if (start_copy.compareTo(end_copy) > 0)
			throw new InvalidObjectException(start +" after "+ end);
	}

}

