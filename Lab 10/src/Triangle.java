public class Triangle extends Polygon{
    private double base;
    private double height;
    private double sideA;
    private double sideB;

    public double getPerimeter() {
        return base + sideA + sideB;
    }

    public double getArea() {
        return (.5) * this.base * this.height;
    }

    public Triangle(String name, double base, double height, double sideA, double sideB){
        super(name);
        this.base = base;
        this.height = height;
        this.sideA = sideA;
        this.sideB = sideB;

    }
}
