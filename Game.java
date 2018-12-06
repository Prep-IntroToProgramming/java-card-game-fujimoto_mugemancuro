import java.util.*;
public class Game
{
    //declaring and initializing newDeck, newPlayer, & dealer instance variables
    Deck newDeck = new Deck();
    Player newPlayer = new Player();
    Player dealer = new Player();

    //game starts by shuffling the deck then dealing 2 cards each to the player & dealer
    public void setUpGame(){
        newDeck.shuffle();
        newPlayer.addCard(newDeck.draw());
        newPlayer.addCard(newDeck.draw());
        dealer.addCard(newDeck.draw());
        dealer.addCard(newDeck.draw());
    }

    //calculating the player's hand value to see if they have blackjack (21)
    public boolean hasBlkJk(Player p){
        if (p.calcHand()==21){
            System.out.print ("You Win!");
        }
        return true;
    }

    //player's turn begins
    public void playTurn(){
        //showing the player their cards
        newPlayer.showHand();
        Scanner startPlay = new Scanner(System.in);
        //declaring & initializing storedVal variable. declaring playerValue variable
        int storedVal = 0;
        int playerValue;

        /*
         * if user input is not a 1 or a 2, program will tell the player it's invalid input 
         * & ask, again, if they'd like to hit 
        */
        while (storedVal != 1 && storedVal != 2){
            System.out.println("Would you like to hit? If yes, press 1. If no, press 2.");
            if (!startPlay.hasNextInt()){
                System.out.println("That is not a valid value. Try again.");
            }else{
                storedVal=startPlay.nextInt();
            }
            startPlay.nextLine();
        }
        //if user inputs a 1, they will hit (gain another card). otherwise the player will stay
        if (storedVal == 1){
            newDeck.draw();
            playerValue = newPlayer.calcHand();
            //newPlayer.showHand();
        }else{
            playerValue = newPlayer.calcHand();
        }
    }
    
    //dealer's turn after the player's turn is up
    public void playDealer(){
        //declaring dealerValue variable
        int dealerValue;
        //assigning dealerValue variable to the value of the dealer's hand
        dealerValue = dealer.calcHand();
        //if the dealer's hand value is less than or equal to 16, the dealer will hit once
        if (dealerValue <= 16){
            newDeck.draw();
            dealerValue = dealer.calcHand();
        }
    }

    //comparing the hand values of the dealer & player; whoever is higher will win
    public void compareHands(){
        int dealerValue;
        int playerValue;
        dealerValue = dealer.calcHand();
        playerValue = newPlayer.calcHand();
        if (dealerValue > playerValue){
            System.out.println("The dealer won!");
        } else if (playerValue > dealerValue){
            System.out.println("You won!");        
        }
    }
    
    //setting up a new game
    public void main (String[] args){
        //declaring & initializing newGame variable
        Game newGame = new Game();
        //setting up a new game
        newGame.setUpGame();
        //
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
