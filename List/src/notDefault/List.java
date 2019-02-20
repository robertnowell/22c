package notDefault;
/**
 * Defines the a singly-linked list class
 * @author 
 * @author
 */

import java.util.NoSuchElementException;

public class List {
    private class Node {
        private int data;
        private Node next;
        
        public Node(int data) {
            this.data = data;
            this.next = null;
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
    public List() {
    	this.length = 0;
    	first = null;
    	last = null;
    	iterator = null;
    }

    /****ACCESSORS****/
    
    
    /**
     * Returns the element currently pointed at by the iterator 
     * @precondition !offEnd();
     * @return the integer value stored at node first
     * @throws NoSuchElementException when precondition is violated
     */
    public int getIterator() {
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
    public int getFirst() throws NoSuchElementException{
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
    public int getLast() throws NoSuchElementException{
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
    
    
    /****MUTATORS****/

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
        }
        else {
            Node tmp = first;
        	while (first.next != iterator) {
        		tmp = tmp.next;
        	}
        	tmp.next = iterator.next;
            if (iterator == last) {
            	last = tmp;
            }
        }
        length--;
        iterator = null;
    }

    /**
     * inserts an element after the node currently pointed at by the iterator
     * @precondition !offEnd()
     * @throws NoSuchElementException when precondition is violated
     */
    public void addIterator(int value) {
        if (offEnd()) {
        	throw new NoSuchElementException("iterator points to null");
        }

        Node newNext = new Node(value);
        newNext.next = iterator.next;
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
    public void addFirst(int data) {
    	Node newFirst = new Node(data);
    	newFirst.next = first;
    	first = newFirst;
    	length++;
    	if (length == 1) {
    		last = newFirst;
    	}
        return;
    }
 
    /**
     * Creates a new last element
     * @param data the data to insert at the 
     * end of the list
     * @postcondition new Node at the end of the list, length increased by 1
     */
    public void addLast(int data) {
        Node newLast = new Node(data);
        if (length == 0) {
            last = newLast;
    		first = newLast;
        }
        else {
            last.next = newLast;
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
        	Node tmp = first;
        	while (tmp.next.next != null) {
        		tmp = tmp.next;
        	}
        	tmp.next = null;
        	last = tmp;
        }
        length--;
        return;
    }

    /****ADDITIONAL OPERATIONS****/
    
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
}

