
import java.util.*;

public class Deck
{
    ArrayList<Card> cards = new ArrayList<Card>();      
    public Deck(){
        for (int i=1; i<=4; i++){
            for (int j=1; j<=13; j++){
                cards.add(new Card(i,j));
            }
        }
    }

    public Card draw() {
        Card cardDrawn = cards.get(0);
        cards.remove(0);
        return cardDrawn;
    }

    public void shuffle(){
        Collections.shuffle(cards);
    }

}