package interfaces;

import java.util.Iterator;

public class StringGridIterator implements Iterator<String> {
	private StringGrid grid;
	private boolean rowMajor;
	
	//the row and column index of next element (f.ex. index is 0 when next element has index 0)
	private int rowIndex = 0;
	private int columnIndex = 0;
	
	public StringGridIterator(StringGrid grid, boolean rowMajor) {
		this.grid = grid;
		this.rowMajor = rowMajor;
	}
	
	public boolean hasNext() {
		if (this.rowMajor) {
			return this.rowIndex < this.grid.getRowCount();
		}
		return this.columnIndex < this.grid.getColumnCount();
		
		
	}
	
	public String next() throws UnsupportedOperationException {
		//algorithm to find the next index values
		if (this.hasNext()) {
			String next = this.grid.getElement(rowIndex, columnIndex);
			
			if (this.rowMajor) {
				if (this.columnIndex + 1 >= this.grid.getColumnCount()) { //check to see if we are at the end of the column or not 
					this.columnIndex = 0; //reset of column index because of new row 
					this.rowIndex++; //new row 
				} else {
					this.columnIndex++; //new column 
				}
			} else {
				if (this.rowIndex + 1 >= this.grid.getRowCount()) { //same check as earlier just with rows instead 
					this.rowIndex = 0;
					this.columnIndex++;
				} else {
					this.rowIndex++;
				}
			}
			
			return next;
		}
		
		throw new UnsupportedOperationException("Index out of bound, no next element to return");
		
	}
	
	public void remove() throws UnsupportedOperationException {
		throw new UnsupportedOperationException("Not possible to remove a string from the grid");
	}
	
	
}
