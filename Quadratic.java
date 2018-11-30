

public class Quadratic extends HashTable{
	int size;
	static int numberofCollision =0 ; 
	
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
		int i =hasCode(k, table.length);
		int input = 0; 
		while (table[i] != null && input != table.length) {
			if (table[i].getnodeKey() == k) {
			temp1 = table[i].getnodeValue(); 
			break; 
			}
			i = hasCode((k+i*i), table.length); 
			input++; 
		}
		return temp1; 
	}

	public String put(int k, String value) {
		int probes = 0;
		Map temp = new Map (k, value); 
		String temp1 = null; 
		int input = 0; 
		int i =hasCode(k, table.length);
		while (table[i] != null &&  table[i].getnodeKey() != -2 &&  input != table.length ) {
			if (table[i].getnodeKey() == k) {
				temp1 = table[i].findseparate(temp, "put");
				i = hasCode((k+i*i), table.length);
				break; 
			}
			
			i = hasCode((k+i*i), table.length); 
			input++;

			numberofCollision++; 
			probes++;
		}
		
		if (temp1 == null) {
			table[i].findseparate(temp, "put");
		}
		
		System.out.println("Value retrived =  "+temp1 +", the size of table is " + table.length +",  number of elements = " + size);
		System.out.println("Probed: " + probes);
		size++; 
		return temp1; 
	}

	@Override
	public String remove(int k) {
		
		Map temp = new Map (-2, "available"); 
		String temp1 = null; 
		int input = 0; 
		int i =hasCode(k, table.length);
		while (table[i] != null &&  table[i].getnodeKey() != -2 &&  input != table.length ) {
			if (table[i].getnodeKey() == k) {
				temp1 = table[i].findseparate(temp, "put");
				break;
				}
			i = hasCode((k+i*i), table.length); 
			input++;
		}
		System.out.println("Value retrived =  "+temp1 +", the size of table is " + table.length +",  number of elements = " + size);
		size--; 
		return temp1;
	}

}
