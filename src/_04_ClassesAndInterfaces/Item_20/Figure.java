package _04_ClassesAndInterfaces.Item_20;

/*
 * perhatikan saja kelas di-bawah ini
 * begitu banyak konstruktor untuk menciptakan
 * berbagai objek yang menjadi bagian dari figure
 * ini adalah cara yang buruk untuk membuat sebuah
 * kelas, lebih baik menciptakan hirarki kelas yang
 * jelas yang menjadikan figure seperti induk dari
 * semua kelas yang sejenis dengan dia.
 */
//Tagged class - vastly inferior to a class hierarchy!
class Figure {

	enum Shape { RECTANGLE, CIRCLE };

	//Tag field - the shape of this figure
	final Shape shape;

	//These fields are used only if shape is RECTANGLE
	double length;
	double width;

	//This field is used only if shape is CIRCLE
	double radius;

	//Constructor for circle
	Figure(double radius) {
		shape = Shape.CIRCLE;
		this.radius = radius;
	}

	//Constructor for rectangle
	Figure(double length, double width) {
		shape = Shape.RECTANGLE;
		this.length = length;
		this.width = width;
	}

	double area() {
		switch(shape) {
			case RECTANGLE:
					return length * width;
			case CIRCLE:
					return Math.PI * (radius * radius);
			default:
				throw new AssertionError();
		}
	}
}
