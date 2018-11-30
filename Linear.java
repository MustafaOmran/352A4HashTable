
public class Linear extends HashTable{
	int size;
	static int numberofCollision =0;
	
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
		for (int i =hasCode(k, table.length); table[i] != null  && input != table.length; i ++) {
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
		int i =hasCode(k, table.length);
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
		int i =hasCode(k, table.length);
		for (; table[i] != null ; i ++) {
			if (table[i].getnodeKey() == k || table[i].getnodeKey() == -2 ) {
				temp1 = table[i].findseparate(temp, "put");
				break; 
				}
			if ( (i+1) == table.length) {
				i = -1;
			}
		}
		System.out.println("Value retrived =  "+temp1 +", the size of table is " + table.length +",  number of elements = " + size);
		size--; 
		return temp1;
	}

}
