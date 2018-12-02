
public class Separate extends HashTable {
	int size; 
	static String resize= null;

	public Separate (int n) {
		super(n);
		size = 0; 
		
		for (int i=0 ; i < table.length ; i ++ ) {
			table[i] = new MyLinkedList();
		}
	}
	
	public boolean isEmpty() {
		return size == 0; 
	}
	
	public int size() {
		return size;
	}
	
	public String get(int k) {
		
		Map temp = new Map (k,null); 
		String temp1 = null; 
		temp1 = table[hashCode(Math.abs(k), table.length)].findseparate(temp,"get");
		return temp1; 
	}

	public String put(int k, String value) {
		Map temp = new Map (k, value); 
		String temp1 = null; 
		temp1 = table[temp.hashCode(Math.abs(k), table.length)].findseparate(temp,"put");
		
		if (temp1 == null) 
			size++; 
		
		if (size >= table.length/2) {
			MyLinkedList table2[] = new MyLinkedList [table.length*2]; 
			
			for (int m=0 ; m< table.length ; m++) {
				table2[m] = table[m]; 
			}
			
			for (int m=table.length; m <table2.length; m++ ) {
				table2[m] = new MyLinkedList(); 
			}
			table = table2;
		}
		
		return "The size of table is " + table.length +".   number of elements = " + size + "\t Collisions: " + table[temp.hashCode(Math.abs(k), table.length)].size();
	}

	
	@Override
	public String remove(int k) {
		Map temp = new Map(); 
		String temp1 = null; 
		
		temp1 = table[temp.hashCode(Math.abs(k), table.length)].findseparate(temp,"put");
				
		if (temp1 == null)
			size--; 
		size--; 
		return temp1;
	}
	
	

}
