import java.util.LinkedList;

class Hand {
    private LinkedList<Card> hand;
    public Hand() { hand = new LinkedList<>(); }


    public void addCard(Card card) { hand.add(card); }

    public LinkedList<Card> returnAllCards() {
        LinkedList<Card> tempHand = new LinkedList<>(this.hand);
        this.hand.clear();
        return tempHand;
    }

    public int calculateHand() {
        int handResult = 0;
        for(Card card : hand) {
            handResult += card.getValue();
        }
        return handResult;
    }

    public boolean isBlackjack() { return this.calculateHand() == 21; }
    public boolean isBust() { return this.calculateHand() > 21; }

    @Override
    public String toString() {
        return hand.toString();
    }
}
