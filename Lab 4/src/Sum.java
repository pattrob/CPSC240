import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Sum {
    public static void main(String[] args) throws Exception  {
        // open the file
        Scanner in;
        int sum = 0;
        try (FileReader reader = new FileReader("data.txt")) {


            // make a scanner from it
            in = new Scanner(reader);
            while (in.hasNext()) {
                if(in.hasNextInt()){
                    sum += in.nextInt();
                } else {
                    in.next();
                }
            }


        } catch (FileNotFoundException e) {
            System.err.println("FileNotFoundException: Please input a valid file.");
            System.exit(-1);
        } catch (InputMismatchException e) {
            System.err.println("InputMismatchException: Please only read in one type");
            System.exit(-1);
        }
        System.out.println("Sum is " + sum + ".");
    }
}