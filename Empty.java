/**
 * if the list is Empty throw this exception
 * @author Mustafa Omran - Muherthan Thalayasingam 
 *
 */
public class Empty extends RuntimeException {
	Empty () {
		super("The class array is Empty, please fill the array before removing elements");
	}
}
