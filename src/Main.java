import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Player player = new Player();
        Deck deck = new Deck();
        Game game = new Game(player, deck);
        System.out.println("Type 0 to exit.");
        System.out.println("Starting balance : " + player.getChips());
        while (true) {
            System.out.print("Your Bet : ");
            int bet = scanner.nextInt();
            if (bet == 0)
                break;
            if (bet > player.getChips()) {
                System.out.println("Insufficient balance. " + player.balance());
                continue;
            }
            game.setBet(bet);
            player.setChips(player.getChips() - game.getBet());
            System.out.println(game);
            while (!player.isStand()) {
                if (game.getTotal(player) == 21) {
                    System.out.println("Wow! Blackjack!");
                    System.out.println("Congratulations! " + game.playerWin()*1.5 + " is won.");
                    player.addMoney((int) (bet*1.5));
                }
                System.out.print("Hit (h/H) or Stand(s/S)? --> ");
                String str = scanner.next();
                str = str.toUpperCase();
                if (str.equals("H")) {
                    game.deal(player);
                    System.out.println(game);
                    if (!game.isWin(player)) {
                        System.out.println("Sorry, bad luck.");
                        break;
                    }
                } else if (str.equals("S")) {
                    game.getPlayer().setStand(true);
                    while (game.getTotal(game.getDealer()) < 18) {
                        game.deal(game.getDealer());
                    }
                    System.out.println(game);
                    if (game.isWin(player)) {
                        System.out.println("Congratulations! " + game.playerWin() + " is won.");
                        player.addMoney(bet);
                    } else if (game.getTotal(player) == game.getTotal(game.getDealer())) {
                        game.draw();

                    } else {
                        System.out.println("Sorry, bad luck.");
                    }
                    player.showBalance();
                }
            }
            player.setStand(false);
            game.reset();
        }
    }
}
