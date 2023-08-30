import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.Scanner;

public class Card{
    //Instance variables
    private String question;
    private String answer;
    private int daysBetween;
    private LocalDate dueDate;
    private boolean newCard;

//Card constructor
    public Card(String Question, String Answer){
        this.question = Question;
        this.answer = Answer;
        this.daysBetween = 0;
        this.dueDate = LocalDate.now();
        this.newCard = true;
    }

//Card constructor with scanner param - use to read in cards from .deck file
    public Card(Scanner input){
        this.question = input.nextLine();
        this.answer = input.nextLine();
        this.daysBetween = Integer.parseInt(input.nextLine());
        this.dueDate = LocalDate.parse(input.nextLine());
        this.newCard = Boolean.parseBoolean(input.nextLine());


    }
//dueDate getter
    public LocalDate getDueDate(){
        return dueDate;
    }

//return true if card is due
    public boolean isDue(){
        return this.dueDate.isBefore(LocalDate.now());
    }

//return true if card is new
    public boolean isNew(){
        return this.newCard;
    }

//Change how many days until due again based on user input
    private int updateDays(String letter){
        double num = 0.0;
        if(letter.equals("W")){
            num = 0.0;
        } else if(letter.equals("E")){
            num = 1.5;
        } else if(letter.equals("C")){
            num = 1.25;
        } else if(letter.equals("D")){
            num = 1.1;
        }
        return (int)Math.round((this.daysBetween + 1) * num);
    }

//Ask the user a question on a card - used in study
    public void ask(){
        Scanner input = new Scanner(System.in);
        System.out.println(this.question);
        System.out.print("Press enter when you know the answer");
        input.nextLine();
        System.out.println(this.answer);
        System.out.println("Please enter (E)asy, (C)orrect, (D)ifficult or (W)rong.");
        String diff = input.nextLine();
        this.daysBetween = this.updateDays(diff);
        this.dueDate = LocalDate.now().plusDays(this.daysBetween);
        this.newCard = false;
        System.out.println("This card is due again in " + this.daysBetween + " days");
        System.out.println("");

    }

//Output the updated card to the .deck file
    public void save(PrintWriter write){
        write.println(this.question);
        write.println(this.answer);
        write.println(this.daysBetween);
        write.println(this.dueDate);
        write.println(this.newCard);
        write.println();
    }

//Used to write a new card to a .deck file
    public void addCard(Card card) throws FileNotFoundException {
        PrintWriter write = new PrintWriter("decks/" + Deck.file);
        card.save(write);
        write.close();
    }
}
