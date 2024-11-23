public class Circle implements Shape {
	public final Point center;
	public final double radius;

	public Circle(Point center, double radius) {
		this.center = center;
		this.radius = radius;
	}

	public double area() {
		return Math.PI * Math.pow(radius, 2);
	}

	public double perimeter() {
		return 2 * Math.PI * radius;
	}

	/** 
	* @return Whether point p is inside of the circle.
	*/
	public boolean isInside(Point p) {
		return Point.distance(center, p) < radius;
	}

	/** 
	* @return Whether point p part of/on the border of the circle.
	*/
	public boolean isOn(Point p) {
		return Point.distance(center, p) == radius;
	}

	/** 
	* @param x How much to translate the circle by in the + x direction.
	* @param y How much to translate the circle by in the + y direction.
	* @return The circle that results from the translation.
	*/
	public Circle translate(double x, double y) {
		return new Circle(center.translateX(x).translateY(y), radius);
	}

	/** 
	* @return The circle that results from scaling by k.
	*/
	public Circle scale(double k) {
		return new Circle(center, radius * k);
	}

	@Override
	public String toString() {
		return "(center: " + center + "; radius: " + radius + ")";
	}

    public static Circle fromPoints(Point p1, Point p2, Point p3) {
        double midX1 = (p1.x + p2.x) / 2;
        double midY1 = (p1.y + p2.y) / 2;
        double midX2 = (p2.x + p3.x) / 2;
        double midY2 = (p2.y + p3.y) / 2;
    
        double slope1 = (p2.y - p1.y) / (p2.x - p1.x);
        double slope2 = (p3.y - p2.y) / (p3.x - p2.x);

        double perpSlope1 = -1 / slope1;
        double perpSlope2 = -1 / slope2;
    
        double centerX, centerY;
        if (Double.isInfinite(perpSlope1)) {
            centerX = midX1;
            centerY = perpSlope2 * (centerX - midX2) + midY2;
        } else if (Double.isInfinite(perpSlope2)) {
            centerX = midX2;
            centerY = perpSlope1 * (centerX - midX1) + midY1;
        } else {
            centerX = (perpSlope1 * midX1 - perpSlope2 * midX2 + midY2 - midY1) / (perpSlope1 - perpSlope2);
            centerY = perpSlope1 * (centerX - midX1) + midY1;
        }
        double radius = Point.distance(new Point(centerX, centerY), p1);
        return new Circle(new Point(centerX, centerY), radius);
    }    
}