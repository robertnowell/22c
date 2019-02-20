package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import notDefault.List;

import java.util.NoSuchElementException;

class testRemoveIterator {

	@Test
	void testOne() {
		List L = new List();

		// case: empty list
		try {
			L.removeIterator();
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
		L.removeIterator();

		try {
			L.getFirst();
			fail("list: " + L.toString() + "\nshould raise NoSuchElementException");
		}
		catch (NoSuchElementException e){
			assert !(e == null);
		}
		try {
			L.getLast();
			fail("list: " + L.toString() + "\nshould raise NoSuchElementException");
		}
		catch (NoSuchElementException e){
			assert !(e == null);
		}

		assert L.getLength() == 0;

	}
	
	@Test
	void TestThree() {
		List L = new List();

		// case: iterator at start of list
		L.addFirst(2);
		L.addFirst(1);
        L.pointIterator();
		L.removeIterator();
		assert L.getFirst() == 2;
		assert L.getLast() == 2;
		assert L.getLength() == 1;
	}
	
	@Test
	void TestFour() {
		
		List L = new List();

		// case: iterator at end of list
		L.addFirst(2);
		L.addFirst(1);
        L.pointIterator();
        L.advanceIterator();
		L.removeIterator();
		assert L.getFirst() == 1;
		assert L.getLast() == 1;
		assert L.getLength() == 1;
	}
	
	@Test
	void TestFive() {
		List L = new List();

		// case: iterator in middle of list 
		// case: iterator at end of list
		L.addFirst(3);
		L.addFirst(2);
        L.addFirst(1);
        L.pointIterator();
        L.advanceIterator();
		L.removeIterator();
		assert L.getFirst() == 1;
		assert L.getLast() == 3;
		assert L.getLength() == 2;

	}

}
