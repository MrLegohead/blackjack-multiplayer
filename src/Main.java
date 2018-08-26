public class Main {


    public static void main(String[] args) {

        Game game = Game.getInstance();
        Player player1 = new Player("Neil");
        game.addPlayer(player1);
        game.playRound();
    }
}
