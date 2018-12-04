package day3;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import reader.ReadFile;

public class Day3 {
	private static String filename = "src/day3/day3.txt";
	private static ReadFile rf = new ReadFile();

	public static void main(String[] args) {
		theLoop();
		// duplicateTester();

	}

	private static void theLoop() {
		List<Fabric> fabricsList = new ArrayList<>();
		try {
			String[] lines = rf.readLines(filename);

			for (String line : lines) {
				fabricsList.add(fabricMaker(line));
			}

		} catch (IOException e) {
			// Print out the exception that occurred
			System.out.println("Unable to create " + filename + ": " + e.getMessage());
		}

		int maxX = 0;
		int maxY = 0;
		for (Fabric f : fabricsList) {
			if (f.getFromTheLeft() + f.getWidth() > maxX) {
				maxX = f.getFromTheLeft() + f.getWidth();
			}
			if (f.getFromTheTop() + f.getHeight() > maxY) {
				maxY = f.getFromTheTop() + f.getHeight();
			}
		}

		int[][] matrix = new int[maxY][maxX];

		for (int y = 0; y < maxY; y++) {
			for (int x = 0; x < maxX; x++) {
				for (Fabric f : fabricsList) {
					int yStart = f.getFromTheTop();
					int yEnd = f.getFromTheTop() + f.getHeight() - 1;
					int xStart = f.getFromTheLeft();
					int xEnd = f.getFromTheLeft() + f.getWidth() - 1;
					if (y >= yStart && y <= yEnd && x >= xStart && x <= xEnd) {
						matrix[y][x]++;
					}
				}
			}
		}
		int sum = 0;

		for (int y = 0; y < maxY; y++) {
			for (int x = 0; x < maxX; x++) {
				// System.out.print(matrix[y][x] + " "); //comment out not to print
				if (matrix[y][x] > 1) {
					sum++;
				}
			}
			// System.out.println(); //comment out not to print
		}

		System.out.println();
		System.out.println("Sum is: " + sum);

		for (Fabric f : fabricsList) {
			// System.out.println("ID :#" + f.getId());
			boolean only1s = true;
			int yStart = f.getFromTheTop();
			int yEnd = f.getFromTheTop() + f.getHeight();
			int xStart = f.getFromTheLeft();
			int xEnd = f.getFromTheLeft() + f.getWidth();
			for (int y = yStart; y < yEnd; y++) {
				for (int x = xStart; x < xEnd; x++) {
					// System.out.print(matrix[y][x] + " ");

					if (matrix[y][x] > 1) {
						only1s = false;
						break;
					}
				}
				// System.out.println();
			}

			// System.out.println("----------------------------------");
			if (only1s) {
				System.out.println("Winnning ID is: #" + f.getId());
				for (int y = yStart; y < yEnd; y++) {
					for (int x = xStart; x < xEnd; x++) {
						System.out.print(matrix[y][x] + " ");
					}
					System.out.println();
				}

				break;
			}
		}

		/*
		 * int[][] blah = new int[5][7];
		 * 
		 * for(int i = 0; i < 5; i++) { for(int j = 0; j < 7; j++) {
		 * System.out.print(blah[i][j] + " "); } System.out.println(); } int[][] blah =
		 * new int[5][7];
		 * 
		 * for (int i = 0; i < 5; i++) { for (int j = 0; j < 7; j++) { blah[i][j] = j;
		 * if(blah[i][j] == 3) { break; } System.out.print(blah[i][j] + " ");
		 * 
		 * } System.out.println(); }
		 * 
		 */
	}

//	private static void theLoop() {
//		List<Fabric> fabricsList = new ArrayList<>();
//		List<Fabric> checkedFabricsList = new ArrayList<>();		
//
//		int checkedDuplicate = 0;	
//		int area = 0;
//
//		try {
//			String[] lines = rf.readLines(filename);
//
//			for (String line : lines) {
//				fabricsList.add(fabricMaker(line));
//			}
//
//		} catch (IOException e) {
//			// Print out the exception that occurred
//			System.out.println("Unable to create " + filename + ": " + e.getMessage());
//		}
//
////		Fabric f1 = fabricMaker("#1 @ 387,801: 11x22");
////		Fabric f2 = fabricMaker("#2 @ 101,301: 19x14");
////		
////		System.out.println(doOverlap(f1, f2));
//		
//		for(int i = 0; i < fabricsList.size(); i++) {
//			for(int j = 0; j < fabricsList.size(); j++) {
//				Fabric f1 = fabricsList.get(i);
//				Fabric f2 = fabricsList.get(j);
//				if (doOverlap(f1, f2) && !checkedFabricsList.contains(f2)) {
//					
//					Rectangle rect1 = new Rectangle(f1.getFromTheLeft(), f1.getFromTheTop(), f1.getWidth(), f1.getHeight());
//					Rectangle rect2 = new Rectangle(f2.getFromTheLeft(), f2.getFromTheTop(), f2.getWidth(), f2.getHeight());
//					Rectangle intersection = rect1.intersection(rect2);
//					
//					//System.out.println(f1);
//					//System.out.println(f2);
//					
//					int y = intersection.height;
//					//System.out.println("Intersection height: " + y);
//					int x = intersection.width;
//					//System.out.println("Interserction width: " + x);
//					int areanew = x * y;
//					//System.out.println("Interserction area: " + areanew);
//					area += areanew;
//					
//					checkedDuplicate++;
//					//System.out.println("---------------");
//				}
//				
//			}
//			checkedFabricsList.add(fabricsList.get(i));
//		}
//		
////		for(Fabric f : checkedFabricsList) {
////			System.out.println(f);
////		}
//		
//		System.out.println(fabricsList.size());
//		System.out.println(checkedFabricsList.size());
//		System.out.println("Checked duplicates: " +checkedDuplicate);
//		
///*
//		for (Fabric f1 : fabricsList) {
//			for (Fabric f2 : fabricsList) {
//				if (doOverlap(f1, f2) && !checkedFabricsList.contains(f1)) {
//					//System.out.println(f1 + " and " + f2 + " OVERLAP\n");
//					// calculate intersection area
//					
//					Rectangle rect1 = new Rectangle(f1.getFromTheLeft(), f1.getFromTheTop(), f1.getWidth(), f1.getHeight());
//					Rectangle rect2 = new Rectangle(f2.getFromTheLeft(), f2.getFromTheTop(), f2.getWidth(), f2.getHeight());
//					Rectangle intersection = rect1.intersection(rect2);
//					
//					int x = intersection.height;
//					int y = intersection.width;
//					int areanew = x * y;
//					System.out.println(areanew);
//					area += areanew;
//					
//
//					int K = f1.getFromTheLeft(); // x left
//					int P = f2.getFromTheLeft();
//
//					int M = f1.getFromTheLeft() + f1.getWidth(); // x right
//					int R = f2.getFromTheLeft() + f2.getWidth();
//
//					int L = f1.getFromTheTop() + f1.getHeight(); // y bottom
//					int Q = f2.getFromTheTop() + f2.getHeight();
//
//					int N = f1.getFromTheTop(); // y top
//					int S = f2.getFromTheTop();
//
//					int left = Math.max(K, P);
//					int right = Math.min(M, R);
//					int bottom = Math.min(L, Q);
//					int top = Math.max(N, S);
//
//					int interSection = (right - left) * (top - bottom);
//					int unionArea = ((M - K) * (N - L)) + ((R - P) * (S - Q))- interSection;
//
//					System.out.println(interSection);
//
//					area += interSection;
//					
//					
//				}
//			}
//			checkedFabricsList.add(f1);
//		}
//*/
//		
//		System.out.println("Area is: " + area);
//	}
//
//	private static boolean doOverlap(Fabric f1, Fabric f2) {
//		if (f1.equals(f2)) {
//			return false;
//		}
//		if (f2.getFromTheTop() > f1.getFromTheTop() + f1.getHeight()
//				|| f2.getFromTheTop() + f2.getHeight() < f1.getFromTheTop()) {
//			return false;
//		}
//		if (f1.getFromTheLeft() > f2.getFromTheLeft() + f2.getWidth()
//				|| f1.getFromTheLeft() + f1.getWidth() < f2.getFromTheLeft()) {
//			return false;
//		}
//		return true;
//	}

