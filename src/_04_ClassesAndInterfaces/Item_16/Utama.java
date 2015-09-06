package _04_ClassesAndInterfaces.Item_16;

import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;


public class Utama {
	
	public static void showInstrumentedHashSet(){
		InstrumentedHashSet<String> s = new InstrumentedHashSet<String>();
		
		s.addAll(Arrays.asList("Snap", "Crackle", "Pop"));
		
		System.out.println(s.getAddCount());
	}
	
	public static <E> void showCorrectInstrumentedHashSet(Set<Date> cmp, int capacity){
		@SuppressWarnings("unused")
		Set<Date> s = new CorrectInstrumentedSet<Date>(new TreeSet<Date>(cmp));
		@SuppressWarnings("unused")
		Set<E> s2 = new CorrectInstrumentedSet<E>(new HashSet<E>(capacity));
	}

	public static void viewCorrectInstrumentedHashSet(){
		
		CorrectInstrumentedSet<String> s = new CorrectInstrumentedSet<String>(new HashSet<String>());
		
		s.addAll(Arrays.asList("Snap", "Crackle", "Pop"));
		
		System.out.println(s.getAddCount());
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		showInstrumentedHashSet();
		
		/*
		 * alur correct instrumented set
		 * 1. method addAll() di kelas CorrectInstrumentedHashSet
		 * 2. method addAll() di kelas ForwardingSet
		 */
		viewCorrectInstrumentedHashSet();
	}

}
