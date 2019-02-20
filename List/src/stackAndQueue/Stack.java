package stackAndQueue;

import java.util.NoSuchElementException;

import notDefault.DoubleList;

public class Stack<T extends Comparable<T>> {

	private DoubleList<T> l;
	
	public int getLength() {
		return l.getLength();
	}
	
	public boolean isEmpty() {
		return l.isEmpty();
	}

    @Override public boolean equals(Object o) {
        if(o == this) {
            return true;
        } else if (!(o instanceof Stack)) {
            return false;
        } else {
            Stack<T> s = (Stack<T>) o; 
	
	    	if (l.getLength() != s.getLength()) {
	    		return false;
	    	}
	    	else {
	    		return s == this;
	    	}
        }
    }

	public T peek() {
		if (l.getLength() == 0) {
        	throw new NoSuchElementException("No element to dequeue");
		}
		T data = l.getFirst();
		return data;
	}

	public Stack() {
		l = new DoubleList<T>();
	}

	public void push(T data) {
		l.addFirst(data);
	}

	public void pushAll(Stack<T> giver) {
		while (!giver.isEmpty()) {
			push(giver.pop());
		}
	}

	public T pop() {
		if (l.getLength() == 0) {
        	throw new NoSuchElementException("No element to dequeue");
		}
		T data = l.getFirst();
		l.pointIterator();
		l.removeIterator();
		return data;
	}
}
