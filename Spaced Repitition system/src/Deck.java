import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Deck {

    //Import deck files from path
    public static void getDecks() {
        Path path = Paths.get("/Applications/Spaced Repitition system/Decks/");
        if (Files.exists(path)) {
            String[] decknames;
            File f = new File("/Applications/Spaced Repitition system/Decks/");
            decknames = f.list();
            for (String deckname : decknames) {
                System.out.println(deckname);
            }

        } else {
            new File("/Applications/Spaced Repitition system/src/Decks/");


        }
    }
//Static list and file used across the program
    public static ArrayList<Card> deck = new ArrayList<>();
    public static File file;

    //Choose the deck
    public static Deck chooseDeck() throws IOException {
        Scanner input = new Scanner(System.in);
        System.out.println("Choose deck: ");
        String deckchoice = input.nextLine();
        file = new File(deckchoice);
        Scanner IF = null;
        try {
            IF = new Scanner(new File("/Applications/Spaced Repitition system/Decks/" + file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (IF.hasNextLine()) {
            deck.add(new Card(IF));
            IF.nextLine();

        }
        return null;
    }

    //Study questions and update to the file
    public static void study() throws IOException {
        Collections.shuffle(deck);
        int num = 0;
        if(deck.size() <= 10){
            num = deck.size();
        } else {
            num = 10;
        }
        for(int i = 0; i < num; i ++){
            Card card = deck.get(i);
            if(card.isDue()){
                card.ask();
                save();
            } else if(card.isNew()){
                card.ask();
                save();
            }
        }
        System.out.println("You're all caught up!");
        System.exit(1);
    }

    //Outputs the updated card to the file
    public static void save() throws IOException {
        PrintWriter write = new PrintWriter("decks/" + file);
        for(int i = 0; i < deck.size(); i ++){
            deck.get(i).save(write);
        }
        write.close();
    }
}