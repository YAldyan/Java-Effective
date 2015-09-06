package _04_ClassesAndInterfaces.Item_21;

import java.io.Serializable;
import java.util.Comparator;

//Exporting a concrete strategy
class Host {

	private static class StrLenCmp implements Comparator<String>, Serializable {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public int compare(String s1, String s2) {
			return s1.length() - s2.length();
		}
	}

	//Returned comparator is serializable
	public static final Comparator<String> STRING_LENGTH_COMPARATOR = new StrLenCmp();

	// Bulk of class omitted
}

