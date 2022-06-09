package uno;

public class GameTest {

	public static void main(String[] args) {
		boolean gameOver = false;
		while(!gameOver) {
			System.out.println("Please enter the number of players:");
			String numOfPlayers = System.console().readLine();
			if(isParsable(numOfPlayers)) {
				Game play = new Game( Integer.parseInt(numOfPlayers));
				break;
			}
		}
		
		
		
		

	}
	
	public static boolean isParsable(String input) {
	    try {
	        Integer.parseInt(input);
	        return true;
	    } catch (final NumberFormatException e) {
	        return false;
	    }
	}
}
