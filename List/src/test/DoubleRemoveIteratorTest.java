package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import notDefault.DoubleList;

import java.util.NoSuchElementException;

class DoubleRemoveIteratorTest {

	@Test
	void testOne() {
		DoubleList<String> L = new DoubleList<String>();

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
		DoubleList<String> L = new DoubleList<String>();

		// case: list length == "1"
		L.addFirst("1");
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
		DoubleList<String> L = new DoubleList<String>();

		// case: iterator at start of list
		L.addFirst("2");
		L.addFirst("1");
        L.pointIterator();
		L.removeIterator();
		assert L.getFirst() == "2";
		assert L.getLast() == "2";
		assert L.getLength() == 1;
	}
	
	@Test
	void TestFour() {
		
		DoubleList<String> L = new DoubleList<String>();

		// case: iterator at end of list
		L.addFirst("2");
		L.addFirst("1");
        L.pointIterator();
        L.advanceIterator();
		L.removeIterator();
		System.out.println(L);
		System.out.println(L.getLast());
		assert L.getFirst() == "1";
		assert L.getLast() == "1";
		assert L.getLength() == 1;
	}
	
	@Test
	void TestFive() {
		DoubleList<String> L = new DoubleList<String>();

		// case: iterator in middle of list 
		L.addFirst("3");
		L.addFirst("2");
        L.addFirst("1");
        L.pointIterator();
        L.advanceIterator();
		L.removeIterator();
		assert L.getFirst() == "1";
		assert L.getLast() == "3";
		assert L.getLength() == 2;

	}

	@Test
	void TestSix() {
		DoubleList<String> L = new DoubleList<String>();

		// case: iterator in middle of list 
		L.addFirst("3");
		L.addFirst("2");
        L.addFirst("1");
        L.pointIterator();
        L.advanceIterator();
        L.advanceIterator();
        L.reverseIterator();
		L.removeIterator();
		assert L.getFirst() == "1";
		assert L.getLast() == "3";
		assert L.getLength() == 2;

	}
}
