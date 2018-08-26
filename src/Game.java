import java.util.LinkedList;
import java.util.Scanner;

public class Game {
    private static Game gameInstance = null;
    private Shoe shoe;
    private Dealer dealer;
    private LinkedList<Player> players;
    private Scanner in;

    public static Game getInstance() {
        if(gameInstance == null) {
            gameInstance = new Game();
        }
        return gameInstance;
    }

    private Game() {
        shoe = Shoe.getInstance();
        this.dealer = new Dealer();
        this.players = new LinkedList<>();
        in = new Scanner(System.in);
    }

    public void addPlayer(Player player) {
        this.players.add(player);
    }

    public void removePlayer(Player player) {
        this.players.remove(player);
    }

    private void preRound() {
        for(Player player : this.players) {
            player.takeCard(shoe.distributeCard());
            player.takeCard(shoe.distributeCard());
        }

        dealer.takeCard(shoe.distributeCard());
        dealer.takeCard(shoe.distributeCard());
    }

    private void periRound() {
        System.out.println(dealer);

        // Player Turn
        for(Player player : this.players) {
            System.out.println(player.getPlayerName());
            while(player.getPlayerStatus() == Status.SAFE){
                System.out.println("Hit or Stick? 0/1");
                int hitOrStick = in.nextInt();
                if(hitOrStick == 0) {
                    player.takeCard(shoe.distributeCard());
                    System.out.println(player.getHand());
                } else break;
            }
        }


    }

    private void postRound() {
        for(Player player : this.players) {
            shoe.collectCards(player.returnAllCards());
        }

        shoe.collectCards(dealer.returnAllCards());
    }

    public void playRound() {
        this.preRound();
        this.periRound();
        this.postRound();
    }

}
