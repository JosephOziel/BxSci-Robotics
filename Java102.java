public class Java102 {
    public static void main(String[] args) {
        System.out.println("-----------------Point Class-----------------");
        Point point = new Point(4, 3);
        System.out.println("x: " + point.x + "y: " + point.y);
        Point xTranslation = point.translateX(3);
        Point yTranslation = point.translateY(-7);
        Point xyTranslation = point.translateX(-4).translateY(-3);
        System.out.println("x transl: " + xTranslation);
        System.out.println("y transl: " + yTranslation);
        System.out.println("xy transl: " + xyTranslation);
        System.out.println("Distance: " + Point.distance(xTranslation, yTranslation));
        Point[] points = {point, xTranslation, yTranslation, xyTranslation};
        Point center = Point.centerOfMass(points);
        System.out.println("Center of Mass: " + center);
        Point p = new Point(3.0, 4.0);
        System.out.println("Point: " + p);
        System.out.println("Angle: " + p.angle() + " degrees");
        Point p1 = new Point(1, 0);
        double theta = Math.toRadians(90);
        Point rotatedPoint = p1.rotate(theta);
        System.out.println("Original point: " + p1);
        System.out.println("Rotated point: " + rotatedPoint);
    }
}
