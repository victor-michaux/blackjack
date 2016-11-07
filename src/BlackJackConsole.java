import java.util.Scanner;

public class BlackJackConsole {

	public BlackJackConsole() {
		System.out.println("Welcome to the BlackJack table. Let's play !");
		BlackJack game = new BlackJack();
		System.out.println("The bank draw : " + game.getBankHandString());
		System.out.println("Your draw : " + game.getPlayerHandString());
		
		Scanner sc = new Scanner(System.in);
		
		while(!game.gameFinished) {	
			String reponse = null;
			do {
				System.out.println("Do you want another card ? [y/n]");
				reponse = sc.next();
			} while (!(reponse.equals("y") || reponse.equals("n")));
			
			try {
				if(reponse.equals("y")) {
					game.playerDrawAnotherCard();
					System.out.println("Your new draw : " + game.getPlayerHandString());
				} else {
					game.bankLastTurn();
					System.out.println("The bank draw cards : " + game.getBankHandString());
				}
			} catch (EmptyDeckException e) {
				e.printStackTrace();
			}
			
		}
		
		System.out.println("Your best : " + game.getPlayerBest());
		System.out.println("Bank best : " + game.getBankBest());
		
		if(game.isPlayerWinner()) {
			System.out.println("You win !");
		} else if(game.isBankWinner()) {
			System.out.println("The bank win !");
		} else {
			System.out.println("Draw !");
		}
		
		sc.close();
	}
	
	
	public static void main(String[] args) {
		new BlackJackConsole();
	}

}
