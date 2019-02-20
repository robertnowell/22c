package stackAndQueue;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StackTest {

	@Test
	void test() {
		Stack s = new Stack();
		s.push(1);
		s.push(0);
		System.out.println(s.pop());
	}
}
