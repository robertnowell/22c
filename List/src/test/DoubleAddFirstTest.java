package test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;

import notDefault.DoubleList;

class DoubleAddFirstTest {

	@Test
	void test() {
		DoubleList<Integer> L = new DoubleList<Integer>();
        L.addFirst(2);
        assert(L.getLength() == 1);
        assert(L.getFirst() == 2);
        assert(L.getLast() == 2);
	}

}
