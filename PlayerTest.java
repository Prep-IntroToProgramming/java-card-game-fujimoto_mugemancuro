
public class PlayerTest
{
    public static void main (String[] args){
        //declaring & initializing new player named Bob
        Player Bob = new Player();
        //dealing Bob 2 cards
        Bob.addCard(new Card(1,4));
        Bob.addCard(new Card(3,2));
        //displaying Bob's hand
        Bob.showHand("player");
        //calculating the Bob's hand value 
        Bob.calcHand();
    }
}
