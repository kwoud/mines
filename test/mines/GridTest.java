package mines;

import org.junit.Test;

public class GridTest {
	
	@Test
	public void testGrid() {
		Grid testGrid = new Grid(10, 5, 10);
		for (int i =  0; i < testGrid.getParameters()[2]; i++) {
			System.out.print("| " + testGrid.getGrid()[i] + " ");
		}
		System.out.print("|");
	}
			
//      for (int i = 0; i < gridArray.length; i++) {
//          for (int j = 0; j < gridArray[i].length; j++) {
//              int surroundingMines = 0;
//              if (gridArray[i][j] == ' ') {
//                  for (int x = i - 1; x > i; x++) {
//                      for (int y = i - 1; y > i; y++) {
//                          if (gridArray[x][y] == '*') {
//                              surroundingMines++;
//                          }
//                      }
//                  }
//                  if (surroundingMines != 0) {
//                      gridArray[i][j] = (char)(surroundingMines + '0');
//                  }
//              }    
//              System.out.print("| " + gridArray[i][j] + " ");
//          }
//          System.out.println("|");
	
}
