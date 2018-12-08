package day6;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import reader.ReadFile;

public class ActualWork {
	private String filename = "src/day6/x.txt";
	private ReadFile rf = new ReadFile();
	private List<String> theList;
	private int[] xCoordinate;
	private int[] yCoordinate;
	private int maxX;
	private int maxY;

	public ActualWork() {
		try {
			theList = rf.readLinesAsList(filename);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void start() {
		fillArrays();
		fillMaxAndMin();
		printMatrix();
		
		//to be continued
	}

	private void printMatrix() {
		
		
		for (int y = 0; y <= maxY; y++) {
			for (int x = 0; x <= maxX; x++) {
				boolean hasIt = false;
				for (int i = 0; i < xCoordinate.length; i++) {
					if (y == yCoordinate[i] && x == xCoordinate[i]) {
						hasIt = true;
						break;
					}
				}
				if(hasIt) {
					System.out.print("X");
				} else {
					System.out.print(".");
				}
			}
			System.out.println(); // comment out not to print
		}
	}

	private void fillArrays() {
		xCoordinate = new int[theList.size()];
		yCoordinate = new int[theList.size()];
		
		for (int i = 0; i < theList.size(); i++) {

			String eden = theList.get(i);
			String prvS = eden.substring(0, eden.indexOf(","));
			int x = Integer.parseInt(prvS);
			String vtorS = eden.substring(eden.indexOf(",") + 2);
			int y = Integer.parseInt(vtorS);

			xCoordinate[i] = x;
			yCoordinate[i] = y;
		}
	}

	private void printArray(int[] array) { //tester
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}

	private void fillMaxAndMin() {
		maxX = Arrays.stream(xCoordinate).max().getAsInt();
		maxY = Arrays.stream(yCoordinate).max().getAsInt();
	}

}
