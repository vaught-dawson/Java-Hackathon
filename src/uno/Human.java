package uno;

import java.util.ArrayList;

public class Human extends Player {
	public Human(String name) {
		super(name);
	}

	@Override
	public Card playFromHand(Card topCard) {
		System.out.println("HEre1 ");
		ArrayList<Card> playableCards = this.playable(topCard);
		System.out.println("HEre1 ");

		System.out.println("Playable Cards:");
		for (int i = 0; i < playableCards.size(); i++) {
			System.out.printf("%d - %s\n", i, playableCards.get(i).toString());
		}

		int input = 0;
		do {
			System.out.printf("\nEnter the index of the card you want to play: ");
			try {
				input = Integer.parseInt(System.console().readLine());
			} catch (NumberFormatException e) {
				System.out.println("Must be a number!");
				input = 0;
			}
		} while (input < 0 || input > playableCards.size());

		return this.playCard(playableCards.get(input));
	}

	public String chooseColor() {
		String input = "";
		do {
			System.out.print("Enter a color: ");
			input = System.console().readLine();
			System.out.println("");
		} while (!input.equals("red") && !input.equals("yellow") && !input.equals("green") && !input.equals("blue"));

		input = input.substring(0, 1) + input.substring(1);
		return input;
	}
}
