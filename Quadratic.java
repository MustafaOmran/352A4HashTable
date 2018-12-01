

public class Quadratic extends HashTable{
	int size;
	static int numberofCollision =0 ; 
	static String resize = null;
	
	public Quadratic(int n) {
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
		String temp1 = null; 
		int i =hashCode(Math.abs(k), table.length);
		int input = 0; 
		while (table[i] != null && input != table.length) {
			if (table[i].getnodeKey() == k) {
			temp1 = table[i].getnodeValue(); 
			break; 
			}
			i = hashCode((k+i*i), table.length); 
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
		table[temp.hashCode(Math.abs(k), table.length)] = new MyLinkedList();
		
		while (table[i] != null &&  table[i].getnodeKey() != -2 &&  input != table.length ) {
			if (table[i].getnodeKey() == k) {
				temp1 = table[i].findseparate(temp, "put");
				i = hashCode((k+i*i), table.length);
				break; 
			}
			
			i = hashCode((k+i*i), table.length); 
			input++;

			numberofCollision++; 
			probes++;
		}
		
		if (temp1 == null) {
			temp1 = table[temp.hashCode(Math.abs(k), table.length)].findseparate(temp,"put");
		}
		
		String extra = "Value retrived =  "+temp1 +", the size of table is " + table.length +",  number of elements = " + size + 
				"\nProbed: " + probes;
		size++;
		
		if (size >= table.length/2 ) {
			MyLinkedList table2[] = new MyLinkedList [table.length*table.length]; 
			
			for (int m=0 ; m < table2.length ; m++) {
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
		int input = 0; 
		int i =hashCode(k, table.length);
		while (table[i] != null &&  table[i].getnodeKey() != -2 &&  input != table.length ) {
			if (table[i].getnodeKey() == k) {
				temp1 = table[i].findseparate(temp, "put");
				break;
				}
			i = hashCode((k+i*i), table.length); 
			input++;
		}
		System.out.println("Value retrived =  "+temp1 +", the size of table is " + table.length +",  number of elements = " + size);
		size--; 
		return temp1;
	}

}
