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
      //this second draw method declaration obliquely tests if draw works (by drawing another different card)
      testDeck.draw();
   }
}
