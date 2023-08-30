public class Rectangle extends Polygon{
    private double length;
    private double width;

    public double getPerimeter() {
        return (2 * length) + (2 * width);
    }

    public double getArea() {
        return this.length * this.width;
    }

    public Rectangle (String name, double length, double width){
        super(name);
        this.length = length;
        this.width = width;
    }

}
