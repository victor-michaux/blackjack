import java.util.Collections;
import java.util.LinkedList;

public class Deck {
	LinkedList<Card> cardList;
 
	public Deck(int nbBox)
	{
		cardList = new LinkedList<Card>();
		Value tabValue[] = Value.values();
		Color tabColor[] = Color.values();
		 
		int nbColor = tabColor.length;
		int nbValue = tabValue.length;
		for(int k = 0; k < nbBox; k++) { 
			for(int i = 0; i < nbColor; i++) {
				for(int j = 0; j < nbValue; j++) {
					this.cardList.add(new Card(tabValue[j], tabColor[i]));		 
				}
			}
		}
		Collections.shuffle(cardList);
	}
	
	public String toString()
	{
		return cardList.toString();
	}
	
	public Card draw() throws EmptyDeckException
	{
		Card cardToReturn = cardList.pollFirst();
		if (cardToReturn == null)
			throw new EmptyDeckException();
		else
			return cardToReturn;
	}
}
