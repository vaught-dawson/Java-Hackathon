package uno;

import java.util.ArrayList;
import java.util.Random;

public class Deck {

	private ArrayList<Card> cards;
	private ArrayList<Card> discarded;

	public Deck() {
		this.cards = new ArrayList<Card>();

		for (String color : new String[] { "Red", "Yellow", "Green", "Blue" }) {
			cards.add(new Card(color, 0));
			for (int i = 0; i < 2; i++) {
				cards.add(new Card(color, 1));	
				cards.add(new Card(color, 2));	
				cards.add(new Card(color, 3));	
				cards.add(new Card(color, 4));	
				cards.add(new Card(color, 5));	
				cards.add(new Card(color, 6));	
				cards.add(new Card(color, 7));	
				cards.add(new Card(color, 8));	
				cards.add(new Card(color, 9));	
				cards.add(new Card(color, 10));	
				cards.add(new Card(color, 11));	
				cards.add(new Card(color, 12));	
			}
		}
		
		for (int i = 0; i < 4; i++) {
			cards.add(new Card(null, 13));				
			cards.add(new Card(null, 14));				
		}
		
		this.shuffleCards();
	}

	public ArrayList<Card> getCards() {
		return cards;
	}

	public void setCards(ArrayList<Card> cards) {
		this.cards = cards;
	}
	
	private void shuffleCards() {
		ArrayList<Card> shuffled = new ArrayList<Card>();
		Random rand = new Random();
		
		while (this.cards.size() > 0) {
			int index = rand.nextInt(cards.size());
			shuffled.add(this.cards.remove(index));
		}
		
		this.cards = shuffled;
	}
	
	//TODO Add discarded cards back to deck and shuffle
	private void refreshDeck() {}
}