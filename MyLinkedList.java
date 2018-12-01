import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Implementation of linked list class through list interface
 * @author Mustafa Omran - 26745954 - Muherthan Thalayasingam - 27223064
 *The class will have generic type that holds head and tail, and have doubly linked list spefication
 * @param <E>
 */
public class MyLinkedList  {
	private Node head; 
	private Node tail;
	private int size;
	public static int numberofCollision =0; 

	/** 
	 * Constructor that initialize all attributes 
	 */
	public MyLinkedList () {
		size=0; 
		head = null; 
		tail = null;

	}
	/**
	 * private class node that hold the elemnts and pointer to the previous and next nodes. 
	 */
	private class Node  {
		Node before; 
		Node after;
		Map element; 

		/**
		 *  constructor that initialize the variables 
		 */
		Node () { 
			before = null;
			after = null;
			element= null; 
		}
		
		/**
		 * constructor that take parameter and initialize the attributes accordingly 
		 * @param after the node after 
		 * @param before the node before 
		 * @param element the element
		 */

		Node(Node after, Node before, Map element) {
			this.before = before; 
			this.after = after;
			this.element = element; 

		}
		
		/**
		 * set the element 
		 * @param e generic element
		 */

		void setElement(Map e) {
			element =  e; 
		}

		/**
		 * return the element 
		 * @return element
		 */
		Map getElement () {
			return element; 
		}
		
		/**
		 * set the next node
		 * @param next 
		 */

		void setNext(Node next) { 
			after = next;
		}
		
		/**
		 * set the previous node 
		 * @param prev takes a node 
		 */

		void setPrevious (Node prev) {
			before = prev; 
		}
		
		/** 
		 * returns the next node. 
		 * @return next node 
		 */

		Node getNext() { 
			return after;
		}

		/**
		 * return the previous node
		 * @return
		 */
		Node getPrevious () {
			return before;
		}



		/**
		 * equals method that compares if 2 elements. 
		 * @param obj takes object of node 
		 * @return true/false 
		 */
		public boolean equals(Node obj) {
			return obj.element == this.element;
		}
		
		/**
		 * a to string method for the class 
		 */
		public String toString() {
			return element+" "; 
		}


	}
	
	public int getnodeKey() {
		// changed this for the linear for loop to actually work
		if (head != null)
			return head.getElement().getKey(); 
		else
			// might need to change this value
			return -3;
	}
	
	public String getnodeValue() {
		return head.getElement().getValue(); 
	}

	
	public String findseparate(Map e, String method) {
		Node postion = head; 
		String temp = null; 
		while (postion != null) {
			if (e.getKey() == postion.getElement().getKey()) {
				temp = postion.getElement().getValue();
				
				break; 
			}
			
			postion = postion.getNext(); 
		}
		if (method.equals("put")) {
			if (postion == null) 
				head = postion = new Node(null,null,e); 
			else {
				numberofCollision++; 
				postion.setElement(e);
			}
			return temp = e.getValue(); 
		}
		else if (method.equals("get"))
			return temp; 
		else {
			remove1(e); 
			return temp;
			
		}
	}

	
	/**
	 * add an object to the end of the list
	 * @param object e 
	 * @return true if the element is added 
	 */
	public boolean add(Map e) {
		Node temp = new Node(null,null, e);  
		if (head == null) {
			head=tail=temp;
		}
		else if (head==tail) {
			head.setNext(temp);
			temp.setPrevious(head);
			temp.setNext(null);
			tail = temp; 

		}
		else {
			temp.setPrevious(tail);
			tail.setNext(temp);
			tail= temp; 
		}

		size++; 

		return true;
	}
	
	/**
	 * add an element based on index 
	 * @param Map index 
	 * @param Object element
	 */

	public void add(int index, Map element) {

		if (index > size+1 ) {
			throw new IndexGreaterThan(); 
		}

		Node postion = head; 

		if (isEmpty()) {
			Node temp = new Node(head,tail,  element); 
			head=tail= temp; 
			size++;
			return; 
		}

		if (index == 0 ) {
			
			Node temp = new Node(head,null,  element); 
			head.setPrevious(temp);
			head= temp;
			size++;
			return;
		}

		
		
		if (index == size) {
			Node temp = new Node(null, tail,  element); 
			tail.setNext(temp);

			tail= temp;
			size++;
			return; 

		}
		
		int i =0;
		
		while(i < index ) {
			postion = postion.getNext();
			i++;
		}

		Node temp = new Node(postion, postion.getPrevious(),  element);
		postion.before.setNext(temp);
		postion.setPrevious(temp);

		size++; 




	}

	/*
	 * unsupported method
	 */
	public boolean addAll(Collection c) {
		throw new UnsupportedOperationException(); 
	}


