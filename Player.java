import java.util.*;
public class Player
{
    private String name;
    ArrayList<Card>playerCards = new ArrayList<Card>();
    public void showHand(){
        for (Card testCard:playerCards){
            System.out.print (" "+testCard.rankToString() +" "+"of"+" "+testCard.suitToString());
        }
    }

    public void addCard(Card c){
        playerCards.add(c);
    }

    public int calcHand(){
        int handVal = 0;
        boolean acePresent = false;
        for (Card card:playerCards){
            if (card.rank == 1){
                acePresent = true;
                handVal = handVal + 1;
            }else if (card.rank>=10){
                    handVal = handVal + 10;
            }else{
                    handVal = handVal + card.rank;
            }
        }
        if (acePresent==true && handVal<=11){
                handVal = handVal + 10;
        }
        return handVal;
    }
}

