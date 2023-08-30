

public class Main {
    public static void main(String[] args){

        Time t1 = new Time();
        Time t2 = new Time(17, 30, 0);

        t1.increment(3600);
        t1.print(true);
        t1.print(false);

        t2.increment(5430);
        t2.print(true);
        t2.print(false);

    }
}
