package uno;

public class TestDeck {

	public static void main(String[] args) {

		Deck myDeck = new Deck();
		Card top = myDeck.drawOne();
		System.out.println("Top: " + top.toString());
		
		Human testSubject = new Human("Dave");
		
		testSubject.setHand(myDeck.drawCards(7));
		System.out.println(testSubject.playFromHand(top));
		
		
	}

}
