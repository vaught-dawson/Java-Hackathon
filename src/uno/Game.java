package uno;

import java.util.*;

public class Game {
	public ArrayList<Player> playerList;
	public Deck unoDeck;
	public Card topCard;

	public Game (int numOfPlayers) {
		this.playerList = new ArrayList<Player>();
		this.unoDeck = new Deck();
		this.topCard = unoDeck.drawOne();
		for (int i = 0; i < numOfPlayers; i++) {
			System.out.println("Player please enter your name."); // Would like to add player number
			String name = System.console().readLine();
			Player player = new Human(name);
			player.setHand(unoDeck.drawCards(7));
			playerList.add(player);
		}
	}

	public void runGame() {
		boolean isWinner = false;
		int turn = 0;
		int turnMod = 1;
		while (!isWinner) {
				Player currentPlayer = playerList.get(turn);
				
				System.out.printf("\nThe card on top is %s\nIt is %s's turn\n\n", this.topCard.toString(), currentPlayer.getName());
				
				Card playedCard;
				
				if (currentPlayer.playable(this.topCard).size() == 0) {
					System.out.printf("%s didn't have a card they could play...\n", currentPlayer.getName());
					
					ArrayList<Card> addedCards = new ArrayList<Card>();
					boolean isValidCard = false;
					
					while(!isValidCard) {
						Card drawedCard = this.unoDeck.drawOne();
						addedCards.add(drawedCard);
						isValidCard = drawedCard.canPlayOn(this.topCard);
					}
					
					System.out.println(addedCards);
					
					playedCard = addedCards.remove(addedCards.size()-1);
					ArrayList<Card> newHand = new ArrayList<Card>();
					newHand.addAll(addedCards);
					newHand.addAll(currentPlayer.getHand());
					currentPlayer.setHand(newHand);
					
					System.out.printf("%s drew %d cards!\n", currentPlayer.getName(), addedCards.size() + 1);
				} else {
					playedCard = currentPlayer.playFromHand(this.topCard);
				}
				
				System.out.printf("%s played a %s\n", currentPlayer.getName(), playedCard.toString());
				

				this.topCard = playedCard;
				turn = (turn + turnMod) % playerList.size();
		}

	}

	public String currentHand(Player player) {
		String currentPlayerHand = "";
		for (int i = 0; i < player.getHand().size(); i++) {
			String color = player.getHand().get(i).getColor();
			int num = player.getHand().get(i).getNumber();
			currentPlayerHand = currentPlayerHand + " " + color + " " + num;
		}
		return currentPlayerHand;
	}
	public HashMap<String, String>  playableCards(Player player) {
		HashMap<String, String> playableCards = new HashMap<String, String>();
		for(int i = 0; i< player.playable(topCard).size(); i++) {
			String color = player.playable(topCard).get(i).getColor();
			int num = player.playable(topCard).get(i).getNumber();
			String card = color + " " + num;
			String idx = "" + i;
			playableCards.put(idx, card);
		}
		return playableCards;
		
	}

}
