
public class BlackJackConsole {

	public BlackJackConsole() {
		System.out.println("Welcome to the BlackJack table. Let's play !");
		Card[] tab = { new Card(Value.TWO, Color.HEART), new Card(Value.JACK, Color.SPADE) };
		for(Card c : tab) { // For each card
			System.out.println("This card is a "+c+ " worth "+c.getPoints()+ " points");
			System.out.print("It's a ");
			switch(c.getColorSymbole()) { // Ok from Java 1.7
				case "♥": System.out.print("heart"); break;
				case "♠": System.out.print("spade"); break;
				case "♣": System.out.print("club"); break;
				case "♦": System.out.print("diamond"); break;
			}
			if(c.getValueSymbole().matches("[JQK]")) { // Is the value symbole a J or a Q or a K ?
				System.out.println(" and a face !");
			} else {
				System.out.println(" and it's not a face.");
			}
		}
		Deck deck = new Deck(2);
		System.out.println( "Here is the deck "+ deck);
		for(int i = 0 ; i < 3 ; i++){
				try{
					Card c = deck.draw();
					System.out.println("This card is a " + c + " worth "+c.getPoints()+ " points");
				} catch (EmptyDeckException ex){
					System.err.println(ex.getMessage());
					System.exit(-1);
				}
		}
	}
	
	
	public static void main(String[] args) {
		new BlackJackConsole();
	}

}
