package day4;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import reader.ReadFile;

public class Day4 {
	private static String filename = "src/day4/day4.txt";
	private static ReadFile rf = new ReadFile();
	private static List<String> theList = new ArrayList<>();
	//private static List<NightGuard> guardsList = new ArrayList<>();
	private static Map<String, int[]> mapOfGuards = new LinkedHashMap<>();
	
	public static void main(String[] args) {
		theLoop();
		
	}

	private static void theLoop() {
		try {
			String[] lines = rf.readLines(filename);

			for (String line : lines) {
				theList.add(line);
			}

		} catch (IOException e) {
			// Print out the exception that occurred
			System.out.println("Unable to create " + filename + ": " + e.getMessage());
		}
		
		Collections.sort(theList);
		
		String id = "";
		int startSleep = 0;
		int wakeUp = 0;
		
		for(String line : theList) {
			//System.out.println(line);
			int minute = Integer.parseInt(line.substring(line.indexOf(":")+1, line.indexOf(":")+3));
			if(line.contains("begins")) {
				id = line.substring(line.indexOf("#")+1, line.indexOf("begins")-1);
				//System.out.println(id);
			}
			if(line.contains("falls")) {
				startSleep = minute;
			}
			if(line.contains("up")) {
				wakeUp = minute;
				
				if(!mapOfGuards.containsKey(id)) { // does not contain this guard
					int[] result = new int[60];
					for(int i = 0; i < 60; i++) {
						if(i >= startSleep && i < wakeUp) {
							result[i]++;
						}
					}
					mapOfGuards.put(id, result);
				} else { // contains this guard
					for(int i = 0; i < 60; i++) {
						if(i >= startSleep && i < wakeUp) {
							mapOfGuards.get(id)[i]++;
						}
					}
					
				}
			}
		}
		
		Set<String> idKeySet = mapOfGuards.keySet();
		String maxId = "";
		int maxSleep = 0;
		for(String s : idKeySet) {
			//System.out.println("Guard ID: " + s + " ");
			//printSleep(mapOfGuards.get(s));
			int best = addSleepMinutes(mapOfGuards.get(s));
			if(best > maxSleep) {
				maxSleep = best;
				maxId = s;
			}
		}
		
		System.out.println("Guard: " + maxId + " slept for: " + maxSleep + " minutes in total.");
		
		int finalResult = printSleep(mapOfGuards.get(maxId));
		finalResult *= Integer.parseInt(maxId);
		System.out.println("Strategy 1: " + finalResult);
		System.out.println();
		
		int maximumMinutesSlept = 0;
		String maxSleeperGuard = "";
		int minuteOfMaximumSleep = 0;
		
		for(String s : idKeySet) {
			int[] max = maximumMinutesSleptCalculator(mapOfGuards.get(s));
			if(max[0] > maximumMinutesSlept) {
				maximumMinutesSlept = max[0];
				maxSleeperGuard = s;
				minuteOfMaximumSleep = max[1];
			}
		}

		
		System.out.println("Guard ID: " + maxSleeperGuard + " slept for " + maximumMinutesSlept + " at minute " + minuteOfMaximumSleep);
		int strategy2Answer = minuteOfMaximumSleep * Integer.parseInt(maxSleeperGuard);
		System.out.println("Strategy 2: " + strategy2Answer);
		
		System.out.println();
		printSleep(mapOfGuards.get(maxSleeperGuard));

	}
	
	private static int printSleep(int[] list) {
		for (int i = 0; i < 60; i++) {
			if(i < 10) {
				System.out.print("0" + i + " ");
			} else {
				System.out.print(i + " ");
			}
		}
		System.out.println();
		for (int i = 0; i < 60; i++) {
			System.out.print(list[i] + "  ");
		}
		System.out.println();
		
		int maxMinute = 0;
		int maxSleep = 0;
		for (int i = 0; i < 60; i++) {
			if (list[i] > maxSleep){
				maxSleep = list[i];
				maxMinute = i;
			}
		}
		System.out.println("MaxMinute: " + maxMinute + " slept for: " + maxSleep);
		
		return maxMinute;
	}
	
//	private static int maximumMinutesSleptCalculator(int[] list) {
//		int maxMinute = 0;
//		int maxSleep = 0;
//		for (int i = 0; i < 60; i++) {
//			if (list[i] > maxSleep){
//				maxSleep = list[i];
//				maxMinute = i;
//			}
//		}
//		return maxSleep;
//	}
	
	private static int[] maximumMinutesSleptCalculator(int[] list) {
		int maxMinute = 0;
		int maxSleep = 0;
		for (int i = 0; i < 60; i++) {
			if (list[i] > maxSleep){
				maxSleep = list[i];
				maxMinute = i;
			}
		}

		return new int[] {maxSleep, maxMinute};
	}
	
	private static int addSleepMinutes(int[] list) {
		int result = 0;
		
		for (int i = 0; i < 60; i++) {
			result += list[i];
		}
		return result;
	}

}