import java.util.ArrayList;

public class Player {

    private int chips;
    private final ArrayList<Card> cards;
    private boolean stand;

    public Player() {
        cards = new ArrayList<>();
        chips = 500;
    }

    public int getChips() {
        return chips;
    }

    public String balance() {
        return "Your balance : " + chips;
    }

    public void showBalance() {
        System.out.println("Your Balance is " + chips);
    }

    public void addMoney(int amount) {
        chips += amount;
    }

    public boolean isStand() {
        return stand;
    }

    public void setStand(boolean stand) {
        this.stand = stand;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public void setChips(int chips) {
        this.chips = chips;
    }
}