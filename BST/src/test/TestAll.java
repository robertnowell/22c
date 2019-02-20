package test;

import java.util.NoSuchElementException;

import bst.BST;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestAll {

	@Test
	void testIsEmpty() {
		BST<Integer> b = new BST<Integer>();
		assert(b.isEmpty() == true);
	}


	@Test
	void testInsert() {
		BST<Integer> b = new BST<Integer>();
		b.insert(5);
		Integer data = b.getRoot();
		assert(data == 5);

		try {
			b.insert(null);			
			fail("should not be able to insert null");
		}
		catch (IllegalArgumentException e){
			return;
		}
	}


	@Test
	void testGetSize() {
		BST<Integer> b = new BST<Integer>();
		assert(b.getSize() == 0);
		b.insert(5);
		assert(b.getSize() == 1);
		for(int i = 0; i < 100; i++) {
			b.insert(i);
		}
		assert(b.getSize() == 101);
	}


//	@Test
//	void testConstructor() {
//		BST<Integer> b = new BST<Integer>();
//		assert(b.getRoot() == null);
//
//		b.insert(5);
//		b.insert(6);
//		
//		BST<Integer> b1 = new BST<Integer>(b);
//		assert (b1.getSize() == 2);
//		assert (b1.getRoot() == 5);
//		assert (b.getRoot() == 5);
//		assert (b.getSize() == 2);
//	}
}
