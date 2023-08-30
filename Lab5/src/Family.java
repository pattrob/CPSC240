import java.util.Random;
public class Family {
    //Random number generator and instance variables
    static Random rand = new Random(1);
    private int numgirls;
    private int numboys;

    //Constructors for family object
    public Family(int numgirls, int numboys){
        this.numgirls = numgirls;
        this.numboys = numboys;
    }

    public Family(){
        this.numgirls = 0;
        this.numboys = 0;
    }

    //Random number storage
    double decider = 0;

    //haveChilderen
    public void haveChilderen() {
        while (numgirls == 0) {
            decider = rand.nextDouble();
            if (decider >= 0.5) {
                numboys += 1;
            } else {
                numgirls += 1;
            }
        }
    }

    //Getter methods
    public int getNumgirls() {
        return numgirls;
    }

    public int getNumboys(){
        return numboys;
    }

}
