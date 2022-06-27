import java.util.*;
public class Cards
{
    private List<Card> deck = new ArrayList<Card>();
         
    {
        for (Card.Suit suit : Card.Suit.values())
        {
            for (Card.Rank rank : Card.Rank.values())
            {
                deck.add(new Card(rank, suit));
            }
        }
    }

    public void shuffle()
    {
       Collections.shuffle(deck); 
    }
    
    public Card getCard() {
        //System.out.println(this.deckCards);
        return deck.remove(0);
    }

}