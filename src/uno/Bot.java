package uno;

import java.util.ArrayList;
import java.util.Random;

public class Bot extends Player{
	public Bot(String name) {
		super(name);
	}
	
	@Override
	public Card playFromHand(Card topCard) {
		ArrayList<Card> playableCards = this.playable(topCard);
		Random rand = new Random();
		int index = rand.nextInt(playableCards.size());
		
		return this.playCard(this.currentHand.get(index));
	}
	
	public String chooseColor() {
		String[] colors = { "Red", "Yellow", "Green", "Blue" };
		Random rand = new Random();
		int index = rand.nextInt(4);
		
		return colors[index];
	}
}