	/*
	 * unsupported method
	 */
	public boolean addAll(int index, Collection c) {
		throw new UnsupportedOperationException(); 
	}


	/**
	 * removed all the elements of the list and the nodes
	 */
	public void clear() {
		Node postion = head;


		while (postion.getNext() != null) {
			postion = postion.getNext(); 
			postion.before.setPrevious(null);
			postion.before.setNext(null);
			postion.before = null;
			size--; 
		}

		head=tail=null;


	}

	/*
	 * unsupported method
	 */
	public boolean contains(Object o) {
		throw new UnsupportedOperationException(); 
	}


	/*
	 * unsupported method
	 */
	public boolean containsAll(Collection c) {
		throw new UnsupportedOperationException(); 
	}




	/*
	 * unsupported method
	 */
	public int indexOf(Object o) {
		throw new UnsupportedOperationException(); 
	}


	/**
	 * returns boolean if the list is Empty 
	 * @return true if head is null
	 */
	public boolean isEmpty() {
		if (head== null) {
			return true; 
		}
		return false;
	}


	/*
	 * unsupported method
	 */
	public Iterator iterator() {
		throw new UnsupportedOperationException(); 
	}


	/*
	 * unsupported method
	 */
	public int lastIndexOf(Object o) {
		throw new UnsupportedOperationException(); 
	}


	/*
	 * unsupported method
	 */
	public ListIterator listIterator() {
		throw new UnsupportedOperationException(); 
	}

	
	
	
	

	/**
	 * removed an object from the list and return true if object is removed
	 * @param Object o 
	 * @return true if object is removed 
	 * 
	 */
	public boolean remove1(Map o) {
		Node temp = new Node(null, null, o); 
		boolean removed = false; 
		if (isEmpty()) {
			throw new Empty(); 
		}
		else {
			
			if (temp.equals(head)) {
				Node postion= head.getNext(); 
				head.setNext(null);
				postion.setPrevious(null);
				head = postion; 
				size--; 
				return true; 
				
			}
			
			if (temp.equals(tail)) {
				Node postion = tail.getPrevious(); 
				tail.setPrevious(null);
				postion.setNext(null);
				size--; 
				tail = postion; 
				return true;
			}
			Node postion = head; 

			while (postion!=null) {
				if (postion.equals(temp)) {
					postion.before.setNext(postion.getNext());
					postion.after.setPrevious(postion.getPrevious());
					removed= true; 
					size--; 
					break;
				}
				postion = postion.getNext();
			}
		}
		return removed; 
	}


	/**
	 * remove element based on index and return to the calling function
	 * @param int index 
	 * @return the element
	 */
	public Node remove(int index) {
		Node removed = null; 
		if (isEmpty()) {
			throw new Empty(); 
		}

		if (index>size-1) {
			throw new IndexGreaterThan(); 
		}
		else {
			if (index==0) {
				removed = head;
				head = head.getNext();
				head.getPrevious().setNext(null);
				head.setPrevious(null);
				size--; 
				return removed;
			}

			if (index == size-1) {
				removed = tail; 
				tail = tail.getPrevious(); 
				tail.getNext().setNext(null);
				size--; 
				return removed;
			}
			Node postion = head; 
			int i =0; 
			while (i < size) {

				if (i == index) {
					removed = postion; 
					postion.before.setNext(postion.getNext());
					postion.after.setPrevious(postion.getPrevious());
					size--; 
					return  removed;
				}
				postion = postion.getNext();
				i++;
			}
		}
		return  removed; 
	}


	/*
	 * unsupported method
	 */
	public boolean removeAll(Collection c) {
		throw new UnsupportedOperationException(); 
	}


	/*
	 * unsupported method
	 */
	public boolean retainAll(Collection c) {
		throw new UnsupportedOperationException(); 
	}


	/*
	 * unsupported method
	 */
	public Object set(int index, Object element) {
		// TODO Auto-generated method stub
		return null;
	}


	/**
	 * return the size of the list
	 * @return int size of the list
	 */
	public int size() {
		return size; 
	}


	/*
	 * unsupported method
	 */
	public List subList(int fromIndex, int toIndex) {
		throw new UnsupportedOperationException(); 
	}


	/*
	 * unsupported method
	 */
	public Object[] toArray() {
		throw new UnsupportedOperationException(); 
	}


	/*
	 * unsupported method
	 */
	public Object[] toArray(Object[] a) {
		throw new UnsupportedOperationException(); 
	}

	/**
	 * @return String of all the elemenet in the list
	 */
	
	public String toString() {
		Node postion = head;
		String myString="[";
		while (postion !=null) {
			
			myString += postion.toString();

			postion = postion.getNext();
			
			if (postion != null) {
				myString += ", ";
			}
		}
		myString +="]";
		return myString;
	}


}
