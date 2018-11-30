import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Random;

public class Driver {
	public static void main(String[] args) throws FileNotFoundException {
		Random random = new Random();
		
		for (int resolution = 1; resolution <= 3; resolution++) {
			if (resolution == 1) {
				PrintWriter print = new PrintWriter (new FileOutputStream("SeparateChainingOutput.txt")); 
				Separate h1 = new Separate(100);
				Map[] keys = new Map[50];
				long startTime;
				
				print.println("Put: ");
				for (int i = 0; i < keys.length; i++) {
					Map pair = new Map(Integer.toString(random.nextInt()));
					keys[i] = pair;
					startTime = System.currentTimeMillis();
					print.println(h1.put(pair.getKey(), pair.getValue()) + ". Time elapsed: " + Long.toString(System.currentTimeMillis() - startTime) + "  milliseconds.");
				}
				
				print.println("\nGet: ");
				for (int i = 0; i < keys.length; i++) {
					startTime = System.currentTimeMillis();
					print.println("Value gotten: " + h1.get(keys[i].getKey()) + " -- Time elapsed: " + Long.toString(System.currentTimeMillis() - startTime) + "  milliseconds.");
				}
				
				print.println("\nRemoved: ");
				for (int i = 0; i < 25; i++) {
					startTime = System.currentTimeMillis();
					print.println("Value removed: " + h1.remove(keys[i].getKey()) + "\tTime elapsed: " + Long.toString(System.currentTimeMillis() - startTime) + "  milliseconds.");
				}
				print.close();
			}	else if (resolution == 2) {
				PrintWriter print = new PrintWriter (new FileOutputStream("LinearProbingOutput.txt")); 
				Linear h2 = new Linear(100);
				Map[] keys = new Map[50];
				long startTime;
				
				print.println("Put: ");
				for (int i = 0; i < keys.length; i++) {
					Map pair = new Map(Integer.toString(random.nextInt()));
					keys[i] = pair;
					startTime = System.currentTimeMillis();
					print.println(h2.put(pair.getKey(), pair.getValue()) + ". Time elapsed: " + Long.toString(System.currentTimeMillis() - startTime) + "  milliseconds.");
				}
				
				print.println("\nGet: ");
				for (int i = 0; i < keys.length; i++) {
					startTime = System.currentTimeMillis();
					print.println(h2.get(keys[i].getKey()) + "Time elapsed: " + Long.toString(System.currentTimeMillis() - startTime) + "  milliseconds.");
				}
				
				print.println("\nRemoved: ");
				for (int i = 0; i < 25; i++) {
					startTime = System.currentTimeMillis();
					print.println(h2.remove(keys[i].getKey()));
					print.println("Time elapsed: " + Long.toString(System.currentTimeMillis() - startTime) + "  milliseconds.");
				}
				print.close();
			} 
//			else if (resolution == 3) {
//				PrintWriter print = new PrintWriter (new FileOutputStream("QuadraticProbingOutput.txt")); 
//				Quadratic h3 = new Quadratic(100);
//				Map[] keys = new Map[50];
//				long startTime;
//				
//				print.println("Put: ");
//				for (int i = 0; i < keys.length; i++) {
//					Map pair = new Map(Integer.toString(random.nextInt()));
//					keys[i] = pair;
//					startTime = System.currentTimeMillis();
//					print.println(h3.put(pair.getKey(), pair.getValue()) + ". Time elapsed: " + Long.toString(System.currentTimeMillis() - startTime) + "  milliseconds.");
//					print.println("Time elapsed: " + Long.toString(System.currentTimeMillis() - startTime) + "  milliseconds.");
//				}
//				
//				print.println("\nGet: ");
//				for (int i = 0; i < keys.length; i++) {
//					startTime = System.currentTimeMillis();
//					print.println(h3.get(keys[i].getKey()));
//					print.println("Time elapsed: " + Long.toString(System.currentTimeMillis() - startTime) + "  milliseconds.");
//				}
//				
//				print.println("\nRemoved: ");
//				for (int i = 0; i < 25; i++) {
//					startTime = System.currentTimeMillis();
//					print.println(h3.remove(keys[i].getKey()));
//					print.println("Time elapsed: " + Long.toString(System.currentTimeMillis() - startTime) + "  milliseconds.");
//				}
//				print.close();
//			}
		}
		
		
		
		
	}
}
