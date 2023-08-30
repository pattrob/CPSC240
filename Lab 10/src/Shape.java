public abstract class Shape {
    private String name;

    public abstract double getArea();

    public void display(){
        System.out.println(name + " " + "(" + getArea() + ")");

    }

    public Shape(String name){
        this.name = name;
    }





}
