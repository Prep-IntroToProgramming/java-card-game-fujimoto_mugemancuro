
import java.util.*;

public class Deck
{
    //creating a new deck of cards by creating an ArrayList named cards
    ArrayList<Card> cards = new ArrayList<Card>();      
    public Deck(){
        //assigning a suit to each card
        for (int i=1; i<=4; i++){
            //assinging a rank to each card and adding the new cards into the ArrayList or deck
            for (int j=1; j<=13; j++){
                cards.add(new Card(i,j));
            }
        }
    }
    //removing/drawing a card from the top of the deck
    public Card draw() {
        Card cardDrawn = cards.get(0);
        cards.remove(0);
        return cardDrawn;
    }
    //shuffle card method 
    public void shuffle(){
        //accessing java utility shuffle function
        Collections.shuffle(cards);
    }

}