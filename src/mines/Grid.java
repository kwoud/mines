package mines;

import java.util.Iterator;
import java.util.Random;
import java.util.Vector;

public class Grid {
	private int[] gridArray;
	private int gridX = 15;
	private int gridY = 10;
	private int gridSize = gridX * gridY;
	private int numMines = 30;

	public Grid() {
		gridArray = new int[gridSize];
	}
	
	public void newGrid() {
		gridArray = new int[gridSize];
		setGridMines();
		setGridNumbers();
	}

	public void newGrid(int x, int y, int m) {
		setGridSize(x, y);
		setNumMines(m);
		gridArray = new int[gridSize];
		setGridMines();
		setGridNumbers();
	}
	
	public int[] getGrid() {
		return gridArray;
	}

	public int getValue(int pos) {
		return gridArray[pos];
	}

	public String toString(int pos) {
		if (gridArray[pos] == 9) {return "*";}
		if (gridArray[pos] == 0) {return " ";}
		return Integer.toString(gridArray[pos]);
	}

	public int getGridX() {return gridX;}
	public int getGridY() {return gridY;}
	public int getGridSize() {return gridSize;}
	public int getNumMines() {return numMines;}
	
	public void setGridX(int x) {
		gridX = x;
		gridSize = gridX * gridY;
	}

	public void setGridY(int y) {
		gridY = y;
		gridSize = gridX * gridY;
	}
	
	public void setGridSize(int x, int y) {
		gridX = x;
		gridY = y;
		gridSize = gridX * gridY;
	}
	
	public void setNumMines(int m) {
		assert(m <= gridX * gridY);
		assert(m > 0);
		numMines = m;
	}
	
	public void setGridMines() {
		Random rand = new Random();
		int mineCount = numMines;
		while (mineCount > 0) {
			int randPos = rand.nextInt(gridSize);
			if (gridArray[randPos] == 0) {
				gridArray[randPos] = 9; // 9 steht für eine Mine
				mineCount--;
			}
		}
	}
  
	private boolean inGrid(int x, int y) {
		if ((x < 0) || (x >= gridX) ||
				(y < 0) || (y >= gridY)) {
			return false;
		} else
			return true;
	}
	
	public boolean inGrid(int pos) {
		if (pos < 0) return false;
		if (pos >= gridSize) return false;
		return true;
	}
	
	private boolean isMine(int x, int y) {
		if (gridArray[x +(y * gridX)] == 9) {
			return true;
		} else
			return false;
	}
	
	public boolean isMine(int pos) {
		if (gridArray[pos] == 9) return true;
		else return false;
	}
	
	public boolean isZero(int pos) {
		assert(pos>0);
		assert(pos<gridSize);
		if (gridArray[pos] == 0) return true;
		else return false;
	}
	
	public static int[][] getNeighbour(int x, int y) {
		int[][] neighbourArray = new int[][] {	{x - 1, y - 1}, {x, y - 1}, {x + 1, y - 1}, 
												{x - 1 , y}, 				{x + 1, y},
												{x - 1, y + 1}, {x, y + 1}, {x + 1, y + 1}	}; 
		return neighbourArray;
	}
	
	public int[] getNeighbour(int pos) {
		int[] neighbourArray = new int[] {
				pos-gridX-1, pos-gridX, pos-gridX+1,
				pos-1,					pos+1,
				pos+gridX-1, pos+gridX, pos+gridX+1
		};
		System.out.print("all:        { ");
		for (int i=0; i<neighbourArray.length; i++) {
			System.out.print(neighbourArray[i] + ", ");
		}
		System.out.println("}");
		return neighbourArray;
	}
	
	private boolean areNeighbours(int pos1, int pos2) {
		if (!inGrid(pos2)) return false;
		// pos1 at left border and pos2 at right border
		if (pos1%gridX == 0 && (pos2+1)%gridX==0) return false;
		// pos1 at right border and pos2 at left border
		if ((pos1+1)%gridX == 0 && (pos2%gridX==0)) return false;
		return true;
	}

	public Vector<Integer> getValidNeighbour(int pos) {
		Vector<Integer> validNeighs = new Vector<Integer>();
		int[] allNeighs = getNeighbour(pos);
		for (int i = 0; i < allNeighs.length; i++) {
			if (areNeighbours(pos, allNeighs[i])) {
				validNeighs.add(allNeighs[i]);
			}
		}
		Iterator<Integer> it = validNeighs.iterator();
		System.out.print("valid:      { ");
		while (it.hasNext()){
			System.out.print(it.next() + ", ");
		}
		System.out.println("}");
		return validNeighs;
	}
	
	public void setGridNumbers() {
		int currX, currY;
		for (int j = 0; j < gridY; j++) {
			for (int i = 0; i < gridX; i++) {
				if (gridArray[i + (j * gridX)] == 0) {
					for (int neighbour = 0; neighbour < 8; neighbour++) {
						currX = getNeighbour(i, j)[neighbour][0];
						currY = getNeighbour(i, j)[neighbour][1];
						if ((inGrid(currX, currY)) && (isMine(currX, currY))) {
							gridArray[i + (j * gridX)]++;
						}
					}
				}
			}
		}
	}

}