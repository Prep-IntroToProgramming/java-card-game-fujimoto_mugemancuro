 
import java.util.*;

/**
 * Write a description of class Deck here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Deck
{
    ArrayList<Card> cards = new ArrayList<Card>(); 
    public Deck(int suit, int rank){
        for (int i=1; i<=4; i++){
            for (int j=1; j<=13; j++){
                cards.add(new Card(i,j));
            }
        }
    }
}