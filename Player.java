import java.util.ArrayList;

public class Player extends Holder {

    ArrayList<Integer> playerCards = new ArrayList<Integer>();  
    
    public Player() {
        playerCards.add(getCard());
        getCard();
    }
}
