
public class BlackJackConsole {

	public BlackJackConsole() {
		System.out.println("Welcome to the BlackJack table. Let's play !");
		Deck deck = new Deck(2);
		Hand hand = new Hand();
		System.out.println("Your hand is currently : "+ hand);
		for(int i=0; i < 3 ; i++) {
			try {
				hand.add(deck.draw());
			} catch (EmptyDeckException ex) {
				System.err.println(ex.getMessage());
				System.exit(-1);
			}
		}
		System.out.println("Your hand is currently : "+ hand);
		System.out.println("The best score is : " + hand.best());
		hand.clear();
		System.out.println("Your hand is currently : "+ hand);

	}
	
	
	public static void main(String[] args) {
		new BlackJackConsole();
	}

}
