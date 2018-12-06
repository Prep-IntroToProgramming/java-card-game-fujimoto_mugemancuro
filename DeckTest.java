public class DeckTest
{
     public static void main (String[] args){
      //Creates new deck.
      Deck testDeck = new Deck();
      //uses countCards() method to show its functionality (and prove that the constructor works).
      testDeck.countCards();
      //I added a redunadd
      testDeck.draw();
      testDeck.shuffle();
      testDeck.draw();
   }
}
