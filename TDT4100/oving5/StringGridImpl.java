package interfaces;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Iterator;

public class StringGridImpl implements StringGrid {
	private int rows; 
	private int columnCount; 
	
	private ArrayList<ArrayList<String>> grid = new ArrayList<ArrayList<String>>();
	
	StringGridImpl(int rows, int columnCount) {
		this.rows = rows;
		this.columnCount = columnCount;
		
	}
	
	public int getRowCount() {
		return this.rows;
	}
	
	public int getColumnCount() {
		return this.columnCount;
	}
	
	public String getElement(int row, int column) throws IllegalArgumentException {
		if (!this.isOutOfBounds(row, column)) {
			
			return this.grid.get(row).get(column);
		} else {
			throw new IllegalArgumentException("Row/Column index out of bounds");
		}
		
	}
	
	public void setElement(int row, int column, String element) {
		if (!this.isOutOfBounds(row, column)) {
			if (!(this.grid.size() > row)) { //check to see if the element is getting slotted in or added at the end 
				this.grid.add(new ArrayList<String>(Arrays.asList(element))); //must add a new empty list with element 
			} else {
				if (!(this.grid.get(row).size() > column)) { //same check just with column index instead
					this.grid.get(row).add(element);
				} else {
					this.grid.get(row).set(column,element);
				}
			}
		} else {
			throw new IllegalArgumentException("Row/Column index out of bounds");
		}
	}
	
	//Because StringGridImpl implements StringGrid the class must now implement the method 'iterator()' that returns a string iterator
	public Iterator<String> iterator() {
		return new StringGridIterator(this, true); //we return the string iterator we made in 2)
	}
	
	private boolean isOutOfBounds(int row, int column) {
		return row + 1 > this.rows || column + 1 > this.columnCount;
	}
	
	//test of 3)
	public static void main(String[] args) {
		//initialize the grid 
		StringGrid grid = new StringGridImpl(7, 4);
		
		
		//filling the grid
		for (int i = 0; i < grid.getRowCount(); i++) {
			for (int j = 0; j < grid.getColumnCount(); j++) {
				grid.setElement(i, j, i + ", " + j);
			}
		}
		
		//initialize our own iterator 
		Iterator<String> iterator = grid.iterator();
		
		//use the iterator to print the elements of the grid 
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		
		System.out.println("-------------------");
		
		//same with the for-each implementation 
		for (String s : grid) {
			System.out.println(s);
		}
	}
	
	
	
	
	
}
