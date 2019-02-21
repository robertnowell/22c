package hashTable;

import java.util.ArrayList;

public class HashTable<T extends Comparable<T>> {
	private ArrayList<DoubleList<T>> ht;
	private int numElements;

	public HashTable(int size) {
		ht = new ArrayList<DoubleList<T>>(size);
		numElements = 0;
	}
	
	
	/**Accessors*/
	
	/**
	* Returns the hash value in the Table
	* for a given key by taking modulus
	* of the hashCode value for that key
	* and the size of the table
	* @param t the key
	* @return the index in the Table
	*/
	private int hash(T t) {
	    int code = t.hashCode();
	    return code % ht.size();
	}

//	@Override public int hashCode() {
//		String key = title + director; //define key for this class
//		int sum = 0;
//		for (int i = 0; i < key.length(); i++) {
//			sum += (int) key.charAt(i);
//		}
//		return sum;
//	}

	/**
	* Counts the number of keys at this index
	* @param index the index in the Table
	* @precondition 0 <= index < Table.length
	* @return the count of keys at this index
	* @throws IndexOutOfBoundsException
	*/
	public int countBucket(int index) throws IndexOutOfBoundsException{
	    if (index > ht.size() - 1) {
	    	throw new IndexOutOfBoundsException();
	    }
	    
	    return ht.get(index).getLength();
	}
	
	/**
	* Returns total number of keys in the Table
	* @return total number of keys
	*/
	public int getNumElements() {
	    return numElements;
	}
	
	/**
	* Searches for a specified key in the Table
	* @param t the key to search for
	* @return the index in the Table (0 to Table.length - 1)
	* or -1 if t is not in the Table
	*/
	public int search(T t) {
		int index = hash(t);
		DoubleList<T> bucket = ht.get(index);
		return bucket.linearSearch(t);
	}
	
	
	/**Manipulation Procedures*/
	
	/**
	* Inserts a new key in the Table
	* calls the hash method to determine placement
	* @param t the key to insert
	*/
	public void insert(T t) {
		ht.get(hash(t)).addFirst(t);
	}
	
	public void resize(int size) {
		ArrayList<DoubleList<T>> htCopy = ht;
		ht = new ArrayList<DoubleList<T>>(size);
		for (int i = 0; i < ht.size(); i++) {
			DoubleList<T> bucket = htCopy.get(i);
			bucket.pointIterator();
			while (!bucket.offEnd()) {
				insert(bucket.getIterator());
				bucket.advanceIterator();
			}
		}
	}

	/**
	* removes the key t from the Table
	* calls the hash method on the key to
	* determine correct placement
	* has no effect if t is not in
	* the Table
	* @param t the key to remove
	*/
	public void remove(T t) {
		ht.get(hash(t)).remove(t);
	}
	
	/**Additional Methods*/
	
	/**
	* Prints all the keys at a specified
	* bucket in the Table. Each key displayed
	* on its own line, with a blank line 
	* separating each key
	* Above the keys, prints the message
	* "Printing bucket #<bucket>:"
	* Note that there is no <> in the output
	* @param bucket the index in the Table
	*/
	public void printBucket(int index) {
		DoubleList<T> bucket = ht.get(index);
		System.out.println("Printing bucket with index" + index);
		bucket.printNumberedList();
	}
	
	/**
	* Prints the first key at each bucket
	* along with a count of the total keys
	* with the message "+ <count> -1 more 
	* at this bucket." Each bucket separated
	* with to blank lines. When the bucket is 
	* empty, prints the message "This bucket
	* is empty." followed by two blank lines
	*/
	public void printTable(){
		for (int i = 0; i < ht.size(); i++) {
			printBucket(i);
		}
	}

}

