
public class EventUnits {
	
	String name;
	Requirement[] requirements;
	int numRequirements;
	
	public EventUnits(String unitName, int maxReqs) {
		name = unitName;
		requirements = new Requirement[maxReqs];
		numRequirements = 0;
	}
	
	public void addRequirement(Requirement r) {
		if (numRequirements < requirements.length) {
			requirements[numRequirements] = r;
			numRequirements++;
		}
	}
	
	public void printAll(int[] currentLevels) {
		System.out.printf("%n%n--- %s ---%n", name);
		int completedCount = 0;
		
		for (int i = 0; i < numRequirements; i++) {
			requirements[i].printInfo(i, currentLevels[i]);
			if (currentLevels[i] >= requirements[i].requiredLevel) {
				completedCount++;
			}
		}
		
		int percent = (int)(((double)completedCount / (double)numRequirements) * 100.0);
		
		System.out.printf("%nProgress: %d%% complete (%d / %d)%n", percent, completedCount, numRequirements);
	}

}
