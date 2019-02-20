package notDefault;

import java.util.NoSuchElementException;

/**
 * Class to test DoubleDoubleList<String>.java
 * @author
 * @author
 */
public class DoubleListTest {
    public static void main(String[] args) {
        DoubleList<String> li = new DoubleList<String>();
        System.out.println(li.getLength());       
        System.out.println(li);

        li.addLast("2");
        System.out.println(li.getLength());       
        System.out.println(li);
        
        li.addFirst("1");
        System.out.println(li.getLength());       
        System.out.println(li);
        
        li.addFirst("0");
        System.out.println(li.getLength());       
        System.out.println(li);


        li.addLast("3");
        System.out.println(li.getLength());       
        System.out.println(li);
 
        li.pointIterator();
        System.out.println(li.getIterator());
        li.advanceIterator();
        System.out.println(li.getIterator());
        li.advanceIterator();
        System.out.println(li.getIterator());
        li.advanceIterator();
        System.out.println(li.getIterator());
        li.reverseIterator();
        System.out.println(li.getIterator());
        li.reverseIterator();
        System.out.println(li.getIterator());

        li.moveToIndex(0);
        System.out.println(li.getIterator());

        li.moveToIndex(3);
        System.out.println(li.getIterator());

        li.moveToIndex(1);
        System.out.println(li.getIterator());

        li.printNumberedList();
        li.printReverse();
        System.out.println(li.isSorted());

        DoubleList<String> l = new DoubleList<String>(li);
        System.out.println(l.equals(li));
        l.printNumberedList();

        System.out.println(li.binarySearch("3"));
        System.out.println(li.linearSearch("3"));
        System.out.println(li.binarySearch("0"));
        System.out.println(li.linearSearch("0"));
        System.out.println(li.binarySearch("5"));
        System.out.println(li.linearSearch("5"));
        System.out.println(li.binarySearch("2"));
        System.out.println(li.linearSearch("2"));
        li.removeLast();
        System.out.println(li.getLength());       
        System.out.println(li);

        li.removeLast();
        System.out.println(li.getLength());       
        System.out.println(li);
       
        li.removeLast();
        System.out.println(li.getLength());       
        System.out.println(li);
       
        li.removeLast();
        System.out.println(li.getLength());       
        System.out.println(li);
        
        DoubleListTest lt = new DoubleListTest();
        lt.testToString();
        lt.testAddFirst();
        lt.testRemoveFirst();

    }

    private void testAddFirst() {
        DoubleList<String> L = new DoubleList<String>();
        System.out.println("Should print nothing (an empty list): " + L);
        
        System.out.println("**Testing addFirst**");
        L.addFirst("2"); //Testing Edge case: length == 0
        System.out.println("Should print 2: " + L);
        L.addFirst("1"); //Testing General case: length >= 1
        System.out.println("Should print 1 2: " + L);
    }

    private void testRemoveFirst() {
        DoubleList<String> L = new DoubleList<String>();
        L.addFirst("2");        
        L.addFirst("1");

    	System.out.println("**Testing removeFirst**");
        L.removeFirst(); //Testing General case: length >1
        System.out.println("Should print 2: " + L);
        L.removeFirst(); //Testing Edge case: length == 1
        System.out.println("Should print an new Line: " + L);
        System.out.println("Should an error message for an empty DoubleList<String>: ");
        try { //place in a try-catch so program does not end when exception thrown
            L.removeFirst(); //Testing Precondition: length == 0
        } catch(NoSuchElementException e) {
            System.out.println(e.getMessage());
        }
    }

    private void testToString() {
        DoubleList<String> L = new DoubleList<String>();
        System.out.println("Should print nothing (an empty list): " + L);       
    }
}

