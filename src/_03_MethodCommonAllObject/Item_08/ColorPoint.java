package _03_MethodCommonAllObject.Item_08;

import java.awt.Color;

public class ColorPoint extends Point {

	private final Point point;
	private final Color color;

	public ColorPoint(int x, int y, Color color) {
		super(x,y) ;
		
		if (color == null)
			throw new NullPointerException();
		
		point = new Point(x, y);
		this.color = color;
	}
	
	/**
	* Returns the point-view of this color point.
	*/
	public Point asPoint() {
		return point;
	}
	
	// Broken - violates symmetry!
	// equals jika posisi dan warna
	// sama atau identik.
	@Override 
	public boolean equals(Object o) {
		//if (!(o instanceof Point))
		//	return false;
		
		// If o is a normal Point, do a color-blind comparison
		// untuk testing method testTransitiveSubclass() di Utama.
		//if (!(o instanceof ColorPoint))
		//	return o.equals(this);
		
		if (!(o instanceof ColorPoint))
			return false;
	
		ColorPoint cp = (ColorPoint) o;
		return cp.point.equals(point) && cp.color.equals(color);
		//return super.equals(o) && ((ColorPoint) o).color == color;
	}
	// Remainder omitted
}
