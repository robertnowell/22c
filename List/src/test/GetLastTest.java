package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import notDefault.List;

class GetLastTest {

	@Test
	void test() {
		List L = new List();
        L.addFirst(1);
        L.addLast(2);
        assert(L.getLast() == 2);
	}

}
