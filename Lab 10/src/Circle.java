public class Circle extends Shape{
    private double radius;


    public Circle(String name, double radius){
        super(name);
        this.radius = radius;
    }

    public double getArea() {
        return (3.14) * (this.radius * this.radius);
    }

    public double getCircumference(){
        return (2) * (3.14) * (this.radius);
    }

}
