//I believe the outcome will be about 60% girls and 40% boys
import java.util.ArrayList;
public class Main {
    public static void main(String[] args){

        //ArrayList of families
        ArrayList<Family> fams = new ArrayList<Family>();
        //add 1 million families
        while(fams.size() <= 999999){
            fams.add(new Family());
        }
        //have children
        int i = 0;
        while(i <= 999999){
            fams.get(i).haveChilderen();
            i++;
        }
        //Calculate how many boys and girls there are
        int total_girls = 0;
        int total_boys = 0;
        int j = 0;
        while(j <= 999999){
            total_girls += fams.get(j).getNumgirls();
            total_boys += fams.get(j).getNumboys();
            j++;
        }

        //Switch the integer values to doubles so they aren't taken in a floating point context to maintain accuracy
        double boynum = total_boys;
        double girlnum = total_girls;

        //Calculate percentages
        double total = boynum + girlnum;
        double girl_percent = (girlnum * 100) / total;
        double boy_percent = (boynum * 100) / total;

        //Outuput
        System.out.println("The total number of boys is: " + total_boys);
        System.out.println("The total number of girls is: " + total_girls);
        System.out.printf("The percentage of girls is: %.2f", girl_percent);
        System.out.print("%");
        System.out.println("");
        System.out.printf("The percentage of boys is: %.2f", boy_percent);
        System.out.print("%");

    }
}

//The number of girls is just barely over 50%. I did believe it would be a bit higher.
