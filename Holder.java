public class Holder {
    Cards c = new Cards();

    public Holder() {
        c.shuffle();
    }

    public Card getCard() {
        checkTotal();
        return c.getCard();
    }

    private void checkTotal() {
    }

    public Boolean checkGame(int player, int dealer, Dealer d) {
        if (player < 22 && player > dealer && dealer > 16) {
            System.out.println("WIN");
        } else if (player < 22 && dealer < 16) {
            d.getCard();
        }
        return null; 
    }
    public void start() {
        for (int i = 0; i < 2; i++) {
            getCard();
        }
    }

    public int switchInteger(Card rank) {
        int cardValue = 0;
        String rankString = rank.toStringRank();
        System.out.println(rankString);
        switch(rankString) {
            case "ACE" : cardValue = 1;
            break;
            case "TWO" : cardValue = 2;
            break;
            case "THREE" : cardValue = 3;
            break;
            case "FOUR" : cardValue = 4;
            break;
            case "FIVE" : cardValue = 5;
            break;
            case "SIX" : cardValue = 6;
            break;
            case "SEVEN" : cardValue = 7;
            break;
            case "EIGHT" : cardValue = 8;
            break;
            case "NINE" : cardValue = 9;
            break;
            default: cardValue = 10;
        }
        return cardValue;
    }
}
