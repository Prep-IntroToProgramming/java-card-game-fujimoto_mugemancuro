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
        newPlayer.showHand();
        Scanner startPlay = new Scanner(System.in);
        int storedVal = 0;
        int playerValue;
        while (storedVal != 1 && storedVal != 2){
            System.out.println("Would you like to hit? If yes, press 1. If no, press 2.");
            if (!startPlay.hasNextInt()){
                System.out.println("That is not a valid value. Try again.");
            }else{
                storedVal=startPlay.nextInt();
            }
            startPlay.nextLine();
       }
       if (storedVal == 1){
            newDeck.draw();
            playerValue = newPlayer.calcHand();
       }else{
            playerValue = newPlayer.calcHand();
       }
    }

    public void playDealer(){
        int dealerValue;
        dealerValue = dealer.calcHand();
        if (dealerValue < 16){
            newDeck.draw();
            dealerValue = dealer.calcHand();
        }
    }
    
    public void compareHands(){
        //if (){
        //}
        
    }

    public void main (String[] args){
        Game newGame = new Game();
        newGame.setUpGame();
        if(newGame.hasBlkJk(newGame.newPlayer)){
            System.out.print("You Win!");
            return;
        }
        //We need to add similar functionality for dealerHand.
        if(newGame.hasBlkJk(newGame.dealer)){
            System.out.print("You lose. The Dealer has won.");
            return;
        }
    }
}
