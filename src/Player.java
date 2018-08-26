import java.util.LinkedList;

public class Player {

    private Hand playerHand;
    private String name;
    private Status playerStatus;

    public Player(String name) {
        this.name = name;
        playerHand = new Hand();
        playerStatus = Status.SAFE;
    }

    public void takeCard(Card card) {
        playerHand.addCard(card);
        updateStatus();
    }

    public LinkedList<Card> returnAllCards() {
        return playerHand.returnAllCards();
    }

    private void updateStatus() {
        if(playerHand.isBlackjack()) playerStatus = Status.BLACKJACK;
        else if(playerHand.isBust()) playerStatus = Status.BUST;
        else playerStatus = Status.SAFE;
    }

    public Status getPlayerStatus() { return playerStatus; }
    public String getPlayerName() { return this.name; }
    public int getHand() { return playerHand.calculateHand(); }


    @Override
    public String toString() {
        return "Player{" +
                "playerStatus = " + playerStatus +
                ", name ='" + name + '\'' +
                ", playerHand = " + playerHand +
                '}';
    }
}
