import java.util.Random;

public class map {
	int key; 
	String value; 
	Random ran = new Random(); 
	
	public map (int k, String input) {
		key = k; 
		value = input;
	}
	
	public map (String input) {
		key = ran.nextInt(); 
		value = input;
	}
	
	public map () {
		key =0; 
		value = null; 
	}
	
	public int hasCode(int k, int q) { 
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
	
	public boolean equals (map o) {
		return key == o.getKey();
	}

}
