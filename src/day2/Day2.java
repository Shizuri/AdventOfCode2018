package day2;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import reader.ReadFile;

public class Day2 {
	private static String filename = "src/day2/day2.txt";
	private static ReadFile rf = new ReadFile();
	private static int twos = 0;
	private static int threes = 0;

	public static void main(String[] args) {
		// theLoop();
		zoranIGoran();
		// tester();


	}

	private static void tester() {
		String prvZbor = "abcd";
		String vtorZbor = "abxd";
		int brojNaRazliki = 0;

		for (int i = 0; i < prvZbor.length(); i++) {
			char prvZborBukva = prvZbor.charAt(i);
			char vtorZborBukva = vtorZbor.charAt(i);
			if (prvZborBukva != vtorZborBukva) {
				System.out.println(prvZborBukva + " ne e isto so " + vtorZborBukva);
				brojNaRazliki++;
			}
		}
	}

	private static void zoranIGoran() {
		try {
			String[] lines = rf.readLines(filename);

			for (int z = 0; z < lines.length; z++) { // vrtime zborovi od input.txt
				String prvZbor = lines[z];
				for (int j = 0; j < lines.length; j++) { // vrtime zborovi vo sporedba so prviot (z)
					String vtorZbor = lines[j];
					if (!prvZbor.equals(vtorZbor)) {
						int brojNaRazliki = 0;

						for (int i = 0; i < prvZbor.length(); i++) { // proveruvame bukvi na ista lokacija
							char prvZborBukva = prvZbor.charAt(i);
							char vtorZborBukva = vtorZbor.charAt(i);
							if (prvZborBukva != vtorZborBukva) {
								// System.out.println(prvZborBukva + " ne e isto so " + vtorZborBukva);
								brojNaRazliki++;
							}
						}
//						System.out.println("Prv  zbor: " + prvZbor);
//						System.out.println("Vtor zbor: " + vtorZbor);
//						System.out.println("Broj na razliki: " + brojNaRazliki);
//						System.out.println("-----------------");

						if (brojNaRazliki == 1) {
							System.out.println("Prv  zbor: " + prvZbor);
							System.out.println("Vtor zbor: " + vtorZbor);
							System.out.println();
						}
					}

				}

			}

//			for (String line : lines) {
//				
//			}

		} catch (IOException e) {
			// Print out the exception that occurred
			System.out.println("Unable to create " + filename + ": " + e.getMessage());
		}
	}

	private static void theLoop() {

		try {
			String[] lines = rf.readLines(filename);

			for (String line : lines) {
				boolean twoReps = false;
				boolean threeReps = false;
				List<Character> listOfTestes = new ArrayList<>();
				for (int i = 0; i < line.length(); i++) {
					char testLetter = line.charAt(i);
					int letterRepetition = 0;
					if (!listOfTestes.contains(testLetter)) {
						for (int j = 0; j < line.length(); j++) {

							if (line.charAt(j) == testLetter) {
								letterRepetition++;
								// System.out.println(line.charAt(j) + " is the same as " + testLetter);
								// System.out.println(letterRepetition);
							}
						}
						listOfTestes.add(testLetter);
						if (letterRepetition == 2) {
							twoReps = true;
							// twos++;
						}
						if (letterRepetition == 3) {
							threeReps = true;
							// threes++;
						}
					}

				}
				if (twoReps) {
					twos++;
				}
				if (threeReps) {
					threes++;
				}
				System.out.println("Word is: " + line + " two reps: " + twos + " three reps: " + threes);
			}

		} catch (IOException e) {
			// Print out the exception that occurred
			System.out.println("Unable to create " + filename + ": " + e.getMessage());
		}
		System.out.println("Twos: " + twos);
		System.out.println("Threes: " + threes);

		System.out.println("Sum: " + twos * threes);
	}

}
