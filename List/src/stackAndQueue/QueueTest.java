package stackAndQueue;

public class QueueTest {
	public static void main(String[] args) {
		Queue q = new Queue();
		q.enqueue(5);
		System.out.println(q.dequeue());
	}
}
