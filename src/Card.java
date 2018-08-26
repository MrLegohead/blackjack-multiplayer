public class Card {
    private Value value;
    private Suit suit;
    private Boolean faceDown = false;


    public Card(Value value, Suit suit) {
        this.value = value;
        this.suit = suit;
    }

    public Card(Value value, Suit suit, Boolean faceDown) {
        this.value = value;
        this.suit = suit;
        this.faceDown = faceDown;
    }

    public void toggleFaceDown() { this.faceDown = !this.faceDown; }
    public boolean isFaceDown() { return this.faceDown; }
    public int getValue() { return value.getIntValue(); }

    @Override
    public String toString() {
        return "Card{" +
                "value=" + value +
                ", suit=" + suit +
                ", faceDown=" + faceDown +
                '}';
    }
}
