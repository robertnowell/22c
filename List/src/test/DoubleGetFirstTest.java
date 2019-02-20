package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import notDefault.DoubleList;

class DoubleGetFirstTest {

	@Test
	void test() {
		DoubleList<Integer> L = new DoubleList<Integer>();
        L.addFirst(1);
        L.addLast(2);
        assert(L.getFirst() == 1);
	}
}
