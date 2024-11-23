public class RightTriangle implements Shape {
    private final Point corner; 
    private final double base;
    private final double height; 

    public RightTriangle(Point corner, double base, double height) {
        this.corner = corner;
        this.base = base;
        this.height = height;
    }

    public double area() {
        return 0.5 * base * height;
    }

    public double perimeter() {
        double hypotenuse = Math.sqrt(base * base + height * height);
        return base + height + hypotenuse;
    }

    public boolean isInside(Point p) {
        double relativeX = p.x - corner.x;
        double relativeY = p.y - corner.y;
        return relativeX >= 0 && relativeX <= base &&
               relativeY >= 0 && relativeY <= height &&
               relativeY <= (-height / base) * relativeX + height;
    }

    public boolean isOn(Point p) {
        double relativeX = p.x - corner.x;
        double relativeY = p.y - corner.y;
        return (relativeX == 0 && relativeY >= 0 && relativeY <= height) || // Vertical side
               (relativeY == 0 && relativeX >= 0 && relativeX <= base) ||   // Horizontal side
               (Math.abs(relativeY - (-height / base) * relativeX + height) < 1e-9); // Hypotenuse
    }

    public Shape translate(double x, double y) {
        return new RightTriangle(corner.translateX(x).translateY(y), base, height);
    }

    public Shape scale(double k) {
        return new RightTriangle(corner, base * k, height * k);
    }

    public String toString() {
        return "RightTriangle(corner: " + corner + ", base: " + base + ", height: " + height + ")";
    }

    public static boolean similar(RightTriangle t1, RightTriangle t2) {
        double ratio1 = t1.base / t2.base;
        double ratio2 = t1.height / t2.height;

        return Math.abs(ratio1 - ratio2) < 1e-9;
    }
}

