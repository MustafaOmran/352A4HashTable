
public abstract class hashtable extends map {
	MyLinkedList table[]; 
	
	public hashtable (int n) {
		table =new MyLinkedList [n]; 
	}
	
	public abstract boolean isEmpty() ;
	
	public abstract String get(int k); 
	
	public abstract String put(int k, String value);

	public abstract String remove(int k); 
	
	public abstract int size();
}
