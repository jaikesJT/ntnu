package encapsulation;

public class Nim {
	int[] piles = new int[3]; //length 3 because 3 piles 
	
	public Nim(int pileSize) {
		for (int i = 0; i < this.piles.length; i++) {
			this.piles[i] = pileSize;
		}
	}
	
	public Nim() {
		this(10);
	}
	
	public void removePieces(int number, int targetPile) throws IllegalArgumentException, IllegalStateException {
		if (this.isGameOver()) {
			throw new IllegalStateException("Cannot remove pieces when the game is over");
		}
		
		if (this.isValidMove(number, targetPile)) {
			this.piles[targetPile] -= number;
		} else {
			throw new IllegalArgumentException("The number of pieces '" + number + "' or the target pile '" + targetPile + "' have invalid values");
		}
		
		
	}
	
	public boolean isValidMove(int number, int targetPile) {
		return (number >= 1 && targetPile > -1 && targetPile < 3 && this.piles[targetPile] >= number && !this.isGameOver());
	}
	
	public boolean isGameOver() {
		for (int i = 0; i < this.piles.length; i++) {
			if (this.piles[i] == 0) {
				return true;
			}
		}
		
		return false;
		
	}
	
	public int getPile(int targetPile) {
		return this.piles[targetPile];
	}
	
	public String toString() {
		return this.piles[0] + " " + this.piles[1] + " " + this.piles[2];
	}
	
}
