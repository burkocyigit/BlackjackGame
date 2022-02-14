import java.util.Collections;
import java.util.Stack;

public class Deck {
    private final Stack<Card> deck;

    public Deck() {
        deck = new Stack<>();
        for(int i=1; i<13; i++) {
            Card c = new Card(i,"Heart");
            deck.push(c);
        }
        for(int i=1; i<=13; i++) {
            Card c = new Card(i,"Diamonds");
            deck.push(c);
        }
        for(int i=1; i<=13; i++) {
            Card c = new Card(i,"Spades");
            deck.push(c);
        }
        for(int i=1; i<=13; i++) {
            Card c = new Card(i,"Club");
            deck.push(c);
        }
        Collections.shuffle(deck);
    }

    public Stack<Card> getDeck() {
        return deck;
    }
}
