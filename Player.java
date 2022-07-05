import java.util.ArrayList;
import java.util.List;

public class Player extends Holder {

    ArrayList<Card> playerCards = new ArrayList<Card>( ); 
    int total = 0;
    
    public Player() {
        playerCards.add(getCard());
        playerCards.add(getCard());
        System.out.println(getCardArray());
    }

    public List<Card> getCardArray(){
        return playerCards;
    }

    public void setCardArray(Card index){
        playerCards.add(index);
    }

    public String totalScore() {
        this.total = 0;
        for (int i = 0; i < playerCards.size(); i++) {
            this.total = this.total + switchInteger(playerCards.get(i));
        }
        return String.valueOf(this.total);
    }

    public void resetTotal() {
        this.total = 0;
    }

    public int checkTotal() {
        return this.total;
    }
}
