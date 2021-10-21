package encapsulation;

public class CardDeck {
	private Card[] deck;
	
	public CardDeck(int n) {
		this.deck = new Card[n*4];
		
		char[] suits = {'S', 'H', 'D', 'C'};
		
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < n; j++) {
				this.deck[n*i+j] = new Card(suits[i], j+1);
			}
		}
	}
	
	public int getCardCount() {
		return this.deck.length;
	}
	
	public Card getCard(int n) {
		return this.deck[n];
	}
	
	public void shufflePerfectly() {
		//split the deck, we know that the deck has even number of cards
		int half = this.deck.length/2;
		
		Card[] bot = new Card[half]; //bottom half 
		Card[] top = new Card[half]; //top half
		
		for (int i = 0; i < half; i++) { //filling the halves
			bot[i] = this.deck[i];
			top[i] = this.deck[half+i];
		}
		//counters for the halves
		int nextIndexOfB = 0;
		int nextIndexOfT = 0;
		
		//replacing deck with shuffled version 
		for (int i = 0; i < this.deck.length; i++) {
			if (i % 2 == 0) {
				this.deck[i] = bot[nextIndexOfB];
				nextIndexOfB++;
			} else {
				this.deck[i] = top[nextIndexOfT];
				nextIndexOfT++;
			}
		}
		
	}
	
}
