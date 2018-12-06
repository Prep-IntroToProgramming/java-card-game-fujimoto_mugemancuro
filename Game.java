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
        //System.out.println ("after newplayer cards");
        dealer.addCard(newDeck.draw());
        dealer.addCard(newDeck.draw());
    }

    //calculating the player's hand value to see if they have blackjack (21)
    public boolean hasBlkJk(Player p){
        if (p.calcHand()==21){
            System.out.print ("You got Blackjack!");
            return true;
        }
        return false;
    }

    //player's turn begins
    public int playTurn(){
        //showing the player their cards
        newPlayer.showHand("player");
        Scanner startPlay = new Scanner(System.in);
        //declaring & initializing storedVal variable. declaring playerValue variable
        int storedVal = 0;
        int playerValue;
        Card c;
        /*
         * if user input is not a 1 or a 2, program will tell the player it's invalid input 
         * & ask, again, if they'd like to hit 
         */
        while (storedVal != 2) {
            while (storedVal != 1 && storedVal != 2){
                System.out.println("Would you like to hit? If yes, press 1. If no, press 2.");
                if (!startPlay.hasNextInt()){
                    System.out.println("That is not a valid value. Try again.");
                }else{
                    storedVal=startPlay.nextInt();
                    if (storedVal != 1 && storedVal != 2) {
                        System.out.println ("That is not a valid value. Try again.");
                    }
                }

                startPlay.nextLine();
            }

            //if user inputs a 1, they will hit (gain another card). otherwise the player will stay

            if (storedVal == 1){
                c = newDeck.draw();
                newPlayer.addCard(c);
                playerValue = newPlayer.calcHand();
                newPlayer.showHand("player");
                storedVal = 0;
            }else{
                playerValue = newPlayer.calcHand();
            }
            if (playerValue > 21) {
                System.out.println ("You busted.");
                return 0;
            }
        }
        return 1;
    }

    //dealer's turn after the player's turn is up
    public int playDealer(){
        //declaring dealerValue variable
        int dealerValue;
        Card c;
        //assigning dealerValue variable to the value of the dealer's hand
        dealerValue = dealer.calcHand();
        //if the dealer's hand value is less than or equal to 16, the dealer will hit once
        while (dealerValue <= 16){
            c = newDeck.draw();
            dealer.addCard(c);
            dealerValue = dealer.calcHand();
        }
        dealer.showHand("dealer");
        if (dealerValue > 21) {
            System.out.println ("Dealer busted. You win!");
            return 0;
        } else {
            return 1;
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
    public void main (String[]args){
        int playerHandOk = 1;
        int dealerHandOk = 1;
        //declaring & initializing newGame variable
        Game newGame = new Game();
        //setting up a new game
        newGame.setUpGame();
        //System.out.println ("after setupgame");
        playerHandOk = newGame.playTurn();
        if(newGame.hasBlkJk(newGame.newPlayer)){
            System.out.print("You Win!");
            return;
        }
        if (playerHandOk == 1) {
            dealerHandOk = newGame.playDealer();
            if(newGame.hasBlkJk(newGame.dealer)){
                System.out.print("You lose. The Dealer has won.");
                return;
            }
        }

        if (playerHandOk == 1 && dealerHandOk == 1) {
            newGame.compareHands();
        }

    }
}
