package stackAndQueue;

/**
 * SQueueTest.java
 * @author
 * @author
 * CIS 22C Lab 5
 */
public class TestSQueue {
    public static void main(String[] args) {
        SQueue q = new SQueue();
        System.out.println("**Testing enqueue()**");
        q.enqueue("1");
        System.out.println("Should print 1: " + q);
        q.enqueue("2");
        System.out.println("Should print 1 2: " + q);
        q.enqueue("3");
        System.out.println("Should print 1 2 3: " + q);
        
        System.out.println("\n**Testing dequeue()**");
        q.dequeue();
        System.out.println("Should print 2 3: " + q);
        
        System.out.println("\n**Testing isEmpty()**");
        SQueue q2 = new SQueue();
        System.out.println("Should print true: " + q2.isEmpty());
        System.out.println("Should print false: " + q.isEmpty());
        
        System.out.println("\n**Testing append()**");
        q2.enqueue("A");
        q2.enqueue("B");
        q2.enqueue("C");
        q2.enqueue("D");
        System.out.println("Should print 4: " + q2.getSize());
        q.append(q2);
        System.out.println("Should print 2 3 A B C D: " + q);
        
        System.out.println("\n**Testing getFront()**");
        System.out.println("Should print A: " + q2.getFront());
        
        System.out.println("\n**Testing getSize()**");
        System.out.println("Should print 6: " + q.getSize());
        
        System.out.println("q" + q);
        System.out.println("q2" + q2);
        
        System.out.println("\n**Testing equals()**");
        System.out.println("Should print true: " + q2.equals(q2));
        System.out.println("Should print false: " + q.equals(q2));
        q.dequeue();
        q.dequeue();
        System.out.println("Should print true: " + q.equals(q2));
        q.dequeue();
        
        System.out.println("\n**Testing Copy Constructor**");
        SQueue q3 = new SQueue(q2);
        System.out.println("Should print A B C D: " + q3);
        q3.enqueue("E");
        q3.enqueue("F");
        
        System.out.println("Testing for Deep Copy:");
        System.out.println("Should print A B C D E F: " + q3);
        System.out.println("Should print A B C D: " + q2);
        
        
    }
}