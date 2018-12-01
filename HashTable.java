
public abstract class HashTable extends Map {
	MyLinkedList table[]; 
	
	public HashTable (int n) {
		table = new MyLinkedList [n];
	}
	
	public abstract boolean isEmpty() ;
	
	public abstract String get(int k); 
	
	public abstract String put(int k, String value);

	public abstract String remove(int k); 
	
	public abstract int size();
}
