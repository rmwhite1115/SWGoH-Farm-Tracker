import java.io.*;

public class ProgressTracker {
	int[][] progress;
	int numberOfUnits;
	private final String FILE_NAME = "progress.txt";

	// This creates an array that stores every event unit's requirements and current level.
	public ProgressTracker(int numUnits, int maxReqs) {
		numberOfUnits = numUnits;
		progress = new int[numUnits][maxReqs];
	}

	// This updates the value of the requirement's level in an 2d array of the event units and their individual requirements.
	public void updateProgress(int unitIndex, int reqIndex, int newValue) {
		if (unitIndex >= 0 && unitIndex < numberOfUnits) {
			progress[unitIndex][reqIndex] = newValue;
			saveProgress();
		}
	}

	// This returns the specified units level stored in the array.
	public int getCurrentLevel(int unitIndex, int reqIndex) {
		return progress[unitIndex][reqIndex];
	}

	// This saves the values for each requirements levels to a txt file.
	public void saveProgress() {
		try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME))) {
			for (int i = 0; i < progress.length; i++) {
				for (int j = 0; j < progress[i].length; j++) {
					writer.print(progress[i][j] + (j == progress[i].length - 1 ? "" : ","));
				}
				writer.println();
			}
		} catch (IOException e) {
			System.out.println("Error saving progress: " + e.getMessage());
		}
	}
	
	// This loads every requirements level from a txt file.
	public void loadProgress() {
		File file = new File(FILE_NAME);
		if (!file.exists()) {
			return;
		}
		
		try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
			String line;
			int i = 0;
			
			while ((line = reader.readLine()) != null && i < numberOfUnits) {
				String[] values = line.split(",");
				for (int j = 0; j < values.length && j < progress[i].length; j++) {
					progress[i][j] = Integer.parseInt(values[j]);
				}
				i++;
			}
		} catch (IOException | NumberFormatException e) {
			System.out.println("Error loading Progress. Starting with new data");
		}
	}
	
	// This will reset every index back to 0.
	public void resetAllProgress() {
		for (int i = 0; i < progress.length; i++) {
			for (int j = 0; j < progress[i].length; j++) {
				progress[i][j] = 0;
			}
		}
		saveProgress();
		System.out.println("All farm progress has been wiped");
	}
}
