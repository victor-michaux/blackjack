public class BlackJack {
	private Deck deck;
	private Hand playerHand;
	private Hand bankHand;
	public boolean gameFinished;
	
	public BlackJack() {
		this.deck = new Deck(4);
		this.playerHand = new Hand();
		this.bankHand = new Hand();
		this.gameFinished = false;
		
		try {
			reset();
		} catch (EmptyDeckException e) {
			e.printStackTrace();
		}
	}
	
	public void reset() throws EmptyDeckException {
		this.playerHand.clear();
		this.bankHand.clear();
		this.bankHand.add(this.deck.draw());
		for(int i = 0; i < 2; i++) this.playerHand.add(this.deck.draw());
	}
	
	public String getPlayerHandString() {
		return this.playerHand.toString();
	}
	
	public String getBankHandString() {
		return this.bankHand.toString();
	}
	
	public int getPlayerBest() {
		return this.playerHand.best();
	}
	
	public int getBankBest() {
		return this.bankHand.best();
	}
	
	public boolean isPlayerWinner() {
		if(getBankBest() > 21) {
			return (getPlayerBest() <= 21 && isGameFinished());
		} else {
			return (getPlayerBest() > getBankBest() && getPlayerBest() <= 21 && isGameFinished());
		}
	}
	
	public boolean isBankWinner() {
		if(getPlayerBest() > 21) {
			return (getBankBest() <= 21 && isGameFinished());
		} else {
			return (getBankBest() > getPlayerBest() && getBankBest() <= 21 && isGameFinished());
		}
		
	}
	
	public boolean isGameFinished() {
		return this.gameFinished;
	}
	
	public void playerDrawAnotherCard() throws EmptyDeckException {
		if(!isGameFinished()) {
			this.playerHand.add(this.deck.draw());
			if(this.playerHand.best() > 21) this.gameFinished = true;
		}
	}
	
	public void bankLastTurn() throws EmptyDeckException {
		if(!isGameFinished() && getPlayerBest() <= 21 && getBankBest() < 21) {
			while(getBankBest() < getPlayerBest() && !isGameFinished()) {
				bankHand.add(deck.draw());
			}
			gameFinished = true;
		}
	}
}
