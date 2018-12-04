import java.util.*;
public class Game
{
   Deck newDeck = new Deck();
   Player newPlayer = new Player();
   Player dealer = new Player();
   public void setUpGame(){
        newDeck.shuffle();
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
       Scanner startPlay = new Scanner(System.in);
       int storedVal = startPlay.nextInt();
       System.out.print ("Would you like to hit? If yes, press 1. If no, press 2.");
       while (!startPlay.hasNextInt() && storedVal>1 && storedVal<2){
           System.out.print ("That is not a valid value. Try again.");
       }
       
   }
   public void main (String[] args){
       Game newGame = new Game();
       newGame.setUpGame();
       if(newGame.hasBlkJk(newGame.newPlayer)){
           System.out.print("You Win!");
           return;
       }
       //We need to add similar functionality for dealerHand.
   }
}
