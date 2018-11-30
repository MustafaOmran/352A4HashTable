import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Random;

public class Driver {
	public static void main(String[] args) throws FileNotFoundException {
		PrintWriter print = new PrintWriter (new FileOutputStream("Output.txt")); 
		Random random = new Random();
		
		Separate h1 = new Separate(100);
		Linear h2 = new Linear(100);
		Quadratic h3 = new Quadratic(100);
		
		Map[] keys = new Map[50];
		
		print.println("Put: ");
		for (int i = 0; i < keys.length; i++) {
			Map pair = new Map(Integer.toString(random.nextInt()));
			keys[i] = pair;
//			print.println(h1.put(pair.getKey(), pair.getValue()));
			print.println(h2.put(pair.getKey(), pair.getValue()));
		}
		
		print.println("\nGet: ");
		for (int i = 0; i < keys.length; i++) {
//			print.println(h1.get(keys[i].getKey()));
			print.println(h2.get(keys[i].getKey()));
		}
		
		print.println("\nRemoved: ");
		for (int i = 0; i < 25; i++) {
//			print.println(h1.remove(keys[i].getKey()));
			print.println(h2.remove(keys[i].getKey()));
		}
		print.close();
	}
}
