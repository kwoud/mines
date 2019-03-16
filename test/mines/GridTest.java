package mines;

import org.junit.Test;

public class GridTest {
	
	@Test
	public void testGrid() {
		Grid testGrid = new Grid();
		testGrid.setGridMines();
		testGrid.setGridNumbers();
		int currPos = 0;
		for (int j =  0; j < StartWindow.getGridY(); j++) {
			for (int i = 0; i < StartWindow.getGridX(); i++) {
				currPos = (j * StartWindow.getGridX()) + i;
				System.out.print("| " + testGrid.toString(currPos) + " ");
			}
			System.out.println("|");
		}
	}
	
}
