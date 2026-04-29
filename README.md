# SWGoH Farm Tracker

A console-based progress tracker for *Star Wars: Galaxy of Heroes* (SWGoH) players to monitor their farming progress toward **Galactic Legends**, Legendary units, and key ships.

Built as a Java application using object-oriented programming principles.

## Project Description

**SWGoH Farm Tracker** helps players keep track of the relic levels (for characters) and star levels (for ships) required to unlock high-value Galactic Legend and Legendary characters in SWGoH.

The program includes 25 major units (primarily Galactic Legends and select legendaries), each with their specific requirements. Users can view progress, see completion percentages, and update current relic/star levels as they farm.

## Features and Functionality

- **List all trackable units** — View all 25 supported Galactic Legend / Legendary units.
- **View detailed progress** — For any unit, see every requirement with current vs. required level, completion status, and overall progress percentage.
- **Update progress** — Easily update relic or star levels for individual requirements.
- **Persistent tracking during session** — Progress is stored in memory via the `ProgressTracker` class (Will support file saving in future commit).
- **Clear, formatted console output** with visual completion indicators.

### Supported Units
- Rey
- Supreme Leader Kylo Ren
- Sith Eternal Emperor
- Jedi Master Luke Skywalker
- Jedi Master Kenobi
- Lord Vader
- Jabba the Hutt
- Leia Organa
- Ahsoka Tano
- Pirate King Hondo Ohnaka
- Executor
- Profundity
- Leviathan
- And many more (including newer units Baylan Skoll, Cassian Andor (Undercover), and Maul (Hate-Fueled)

## How to Run the Program

### Prerequisites
- Java Development Kit (JDK) 8 or higher installed
- A terminal / command prompt

### Steps

1. **Compile the Java files** (in the project directory containing all `.java` files):

``` bash
javac *.java
```

2. Run the program

``` bash
java SWGoHFarmTracker
```

3. Follow the on-screen menu:
   Option 1: List all trackable Event Units
   Option 2: View and Update progress for specific unit
   Option 3: Exit

## Concepts from Programming Principles 1 Used in the Project

1. Java Fundamentals
- Variables, data types, and expressions (Ch. 1–2)
- Conditional statements such as if and else expressions (Ch. 3)
- Loops using for and while loops (Ch. 5)
- Methods with parameters and return values (Ch. 6)
2. Strings, Characters, and Math
- String processing (Ch. 4)
- Mathematical functions (Ch. 4)
3. Arrays and Data Organization
- Single-dimensional arrays (Ch. 7)
- Multi-dimensional arrays (Ch. 8)
4. Objects and Classes
- Minimum of 2 custom classes (not including Main) (Ch. 9)
- Clear separation of responsibilities between classes (Ch. 9)
- Proper encapsulation (Ch. 9)
- Objects used to model real data (Ch. 9)
5. Exception Handling and Text I/O
- Text file input or output (reading from or writing to a file) (Ch. 12)

## Reflection
### Challenges Faced
- Managing the large amount of requirement data accurately for 25 units while keeping the code maintainable.
- Handling different requirement types (relics vs. ship stars) cleanly in the Requirement class.
- Ensuring input validation to prevent crashes from invalid menu choices or array index errors.
- Balancing code readability with the extensive hardcoded unit data in createAllUnits().

### What I Learned
- How to design and implement a small multi-class Java application from scratch.
- The importance of proper class relationships and data encapsulation.
- Practical use of arrays to manage related data (progress tracking).
- Building an intuitive text-based user interface for console applications.
- Organizing code into logical modules (EventUnits, Requirement, ProgressTracker).
### Future Features
- Saving and Loading from Text FIle
- Crystal Income tracker
- Relic Material Income tracker
- Rough calculations for time to reach unit based on incomes
