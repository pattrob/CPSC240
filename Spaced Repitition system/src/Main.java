import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
//Main study method - choses the deck and studies it
    public static void study() throws IOException {
        Deck.getDecks();
        Deck.chooseDeck();
        Deck.study();
    }
//Add cards to a deck
    public static void addCards() throws IOException {
        Deck.getDecks();
        Deck.chooseDeck();
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a question: ");
        String Q = input.nextLine();
        System.out.println("Enter an answer: ");
        String A = input.nextLine();
        Card card = new Card(Q, A);
        Deck.deck.add(card);
        card.addCard(card);
    }
//Create a deck
    public static void createDeck(){
        Scanner input = new Scanner(System.in);
        System.out.println("What would you like to name your deck? ");
        String name = input.nextLine();
        Deck deck = new Deck();
        try {
            PrintWriter pw = new PrintWriter("decks/" + name + ".deck");
            pw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }



//Main - presents a menu and runs until the user exits
    public static void main(String[] args) throws IOException {

        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to the spaced repetition system!");
        System.out.println("Please choose an option: ");
        System.out.println("1. Study a deck");
        System.out.println("2. Add cards to a deck");
        System.out.println("3. Create a new deck");
        System.out.println("4. Exit");

        int choice = input.nextInt();

        while(choice != 4){
            if(choice == 1){
                study();
            } else if(choice == 2){
                addCards();
            } else if(choice == 3){
                createDeck();
            } System.out.println("Welcome to the spaced repetition system!");
            System.out.println("Please choose an option: ");
            System.out.println("1. Study a deck");
            System.out.println("2. Add cards to a deck");
            System.out.println("3. Create a new deck");
            System.out.println("4. Exit");
            choice = input.nextInt();
        }
    }

}
