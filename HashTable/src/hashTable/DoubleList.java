package hashTable;


import java.util.NoSuchElementException;

public class DoubleList<T extends Comparable<T>>{
    private class Node {
        private T data;
        private Node next;
        private Node prev;

        public Node(T data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    private int length;
    private Node first;
    private Node last;
    private Node iterator;

    /****CONSTRUCTOR****/

    /**
     * Instantiates a new List with default values
     * @postcondition Node object created with data == 0, next == null;
     */
    public DoubleList() {
    	length = 0;
    	first = null;
    	last = null;
    	iterator = null;
    }

    public DoubleList(DoubleList<T> l) {
    	iterator = null;
    	length = 0;
    	if (l.getLength() == 0) {
    		first = null;
    		last = null;
    	}
    	else {
        	Node tmp = l.first;
        	while (tmp != null) {
        		addLast(tmp.data);
        		tmp = tmp.next;
        	}    		
    	}
    }


    /****ACCESSORS****/
    
    
	/**
     * Searches the List for the specified
     * value using the iterative linear
     * search algorithm
     * @param value the value to search for
     * @return the location of value in the
     * List or -1 to indicate not found
     * Note that if the List is empty we will
     * consider the element to be not found
     * @postcondition: position of the iterator remains
     * unchanged!
     */
    public int linearSearch(T value) {
    	if (getLength() == 0) {
    		return -1;
    	}
    	Node tmp = first;
    	int index = 0;
    	while (tmp != null) {
    		if (tmp.data == value) {
    			return index;
    		}
    		tmp = tmp.next;
    		index++;
    	}
    	return -1;
    }

	/**
     * Returns the index from 1 to length
     * where value is located in the List
     * by calling the private helper method
     * binarySearch
     * @param value the value to search for
     * @return the index where value is 
     * stored from 1 to length, or -1 to
     * indicate not found
     * @precondition isSorted()
     * @postcondition the position of the
     * iterator must remain unchanged! 
     * @throws IllegalStateException when the
     * precondition is violated.
     */
    public int binarySearch(T value) throws IllegalStateException {
        if (!isSorted()) {
        	throw new IllegalStateException("list is not sorted");        	
        }
        return binarySearch(0, getLength()-1, value);
    }

    /**
     * Searches for the specified value in
     * the List by implementing the recursive
     * binarySearch algorithm
     * @param low the lowest bounds of the search
     * @param high the highest bounds of the search
     * @param value the value to search for
     * @return the index at which value is located
     * or -1 to indicate not found
     * @postcondition the location of the iterator
     * must remain unchanged
     */
    private int binarySearch(int low, int high, T value) {
        if (low > high) {
        	return -1;
        }
        int mid = (low+high)/2;
        Node tmp = first;
        for(int i = 0; i < mid; i++) {
        	tmp = tmp.next;
        }
        if (tmp.data.compareTo(value) == 0) {
        	return mid;
        }
        else if (tmp.data.compareTo(value) > 0) {
        	return binarySearch(low, mid-1, value);
        }
        else {
        	return binarySearch(mid+1, high, value);
        }
    }

    /**
     * Returns the index of the iterator
     * from 1 to n. Note that there is 
     * no index 0.
     * @precondition iterator must not point to null
     * @return the index of the iterator
     * @throws NullPointerException when
     * the precondition is violated
     */
    public int getIndex() throws NullPointerException{
    	if (offEnd()) {
        	throw new NullPointerException("iterator points to null");        	
        }
    	int index = 0;
		Node tmp = first;
    	while (tmp != iterator) {
    		tmp = tmp.next;
    		index++;
    	}
    	return index;
    }


    /**
     * Determines whether a List is sorted
     * by calling the recursive helper method
     * isSorted
     * Note: A List that is empty can be
     * considered to be (trivially) sorted
     * @return whether this List is sorted
     */
    public boolean isSorted() {
        if (getLength() == 0) {
        	return true;
        }
        else {
        	return (isSorted(first));
        }
    }

    /**
     * Recursively determines whether 
     * a List is sorted in ascending order
     * @return whether this List is sorted
     */
    public boolean isSorted(Node n) {
        if (n == last) {
        	return true;
        }
        else if (n.data.compareTo(n.next.data) > 0) {
        	return false;
        }
        else {
        	return isSorted(n.next);
        }
    }

    
    /**
     * Returns the element currently pointed at by the iterator 
     * @precondition !offEnd();
     * @return the integer value stored at node first
     * @throws NoSuchElementException when precondition is violated
     */
    public T getIterator() {
        if (offEnd()) {
        	throw new NoSuchElementException("iterator points to null");
        }
        return iterator.data;
    }
    
    
    /**
     * Returns the value stored in the first node
     * @precondition length >= 1
     * @return the integer value stored at node first
     * @throws NoSuchElementException when precondition is violated
     */
    public T getFirst() throws NoSuchElementException{
        if (length < 1) {
        	throw new NoSuchElementException("length cannot be < 1. length = " + length);
        }
        else {
        	return first.data;
        }
    }

    /**
     * Returns the value stored in the last node
     * @precondition length >= 1
     * @return the integer value stored in the node last
     * @throws NoSuchElementException when precondition is violated
     */
    public T getLast() throws NoSuchElementException{
        if (length < 1) {
        	throw new NoSuchElementException("length cannot be < 1. length = " + length);
        }
        else {
        	return last.data;
        }    
    }

    /**
     * Returns the current length of the list
     * @return the length of the list from 0 to n
     */
    public int getLength() {
        return length;
    }

    /**
     * Returns whether the list is currently empty
     * @return whether the list is empty
     */
    public boolean isEmpty() {
        return length == 0;
    }

    /**
     * returns whether the iterator is off the end of the list, i.e. pointing to null
     * @return whether iterator points to null
     * @throws NoSuchElementException when precondition is violated
     */
    public boolean offEnd() {
    	return iterator == null;
    }
    
    
    /**
     * overrides the equals method, checks for same data in the same order.
     * @return whether same data exists in same order
     */
    @Override public boolean equals(Object o) {
        if(o == this) {
            return true;
        } else if (!(o instanceof DoubleList)) {
            return false;
        } else {
            DoubleList<T> l = (DoubleList<T>) o; 
	
	    	if (getLength() != l.getLength()) {
	    		return false;
	    	}
	    	Node tmp1 = this.first;
	    	Node tmp2 = l.first;
	    	for (int i = 0; i < getLength(); i++) {
	    		if (tmp1.data != tmp2.data) {
	    			return false;
	    		}
	    		tmp1 = tmp1.next;
	    		tmp2 = tmp2.next;
	    	}
	    	return true;

        }
    }
    /****MUTATORS****/

    /**
     * Points the iterator at first
     * and then iteratively advances 
     * it to the specified index
     * @param index the index where
     * the iterator should be placed
     * @precondition 1 <= index <= length
     * @throws IndexOutOfBoundsException
     * when precondition is violated
     */
    public void moveToIndex(int index) throws IndexOutOfBoundsException{
        if (index >= getLength()) {
        	throw new IndexOutOfBoundsException("index " +
        				Integer.toString(index) + " >= length " +  Integer.toString(getLength()));
        }
        if (index < 0) {
        	throw new IndexOutOfBoundsException("index must be >= 0");
        }
        int currentIndex = getIndex();
        while (currentIndex < index) {
        	advanceIterator();
        	currentIndex++;
        }        	
        while (currentIndex > index) {
        	reverseIterator();
        	currentIndex--;
        }
    }

    /**
     * Moves the iterator to the beginning of the list
     */
    public void pointIterator() {
    	iterator = first;
    }


    /**
     * moves the iterator up by one node towards the last node
     * @precondition !offEnd()
     * @throws NoSuchElementException when precondition is violated
     */
    public void advanceIterator() {
        if (offEnd()) {
        	throw new NoSuchElementException("iterator points to null");
        }
        iterator = iterator.next;
    }


    /**
     * moves the iterator down by one node towards the first node
     * @precondition !offEnd()
     * @throws NoSuchElementException when precondition is violated
     */
    public void reverseIterator() {
        if (offEnd()) {
        	throw new NoSuchElementException("iterator points to null");
        }
        iterator = iterator.prev;
    }

    public void remove(T t) {
    	pointIterator();
    	while (!offEnd()) {
    		T elem = getIterator();
    		if (elem == t){
    			removeIterator();
    			break;
    		}
			advanceIterator();
    	}
    	setIteratorToValue(t);
    }
    
    public void setIteratorToValue(T t) throws NoSuchElementException {
    	pointIterator();
    	while (!offEnd()) {
    		T elem = getIterator();
    		if (elem == t) {
    			return;
    		}
    		advanceIterator();
    	}
    	throw new NoSuchElementException("reached end of list");
    }

    /**
     * Removes the element currently pointed to by the iterator
     * @precondition !offEnd();
     * @postcondition element pointed to by iterator is removed. Resets first and/or last if needed.
     * @throws NoSuchElementException when precondition is violated
     */
    public void removeIterator() {
        if (offEnd()) {
        	throw new NoSuchElementException("iterator points to null");
        }
        if (getLength() == 1) {
        	first = null;
        	last = null;
        }
        else if (first == iterator) {
        	first = iterator.next;
        	first.prev = null;
        }
        else {
        	if (iterator != last) {
            	iterator.next.prev = iterator.prev;        		
        	}
        	else {
        		last = iterator.prev;
        	}
        	iterator.prev.next = iterator.next;
        }
        length--;
        iterator = null;
    }

    /**
     * inserts an element after the node currently pointed at by the iterator
     * @precondition !offEnd()
     * @throws NoSuchElementException when precondition is violated
     */
    public void addIterator(T value) {
        if (offEnd()) {
        	throw new NoSuchElementException("iterator points to null");
        }

        Node newNext = new Node(value);
        newNext.next = iterator.next;
        newNext.prev = iterator;
        iterator.next = newNext;
        if (iterator == last) {
        	last = newNext;
        }
        length++;
    }

    /**
     * Creates a new first element
     * @param data the data to insert at the 
     * front of the list
     * @postcondition new Node n at the front of list with n.data == data. Length increased by one.
     */
    public void addFirst(T data) {
    	Node newFirst = new Node(data);
    	newFirst.next = first;
    	first = newFirst;
    	length++;
    	if (length == 1) {
    		last = newFirst;
    	}
    	else {
    		first.next.prev = first;
    	}
        return;
    }
 
    /**
     * Creates a new last element
     * @param data the data to insert at the 
     * end of the list
     * @postcondition new Node at the end of the list, length increased by 1
     */
    public void addLast(T data) {
        Node newLast = new Node(data);
        if (length == 0) {
            last = newLast;
    		first = newLast;
        }
        else {
            last.next = newLast;
            newLast.prev = last;
            last = newLast;
        }
        length++;
    	return;
    }

    /**
    * removes the element at the front of the list
    * @precondition length >= 1
    * @postcondition first element of list removed
    * @throws NoSuchElementException when precondition is violated
    */
    public void removeFirst() throws NoSuchElementException{
        if (length < 1) {
        	throw new NoSuchElementException("length cannot be < 1. length = " + length);
        }
        else if (length == 1) {
        	first = null;
        	last = null;
        }
        else {
        	first = first.next;
        	first.prev = null;
        }
        length--;
        return;
    }

    /**
     * removes the element at the end of the list
     * @precondition length >= 1
     * @postcondition last element removed
     * @throws NoSuchElementException when precondition is violated
     */
    public void removeLast() throws NoSuchElementException{
        if (length < 1) {
        	throw new NoSuchElementException("length cannot be < 1. length = " + length);
        }
        else if (length == 1) {
        	first = null;
        	last = null;
        }
        else {
        	last = last.prev;
        	last.next = null;
        }
        length--;
        return;
    }

    /****ADDITIONAL OPERATIONS****/


    /**
     * prints the contents of the linked list
     */
    public void printNumberedList() {
    	if (getLength() == 0) {
    		System.out.println("Empty list");
    	}
    	Node tmp = first;
    	for (int i = 0; i < getLength(); i++) {
        	System.out.println(Integer.toString(i) + ". " + tmp.data + "\n");
        	tmp = tmp.next;
        }
    }


    /**
     * List with each value separated by a blank space
     * At the end of the List a new line
     * @return the List as a String for display
     */
    @Override public String toString() {
        String s = "[";
        Node tmp = first;
        while (tmp != null) {
        	s += tmp.data + " ";
        	tmp = tmp.next;
        }
    	return s + "]\n";
    }

    /**
     * Prints a linked list to the console
     * in reverse by calling the private 
     * recursive helper method printReverse
     */
    public void printReverse() {
       if (getLength() == 0){
    	   printNumberedList();
       }
       else {
    	   printReverse(last);
       }
    }
    
    /**
     * Prints a linked list to the console
     * recursively (no loop)
     * in reverse order from last to first
     * Each element separated by a space
     * Should print a new line after all
     * elements have been displayed
     */    

    private void printReverse(Node n) {
        System.out.print(n.data);
        if (n == first) {
        	System.out.println();
        }
        else {
            System.out.print(" ");
        	printReverse(n.prev);
        }
    }
}
