package _07_Method.Item_43;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EmptyArray {
	
	List<String> cheesesInStock = new ArrayList<String>();
	
	// The right way to return a copy of a collection
	public List<String> getCheeseList() {
		if (cheesesInStock.isEmpty())
			return Collections.emptyList(); // Always returns same list
		else
			return new ArrayList<String>(cheesesInStock);
	}

}
