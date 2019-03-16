package mines;

import java.util.Random;

public class Grid {

	private int[] gridArray;
	int gridX = StartWindow.getGridX();
	int gridY = StartWindow.getGridY();
	int gridSize = gridX * gridY;
	int numMines = StartWindow.getNumMines();
	
	public int[] getGrid() {
		return gridArray;
	}
	
	public Grid() {
		gridArray = new int[StartWindow.getGridX() * StartWindow.getGridY()];
	}
	
	public void setGridMines() {
		Random rand = new Random();
		int mineCount = numMines;
		do {
			int randPos = rand.nextInt(gridSize);
			if (gridArray[randPos] == 0) gridArray[randPos] = 9; // 9 steht für eine Mine
		}
		while (--mineCount > 0);
	}
	
	private boolean inGrid(int i) {
		if ((i < 0) || (i >= gridX) ||
				(i < 0) || (i >= gridY)) {
			return false;
			}
		else return true;
	}
	
	private boolean isMine(int i) {
		if (gridArray[i] == 9) {
			return true;
		}
		else return false;
	}
	
	public void setGridNumbers() {
		for (int i = 0; i < gridSize; i++) {
			int psblNeighbour;
			if (gridArray[i] == 0) {
				//folgende Schleife läuft über die 3 über i liegenden Felder
				for (psblNeighbour = i - gridX - 1; psblNeighbour == i - gridX + 1; psblNeighbour++) {
					if (inGrid(psblNeighbour) && isMine(psblNeighbour)) {
						gridArray[i]++;
					}
				}
				//linker Nachbar
				if (inGrid(i - 1) && isMine(i - 1)) {
					gridArray[i]++;
				}
				//rechter Nachbar
				if (inGrid(i + 1) && isMine(i + 1)) {
					gridArray[i]++;
				}
				//folgende Schleife läuft über die 3 unter i liegenden Felder
				for (psblNeighbour = i + gridX - 1; psblNeighbour == i + gridX + 1; psblNeighbour++) {
					if (inGrid(psblNeighbour) && isMine(psblNeighbour)) {
						gridArray[i]++;
					}
				}
			}
		}
	
			
//		for (int i = 0; i < size; i++) {
//			for (int x = i - gridX - 1)
//			if (inGrid(i) && gridArray[i] == 9) {
//				gridArray[i + 1]++;
//			}
//		}	
		
	}
	
}
	
//    public static void main(String[] args) {
//    
//        char[][] gridArray = new char[10][10];
//
//        for (char[] row : gridArray) {
//            Arrays.fill(row, ' ');
//        }
//        
//        int mineCount = 10;
//        Random rand = new Random();
//        
//        if (mineCount >= 10 * 10) {
//            System.out.println("Es muss weniger Minen geben als Felder im Grid!");
//        }
//        else {
//            do {
//                int randi = rand.nextInt(10);
//                int randj = rand.nextInt(10);
//                if (gridArray[randi][randj] == ' ') {
//                    gridArray[randi][randj] = '*';
//                    mineCount--;
//                }
//            }
//            while (mineCount > 0);
//
//            for (int i = 0; i < gridArray.length; i++) {
//                for (int j = 0; j < gridArray[i].length; j++) {
//                    int surroundingMines = 0;
//                    if (gridArray[i][j] == ' ') {
//                        for (int x = i - 1; x > i; x++) {
//                            for (int y = i - 1; y > i; y++) {
//                                if (gridArray[x][y] == '*') {
//                                    surroundingMines++;
//                                }
//                            }
//                        }
//                        if (surroundingMines != 0) {
//                            gridArray[i][j] = (char)(surroundingMines + '0');
//                        }
//                    }    
//                    System.out.print("| " + gridArray[i][j] + " ");
//                }
//                System.out.println("|");
//            }
//        }
//    }
//
//}
