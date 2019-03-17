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
	
	private boolean inGrid(int i, int j) {
		if ((i < 0) || (i >= gridX) ||
				(j < 0) || (j >= gridY)) {
			return false;
			}
		else return true;
	}
	
	private boolean isMine(int i, int j) {
		if (gridArray[(j * gridX) + i] == 9) {
			return true;
		}
		else return false;
	}
	
	public int[][] psblNeighbour(int i, int j) {
		int[][] neighbourArray = new int[][] {	{i - 1, j - 1}, {i, j - 1}, {i + 1, j - 1}, 
												{i - 1 , j}, 				{i + 1, j},
												{i - 1, j + 1}, {i, j + 1}, {i + 1, j + 1}	}; 
		return neighbourArray;
	}
	
	public void setGridNumbers() {
		for (int j = 0; j < gridY; j++) {
			for (int i = 0; i < gridX; i++) {
				if (gridArray[(j * gridX) + i] == 0) {
					for (int neighbour = 0; neighbour < 8; neighbour++) {
						int currX = psblNeighbour(i, j)[neighbour][0];
						int currY = psblNeighbour(i, j)[neighbour][1];
						if (inGrid(currX, currY)) {
							if (isMine(currX, currY)) {
								gridArray[(j * gridX) + i]++;							
							}
						}
					}
				}
			}
		}
	}
	
}