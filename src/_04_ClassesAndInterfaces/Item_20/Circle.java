package _04_ClassesAndInterfaces.Item_20;

public class Circle extends AbstractFigure {
	
	final double radius;
	
	Circle(double radius) { 
		
		this.radius = radius; 
	}
	
	double area() { 
		return Math.PI * (radius * radius);
	}
}
