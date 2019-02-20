package test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;

import notDefault.List;

class AddFirstTest {

	@Test
	void test() {
		List L = new List();
        L.addFirst(2);
        assert(L.getLength() == 1);
        assert(L.getFirst() == 2);
        assert(L.getLast() == 2);
	}

}
