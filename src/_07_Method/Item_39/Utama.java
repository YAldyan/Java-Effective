package _07_Method.Item_39;

import java.util.Date;

public class Utama {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		// Second attack on the internals of a Period instance
		Date start = new Date();
		Date end = new Date();
		Period p = new Period(start, end);
		p.end().setYear(78); // Modifies internals of p!

	}
	
	@SuppressWarnings("deprecation")
	public void firstAttack(){
		// Attack the internals of a Period instance
		Date start = new Date();
		Date end = new Date();
		
		@SuppressWarnings("unused")
		Period p = new Period(start, end);
		end.setYear(78); // Modifies internals of p!	
	}
	
	@SuppressWarnings("deprecation")
	public void secondAttack(){
		
		// Second attack on the internals of a Period instance
		Date start = new Date();
		Date end = new Date();
		Period p = new Period(start, end);
		p.end().setYear(78); // Modifies internals of p!
	}

}
