import java.util.*;
public class Player
{
    int handVal;
    private String name;
    ArrayList<Card>playerCards = new ArrayList<Card>();
    public void showHand(){
        System.out.print (playerCards);
    }

    public void addCard(Card c){
        playerCards.add(c);
    }

    public int calcHand(){
        
    }
}


