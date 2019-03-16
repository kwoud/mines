package mines;

import java.util.Random;

public class Grid {

	private int[] gridArray;
	int gridX = StartWindow.getGridX();
	int gridY = StartWindow.getGridY();
	int gridSize = gridX * gridY;
	int numMines = StartWindow.getNumMines();
	
	public Grid() {
		gridArray = new int[gridSize];
	}

	public int[] getGrid() {
		return gridArray;
	}
	
	public int getValue(int pos) {
		return gridArray[pos];
	}
	
	public String toString(int pos) {
		if (gridArray[pos] == 9) { return "*"; }
		if (gridArray[pos] == 0) { return " "; }
		return Integer.toString(gridArray[pos]);
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
			}
		else return true;
	}
	
	private boolean isMine(int x, int y) {
		if (gridArray[x +(y * gridX)] == 9) {
			return true;
		}
		else return false;
	}
	
	public static int[][] getNeighbour(int x, int y) {
		int[][] neighbourArray = new int[][] {	{x - 1, y - 1}, {x, y - 1}, {x + 1, y - 1}, 
												{x - 1 , y}, 				{x + 1, y},
												{x - 1, y + 1}, {x, y + 1}, {x + 1, y + 1}	}; 
		return neighbourArray;
	}
	
	public void setGridNumbers() {
		for (int j = 0; j < gridY; j++) {
			for (int i = 0; i < gridX; i++) {
				if (gridArray[i + (j * gridX)] == 0) {
					for (int neighbour = 0; neighbour < 8; neighbour++) {
						int currX = getNeighbour(i, j)[neighbour][0];
						int currY = getNeighbour(i, j)[neighbour][1];
						if ( (inGrid(currX, currY)) && (isMine(currX, currY))) {
								gridArray[i + (j * gridX)]++;
						}
					}
				}
			}
		}
	}
	
}