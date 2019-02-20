package stackAndQueue;

import java.util.NoSuchElementException;

import notDefault.DoubleList;

public class Queue<T extends Comparable<T>> {

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
        } else if (!(o instanceof Queue)) {
            return false;
        } else {
            Queue<T> q2 = (Queue<T>) o; 
	
	    	if (l.getLength() != q2.getLength()) {
	    		return false;
	    	}
	    	else {
	    		return q2 == this;
	    	}
        }
    }

	public T getFront() {
		if (l.getLength() == 0) {
        	throw new NoSuchElementException("No element to dequeue");
		}
		T data = l.getFirst();
		return data;
	}

	public Queue() {
		l = new DoubleList<>();
	}

	public void enqueue(T data) {
		l.addLast(data);
	}

	public T dequeue() {
		if (l.getLength() == 0) {
        	throw new NoSuchElementException("No element to dequeue");
		}
		T data = l.getFirst();
		l.pointIterator();
		l.removeIterator();
		return data;
	}
}
