package _06_EnumAndAnnotation.Item_33;

import java.util.EnumMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//import java.util.HashSet;
//import java.util.Map;
//import java.util.Set;

public class Main {
	
	// use ordinal method for enum
	// Using ordinal() to index an array - DON'T DO THIS!	
	// Indexed by Herb.Type.ordinal()
	public static void herbOrdinal(){
		
		@SuppressWarnings("unchecked")
		Set<Herb>[] herbsByType = (Set<Herb>[]) new Set[Herb.Type.values().length];
		
		Herb[] garden = new Herb[herbsByType.length];
		
		for (int i = 0; i < herbsByType.length; i++)
			herbsByType[i] = new HashSet<Herb>();

		for (Herb h : garden)
			herbsByType[h.type.ordinal()].add(h);

		// Print the results
		for (int i = 0; i < herbsByType.length; i++) {
			System.out.printf("%s: %s%n",
				Herb.Type.values()[i], herbsByType[i]);
		}
		
	}
	
	// using enum map
	// Using an EnumMap to associate data with an enum
	public static void usingEnumMap(){
		
		Map<Herb.Type, Set<Herb>> herbsByType = new EnumMap<Herb.Type, Set<Herb>>(Herb.Type.class);
		
		Herb[] garden = new Herb[herbsByType.size()];
		
		for (Herb.Type t : Herb.Type.values())
			herbsByType.put(t, new HashSet<Herb>());
	
		for (Herb h : garden)
			herbsByType.get(h.type).add(h);
		
		System.out.println(herbsByType);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
