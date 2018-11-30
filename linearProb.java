
public class linearProb extends hashtable{
	int size; 
	public linearProb(int n) {
		super(n);
		size = 0; 
	}

	public boolean isEmpty() {
		return size == 0; 
	}
	
	public String get(int k) {
		String temp1 = null; 
		for (int i =hasCode(k, table.length); table[i] != null ; i ++) {
			if (table[i].getnodeKey() == k) {
			temp1 = table[i].getnodeValue(); 
			}
			if ( (i+1) == table.length) {
				i = -1;
			}
		}
		return temp1; 
	}

	public String put(int k, String value) {
		map temp = new map (k, value); 
		String temp1 = null; 
		int i =hasCode(k, table.length);
		for (i =hasCode(k, table.length); table[i] != null ; i ++) {
			if (table[i].getnodeKey() == k) {
				temp1 = table[i].findseparate(temp, "remove");
				}
			if ( (i+1) == table.length) {
				i = -1;
			}
		}
		table[i].add(temp) ;
		System.out.println("Value retrived =  "+temp1 +", the size of table is " + table.length +",  number of elements = " + size);
		
		size++; 
		return temp1; 
	}

	@Override
	public String remove(int k) {
		
		map temp = new map (k, value); 
		String temp1 = null; 
		int i =hasCode(k, table.length);
		for (i =hasCode(k, table.length); table[i] != null ; i ++) {
			if (table[i].getnodeKey() == k) {
				temp1 = table[i].findseparate(temp, "remove");
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
