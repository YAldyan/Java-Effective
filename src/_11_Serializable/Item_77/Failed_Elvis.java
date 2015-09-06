package _11_Serializable.Item_77;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.Arrays;

//Broken singleton - has nontransient object reference field!
public class Failed_Elvis implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 172188941215833117L;
	
	public static final Failed_Elvis INSTANCE = new Failed_Elvis();

	private Failed_Elvis() { }

	private String[] favoriteSongs = { "Hound Dog", "Heartbreak Hotel" };

	public void printFavorites() {
		System.out.println(Arrays.toString(favoriteSongs));
	}

	private Object readResolve() throws ObjectStreamException {
		return INSTANCE;
	}
	
	// Returns the object with the specified serialized form
	public static Object deserialize(byte[] sf) {
		
		try {
			InputStream is = new ByteArrayInputStream(sf);
					
			ObjectInputStream ois = new ObjectInputStream(is);
		
			return ois.readObject();
		} catch (Exception e) {
			throw new IllegalArgumentException(e);
		}
	}
}

