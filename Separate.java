
public class Separate extends hashtable {
	int size; 
	
	public Separate (int n) {
		super(n);
		size =0; 
	}
	
	public boolean isEmpty() {
		return size == 0; 
	}
	
	public int size() {
		return size;
	}
	
	public String get(int k) {
		
		map temp = new map (k,null); 
		String temp1 = null; 
		temp1 = table[hasCode(k, table.length)].findseparate(temp,"get");
		return temp1; 
	}

	public String put(int k, String value) {
		map temp = new map (k, value); 
		String temp1 = null; 
		
		temp1 = table[temp.hasCode(k, table.length)].findseparate(temp,"put");
		System.out.println("Value retrived =  "+temp1 +", the size of table is " + table.length +",  number of elements = " + size);
		
		size++; 
		return temp1; 
	}

	@Override
	public String remove(int k) {
		map temp = new map(); 
		String temp1 = null; 
		temp1 = table[temp.hasCode(k, table.length)].findseparate(temp,"put");
		size--; 
		return temp1;
	}
	
	

}
