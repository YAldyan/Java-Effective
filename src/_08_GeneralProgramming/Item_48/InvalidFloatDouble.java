package _08_GeneralProgramming.Item_48;

public class InvalidFloatDouble {

	// Broken - uses floating point for monetary calculation!
	public static void main(String[] args) {
		double funds = 1.00;
		int itemsBought = 0;
	
		for (double price = .10; funds >= price; price += .10) {
			funds -= price;
			itemsBought++;
		}
	
		System.out.println(itemsBought + " items bought.");
		System.out.println("Change: $" + funds);
	}
	
//  revision with integer as type of value
	
//	public static void main(String[] args) {
//		int itemsBought = 0;
//		int funds = 100;
//		
//		for (int price = 10; funds >= price; price += 10) {
//			itemsBought++;
//			funds -= price;
//		}
//		
//		System.out.println(itemsBought + " items bought.");
//		System.out.println("Money left over: "+ funds + " cents");
//	}
}
