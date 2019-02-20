package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import notDefault.List;

class GetFirstTest {

	@Test
	void test() {
		List L = new List();
        L.addFirst(1);
        L.addLast(2);
        assert(L.getFirst() == 1);
	}
}
