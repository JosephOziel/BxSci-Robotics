public class Point {
	public final double x;
	public final double y;

	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public Point translateX(double t) {
		return new Point(x + t, y);
	}
	
	public Point translateY(double t) {
		return new Point(x, y + t);
	}

	@Override
	public String toString() {
		return "(" + x + ", " + y + ")";
	}

    public static double distance(Point p1, Point p2) {
		return Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2));
	}

    public static Point centerOfMass(Point[] points) {
        double xSum = 0;
        double ySum = 0;
        for (int i = 0; i < points.length; i++) {
            xSum += points[i].x;
            ySum += points[i].y;
        }

        return new Point(xSum / points.length, ySum / points.length);
    }

    public double angle() {
        double angleInRadians = Math.atan2(y, x); // Calculate angle in radians
        return Math.toDegrees(angleInRadians);   // Convert to degrees
    }

    public Point rotate(double theta) {
        double cosTheta = Math.cos(theta);
        double sinTheta = Math.sin(theta);
        double newX = x * cosTheta - y * sinTheta;
        double newY = x * sinTheta + y * cosTheta;
        return new Point(newX, newY);
    }
}
