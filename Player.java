import java.util.*;
public class Player
{
    //declaring a name variable for the player
    private String name;
    //creating the player's cards using an ArrayList called playerCards
    ArrayList<Card>playerCards = new ArrayList<Card>();
    //showing the player the rank and suit of their hand
    public void showHand(){
        for (Card testCard:playerCards){
            System.out.print (" "+testCard.rankToString() +" "+"of"+" "+testCard.suitToString());
        }
    }
    //adding card c to the player's hand
    public void addCard(Card c){
        playerCards.add(c);
    }
    //method to calculate the value of the player's hand
    public int calcHand(){
        //declaring and initializing handVal variable which represents the value of the player's hand
        int handVal = 0;
        //declaring and initializing acePresent variable which checks if the player has an ace in their hand
        boolean acePresent = false;
        /* 
         * if player has an ace, ace takes on a value of 1. if rank of other card 
         * is >= 10, the ace takes on a value of 11...
         */
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
        /*
         * if player has an ace and their hand value is less than or equal to 11,
         * ace will assume a value of 11
         */ 
        if (acePresent==true && handVal<=11){
                handVal = handVal + 10;
        }
        return handVal;
    }
}

