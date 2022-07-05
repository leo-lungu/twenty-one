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

    public Boolean playerEnd(int player, int dealer, Dealer d) {
        Boolean playerLoss = false;
        if (player < 22) {
            playerLoss = false;
        } else if (player > 21) {
            playerLoss = true;
        } 
        return playerLoss;
    }

    public Boolean dealerAbove16(int player, int dealer, Dealer d){ 
        Boolean dealerAbove16 = true;
        if (dealer < 16) {
            dealerAbove16 = false;
        }
        return dealerAbove16;
    }
    public Boolean dealerEnd(int player, int dealer, Dealer d) {
        Boolean dealerLoss = false;
        if (dealer > 22) {
            dealerLoss = true;
        }
        return dealerLoss;
    }
    
    public Boolean checkGame(int player, int dealer, Dealer d) {
        Boolean playerLoss = playerEnd(player, dealer, d);
        Boolean dealerLoss = dealerEnd(player, dealer, d);
        return true;
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
