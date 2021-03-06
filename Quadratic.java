

public class Quadratic extends HashTable{
	int size;
	static int numberofCollision =0 ; 
	static String resize = null;
	
	public Quadratic(int n) {
		super(n);
		size = 0; 
		for (int i=0; i < table.length; i++) {
			table[i] = new MyLinkedList(); 
		}
	}
	
	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0; 
	}
	
	public String get(int k) {
		String temp1 = null; 
		int i =hashCode(Math.abs(k), table.length);
		int input = 0; 
		while (table[i] != null && input != table.length) {
			if (table[i].getnodeKey() == k && table[i].getnodeValue() != "available" ) {
			temp1 = table[i].getnodeValue(); 
			break; 
			}
			i = hashCode((1+i*i), table.length); 
			input++; 
		}
		return temp1; 
	}

	public String put(int k, String value) {
		int probes = 0;
		Map temp = new Map (k, value); 
		String temp1 = null; 
		int input = 0; 
		int i = hashCode(Math.abs(k), table.length);
		
		while (table[i].getnodeKey() !=  -2  &&  input != table.length ) {
			if (table[i].getnodeKey() == k || table[i].getnodeValue() == "available" ) {
				temp1 = table[i].findseparate(temp, "put");
				i = hashCode((1+i*i), table.length);
				break; 
			}
			
			i = hashCode((1+i*i), table.length); 
			input++;
			numberofCollision++; 
			probes++;
		}
		
		if (temp1 == null) {
			temp1 = table[temp.hashCode(Math.abs(k), table.length)].findseparate(temp,"put");
		}
		
		if (temp1 == null)
			size++;
		
		if (size >= table.length/2 ) {
			MyLinkedList table2[] = new MyLinkedList [table.length*2]; 
			
			for (int m=0 ; m< table.length ; m++) {
				table2[m] = table[m]; 
			}
			
			for (int m=table.length; m <table2.length; m++ ) {
				table2[m] = new MyLinkedList(); 
			}
			table = table2;
		}
			
		return "The size of table is " + table.length +",  number of elements = " + size + 
				"   Probed: " + probes;
	}

	@Override
	public String remove(int k) {
		k = Math.abs(k);
		Map temp = new Map (k, "available"); 
		String temp1 = null; 
		int input = 0; 
		int i =hashCode(k, table.length);
		while (table[i] != null &&  input != table.length ) {
			if (table[i].getnodeKey() == k) {
				temp1 = table[i].findseparate(temp, "put");
				break;
				}
			i = hashCode((1+i*i), table.length); 
			input++;
		}
		if (temp1 != null && temp1.equals("available")) {
			temp1 = null;
		}
		
		if (temp != null)
			size--; 
		return temp1;
	}

}
