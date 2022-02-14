public class Game {
    private final Player player;
    private final Player dealer = new Player();
    private final Deck deck;
    private int bet;

    public Game(Player player, Deck deck) {
        this.player = player;
        this.deck = deck;
        firstDeal();
    }

    private void firstDeal() {
        for (int i = 0; i < 2; i++) {
            deal(player);
            dealer.addCard(deck.getDeck().pop());
        }
    }

    public void deal(Player player) {
        player.addCard(deck.getDeck().pop());
    }

    public Player getPlayer() {
        return player;
    }

    public int getTotal(Player player) {
        int t = 0;
        int a = 0;
        boolean ace = false;
        for (Card c : player.getCards()) {
            t += c.getValue();
            if (c.getValue() == 11) {
                ace = true;
                a++;
            }
        }

        if (total() > 21 && ace) {
            t -= 10 * a;
        }

        return t;
    }

    public Player getDealer() {
        return dealer;
    }

    private int total() {
        int t = 0;
        for (Card c : player.getCards())
            t += c.getValue();
        return t;
    }

    public int playerWin() {
        if (isWin(player)) {
            player.setChips(player.getChips() + bet);
        }
        return bet;
    }

    public boolean isWin(Player player) {
        if (getTotal(player)>21)
            return false;
        else if (getTotal(dealer)>21 && getTotal(player)<=21)
            return true;
        else return getTotal(dealer) < getTotal(player) && getTotal(player) <= 21;
    }

    public void reset() {
        player.getCards().clear();
        dealer.getCards().clear();
        firstDeal();
    }

    public int getBet() {
        return bet;
    }

    public void draw() {
        player.setChips(player.getChips()+bet);
        System.out.println("Push!");
    }
    public void setBet(int bet) {
        this.bet = bet;
    }

    @Override
    public String toString() {
        if (!player.isStand())
            return  "==============================\nYour hand\n" + player.getCards().toString() + " -> " + getTotal(player) + "\n==============================\nDealer's Hand\n[" + dealer.getCards().get(0) + ", " + " Closed Card" + "] -> " + (getTotal(dealer) - dealer.getCards().get(1).getValue()) + "\n==============================\n";
        else
            return "==============================\nYour hand\n" + player.getCards().toString() + " -> " + getTotal(player) + "\n==============================\nDealer's Hand\n" + dealer.getCards().toString() + " -> " + getTotal(dealer) + "\n==============================\n";
    }
}
