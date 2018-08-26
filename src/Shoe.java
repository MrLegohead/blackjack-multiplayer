import java.util.*;

public class Shoe {

    private static Shoe shoeInstance = null;
    private static Queue<Card> deck;

    private Shoe() {
        generateDeck();
        shuffle();
    }

    public synchronized static Shoe getInstance() {
        if(shoeInstance == null) {
            shoeInstance = new Shoe();
        }
        return shoeInstance;
    }

    private void generateDeck() {
        deck = new LinkedList<>();
        for(Value value : Value.values()) {
            for(Suit suit : Suit.values()) {
                deck.add(new Card(value, suit));
            }
        }
    }

    public int getCardCount() { return deck.size(); }

    public Card distributeCard() { return deck.remove(); }

    private void collectCard(Card card) { deck.offer(card); }

    public void collectCards(LinkedList<Card> cards) {
        for(Card card : cards ) {
            this.collectCard(card);
        }
    }


    @Override
    public String toString() { return deck.toString(); }

    public void shuffle() { Collections.shuffle((List<?>) deck); }

}
