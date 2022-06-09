package uno;

import java.util.ArrayList;

public class TestDeck {

	public static void main(String[] args) {

		Deck myDeck = new Deck();
		
		ArrayList<Card> cards = myDeck.getCards();

		for (Card card : cards) {
			card.showCard();
		}
		
		System.out.printf("Deck has %d cards\n", cards.size());
		
		for (int i = 0; i < 8; i++) {
			myDeck.drawOne().showCard();
		}
		
		System.out.printf("Deck has %d cards\n", cards.size());
		
	}

}
