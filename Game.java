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
        //System.out.println ("after newplayer cards"); debugging
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
        //declaring & initializing storedVal variable. declaring playerValue and Card c variable
        int storedVal = 0;
        int playerValue;
        Card c;
        /*
         * if player input is not a 1 or a 2, program will tell the player it's invalid input 
         * & ask again if they'd like to hit 
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

            //if player inputs a 1, they will hit (gain another card). otherwise the player will stay
            if (storedVal == 1){
                c = newDeck.draw();
                newPlayer.addCard(c);
                playerValue = newPlayer.calcHand();
                newPlayer.showHand("player");
                storedVal = 0;
            }else{
                playerValue = newPlayer.calcHand();
            }
            //if player's hand is greater than 21, program tells them they busted and ends the game
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
        //if the dealer's hand value is less than or equal to 16, the dealer will hit 
        while (dealerValue <= 16){
            c = newDeck.draw();
            dealer.addCard(c);
            dealerValue = dealer.calcHand();
        }
        //printing out the dealer's hand
        dealer.showHand("dealer");
        //if the dealer's hand value is greater than 21, program will say the dealer busted & player won & end game
        if (dealerValue > 21) {
            System.out.println ("Dealer busted. You win!");
            return 0;
        } else {
            //if the dealer does not bust, he will hit until his hand value is greater than 16
            return 1;
        }
    }

    //comparing the hand values of the dealer & player; whoever is higher will win
    public void compareHands(){
        //declaring dealerValue & playerValue variables
        int dealerValue;
        int playerValue;
        //assigning dealerValue to dealer hand value & playerValue to player hand value
        dealerValue = dealer.calcHand();
        playerValue = newPlayer.calcHand();
        /*
         * if the dealer's hand value is greater than the player's hand value, the dealer wins.
         * if the player's hand value is greater than the dealer's hand value, the player wins.
         */
        if (dealerValue > playerValue){
            System.out.println("The dealer won!");
        } else if (playerValue > dealerValue){
            System.out.println("You won!");        
        }
    }

    //setting up a new game
    public void main (String[]args){
        //declaring & initializing playerHandOk & dealerHandOk variables
        int playerHandOk = 1;
        int dealerHandOk = 1;
        //declaring & initializing newGame variable
        Game newGame = new Game();
        //setting up a new game
        newGame.setUpGame();
        //System.out.println ("after setupgame"); debugging
        //if the player's hand is still below 21, they can continue to hit if they would like
        playerHandOk = newGame.playTurn();
        //if player has blackjack, player wins & game ends
        if(newGame.hasBlkJk(newGame.newPlayer)){
            System.out.print("You Win!");
            return;
        }
        //if player has not busted & wants to stay, dealer's turn comes next
        if (playerHandOk == 1) {
            dealerHandOk = newGame.playDealer();
            //if dealer has blackjack, dealer wins
            if(newGame.hasBlkJk(newGame.dealer)){
                System.out.print("You lose. The Dealer has won.");
                return;
            }
        }
        //if player and dealer have not busted and decide to stay, compare the hand values of each to determine winner
        if (playerHandOk == 1 && dealerHandOk == 1) {
            newGame.compareHands();
        }
    }
}
