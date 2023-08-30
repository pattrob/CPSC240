public abstract class Polygon extends Shape{
    private int numsides;

    public Polygon(String name){
        super(name);

    }

    public double getArea(){
        return 2;
    }


    public abstract double getPerimeter();

    public int getNumsides(){
        return numsides;
    }

}
