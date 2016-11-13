import java.util.LinkedList;
import java.util.List;

public class Hand {
	private LinkedList<Card> cardList;
	
	public Hand() {
		this.cardList = new LinkedList<Card>();
	}
	
	@Override
	public String toString() {
		return this.cardList.toString() + " : " + count().toString();
	}
	
	public void add(Card card) {
		this.cardList.add(card);
	}
	
	public void clear() {
		this.cardList.removeAll(this.cardList);
	}
	
	public List<Integer> count() {
		LinkedList<Integer> resultat = new LinkedList<Integer>();
		resultat.add(0);
		for(Card card : this.cardList) {
			int size = resultat.size();
			for(int i = 0; i < size; i++) {
				int val = resultat.get(i);
				resultat.set(i,	val + card.getPoints());
				if(card.getPoints() == 1) resultat.add(val + 11);
			}
		}
		return resultat;
	}
	
	public int best() {
		int max = 0;
		int defaut = 0;
		for(Integer i : count()) {
			i = i.intValue();
			if(i > max) defaut = i;
			if(i <= 21) max = i;
		}
		return (max == (int) 0) ? defaut : max;
	}

	public List<Card> getCardList() {
		return new LinkedList<Card>(this.cardList);
	}
}
