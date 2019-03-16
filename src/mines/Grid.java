package mines;

import java.util.Arrays;
import java.util.Random;

public class Grid {

	private int[] gridArray;
	
	public int[] getGrid() {
		return gridArray;
	}
	
	public Grid() {
		gridArray = new int[StartWindow.getGridX() * StartWindow.getGridY()];
	}
	
	public void setGrid() {
		Random rand = new Random();
		int mineCount = StartWindow.getNumMines();
		do {
			int randPos = rand.nextInt(StartWindow.getGridX() * StartWindow.getGridY());
			if (gridArray[randPos] == 0) gridArray[randPos] = 9; // 9 steht für eine Mine
		}
		while (--mineCount > 0);
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
