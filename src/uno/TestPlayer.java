package uno;

public class TestPlayer {

	public static void main(String[] args) {
		Player player1 = new Player("gary");
		Card card = new Card("Yellow", 8);
		System.out.print(player1.playable(card));
		

	}

}
