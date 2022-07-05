import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;

public class Dealer extends Holder{
    
    ArrayList<Card> dealerCards = new ArrayList<Card>( ); 
    int total = 0;
    
    public Dealer() {
        dealerCards.add(getCard());
        dealerCards.add(getCard());
        System.out.println(getCardArray());
    }

    public List<Card> getCardArray(){
        return dealerCards;
    }

    public String totalScore() {
        this.total = 0;
        for (int i = 0; i < dealerCards.size(); i++) {
            this.total = this.total + switchInteger(dealerCards.get(i));
        }
        return String.valueOf(this.total);
    }

    public int checkTotal() {
        return this.total;
    }

    public void resetTotal() {
        this.total = 0;
    }

    public void add(JLabel l) {
    }
}