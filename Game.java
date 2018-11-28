import java.util.*;
public class Game
{
   Deck newDeck = new Deck();
   Player newPlayer = new Player();
   Player dealer = new Player();
   public void setUpGame(){
        newPlayer.addCard(newDeck.draw());
        newPlayer.addCard(newDeck.draw());
        dealer.addCard(newDeck.draw());
        dealer.addCard(newDeck.draw());
   }
   public boolean hasBlkJk(Player p){
       if (p.calcHand()==21){
           System.out.print ("You Win!");
       }
       return true;
   }
   public void playTurn(){
       
   }
   public void main (String[] args){
   
   }
}
