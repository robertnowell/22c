package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;

import notDefault.List;

class AddIteratorTest {

	@Test
	void testOne() {
		List L = new List();

		// case: empty list
		try {
			L.addIterator(4);
			fail("list: " + L.toString() + "\nshould raise NoSuchElementException");
		}
		catch (NoSuchElementException e){
			assert !(e == null);
		}
	}

	@Test
	void testTwo() {
		List L = new List();

		// case: list length == 1
		L.addFirst(1);
        L.pointIterator();
		L.addIterator(2);
		assert L.getFirst() == 1;
		assert L.getLast() == 2;
		assert L.getLength() == 2;
		
	}

	@Test
	void testThree() {
		List L = new List();

		// case: list length == 1
		L.addFirst(4);
		L.addFirst(2);
		L.addFirst(1);
        L.pointIterator();
        L.advanceIterator();
        L.addIterator(3);
		assert L.getFirst() == 1;
		assert L.getLast() == 4;
		assert L.getLength() == 4;
	}
}
