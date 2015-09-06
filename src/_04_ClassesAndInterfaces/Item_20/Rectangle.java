package _04_ClassesAndInterfaces.Item_20;

public class Rectangle extends AbstractFigure{
	
	final double length;
	final double width;

	Rectangle(double length, double width) {
		this.length = length;
		this.width = width;
	}
	
	double area() { 
		return length * width; 
	}
}