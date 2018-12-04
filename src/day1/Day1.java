package day1;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import reader.ReadFile;

public class Day1 {
	private static String filename = "src/day1/day1.txt";
	private static int sum = 0;
	private static List<Integer> listOfSums = new ArrayList<>();
	private static int firstRepeatedFrequency = 0;
	private static ReadFile rf = new ReadFile();

	public static void main(String[] args) {
		int loopInterval = 0;
		
//		theLoop(); za eden loop
		while(firstRepeatedFrequency == 0) {
			theLoop();
			System.out.println("Loop interval: " + loopInterval);
			loopInterval++;
		}
        
	}
	
	private static void theLoop() {
		System.out.println("Sum is: " + sum);
        try
        {
            String[] lines = rf.readLines(filename);
         
            for (String line : lines) 
            {
            	sum += Integer.parseInt(line);
            	if(listOfSums.contains(sum)) {
            		firstRepeatedFrequency = sum;
            		System.out.println("firstRepeatedFrequency is ".toUpperCase() + firstRepeatedFrequency);
            		break;
            	}
            	listOfSums.add(sum);
            	//System.out.println("Adding or subtracting " + line);
                //System.out.println("Current sum is: " + sum);
            }
        }
        catch(IOException e)
        {
            // Print out the exception that occurred
            System.out.println("Unable to create "+filename+": "+e.getMessage());              
        }
        
        System.out.println("Final sum is: " + sum);
	}

}
