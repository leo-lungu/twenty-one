public class Card {
    public enum Suit { CLUBS, DIAMONDS, HEARTS, SPADES; }

    public enum Rank { TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, 
                       NINE, TEN, JACK, QUEEN, KING, ACE; }

    final Rank rank;
    final Suit suit;

    public Card (final Rank rank, final Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public String toString () {
        return rank + " of " + suit;
    }

    public String toStringRank () {
        return rank + "";
    }
}
