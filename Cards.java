import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;


public class Cards {
    ArrayList<Integer> cardsAvailable = new ArrayList<Integer>();
    ArrayList<Integer> deckCards = new ArrayList<Integer>();     

    public Cards() {
        for (int i = 1; i <= 52; i++) {
            this.cardsAvailable.add(i);
        }
    }
    public void getCard() {
        Random r = new Random();
        Double cardGenerated = 1 + (52) * r.nextDouble();
        int newCard = (int) round(cardGenerated);
        //System.out.println(newCard);
        Boolean trueCard = false;
        while (trueCard == false) {  
            if (deckCards.size() == 52){
                break;
            } 
            else if (newCard == (this.cardsAvailable.get(newCard-1)) && deckCards.size() < 53) {
                deckCards.add(newCard);
                trueCard = true;
                //System.out.println(newCard);
                //System.out.println(this.cardsAvailable.get(newCard-1));
                cardsAvailable.set(newCard - 1, 0);
                //System.out.println("test: " + this.cardsAvailable);
                //System.out.println("randomised: " + deckCards);
                //System.out.println("size: " + deckCards.size());
            }
            cardGenerated = 1 + (52) * r.nextDouble();
            newCard = (int) round(cardGenerated);
        }
    }

    public  double round(double number) { //method to round the numbers
        DecimalFormat df = new DecimalFormat("###.00"); //they are rounded to 2 decimal places
        String newNumber = df.format(number);
        number = Double.parseDouble(newNumber);
        return number; 
    }
}
