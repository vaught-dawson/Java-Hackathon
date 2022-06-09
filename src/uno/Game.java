package uno;

import java.util.*;

public class Game {
	public ArrayList<Player> playerList;
	public Deck unoDeck;
	public Card topCard;

	public Game (int numOfPlayers) {
		this.unoDeck = new Deck();
		this.topCard = unoDeck.drawOne();
		int i = 0;
		while (i < numOfPlayers) {
			System.out.println("Player please enter your name."); // Would like to add player number
			String name = System.console().readLine();
			Player player = new Player(name);
			player.setHand(unoDeck.drawCards(7));
			playerList.add(player);

		}
	}

	public void runGame() {
		boolean isWinner = false;
		int numOfPlayers = playerList.size();
		int turnCounter = 0;
		while (!isWinner) {
			if(turnCounter < numOfPlayers) {
				System.out.println(String.format("The card on top is %s %d", topCard.getColor(), topCard.getNumber()));
				Player currentPlayer = playerList.get(turnCounter);
				System.out.println(String.format("%s, it is your turn.", currentPlayer.getName()));
				System.out.println(String.format("Your currently have these cards %s", currentHand(currentPlayer)));
				System.out.println("The cards you can play are:");
				System.out.println(playableCards(currentPlayer));
			}

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
