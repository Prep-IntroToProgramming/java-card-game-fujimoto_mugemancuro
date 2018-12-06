public class DeckTest
{
     public static void main (String[] args){
      //Creates new deck.
      Deck testDeck = new Deck();
      //uses countCards() method to show its functionality (and prove that the constructor works).
      testDeck.countCards();
      //I added a redundant print statement to show the functionality of the draw method.
      testDeck.draw();
      //shuffle.
      testDeck.shuffle();
      //discard.
      testDeck.discard();
      //checks to see if one card has been discarded.
      testDeck.countCards();
   }
}
