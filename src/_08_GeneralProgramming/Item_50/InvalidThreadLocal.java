package _08_GeneralProgramming.Item_50;

public class InvalidThreadLocal {

	private InvalidThreadLocal() { } // Noninstantiable

	// Sets the current thread's value for the named variable.
	public static void set(String key, Object value){};

	// Returns the current thread's value for the named variable.
	public static Object get(String key){return null;};
	
}
