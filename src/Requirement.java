
public class Requirement {
	String name;
	boolean isShip;
	int requiredLevel;
	
	public Requirement(String n, boolean ship, int level) {
		name = n;
		isShip = ship;
		requiredLevel = level;
	}
	
	public void printInfo(int i, int currentLevel) {
		String type = isShip ? "Stars" : "Relics";
		String status = (currentLevel >= requiredLevel) ? " (COMPLETE)" : "";
		System.out.printf("%d. %s - Current: %d / %d %s%s%n", i + 1, name, currentLevel, requiredLevel, type, status);
	}

}
