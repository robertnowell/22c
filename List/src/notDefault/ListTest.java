package notDefault;
import java.util.NoSuchElementException;

/**
 * Class to test List.java
 * @author
 * @author
 */
public class ListTest {
    public static void main(String[] args) {
        List li = new List();
        System.out.println(li.getLength());       
        System.out.println(li);

        li.addLast(2);
        System.out.println(li.getLength());       
        System.out.println(li);
        
        li.addFirst(1);
        System.out.println(li.getLength());       
        System.out.println(li);
        
        li.addFirst(0);
        System.out.println(li.getLength());       
        System.out.println(li);


        li.addLast(3);
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
       
        li.removeLast();
        System.out.println(li.getLength());       
        System.out.println(li);
        
        ListTest lt = new ListTest();
        lt.testToString();
        lt.testAddFirst();
        lt.testRemoveFirst();

    }

    private void testAddFirst() {
        List L = new List();
        System.out.println("Should print nothing (an empty list): " + L);
        
        System.out.println("**Testing addFirst**");
        L.addFirst(2); //Testing Edge case: length == 0
        System.out.println("Should print 2: " + L);
        L.addFirst(1); //Testing General case: length >= 1
        System.out.println("Should print 1 2: " + L);
    }

    private void testRemoveFirst() {
        List L = new List();
        L.addFirst(2);
        L.addFirst(1);

    	System.out.println("**Testing removeFirst**");
        L.removeFirst(); //Testing General case: length >1
        System.out.println("Should print 2: " + L);
        L.removeFirst(); //Testing Edge case: length == 1
        System.out.println("Should print an new Line: " + L);
        System.out.println("Should an error message for an empty List: ");
        try { //place in a try-catch so program does not end when exception thrown
            L.removeFirst(); //Testing Precondition: length == 0
        } catch(NoSuchElementException e) {
            System.out.println(e.getMessage());
        }
    }

    private void testToString() {
        List L = new List();
        System.out.println("Should print nothing (an empty list): " + L);       
    }
}