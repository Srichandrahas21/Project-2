/* 	
 * Project 2
 * <Brief project description: 
 * This java project is a java program for a game that reads a list of characters from a file 
 * and shows different options to the user. These options are displaying characters in alphabetical order
 * finding characters by a certain super power/attack ability sorting by power level calculating total power
 * and quitting the program and whatever option you choose that result will pop up on the console and then the 
 * loop continues until you quit.>
 * 
*/

// importing java tools

import java.util.Scanner;
import java.util.Random;
import java.io.*;

public class HeroDriver {

	// methods that need to be used throughout the file
	// max hero is a constant
	private static final int MaxHero = 100;
	private static int heroCount = 0;
	private static boolean running = true;
	private static Hero[] heroes = new Hero[MaxHero];

	/**
	 * Reads hero data from a file, displays the menu, and processes user input.
	 * 
	 * @param args
	 * @throws IOException
	 * @throws NumberFormatException
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {

		// name of the file to read
		String filename = "heroInfo.txt";

		// Use BufferedReader to read the file
		FileReader fr = new FileReader(filename);
		BufferedReader inputFile = new BufferedReader(fr);
		String line;

		// Read all of the lines in the file and get the heroes
		while ((line = inputFile.readLine()) != null && heroCount < MaxHero) {

			// Use Scanner to parse the line with a delimiter
			Scanner lineScanner = new Scanner(line);

			// Setting the delimiter to a comma
			lineScanner.useDelimiter(",\\s*");

			if (lineScanner.hasNext()) {
				// getting info from line and trimming the whitespace
				String name = lineScanner.next().trim();
				char type = lineScanner.next().trim().charAt(0);
				int health = Integer.parseInt(lineScanner.next().trim());
				double power = Double.parseDouble(lineScanner.next().trim());
				String attackAbility = lineScanner.next().trim();

				// Randomize health from -5 to 5
				Random rand = new Random();
				health += (rand.nextInt(11) - 5);

				// creates new object and adds it to array
				heroes[heroCount] = new Hero(name, type, health, power, attackAbility);
				heroCount++;
			}

			// closing the scanner object
			lineScanner.close();
		}

		inputFile.close();

		Scanner scanner = new Scanner(System.in);

		// while loop that keeps the program running or not running
		while (running) {
			displayMenu();
			int choice = scanner.nextInt();
			menuChoice(choice);
		}

		scanner.close();
	}

	/**
	 * this method is used to display the options of methods to run.
	 */
	private static void displayMenu() {
		// printing each option
		System.out.println();
		System.out.println("Menu");
		System.out.println("1.Show all of the heroes alphabetically sorted by name from A to Z");
		System.out.println("2.Find heroes with a specific attack ability");
		System.out.println("3.Show all of the heroes sorted by power level from least to greatest");
		System.out.println("4.Calculate total power level of all of the heroes.");
		System.out.println("5.Quit the program");
	}

	/**
	 * this method is for the user to select the options of methods to run.
	 * 
	 * @param choice the option that was chosen.
	 */
	private static void menuChoice(int choice) {

		// switch statement with the method options to choose from
		switch (choice) {
		case 1:
			sortedByName();
			break;
		case 2:
			Scanner keyboard = new Scanner(System.in);
			System.out.println("Input the power you're looking for:");
			String attackAbility = keyboard.nextLine();
			findCharactersByAttackAbility(attackAbility);
			break;
		case 3:
			sortedByPower();
			break;
		case 4:
			System.out.println("Total power of all the characters: " + totalPower());
			break;
		case 5:
			quit();
			break;
		default:
			System.out.println("Invalid Choice please choose a option between 1-5.");
		}
	}

	/**
	 * this method sets the running boolean to false so that the while loop that
	 * runs stops running and the program stops.
	 */
	private static void quit() {
		System.out.println("Quitting...");
		running = false;
	}

	/**
	 * this method copies the original array info and sorts the heros names in the
	 * array by alphabetical order with bubble sort.
	 */
	private static void sortedByName() {
		// new array
		Hero[] nameSortedHeroes = new Hero[heroCount];
		// copying array info
		for (int i = 0; i < heroCount; i++) {
			nameSortedHeroes[i] = heroes[i];
		}

		// loop through each hero in the array
		for (int i = 0; i < heroCount - 1; i++) {
			// loop compares each hero with the next hero in the array
			for (int j = 0; j < heroCount - i - 1; j++) {
				// compares the name of each hero
				if (nameSortedHeroes[j].getName().compareToIgnoreCase(nameSortedHeroes[j + 1].getName()) > 0) {
					// Swap heroes
					Hero temp = nameSortedHeroes[j];
					nameSortedHeroes[j] = nameSortedHeroes[j + 1];
					nameSortedHeroes[j + 1] = temp;
				}
			}
		}

		System.out.println("Heroes sorted by name:");
		for (int i = 0; i < heroCount; i++) {
			System.out.println(nameSortedHeroes[i]);
		}
	}

	/**
	 * This method finds and prints all of the characters with a specific attack
	 * ability that was typed into the console.
	 * 
	 * @param attackAbility the attack ability that was typed
	 */
	public static void findCharactersByAttackAbility(String attackAbility) {
		System.out.println("Characters with  the attack ability " + attackAbility + ": ");
		// loop checks to see if any heros attack ability matches with the input
		for (int i = 0; i < heroCount; i++) {
			if (heroes[i].getAttackAbility().equalsIgnoreCase(attackAbility)) {
				System.out.println(heroes[i]);
			}
		}
	}

	/**
	 * this method copies the original array and sorts the heros in order by their
	 * power level with bubble sort.
	 */
	public static void sortedByPower() {
		// new array
		Hero[] powerSortedHeroes = new Hero[heroCount];

		// copy array info
		for (int i = 0; i < heroCount; i++) {
			powerSortedHeroes[i] = heroes[i];
		}

		// loop through each hero in the array
		for (int i = 0; i < heroCount - 1; i++) {
			// loop compares each hero with the next hero in the array
			for (int j = 0; j < heroCount - i - 1; j++) {
				// compares the name of each hero
				if (powerSortedHeroes[j].getPower() > powerSortedHeroes[j + 1].getPower()) {
					// Swap heroes if the current hero has a higher power than the next one
					Hero temp = powerSortedHeroes[j];
					powerSortedHeroes[j] = powerSortedHeroes[j + 1];
					powerSortedHeroes[j + 1] = temp;
				}
			}
		}

		System.out.println("Heroes sorted by power:");
		for (int i = 0; i < heroCount; i++) {
			System.out.println(powerSortedHeroes[i]);
		}
	}

	/**
	 * this method calculates the total power of all of the heros in the array.
	 * 
	 * @return totalPower the power level of each hero added up
	 */
	public static double totalPower() {
		double totalPower = 0;
		// the for loop reads each hero in the array
		for (int i = 0; i < heroCount; i++) {
			// adding the power of each hero in the array to the total power
			totalPower += heroes[i].getPower();
		}
		return totalPower;
	}
}
