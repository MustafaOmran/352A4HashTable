import java.util.Random;

public class Map {
	int key; 
	String value; 
	Random ran = new Random(); 
	
	public Map (int k, String input) {
		key = k; 
		value = input;
	}
	
	public Map (String input) {
		key = ran.nextInt(); 
		value = input;
	}
	
	public Map () {
		key =0; 
		value = null; 
	}
	
	public int hashCode(int k, int q) { 
		return k % q; 
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	public boolean equals (Map o) {
		return key == o.getKey();
	}

}
