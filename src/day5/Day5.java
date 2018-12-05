package day5;

public class Day5 {
	
	public static void main(String[] args) {
		long startTime = System.nanoTime();
		
		ActualWork aw = new ActualWork();
		aw.Start();
	
		long endTime = System.nanoTime();
		System.out.println("Took "+(endTime - startTime) + " ns"); 
	}

}