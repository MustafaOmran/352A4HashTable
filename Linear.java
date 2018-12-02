
public class Linear extends HashTable{
	int size;
	static int numberofCollision =0;
	static String resize= null;

	public Linear(int n) {
		super(n);
		size = 0; 
		
		for (int i=0 ; i < table.length ; i++ ) 
			table[i] = new MyLinkedList();
	}
	
	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0; 
	}
	
	public String get(int k) {
		int input = 0; 
		String temp1 = null; 
		for (int i =hashCode(Math.abs(k), table.length); table[i] != null  && input != table.length; i ++) {
			if (table[i].getnodeKey() == k) {
			temp1 = table[i].getnodeValue(); 
			break; 
			}
			if ( (i+1) == table.length) {
				i = -1;
			}
			input++; 
		}
		return temp1; 
	}

	public String put(int k, String value) {
		int probes = 0;
		Map temp = new Map (k, value); 
		String temp1 = null; 
		
		int i = temp.hashCode(Math.abs(k), table.length);
		
		int input =0;
		for (; table[i] != null && table[i].getnodeValue() != "available" && input != table.length ; i ++) {
			

			if (table[i].getnodeKey() == k) {
				temp1 = table[i].findseparate(temp, "put");
				break; 
			}
			if ((i+1) == table.length) {
				i = -1;
			}
			numberofCollision++; 
			probes++;
			input++;
		}
		if (temp1 == null) {
			temp1 = table[temp.hashCode(Math.abs(k), table.length)].findseparate(temp,"put");
			size++; 
		}
		
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
		Map temp = new Map (k, "available"); 
		String temp1 = null; 
		int i =hashCode(Math.abs(k), table.length);
		for (; table[i] != null ; i ++) {
			if (table[i].getnodeKey() == k || table[i].getnodeValue() == "available" ) {
				temp1 = table[i].findseparate(temp, "put");
				break; 
				}
			if ((i+1) == table.length) {
				i = -1;
			}
		}
		if (temp1 == null)
			size--; 
		return temp1;
	}

}
