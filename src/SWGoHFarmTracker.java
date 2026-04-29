import java.util.Scanner;

public class SWGoHFarmTracker {
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		EventUnits[] units = createAllUnits();
		ProgressTracker tracker = new ProgressTracker(units.length, 20);
		
		
		// This automatically checks for a progress.txt file in the project directory and imports data if so.
		tracker.loadProgress();
		
		System.out.println("--------------------------------------------------------------");
		System.out.println("           Star Wars Galaxy of Heroes Farm Tracker            ");
		System.out.println("--------------------------------------------------------------");
		
		boolean running = true;
		
		// This will always loop the tracker back to the main menu when the user has fully navigated each menu.
		while (running) {
			System.out.println("Main Menu:");
			System.out.println("1. List all trackable Event Units");
			System.out.println("2. View and update progress");
			System.out.println("3. Reset all progress");
			System.out.println("4. Exit");
			System.out.print("Choose (1-4): ");
			
			int choice = input.nextInt();
			
			System.out.println();
			
			// This executes the necessary command based on the user input.
			if (choice == 1) {
				listUnits(units);
			} else if (choice == 2) {
				viewAndUpdate(units, tracker, input);
			} else if (choice == 3) {
				System.out.print("Are you sure uou want to reset ALL progress? (y/n): ");
				String confirm = input.next().trim().toLowerCase();
				if (confirm.equals("y")) {
					tracker.resetAllProgress();
				} else {
					System.out.println("Reset cancelled.");
				}
			} else if (choice == 4) {
				System.out.println("Goodbye, Old Friend. May the Force be with You.");
				running = false;
			} else {
				System.out.println("Please enter a valid option");
			}
			
			System.out.println();
		}
		

		
		input.close();
	}
	
	public static EventUnits[] createAllUnits() {
		EventUnits[] units = new EventUnits[25]; // 10 Galactic Legends + 3 Galactic Legend Ships + 12 key legendaries
		
		// This initializes every journey unit and their requirements.
		
		// Galactic Legends
		
		// 0 == Rey
		units[0] = new EventUnits("Rey", 13);
		units[0].addRequirement(new Requirement("Rey (Jedi Training)", false, 7));
		units[0].addRequirement(new Requirement("Finn", false, 5));
		units[0].addRequirement(new Requirement("Resistance Trooper", false, 5));
		units[0].addRequirement(new Requirement("Rey Scavenger", false, 7));
		units[0].addRequirement(new Requirement("Resitance Pilot", false, 3));
		units[0].addRequirement(new Requirement("Poe Dameron", false, 5));
		units[0].addRequirement(new Requirement("Resitance Hero Finn", false, 5));
		units[0].addRequirement(new Requirement("Amilyn Holdo", false, 5));
		units[0].addRequirement(new Requirement("Rose Tico", false, 5));
		units[0].addRequirement(new Requirement("Resitance Hero Poe", false, 5));
		units[0].addRequirement(new Requirement("BB-8", false, 7));
		units[0].addRequirement(new Requirement("Veteran Smuggler Chewbacce", false, 3));
		units[0].addRequirement(new Requirement("Raddus", true, 5));
		
		// 1 == Supreme Leader Kylo Ren
		units[1] = new EventUnits("Supreme Leader Kylo Ren", 13);
		units[1].addRequirement(new Requirement("Kylo Ren (Unmasked)", false, 7));
		units[1].addRequirement(new Requirement("First Order Stormtrooper", false, 5));
		units[1].addRequirement(new Requirement("First Order Officer", false, 5));
		units[1].addRequirement(new Requirement("Kylo Ren", false, 7));
		units[1].addRequirement(new Requirement("Captain Phasma", false, 5));
		units[1].addRequirement(new Requirement("First Order Executioner", false, 5));
		units[1].addRequirement(new Requirement("Veteran Smuggle Han Solo", false, 3));
		units[1].addRequirement(new Requirement("Sith Trooper", false, 5));
		units[1].addRequirement(new Requirement("First Order Special Forces TIE Pilot", false, 3));
		units[1].addRequirement(new Requirement("General Hux", false, 5));
		units[1].addRequirement(new Requirement("First Order TIE Pilot", false, 3));
		units[1].addRequirement(new Requirement("Emperor Palpatine", false, 7));
		units[1].addRequirement(new Requirement("Finalizer", true, 5));
		
		// 2 == Sith Eternal Emperor
		units[2] = new EventUnits("Sith Eternal Emperor", 15);
		units[2].addRequirement(new Requirement("Emperor Palpatine", false, 7));
		units[2].addRequirement(new Requirement("Darth Vader", false, 7));
		units[2].addRequirement(new Requirement("Royal Guard", false, 3));
		units[2].addRequirement(new Requirement("Admiral Piett", false, 5));
		units[2].addRequirement(new Requirement("Director Krennic", false, 4));
		units[2].addRequirement(new Requirement("Darth Sidious", false, 7));
		units[2].addRequirement(new Requirement("Darth Maul", false, 4));
		units[2].addRequirement(new Requirement("Count Dooku", false, 6));
		units[2].addRequirement(new Requirement("Sith Marauder", false, 7));
		units[2].addRequirement(new Requirement("Imperial Tie Bomber", true, 6));
		units[2].addRequirement(new Requirement("Jedi Knight Anakin", false, 7));
		units[2].addRequirement(new Requirement("Grand Admiral Thrawn", false, 6));
		units[2].addRequirement(new Requirement("Grand Moff Tarkin", false, 3));
		units[2].addRequirement(new Requirement("General Veers", false, 3));
		units[2].addRequirement(new Requirement("Colonel Stark", false, 3));
		
		// 3 == Jedi Master Luke Skywalker
		units[3] = new EventUnits("Jedi Master Luke Skywalker", 15);
		units[3].addRequirement(new Requirement("Obi-Wan Kenobi (Old Ben)", false, 5));
		units[3].addRequirement(new Requirement("Rey (Jedi Training)", false, 7));
		units[3].addRequirement(new Requirement("C-3PO", false, 5));
		units[3].addRequirement(new Requirement("Mon Mothma", false, 5));
		units[3].addRequirement(new Requirement("Threepio & Chewie", false, 5));
		units[3].addRequirement(new Requirement("Jedi Knight Luke Skywalker", false, 7));
		units[3].addRequirement(new Requirement("R2-D2", false, 7));
		units[3].addRequirement(new Requirement("Han Solo", false, 6));
		units[3].addRequirement(new Requirement("Chewbacca", false, 6));
		units[3].addRequirement(new Requirement("Rebel Y-Wing", true, 6));
		units[3].addRequirement(new Requirement("Princess Leia", false, 3));
		units[3].addRequirement(new Requirement("Hermit Yoda", false, 5));
		units[3].addRequirement(new Requirement("Wedge Antilles", false, 3));
		units[3].addRequirement(new Requirement("Biggs Darklighter", false, 3));
		units[3].addRequirement(new Requirement("Lando Calrissian", false, 5));
		
		// 4 == Jedi Master Kenobi
		units[4] = new EventUnits("Jedi Master Kenobi", 15);
		units[4].addRequirement(new Requirement("General Kenobi", false, 8));
		units[4].addRequirement(new Requirement("Negotiator", true, 7));
		units[4].addRequirement(new Requirement("Mace Windu", false, 3));
		units[4].addRequirement(new Requirement("Aayla Secura", false, 3));
		units[4].addRequirement(new Requirement("Bo-Katan Kryze", false, 5));
		units[4].addRequirement(new Requirement("Qui-Gon Jinn", false, 3));
		units[4].addRequirement(new Requirement("IG-100 MagnaGuard", false, 5));
		units[4].addRequirement(new Requirement("Clone Sergeant - Phase I", false, 5));
		units[4].addRequirement(new Requirement("Wat Tambor", false, 7));
		units[4].addRequirement(new Requirement("General Grievous", false, 7));
		units[4].addRequirement(new Requirement("Cad Bane", false, 5));
		units[4].addRequirement(new Requirement("CC-2224 \"Cody\"", false, 5));
		units[4].addRequirement(new Requirement("Jango Fett", false, 7));
		units[4].addRequirement(new Requirement("Shaak Ti", false, 7));
		units[4].addRequirement(new Requirement("Grand Master Yoda", false, 8));
		
		// 5 == Lord Vader
		units[5] = new EventUnits("Lord Vader", 15);
		units[5].addRequirement(new Requirement("Hunter", false, 5));
		units[5].addRequirement(new Requirement("Tech", false, 5));
		units[5].addRequirement(new Requirement("Wrecker", false, 5));
		units[5].addRequirement(new Requirement("Tusken Raider", false, 5));
		units[5].addRequirement(new Requirement("Padme Amidala", false, 8));
		units[5].addRequirement(new Requirement("Embo", false, 5));
		units[5].addRequirement(new Requirement("Echo (501st)", false, 7));
		units[5].addRequirement(new Requirement("Echo (Bad Batch)", false, 5));
		units[5].addRequirement(new Requirement("Count Dooku", false, 8));
		units[5].addRequirement(new Requirement("Zam Wessel", false, 7));
		units[5].addRequirement(new Requirement("BTL-B Y-Wing Starfighter", true, 7));
		units[5].addRequirement(new Requirement("Grand Moff Tarkin", false, 7));
		units[5].addRequirement(new Requirement("ARC Trooper", false, 8));
		units[5].addRequirement(new Requirement("General Skywalker", false, 8));
		units[5].addRequirement(new Requirement("Nute Gunray", false, 7));
		
		// 6 == Jabba The Hutt
		units[6] = new EventUnits("Jabba the Hutt", 15);
		units[6].addRequirement(new Requirement("Krrsantan", false, 5));
		units[6].addRequirement(new Requirement("Han Solo", false, 8));
		units[6].addRequirement(new Requirement("Gamorrean Guard", false, 3));
		units[6].addRequirement(new Requirement("Outrider", true, 7));
		units[6].addRequirement(new Requirement("Greedo", false, 6));
		units[6].addRequirement(new Requirement("Skiff Guard (Lando Calrissian", false, 5));
		units[6].addRequirement(new Requirement("Jedi Knight Luke Skywalker", false, 7));
		units[6].addRequirement(new Requirement("Jawa", false, 3));
		units[6].addRequirement(new Requirement("URoRRuR'R'R", false, 4));
		units[6].addRequirement(new Requirement("C-3PO", false, 7));
		units[6].addRequirement(new Requirement("Boushh (Leia Organa)", false, 5));
		units[6].addRequirement(new Requirement("Aurra Sing", false, 6));
		units[6].addRequirement(new Requirement("Fennec Shand", false, 7));
		units[6].addRequirement(new Requirement("Boba Fett", false, 7));
		units[6].addRequirement(new Requirement("Mob Enforcer", false, 3));
		
		// 7 == Leia Organa
		units[7] = new EventUnits("Leia Organa", 15);
		units[7].addRequirement(new Requirement("Captain Rex", false, 7));
		units[7].addRequirement(new Requirement("Princess Kneesaa", false, 7));
		units[7].addRequirement(new Requirement("Wicket", false, 3));
		units[7].addRequirement(new Requirement("Lando Calrissian", false, 5));
		units[7].addRequirement(new Requirement("Admiral Ackbar", false, 3));
		units[7].addRequirement(new Requirement("Scout Trooper", false, 7));
		units[7].addRequirement(new Requirement("R2-D2", false, 8));
		units[7].addRequirement(new Requirement("Captain Han Solo", false, 5));
		units[7].addRequirement(new Requirement("Rebel Officer Leia Organa", false, 5));
		units[7].addRequirement(new Requirement("Chief Chirpa", false, 3));
		units[7].addRequirement(new Requirement("Captain Drogan", true, 7));
		units[7].addRequirement(new Requirement("Commander Luke Skywalker", false, 7));
		units[7].addRequirement(new Requirement("Boushh (Leia Organa)", false, 5));
		units[7].addRequirement(new Requirement("Threepio & Chewie", false, 7));
		units[7].addRequirement(new Requirement("Lobot", false, 3));
		
		// 8 == Ahsoka Tano
		units[8] = new EventUnits("Ahsoka Tano", 16);
		units[8].addRequirement(new Requirement("Ahsoka Tano (Snips)", false, 9));
		units[8].addRequirement(new Requirement("General Skywalker", false, 8));
		units[8].addRequirement(new Requirement("Asajj Ventress", false, 5));
		units[8].addRequirement(new Requirement("Night Trooper", false, 7));
		units[8].addRequirement(new Requirement("Commander Ahsoka Tano", false, 9));
		units[8].addRequirement(new Requirement("Captain Enoch", false, 7));
		units[8].addRequirement(new Requirement("Death Trooper (Peridea)", false, 7));
		units[8].addRequirement(new Requirement("Ezra Bridger", false, 7));
		units[8].addRequirement(new Requirement("Ahsoka Tano (Fulcrum)", false, 9));
		units[8].addRequirement(new Requirement("CT-7567 \"Rex\"", false, 7));
		units[8].addRequirement(new Requirement("Barriss Offee", true, 5));
		units[8].addRequirement(new Requirement("Padawan Sabine Wren", false, 7));
		units[8].addRequirement(new Requirement("General Syndulla", false, 5));
		units[8].addRequirement(new Requirement("Plo Koon", false, 8));
		units[8].addRequirement(new Requirement("Huyang", false, 7));
		units[8].addRequirement(new Requirement("Ahsoka Tano's Starfighter", true, 7));
		
		// 9 == Pirate King Hondo Ohnaka
		units[9] = new EventUnits("Pirate King Hondo Ohnaka", 16);
		units[9].addRequirement(new Requirement("Captain Ithano", false, 3));
		units[9].addRequirement(new Requirement("Hondo Ohnaka", false, 9));
		units[9].addRequirement(new Requirement("Veteran Smuggler Chewbacca", false, 7));
		units[9].addRequirement(new Requirement("Ezra Bridger", false, 6));
		units[9].addRequirement(new Requirement("Quiggold", false, 5));
		units[9].addRequirement(new Requirement("Kix", false, 6));
		units[9].addRequirement(new Requirement("General Skywalker", false, 9));
		units[9].addRequirement(new Requirement("Rey (Scavenger)", false, 8));
		units[9].addRequirement(new Requirement("Brutus", false, 7));
		units[9].addRequirement(new Requirement("Vane", false, 7));
		units[9].addRequirement(new Requirement("General Kenobi", false, 9));
		units[9].addRequirement(new Requirement("Chirrut Imwe", false, 5));
		units[9].addRequirement(new Requirement("Captain Silvo", false, 7));
		units[9].addRequirement(new Requirement("Count Dooku", false, 8));
		units[9].addRequirement(new Requirement("Bossk", false, 8));
		units[9].addRequirement(new Requirement("Rey's Millennium Falcon", true, 7));
		
		// Galactic Legend Ships
		
		// 10 == Executor
		units[10] = new EventUnits("Executor", 14);
		units[10].addRequirement(new Requirement("Darth Vader", false, 7));
		units[10].addRequirement(new Requirement("Admiral Piett", false, 8));
		units[10].addRequirement(new Requirement("Boba Fett", false, 8));
		units[10].addRequirement(new Requirement("Dengar", false, 5));
		units[10].addRequirement(new Requirement("IG-88", false, 5));
		units[10].addRequirement(new Requirement("Bossk", false, 5));
		units[10].addRequirement(new Requirement("Imperial TIE Fighter Pilot", false, 5));
		units[10].addRequirement(new Requirement("TIE Advanced x1", true, 7));
		units[10].addRequirement(new Requirement("Imperial TIE Bomber", true, 7));
		units[10].addRequirement(new Requirement("Hound's Tooth", true, 7));
		units[10].addRequirement(new Requirement("Slave I", true, 7));
		units[10].addRequirement(new Requirement("IG-2000", true, 7));
		units[10].addRequirement(new Requirement("Imperial TIE Fighter", true, 7));
		units[10].addRequirement(new Requirement("Razor Crest", true, 7));
		
		// 11 == Profundity
		units[11] = new EventUnits("Profundity", 14);
		units[11].addRequirement(new Requirement("Admiral Raddus", false, 9));
		units[11].addRequirement(new Requirement("Cassian Andor", false, 8));
		units[11].addRequirement(new Requirement("Dash Rendar", false, 7));
		units[11].addRequirement(new Requirement("Mon Mothma", false, 5));
		units[11].addRequirement(new Requirement("Bistan", false, 5));
		units[11].addRequirement(new Requirement("Jyn Erso", false, 5));
		units[11].addRequirement(new Requirement("Hera Syndulla", false, 5));
		units[11].addRequirement(new Requirement("Outrider", true, 7));
		units[11].addRequirement(new Requirement("Cassian's U-Wing", true, 7));
		units[11].addRequirement(new Requirement("Bistan's U-Wing", true, 7));
		units[11].addRequirement(new Requirement("Wedge Antilles's X-Wing", true, 7));
		units[11].addRequirement(new Requirement("Biggs Darklighter's X-Wing", true, 7));
		units[11].addRequirement(new Requirement("Rebel Y-Wing", true, 7));
		units[11].addRequirement(new Requirement("Ghost", true, 7));
		
		// 12 == Leviathan
		units[12] = new EventUnits("Leviathan", 16);
		units[12].addRequirement(new Requirement("Darth Revan", false, 9));
		units[12].addRequirement(new Requirement("Darth Malak", false, 9));
		units[12].addRequirement(new Requirement("Sith Empire Trooper", false, 7));
		units[12].addRequirement(new Requirement("Sith Trooper", false, 7));
		units[12].addRequirement(new Requirement("Darth Maul", false, 7));
		units[12].addRequirement(new Requirement("HK-47", false, 7));
		units[12].addRequirement(new Requirement("Bastila Shan", false, 7));
		units[12].addRequirement(new Requirement("Sith Assassin", false, 5));
		units[12].addRequirement(new Requirement("50R-T", false, 5));
		units[12].addRequirement(new Requirement("Fury Class Interceptor", true, 7));
		units[12].addRequirement(new Requirement("Mark VI Interceptor", true, 7));
		units[12].addRequirement(new Requirement("TIE Dagger", true, 7));
		units[12].addRequirement(new Requirement("B-28 Extinction-class Bomber", true, 7));
		units[12].addRequirement(new Requirement("Scimitar", true, 7));
		units[12].addRequirement(new Requirement("Sith Fighter", true, 7));
		units[12].addRequirement(new Requirement("Ebon Hawk", true, 7));
		
		// General Legendary and Epic Confrontations
		
		// 13 == Darth Malak
		units[13] = new EventUnits("Darth Malak", 12);
		units[13].addRequirement(new Requirement("Jedi Knight Revan", false, 3));
		units[13].addRequirement(new Requirement("Bastila Shan", false, 3));
		units[13].addRequirement(new Requirement("Jolee Bindo", false, 3));
		units[13].addRequirement(new Requirement("Mission Vao", false, 3));
		units[13].addRequirement(new Requirement("Zaalbar", false, 3));
		units[13].addRequirement(new Requirement("T3-M4", false, 3));
		units[13].addRequirement(new Requirement("Darth Revan", false, 3));
		units[13].addRequirement(new Requirement("Bastila Shan (Fallen)", false, 3));
		units[13].addRequirement(new Requirement("HK-47", false, 3));
		units[13].addRequirement(new Requirement("Canderous Ordo", false, 3));
		units[13].addRequirement(new Requirement("Carth Onasi", false, 3));
		units[13].addRequirement(new Requirement("Juhani", false, 3));
		
		// 14 == General Skywalker
		units[14] = new EventUnits("General Skywalker", 13);
		units[14].addRequirement(new Requirement("Negotiator", true, 7));
		units[14].addRequirement(new Requirement("Endurance", true, 7));
		units[14].addRequirement(new Requirement("Anakin's Eta-2 Starfighter", true, 7));
		units[14].addRequirement(new Requirement("Padme Amidala", false, 3));
		units[14].addRequirement(new Requirement("General Kenobi", false, 3));
		units[14].addRequirement(new Requirement("Shaak Ti", false, 3));
		units[14].addRequirement(new Requirement("C-3PO", false, 3));
		units[14].addRequirement(new Requirement("Ahsoka Tano (Snips)", false, 3));
		units[14].addRequirement(new Requirement("Asajj Ventress", false, 3));
		units[14].addRequirement(new Requirement("IG-100 MagnaGuard", false, 3));
		units[14].addRequirement(new Requirement("B1 Battle Droid", false, 3));
		units[14].addRequirement(new Requirement("B2 Super Battle Droid", false, 3));
		units[14].addRequirement(new Requirement("Droideka", false, 3));
		
		// 15 == Jedi Knight Luke Skywalker
		units[15] = new EventUnits("Jedi Knight Luke Skywalker", 11);
		units[15].addRequirement(new Requirement("Wampa", false, 3));
		units[15].addRequirement(new Requirement("Commander Luke Skywalker", false, 3));
		units[15].addRequirement(new Requirement("C-3PO", false, 3));
		units[15].addRequirement(new Requirement("Chewbacca", false, 3));
		units[15].addRequirement(new Requirement("Captain Han Solo", false, 3));
		units[15].addRequirement(new Requirement("Rebel Officer Leia Organa", false, 3));
		units[15].addRequirement(new Requirement("Han's Millennium Falcon", true, 7));
		units[15].addRequirement(new Requirement("Wedge Antilles's X-Wing", true, 7));
		units[15].addRequirement(new Requirement("Hermit Yoda", false, 3));
		units[15].addRequirement(new Requirement("Lando Calrissian", false, 3));
		units[15].addRequirement(new Requirement("Darth Vader", false, 3));
		
		// 16 == Bo-Katan (Mand'alor)
		units[16] = new EventUnits("Bo-Katan (Mand'alor)", 4);
		units[16].addRequirement(new Requirement("Kelleran Beq", false, 7));
		units[16].addRequirement(new Requirement("Paz Vizla", false, 7));
		units[16].addRequirement(new Requirement("IG-12 & Grogu", false, 7));
		units[16].addRequirement(new Requirement("The Mandalorian (Beskar Armor)", false, 7));
		
		// 17 == Baylan Skoll
		units[17] = new EventUnits("Baylan Skoll", 5);
		units[17].addRequirement(new Requirement("Shin Hati", false, 7));
		units[17].addRequirement(new Requirement("Marrok", false, 7));
		units[17].addRequirement(new Requirement("Morgan Elsbeth", false, 7));
		units[17].addRequirement(new Requirement("Great Mothers", false, 7));
		units[17].addRequirement(new Requirement("Grand Admiral Thrawn", false, 7));
		
		// 18 == Starkiller
		units[18] = new EventUnits("Starkiller", 4);
		units[18].addRequirement(new Requirement("Dash Rendar", false, 5));
		units[18].addRequirement(new Requirement("Kyle Katarn", false, 5));
		units[18].addRequirement(new Requirement("Darth Talon", false, 5));
		units[18].addRequirement(new Requirement("Mara Jade, The Emperor's Hand", false, 5));
		
		// 19 == Grand Inquisitor
		units[19] = new EventUnits("Grand Inquisitor", 5);
		units[19].addRequirement(new Requirement("Second Sister", false, 5));
		units[19].addRequirement(new Requirement("Ninth Sister", false, 5));
		units[19].addRequirement(new Requirement("Seventh Sister", false, 5));
		units[19].addRequirement(new Requirement("Eighth Brother", false, 5));
		units[19].addRequirement(new Requirement("Fifth Brother", false, 5));
		
		// 20 == Doctor Aphra
		units[20] = new EventUnits("Doctor Aphra", 4);
		units[20].addRequirement(new Requirement("Hondo Ohnaka", false, 5));
		units[20].addRequirement(new Requirement("0-0-0", false, 5));
		units[20].addRequirement(new Requirement("BT-1", false, 5));
		units[20].addRequirement(new Requirement("Sana Starros", false, 5));
		
		// 21 == Jar Jar Binks
		units[21] = new EventUnits("Jar Jar Binks", 4);
		units[21].addRequirement(new Requirement("Boss Nass", false, 5));
		units[21].addRequirement(new Requirement("Captain Tarpals", false, 5));
		units[21].addRequirement(new Requirement("Gungan Boomadier", false, 5));
		units[21].addRequirement(new Requirement("Gungan Phalanx", false, 5));
		
		// 22 == Jedi Master Mace Windu
		units[22] = new EventUnits("Jedi Master Mace Windu", 6);
		units[22].addRequirement(new Requirement("CC-1119 \"Appo\"", false, 5));
		units[22].addRequirement(new Requirement("CX-2", false, 5));
		units[22].addRequirement(new Requirement("Disguised Clone Trooper", false, 5));
		units[22].addRequirement(new Requirement("RC-1262 \"Scorch\"", false, 5));
		units[22].addRequirement(new Requirement("Temple Guard", false, 5));
		units[22].addRequirement(new Requirement("Depa Billaba", false, 5));
		
		// 23 == Maul (Hate-Fueled)
		units[23] = new EventUnits("Maul (Hate-Fueled)", 6);
		units[23].addRequirement(new Requirement("Stormtrooper Luke", false, 6));
		units[23].addRequirement(new Requirement("IG-90", false, 6));
		units[23].addRequirement(new Requirement("Yoda & Chewie", false, 6));
		units[23].addRequirement(new Requirement("Asajj Ventress (Dark Disciple)", false, 6));
		units[23].addRequirement(new Requirement("Inquisitor Barriss", false, 6));
		units[23].addRequirement(new Requirement("Darth Vader (Duel's End)", false, 6));
		
		// 24 == Cassian Andor (Undercover)
		units[24] = new EventUnits("Cassian Andor (Undercover)", 6);
		units[24].addRequirement(new Requirement("Kleya Marki", false, 6));
		units[24].addRequirement(new Requirement("Vel Sartha", false, 6));
		units[24].addRequirement(new Requirement("Cinta Kaz", false, 6));
		units[24].addRequirement(new Requirement("Dedra Meero", false, 6));
		units[24].addRequirement(new Requirement("Major Partagaz", false, 6));
		units[24].addRequirement(new Requirement("KX Security Droid", false, 6));
		
		return units;
	}
	
	// This method is used to print out a list of every unit that is available to track.
	public static void listUnits(EventUnits[] units) {
		System.out.println("All Trackable Event Units:");
		for (int i = 0; i < units.length; i++) {
			System.out.printf("%d. %s%n", i + 1, units[i].name);
		}
		
		System.out.println();
	}
	
	// This method utilizes listUnits() and allows the user to modify the values for each requirement.
	public static void viewAndUpdate(EventUnits[] units, ProgressTracker tracker, Scanner input) {
		listUnits(units);
		
		System.out.print("Enter number: ");
		int unitChoice = input.nextInt() - 1;
		System.out.println();
		
		// This aborts to the main menu if the value is not valid.
		if (unitChoice < 0 || unitChoice >= units.length) {
			System.out.println("Invalid option");
			return;
		}
		
		// This returns the appropriate unit requirements for the user choice.
		EventUnits unit = units[unitChoice];
		int[] currentLevels = new int[unit.numRequirements];
		
		for (int i = 0; i < unit.numRequirements; i++) {
			currentLevels[i] = tracker.getCurrentLevel(unitChoice,  i);
		}
		
		unit.printAll(currentLevels);
		
		System.out.print("Update any values? (y/n): ");
		String answer = input.next().trim().toLowerCase();
		System.out.println();
		
		if (answer.equals("y")) {
			System.out.print("Enter requirement number: ");
			int reqNum = input.nextInt() - 1;
			System.out.println();
			
			// This updates the appropriate unit's level based on the last prompt.
			if (reqNum >= 0 && reqNum < unit.numRequirements) {
				System.out.print("New Level: ");
				int newLevel = input.nextInt();
				System.out.println();
				tracker.updateProgress(unitChoice, reqNum, newLevel);
				System.out.println("Updated!");
			}
		}
				
		
	}

}