	private static Fabric fabricMaker(String line) {
		String[] parts = line.split("[#\\s@,:x]");
		String[] parts2 = new String[5];

		int counter = 0;
		for (int i = 0; i < parts.length; i++) {
			if (!parts[i].isEmpty()) {
				parts2[counter] = parts[i];
				counter++;
			}
		}
		int id = Integer.parseInt(parts2[0]);
		int fromTheLeft = Integer.parseInt(parts2[1]);
		int fromTheTop = Integer.parseInt(parts2[2]);
		int width = Integer.parseInt(parts2[3]);
		int height = Integer.parseInt(parts2[4]);
		Fabric fabric = new Fabric(id, fromTheLeft, fromTheTop, width, height);

		return fabric;
	}

//	public static void duplicateTester() {
//		List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5);
//		List<Integer> checked = new ArrayList<>();
//
//		for (Integer i : list1) {
//			for (Integer j : list1) {
//				if (!checked.contains(j)) {
//					System.out.println("i: " + i + " j: " + j);
//				}
//
//			}
//			checked.add(i);
//			System.out.println("----------");
//		}
//	}

}

/*
 * The four square inches marked with X are claimed by both 1 and 2. (Claim 3,
 * while adjacent to the others, does not overlap either of them.)
 * 
 * If the Elves all proceed with their own plans, none of them will have enough
 * fabric. How many square inches of fabric are within two or more claims?
 */
