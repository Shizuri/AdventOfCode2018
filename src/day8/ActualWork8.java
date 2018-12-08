package day8;

import java.util.ArrayList;
import java.util.List;

import reader.ReadFile;

public class ActualWork8 {
	private String filename = "src/day8/x.txt";
	private ReadFile rf = new ReadFile();
	private String theString = rf.readSingleStringUsingBufferedReader(filename);
	private List<Integer> theList = new ArrayList<>();
	private List<Integer> metadatas = new ArrayList<>();

	public ActualWork8() {
		
	}

	public void start() {
		
		
		turnStringToList(theString);
//		printList(theList);
		calculateMetadata(theList);
		
		//printList(theList);
		System.out.println("The sum is: " + printMetadatasSum(metadatas));
	}

	
	//header(#children, #metadata)  //node size = header(2) + metadata + childrenSize
	
	// zapishi gi site metadata vo listata "metadatas", za 2 indeksa na nazad namali za 1, izvadi go hederot i metadatata od nizata
	// za del dva, vidi dali e dete na korenot i - 2 == 0;
	// 2 3 0 3 10 11 12 1 1 0 1 99 2 1 1 2
	private void calculateMetadata(List<Integer> input) {
		for (int i = 0; i < input.size(); i++) {
			if(input.get(i) == 0) { //number of children
				int numberOfMetadata = input.get(i + 1); //number of metadata
				
//				if(i - 2 == 0) { // dali e dete na korenot
//					System.out.println("namaluvam od koren, i = " + i + " ova e dete na korenot");
//					System.out.print("nodot e: #Deca = " + input.get(i-2) + ", #Metadata = " + input.get(i-1));
//					for(int z = 0; z < input.get(i-1); z++) {
//						System.out.print(" chlen: " + input.get(i + z));
//					}
//					System.out.println();
//				}
				
//				System.out.println("number of metadata: " + numberOfMetadata);
				for (int j = i + 2; j < i + 2 + numberOfMetadata; j++) {  
					metadatas.add(input.get(j));
//					System.out.print("METADATA: " + input.get(j) + " ");  //presmetaj(ispechati) ja brojkata
				}
//				System.out.println();
				//System.out.println("input.get(i) is: " + input.get(i - 2));
				if(!(input.get(i + 1) == input.size() - 2)) {
					input.set(i - 2, input.get(i - 2)-1);  //za 2 indeksa na nazad namali za 1
					//System.out.println("input.get(i) is: " + input.get(i - 2));
				}
				
				for(int j = 0; j < 2 + numberOfMetadata; j++) {  // izvadi go hederot i metadatata od nizata
//					System.out.println("removing: " + input.get(i));
					input.remove(i);
				}
				i = 0;
//				printList(input);
			}
		}
		
		for (int i = 0; i < input.size(); i++) {  // celoto ova e samo za posledniot chlen da go izvadam
			if(input.get(i) == 0) { //number of children
				int numberOfMetadata = input.get(i + 1); //number of metadata
//				System.out.println("number of metadata: " + numberOfMetadata);
				for (int j = i + 2; j < i + 2 + numberOfMetadata; j++) {  
					metadatas.add(input.get(j));
//					System.out.print("METADATA: " + input.get(j) + " ");  //presmetaj(ispechati) ja brojkata
				}
				System.out.println();
				//System.out.println("input.get(i) is: " + input.get(i - 2));
				if(!(input.get(i + 1) == input.size() - 2)) {
					input.set(i - 2, input.get(i - 2)-1);  //za 2 indeksa na nazad namali za 1
					//System.out.println("input.get(i) is: " + input.get(i - 2));
				}
				
				for(int j = 0; j < 2 + numberOfMetadata; j++) {  // izvadi go hederot i metadatata od nizata
//					System.out.println("removing: " + input.get(i));
					input.remove(i);
				}
				i = 0;
//				printList(input);
			}
		}
		
	}
	
	private int printMetadatasSum(List<Integer> list) {
		int sum = 0;
		
		for(int x : list) {
			sum += x;
		}
		
		return sum;
	}
	
	private void printMetadata2(List<Integer> input) {
		for (int i = 0; i < input.size(); i++) {
			int numberOfChildren = input.get(i);
			int depth = numberOfChildren;
			int numberOfMetadata = input.get(i + 1);
			if(numberOfChildren == 0) {
				int j = 0;
				for (j = i + 2; j < i + 2 + numberOfMetadata; j++) {
					System.out.print(input.get(j) + " ");
				}
				i = j;
				depth --;
			}
			if(depth == 0) {
				int j = 0;
				for (j = 0; j < numberOfMetadata; j++) { //????
					System.out.print(input.get(j) + " ");
				}
				i = j;
			}
		}
	}
	
	private void turnStringToList(String input) {
		String[] s = input.split("\\s+");
		for(int i = 0 ; i < s.length; i++) {
			theList.add(Integer.parseInt(s[i]));
		}
	}
	
	private void printList(List<Integer> list) {
		for(int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");
			if(i != 0) {
				if(i % 90 == 0) {
					System.out.println();
				}
			}
			
		}
		System.out.println();
		System.out.println("^ full list");
	}
	

}
