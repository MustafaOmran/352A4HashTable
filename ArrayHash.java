
public class ArrayHash extends hashtable {
	int size; 
	
	public ArrayHash (int n) {
		super(n);
		size =0; 
	}
	
	public boolean isEmpty() {
		return size == 0; 
	}
	
	public String get(map k) {
		String temp1 = null; 
		temp1 = table[k.hasCode(k.getKey(), table.length)].findfindseparate(k,"get");
		return temp1; 
	}

	public String put(int k, String value) {
		map temp = new map (k, value); 
		String temp1 = null; 
		temp1 = table[temp.hasCode(k, table.length)].findfindseparate(temp,"put");
		return temp1; 
	}
	
	

	@Override
	public String remove(int k) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
