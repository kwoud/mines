package mines;

import org.junit.Test;

public class GridTest {
	
	@Test
	public void testGrid() {
		Grid testGrid = new Grid();
		testGrid.setGridMines();
//		testGrid.setGridNumbers();
		for (int i =  0; i < StartWindow.getGridY(); i++) {
			for (int j = 0; j < StartWindow.getGridX(); j++) {
				System.out.print("| " + testGrid.getGrid()[(i * StartWindow.getGridX()) + j] + " ");
			}
			System.out.println("|");
		}
	}
	
}
