package stackAndQueue;

import java.util.NoSuchElementException;

/**
 * Queue.java
 * @author
 * @author
 * CIS 22C Lab 5
 */
public class SQueue {
    private Stack<String> popper;
    private Stack<String> pusher;
    
    /**Constructors**/
    
    /**
     * Default constructor for the
     * Queue class
     */
    public SQueue() {
        popper = new Stack<String>();
        pusher = new Stack<String>();
        
    }
    
    /**
     * Copy constructor for the
     * Queue class
     * @param q the original Queue
     * to copy
     */
    public SQueue(SQueue q) {
        popper = new Stack<String>();
        pusher = new Stack<String>();

        SQueue tmp = new SQueue();
        tmp.append(q);

    	while (!tmp.isEmpty()) {
        	pusher.push(tmp.dequeue());
    	}
    }
    
    /**Mutators**/
    
    /**
     * Inserts new data to the end
     * of the Queue
     * @param data the value to insert
     */
    public void enqueue(String data) {
    	makePushable();
    	pusher.push(data);
    }
    
    /**
     * Removes data from the front of
     * the Queue
     * Precondition: !isEmpty()
     */
    public String dequeue() {
        if (isEmpty()) {
        	throw new NoSuchElementException("queue is empty");
        }
    	if (!pusher.isEmpty()) {
    		popper.pushAll(pusher);
    	}
		return popper.pop();
    }

    /**
     * Appends the values of a
     * a new Queue onto the end
     * of this Queue
     * @param q the Queue whose
     * values to append
     */
    public void append(SQueue q) {
    	makePushable();
        int size = q.getSize();
        Queue<String> tmp = new Queue<String>();
    	for (int i = 0; i < size; i++) {
        	String cur = q.dequeue();
        	tmp.enqueue(cur);
        	pusher.push(cur);
        }
    	while (!tmp.isEmpty()) {
        	q.enqueue(tmp.dequeue());
    	}
        System.out.println(q);

    }

    /**Accessors**/
    
    /**
     * Returns the value stored
     * at the front of the Queue
     * Precondition: !isEmpty()
     * @return
     */
    public String getFront() {
        if (isEmpty()) {
        	throw new NoSuchElementException("queue is empty");
        }
        makePoppable();
        return popper.peek();
    }
    
    /**
     * Returns the current size of
     * this Queue
     * @return the current size
     */
    public int getSize() {
        return pusher.getLength() + popper.getLength();
    }
    
    /**
     * Returns whether this Queue is
     * currently empty
     * @return whether the Queue is empty
     */
    public boolean isEmpty() {
        return getSize() == 0;
    }
    
    /**
     * Determines whether two Queues 
     * have the data stored in the same
     * order
     */
    @Override public boolean equals(Object o) {
        if(o == this) {
            return true;
        } else if (!(o instanceof Queue)) {
            return false;
        } else {
            SQueue sQ2 = (SQueue) o; 
	
	    	if (getSize() != sQ2.getSize()) {
	    		return false;
	    	}
	    	else {
	    		return sQ2 == this;
	    	}
        }
    }

    /**
     * Move all elements to popper
     */
    private void makePoppable() {
        if (!pusher.isEmpty()) {
        	popper.pushAll(pusher);
        }
    }
    
    private void makePushable() {    	
    	if (!popper.isEmpty()) {
    		pusher.pushAll(popper);
    	}
    }
    
    /**Additional Operations**/
    
    /**
     * Creates a String to store the values
     * the Queue,and ending with a new line
     * character
     */
    @Override public String toString() {
    	String res = "";
    	if (getSize() == 0) {
        	return "[]";
        }
        else {
        	res += "[ ";
        }
        makePoppable();
        while (!popper.isEmpty()) {
        	String cur = popper.pop();
        	res += "[" + cur + "]";
        	if (!popper.isEmpty()) {
        		res += ", ";
        	}
        	pusher.push(cur);
        }
        res += "]";
        return res;
    }
}

