package day5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import reader.ReadFile;

public class ActualWork {

	private String polimer;
	// private String endPolimer; ? should it be a list?
	private List<Character> pList = new ArrayList<>();
	// private Map<Character, Integer> charToPlimerLengthMap = new HashMap<>();

	private String filename = "src/day5/day5.txt";
	// private ReadFile rf = new ReadFile();

	public void Start() {

		polimer = usingBufferedReader(filename);
		turnToArray(polimer);

//		List<Character> newList = new ArrayList<>(pList);

		// printPolimerCharList(pList);

		// processPolimer(pList);

		// printPolimerCharList(pList);

		// System.out.println("Units left: " + pList.size());

//		printPolimerCharList(newList);
//		List<Character> clensed = clenseListFromChar(newList, 'a');
//		System.out.println("========================================================================================");
//		printPolimerCharList(clensed);

		clenseProcessAndPrint(pList);

//		char ch1 = 'z';
//		char ch2 = 'Z';
//		System.out.println(Character.toLowerCase(ch1) == Character.toLowerCase(ch2));
//		System.out.println(Character.toLowerCase(ch1));
//		System.out.println(Character.toLowerCase(ch2));

	}

	private void clenseProcessAndPrint(List<Character> list) {
		char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		char[] alphabet2 = "v".toCharArray();
		int size = 0;
		int minSize = 999999999;
		char minSizeChar = 'a';

		for (int i = 0; i < alphabet.length; i++) {
			char ch = alphabet[i];
			List<Character> theList = clenseListFromChar(list, ch);

			// System.out.println("before processing, after clensing:");
			// printPolimerCharList(theList);

			processPolimer(theList);
			size = theList.size();
			if (size < minSize) {
				minSize = size;
				minSizeChar = ch;
			}

//			System.out.println("Showing list clensed of: " + ch);
//			printPolimerCharList(theList);
//
			System.out.println("For char |" + ch + "| size is: " + size);
//			System.out.println("checking: " + doesPolimerStillNeedProcessing(theList));
		}
		System.out.println("MinSize: " + minSize + " for char: " + minSizeChar);

	}

	private List<Character> clenseListFromChar(List<Character> list, char ch) {

		List<Character> workingList = new ArrayList<>(list);
		while (workingList.contains(Character.toLowerCase(ch)) || workingList.contains(Character.toUpperCase(ch))) {
			for (int i = 0; i < workingList.size(); i++) {
				char ch1 = Character.toLowerCase(ch);
				char ch2 = Character.toLowerCase(workingList.get(i));

				if (ch1 == ch2) {
					workingList.remove(i);
				}
			}

			for (int i = 0; i < workingList.size(); i++) {
				char ch3 = Character.toUpperCase(ch);
				char ch4 = Character.toUpperCase(workingList.get(i));

				if (ch3 == ch4) {
					workingList.remove(i);
				}
			}
		}

		return workingList;
	}

	private List<Character> clenseListFromChar2OLD(List<Character> list, char ch) {

		List<Character> workingList = new ArrayList<>(list);
		for (int i = 0; i < workingList.size(); i++) {
			char ch1 = Character.toLowerCase(ch);
			char ch2 = Character.toLowerCase(workingList.get(i));

			if (ch1 == ch2) {
//				System.out.println(ch1 + " ch1");
//				System.out.println(ch2 + " ch2");
				Character remove = workingList.remove(i);
//				System.out.println("removed " + remove);
			}
		}

		for (int i = 0; i < workingList.size(); i++) {
			char ch3 = Character.toUpperCase(ch);
			char ch4 = Character.toUpperCase(workingList.get(i));

			if (ch3 == ch4) {
//				System.out.println(ch1 + " ch1");
//				System.out.println(ch2 + " ch2");
				Character remove = workingList.remove(i);
//				System.out.println("removed " + remove);
			}
		}
		return workingList;
	}

	private boolean doesPolimerStillNeedProcessing(List<Character> pList) {
		for (int i = 0; i < pList.size() - 1; i++) {
			char first = pList.get(i);
			char next = pList.get(i + 1);
			if (Character.toLowerCase(first) == Character.toLowerCase(next)) {
				if (Character.isLowerCase(first) && Character.isUpperCase(next)
						|| Character.isLowerCase(next) && Character.isUpperCase(first)) {
					return true;
				}
			}
		}
		return false;
	}

	private void processPolimer(List<Character> pList) {
		int processNumber = 0;

		while (doesPolimerStillNeedProcessing(pList)) {
			for (int i = 0; i < pList.size() - 1; i++) {
				char first = pList.get(i);
				char next = pList.get(i + 1);
				if (Character.toLowerCase(first) == Character.toLowerCase(next)) {
					if (Character.isLowerCase(first) && Character.isUpperCase(next)
							|| Character.isLowerCase(next) && Character.isUpperCase(first)) {
						pList.remove(i);
						pList.remove(i);
						// System.out.println(first + " " + next);
					}
				}
			}
			processNumber++;
			// System.out.println("Process number: " + processNumber);
		}

	}

	private void turnToArray(String polimer) {
		for (int i = 0; i < polimer.length(); i++) {
			pList.add(polimer.charAt(i));
		}
	}

	private void printPolimerCharList(List<Character> pList) {
		for (int i = 0; i < pList.size(); i++) {
			System.out.print(pList.get(i));
			if (i != 0) {
				if (i % 100 == 0) {
					System.out.println();
				}
			}
		}
		System.out.println();
		System.out.println();
	}

//	private void printString(String inputS) {
//		
//		for(int i = 0; i < inputS.length(); i++) {
//			System.out.print(inputS.charAt(i));
//			if(i != 0) {
//				if(i % 100 == 0) {
//					System.out.println();
//				}
//			}
//			
//		}
//		System.out.println();
//		System.out.println();
//	}

	private String usingBufferedReader(String filePath) {
		StringBuilder contentBuilder = new StringBuilder();
		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

			String sCurrentLine;
			while ((sCurrentLine = br.readLine()) != null) {
				contentBuilder.append(sCurrentLine);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return contentBuilder.toString();
	}

//	private StringBuilder usingBufferedReader2(String filePath)
//	{
//	    StringBuilder contentBuilder = new StringBuilder();
//	    try (BufferedReader br = new BufferedReader(new FileReader(filePath)))
//	    {
//	 
//	        String sCurrentLine;
//	        while ((sCurrentLine = br.readLine()) != null)
//	        {
//	            contentBuilder.append(sCurrentLine).append("\n");
//	        }
//	    }
//	    catch (IOException e)
//	    {
//	        e.printStackTrace();
//	    }
//	    return contentBuilder;
//	}

}
