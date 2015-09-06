package _08_GeneralProgramming.Item_52;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Prefer_Interface {
	
	@SuppressWarnings("unused")
	public void implementasi_Interface(){
		
		// Good - uses interface as type
		List<Subscriber> subscribers = new Vector<Subscriber>();

		// Bad - uses class as type!
		Vector<Subscriber> subscribers_02 = new Vector<Subscriber>();

		// we can change type only with change its konstruktor
		// see we change konstruktor from Vector to ArrayList
		// if we use List, cause it's interface
		List<Subscriber> subscribers_03 = new ArrayList<Subscriber>();
	}

}

class Subscriber{
	
	public Subscriber(){};
	
}