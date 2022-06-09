package uno;
import java.util.*;

public class Player {
	protected ArrayList<Card> currentHand;
	private String name;
	
	
	public Player(String name) { //to make the player first time around. 
		this.name = name;
	}
	
	
	public String getName() {
		return this.name;
	}
	
	public ArrayList<Card> getHand(){
		return this.currentHand;
	}
	
	public void setHand(ArrayList<Card> hand) {
		this.currentHand = hand;
	}
	
	public void setName(String name) {
		this.name = name;
		
	}
	
	public ArrayList<Card> playable(Card card){
		ArrayList<Card> playableCard = new ArrayList<Card>();
		for(int i = 0; i < this.currentHand.size(); i++) {
			if(card.canPlayOn(this.currentHand.get(i))) {
				playableCard.add(this.currentHand.get(i));
			}
		}
		return playableCard;
	}
	
	public void playCard(Card card){
		int idx = this.currentHand.indexOf(card);
		this.currentHand.remove(idx);
	}
	
	public Card playFromHand(Card topCard) {
		return null;
	}
}
