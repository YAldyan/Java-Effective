package _08_GeneralProgramming.Item_50;

public class ValidThreadLocal {

	private ValidThreadLocal() { } // Noninstantiable
	
	public static class Key { // (Capability)
		Key() { }
	}
	
	// Generates a unique, unforgeable key
	public static Key getKey() {
		return new Key();
	}
	
	public static void set(Key key, Object value){};
	public static Object get(Key key){return null;};
}
