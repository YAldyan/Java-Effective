package _08_GeneralProgramming.Item_51;

public class String_Concat {
	
	private int LINE_WIDTH = 0;

	// Inappropriate use of string concatenation - Performs horribly!
	public String statement() {
		String result = "";
	
		for (int i = 0; i < numItems(); i++)
			result += lineForItem(i); // String concatenation
	
		return result;
	}

	
	public String statement_correct() {
	
		StringBuilder b = new StringBuilder(numItems() * LINE_WIDTH);
		
		for (int i = 0; i < numItems(); i++)
			b.append(lineForItem(i));
		
		return b.toString();
	}

	public int numItems(){return 0;};
	
	public String lineForItem(int i){return null;};
}
