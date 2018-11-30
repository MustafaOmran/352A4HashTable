
public class Linear extends HashTable{
	int size;
	static int numberofCollision =0;
	static String resize= null;

	public Linear(int n) {
		super(n);
		size = 0; 
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
		table[temp.hashCode(Math.abs(k), table.length)] = new MyLinkedList();
		
		for (; table[i] != null && table[i].getnodeKey() != -2 ; i ++) {
			if (table[i].getnodeKey() == k) {
				temp1 = table[i].findseparate(temp, "put");
				break; 
			}
			
			if ( (i+1) == table.length) {
				i = -1;
			}
			numberofCollision++; 
			probes++;
		}
		if (temp1 == null) {
			temp1 = table[temp.hashCode(Math.abs(k), table.length)].findseparate(temp,"put");
		}
		
		String extra = "Value retrived =  "+temp1 +", the size of table is " + table.length +",  number of elements = " + (size +1) +
				"\nProbed: " + probes;
		size++; 
		if (size >= table.length/2  &&resize != null ) {
			MyLinkedList table2[] = new MyLinkedList [table.length*table.length]; 
			
			for (int m=0 ; m< table2.length ; m++) {
				table[m] = table[m]; 
			}
			table = table2; 
		}
		return extra; 
	}

	@Override
	public String remove(int k) {
		
		Map temp = new Map (-2, "available"); 
		String temp1 = null; 
		int i =hashCode(Math.abs(k), table.length);
		for (; table[i] != null ; i ++) {
			if (table[i].getnodeKey() == k || table[i].getnodeKey() == -2 ) {
				temp1 = table[i].findseparate(temp, "put");
				break; 
				}
			if ( (i+1) == table.length) {
				i = -1;
			}
		}
		String extra = "Value retrived =  "+temp1 +", the size of table is " + table.length +",  number of elements = " + size;
		size--; 
		return extra;
	}

}
