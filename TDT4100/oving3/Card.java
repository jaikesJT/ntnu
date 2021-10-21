package encapsulation;

public class Card {
	private char suit;
	private int face;
	
	public Card(char suit, int face) {
		if (!((suit == 'S' || suit == 'H' || suit == 'D' || suit == 'C') && (face > 0 && face < 14))) {
			throw new IllegalArgumentException("Illegal arguments when initilizing card");
		} else {
			this.suit = suit;
			this.face = face;
		}
	}
	
	public char getSuit() {
		return this.suit;
	}
	
	public int getFace() {
		return this.face;
	}
	
	public String toString() {
		return this.suit + "" + this.face;
	}
}