import java.util.ArrayList;

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

        System.out.println("-----------------Grid Class-----------------");
        Grid<Integer> grid = new Grid<Integer>(3, 0);
        grid.set(0,0,4); grid.set(1,1,2); grid.set(2,2,7);
        ArrayList<Integer> diag = grid.diagonal();
        System.out.println("Grid:\n" + grid);
        System.out.println("Diagonal: " + diag);
        System.out.println("Max SideLength: " + Grid.maxSideLength() + "\n");
        Grid<Integer> grid1 = new Grid<Integer>(7, 0);
        System.out.println("New Grid:\n" + grid1);
        System.out.println("Max SideLength: " + Grid.maxSideLength());

        System.out.println("-----------------Grid Class-----------------");
        Point point1 = new Point(0, 0);
        Point point2 = new Point(6, 0);
        Point point3 = new Point(3, 6);
        Circle c = Circle.fromPoints(point1, point2, point3);
        System.out.println("Circle: " + c);
        RightTriangle triangle1 = new RightTriangle(new Point(0, 0), 3, 4);
        RightTriangle triangle2 = new RightTriangle(new Point(1, 1), 6, 8);
        System.out.println("Triangle 1: " + triangle1);
        System.out.println("Triangle 2: " + triangle2);
        System.out.println("Are they similar? " + RightTriangle.similar(triangle1, triangle2));
    }
}
