package uno;

import java.util.HashMap;

public class Card {

	private String color;
	private int number;
	private String name;

	public Card(String color, Integer number) {
		this.color = color;
		this.number = number;
		this.name = "";

		HashMap<Integer, String> names = new HashMap<Integer, String>();
		names.put(10, "Skip");
		names.put(11, "Reverse");
		names.put(12, "+2");
		names.put(13, "Wild");
		names.put(14, "Wild +4");

		if (names.get(number) != null) {
			this.name = names.get(number);
		} else {
			this.name = Integer.toString(number);
		}
	}

	public void showCard() {
		System.out.printf("%s %s\n", this.name, this.color);
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public boolean canPlayOn(Card card) {
		if (card.getNumber() == this.number || card.getColor().equals(this.color)) {
			return true;
		}
		return false;
	}
}