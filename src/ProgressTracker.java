import java.io.*;

public class ProgressTracker {
	int[][] progress;
	int numberOfUnits;
	private final String FILE_NAME = "progress.txt";

	public ProgressTracker(int numUnits, int maxReqs) {
		numberOfUnits = numUnits;
		progress = new int[numUnits][maxReqs];
	}

	public void updateProgress(int unitIndex, int reqIndex, int newValue) {
		if (unitIndex >= 0 && unitIndex < numberOfUnits) {
			progress[unitIndex][reqIndex] = newValue;
			saveProgress();
		}
	}

	public int getCurrentLevel(int unitIndex, int reqIndex) {
		return progress[unitIndex][reqIndex];
	}

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
