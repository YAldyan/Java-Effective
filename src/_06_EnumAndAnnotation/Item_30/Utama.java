package _06_EnumAndAnnotation.Item_30;

public class Utama {	

	public static void weightOfPlanet(){
		for (Planet p : Planet.values())
			System.out.printf("Weight on %s is %f%n", p, p.surfaceGravity());
	}
	
	public static void operation(){
		double x = Double.parseDouble("2");
		double y = Double.parseDouble("3");

		for (Operation op : Operation.values())
			System.out.printf("%f %s %f = %f%n", x, op, y, op.apply(x, y));

	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub		
		weightOfPlanet();	
		
		operation();
	}

}