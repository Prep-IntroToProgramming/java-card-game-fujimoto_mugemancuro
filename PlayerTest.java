
public class PlayerTest
{
    public static void main (String[] args){
        Player Bob = new Player();
        Bob.addCard(new Card(1,4));
        Bob.addCard(new Card(3,2));
        Bob.showHand("player");
        Bob.calcHand();
    }
}
