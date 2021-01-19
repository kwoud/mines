package mines;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SaveGame {
	private static Grid grid = StartWindow.getGrid();
	private static String dir = System.getProperty("user.dir") + File.separator + "SaveGame";
	private static String file = "mine.sav";
	private static File saveFile = new File(dir, file);

	private static String gridAsString(Grid grid) {
		int x = grid.getGridX();
		int y = grid.getGridY();
		int[] gridArr = grid.getGrid();
		String gridString = new String();
		for (int row = 0; row != y; ++row) {
			for (int col = 0; col != x; ++col) {
				gridString += Integer.toString(gridArr[row * x + col]) + " ";
			}
			gridString += "\n";
		}
		return gridString;
	}

	private static void createFile(File file) {
		try {
			if (file.getParentFile().mkdir()) {
				file.createNewFile();
			} else {
				throw new IOException("Failed to create directory " + file.getParent());
			}
		} catch (Exception e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

	private static void writeToFile(File file, String string) {
		try {
			FileWriter writerObj = new FileWriter(file);
			writerObj.write(string);
			writerObj.close();
			System.out.println("Successfully saved game.");
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

	public static void saveGrid() {
		createFile(saveFile);
		writeToFile(saveFile, gridAsString(grid));
	}
}
