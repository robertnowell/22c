package bst;
import java.util.*; 

import java.util.NoSuchElementException;
import java.util.LinkedList;

public class BST<T extends Comparable<T>> {
	private Node root;

	private class Node{
		private T data;
		private Node left;
		private Node right;
		
		public Node(T data) {
			this.data = data;
			left = null;
			right = null;
		}
	}

	public BST(){
		root = null;
	}

	public BST(BST<T> b) {
		if (b.isEmpty()) {
			root = null;
		}
		else {
			Node n = b.getRootNode();
			copyHelper(n);
		}
	}

    private void copyHelper(Node node) {
        insert(node.data);
        if (node.left != null) {
        	copyHelper(node.left);
        }
        if (node.right != null) {
        	copyHelper(node.right);
        }
    }

    
	/**
     * Returns the data stored in the root
     * @precondition !isEmpty()
     * @return the data stored in the root
     * @throws NoSuchElementException when
     * preconditon is violated
     */
    public T getRoot() throws NoSuchElementException{
        if (isEmpty()) {
        	throw new NoSuchElementException("bst is empty");        	
        }
        return root.data;
    }
    
	/**
     * Returns the data stored in the root
     * @precondition !isEmpty()
     * @return the data stored in the root
     * @throws NoSuchElementException when
     * preconditon is violated
     */
    public Node getRootNode() throws NoSuchElementException{
        if (isEmpty()) {
        	throw new NoSuchElementException("bst is empty");        	
        }
        return root;
    }
    
    /**
     * Determines whether the tree is empty
     * @return whether the tree is empty
     */
    public boolean isEmpty() {
        if (root == null){
        	return true;
        }
        else {
        	return false;
        }
    }
    
	public int getHeight() {
		if (isEmpty()) {
			return -1;
		}
		return getHeight(root);
	}
	
    /**
     * Helper method for getHeight method
     * @param node the current
     * node whose height to count
     * @return the height of the tree
     */
    private int getHeight(Node node) {
    	if (node == null) {
    		return 0;
    	}
    	else {
    		int left = getHeight(node.left);
    		int right = getHeight(node.right);
    		if (left > right) {
    			return left + 1;
    		}
    		else {
    			return right + 1;
    		}
    	}
    }
    
    
	
	public int getSize() {
		if (isEmpty()) {
			return 0;
		}
		else {
			return getSize(root);			
		}
	}
	
    /**
     * Helper method for the getSize method
     * @param node the current node to count
     * @return the size of the tree
     */
    private int getSize(Node node) {
    	if (node == null) {
    		return 0;
    	}
    	else {
    		return (1 + getSize(node.left) + getSize(node.right));
    	}
    }
	

    /**
     * Returns the smallest value in the tree
     * @precondition !isEmpty()
     * @return the smallest value in the tree
     * @throws NoSuchElementException when the
     * precondition is violated
     */
    public T findMin() throws NoSuchElementException{
        if (isEmpty()) {
        	throw new NoSuchElementException("bst is empty");        	
        }
        else {
        	return findMin(root);
        }
    }

    /**
     * Helper method to findMin method
     * @param node the current node to check
     * if it is the smallest
     * @return the smallest value in the tree
     */
    private T findMin(Node node) {
        if (node.left == null) {
        	return node.data;
        }
        else {
        	return findMin(node.left);
        }
    }
    
    /**
     * Returns the largest value in the tree
     * @precondition !isEmpty()
     * @return the largest value in the tree
     * @throws NoSuchElementException when the
     * precondition is violated
     */
    public T findMax() throws NoSuchElementException{
        if (isEmpty()) {
        	throw new NoSuchElementException("bst is empty");        	
        }
        else {
        	return findMax(root);
        }
    }
    
    /**
     * Helper method to findMax method
     * @param node the current node to check
     * if it is the largest
     * @return the largest value in the tree
     */
    private T findMax(Node node) {
        if (node.right == null) {
        	return node.data;
        }
        else {
        	return findMax(node.right);
        }
    }
    
    /**
     * Searches for a specified value
     * in the tree
     * @param data the value to search for
     * @return whether the value is stored
     * in the tree
     */
    public boolean search(T data) {
        return search(data, root);
    }
    
    /**
     * Helper method for the search method
     * @param data the data to search for
     * @param node the current node to check
     * @return whether the data is stored
     * in the tree
     */
    private boolean search(T data, Node node) {
        if (node == null) {
        	return false;
        }
        if (node.data == data) {
        	return true;
        }
        else {
        	return (search(data, node.left) || search(data, node.right));
        }
    }


    /**
     * Determines whether two trees store
     * identical data in the same structural
     * position in the tree
     * @param o another Object
     * @return whether the two trees are equal
     */
    @Override public boolean equals(Object o) {
        return false;
    }
    
    /**
     * Helper method for the equals method
     * @param node1 the node of the first bst
     * @param node2 the node of the second bst
     * @return whether the two trees contain
     * identical data stored in the same structural
     * position inside the trees
     */    
    private boolean equals(Node node1, Node node2) {
        return false;
    }
    
    /***MUTATORS***/
    
    /**
     * Inserts a new node in the tree
     * @param data the data to insert
     * @precondition data != null
     */
    public void insert(T data) {
    	if (data == null) {
    		throw new IllegalArgumentException("data must not equal null");
    	}
    	if (isEmpty()) {
    		root = new Node(data);
    	}
    	else {
    		insert(data, root);
    	}
    }
    
    /**
     * Helper method to insert
     * Inserts a new value in the tree
     * @param data the data to insert
     * @param node the current node in the
     * search for the correct location
     * in which to insert
     */
    private void insert(T data, Node node) {
		if (node.data.compareTo(data) > 0) {
			if (node.left == null) {
				node.left = new Node(data);
			}
			else {
				insert(data, node.left);
			}
		}
		else {
			if (node.right == null) {
				node.right = new Node(data);
			}
			else {
				insert(data, node.right);
			}
		}
    }

    private void reinsertSubtree(Node node) {
    	if (node == null) {
    		return;
    	}
    	insert(node.data);
    	if (node.left != null) {
    		reinsertSubtree(node.left);
    	}
    	if (node.right != null) {
    		reinsertSubtree(node.right);
    	}
    }

    /**
     * Removes a value from the BST
     * @param data the value to remove
     * @precondition !isEmpty()
     * @precondition the data is located in the tree
     * @throws NoSuchElementException when the
     * precondition is violated
     */
    public void remove(T data) throws NoSuchElementException{
    	if (isEmpty()) {
    		throw new NoSuchElementException("tree must not be empty");
    	}
    	if (root.data == data) {
        	Node copy = new Node(root.data);
        	copy.left = root.left;
        	copy.right = root.right;
    		root = null;
    		reinsertSubtree(copy.left);
    		reinsertSubtree(copy.right);
    		return;
    	}
    	
    	Node result = null;
    	if (root.data.compareTo(data) > 0) {
    		if (root.left != null) {
        		if (root.left.data == data) {
                	Node copy = new Node(root.left.data);
                	copy.left = root.left.left;
                	copy.right = root.left.right;
                	root.left = null;
            		reinsertSubtree(copy.left);
            		reinsertSubtree(copy.right);
            		result = copy;
        		}
        		else {
        			result = remove(data, root.left);
        		}
    		}
    	}
    	else {
    		if (root.right != null) {
        		if (root.right.data == data) {
                	Node copy = new Node(root.right.data);
                	copy.left = root.right.left;
                	copy.right = root.right.right;
                	root.right = null;
            		reinsertSubtree(copy.left);
            		reinsertSubtree(copy.right);
            		result = copy;
        		}
        		else {
        			result = remove(data, root.right);
        		}
        	}
    	}
    	if (result == null) {
			throw new NoSuchElementException("Element not found");
    	}
    }

    /**
     * Helper method to the remove method
     * @param data the data to remove
     * @param node the current node
     * @return an updated reference variable
     */
    private Node remove(T data, Node node) {       
        if (node.left != null) {
        	if (node.left.data == data) {
            	Node copy = new Node(node.left.data);
            	copy.left = node.left.left;
            	copy.right = node.left.right;
            	node.left = null;
        		reinsertSubtree(copy.left);
        		reinsertSubtree(copy.right);
            	return copy;
        	}
        }
        if (node.right != null) {
        	if (node.right.data == data) {
            	Node copy = new Node(node.right.data);
            	copy.left = node.right.left;
            	copy.right = node.right.right;
            	node.right = null;
        		reinsertSubtree(copy.left);
        		reinsertSubtree(copy.right);
            	return copy;
        	}
        }
        Node result = null;
        if (node.left != null) {
        	result = remove(data, node.left);
        }
        if (result == null && node.right != null) {
        	result = remove(data, node.right);
        }
        return result;
    }

    /***ADDITIONAL OPERATIONS***/
    
    /**
     * Prints the data in pre order
     * to the console
     */
    public void preOrderPrint() {
    	if (isEmpty()) {
    		System.out.println("[]");
    	}
    	else {
        	preOrderPrint(root);
        	System.out.println("");
    	}
    }
    
    /**
     * Helper method to preOrderPrint method
     * Prints the data in pre order
     * to the console
     */
    private void preOrderPrint(Node node) {
    	if (node == null) {
    		return;
    	}
    	System.out.print(node.data);
    	System.out.print(" ");
    	preOrderPrint(node.left);
    	preOrderPrint(node.right);
    }
    
    /**
     * Prints the data in sorted order 
     * to the console
     */
    public void inOrderPrint() {
    	if (isEmpty()) {
    		System.out.println("[]");
    	}
    	else {
        	inOrderPrint(root);
        	System.out.println("");
    	}
    }
    
    /**
     * Helper method to inOrderPrint method
     * Prints the data in sorted order
     * to the console
     */
    private void inOrderPrint(Node node) {
    	if (node == null) {
    		return;
    	}

    	inOrderPrint(node.left);
    	System.out.print(node.data);
    	System.out.print(" ");
    	inOrderPrint(node.right);
        
    }
    
    /**
     * Prints the data in post order
     * to the console
     */
    public void postOrderPrint() {
    	if (isEmpty()) {
    		System.out.println("[]");
    	}
    	else {
        	postOrderPrint(root);    		
        	System.out.println("");
    	}
    }
    
    /**
     * Helper method to postOrderPrint method
     * Prints the data in post order
     * to the console
     */
    private void postOrderPrint(Node node) {
    	if (node == null) {
    		return;
    	}
    	postOrderPrint(node.left);
    	postOrderPrint(node.right);
    	System.out.print(node.data);
    	System.out.print(" ");
    }

    private class QueueObj {
		private Node node;
		private int depth;
		private double offset;

		public QueueObj(Node node, int depth, double offset) {
			this.node = node;
			this.depth = depth;
			this.offset = offset;
		}
    }

	public void pprint() {
		if (isEmpty()) {
			System.out.println("Empty Tree");
			return;
		}
		LinkedList<QueueObj> q = new LinkedList<QueueObj>();
		int height = getHeight();
		q.add(new QueueObj(root, 0, Math.pow(2, height)/2));
		int prev_lev = 0;
		String s = "";
		while(!q.isEmpty()) {
			QueueObj cur = q.remove();
			double offsetMod = Math.pow(2, height-(cur.depth+1))/2;

			if (cur.node.left != null) {
				q.add(new QueueObj(cur.node.left, cur.depth + 1, cur.offset - offsetMod));
			}
			if (cur.node.right != null) {
				q.add(new QueueObj(cur.node.right, cur.depth + 1, cur.offset + offsetMod));
			}
			if(cur.depth != prev_lev) {
				prev_lev = cur.depth;
				System.out.println(s);
				s = "";
			}
			for (int i = s.length(); i < cur.offset; i++) {				
				s += " ";
			}
			s += cur.node.data;
		}
		System.out.println(s);
	}

	public double maxOffset = 0;
	public HashMap<Double, QueueObj> toHashMap() {
		if (isEmpty()) {
			return new HashMap<Double, QueueObj>();
		}
		int height = getHeight();
		LinkedList<QueueObj> q = new LinkedList<QueueObj>();
		HashMap<Double, QueueObj> map = new HashMap<Double, QueueObj>();
		double rootOffset = Math.pow(2, height-1);
		q.add(new QueueObj(root, 0, rootOffset));
		if (rootOffset > maxOffset) {
			maxOffset = rootOffset;
		}
		while (!q.isEmpty()){
			QueueObj cur = q.remove();
			if (cur.offset > maxOffset) {
				maxOffset = cur.offset;
			}
			double offsetMod = Math.pow(2, height-(cur.depth+2));
			if (cur.node.left != null) {
				q.add(new QueueObj(cur.node.left, cur.depth + 1, cur.offset - offsetMod));
			}
			if (cur.node.right != null) {
				q.add(new QueueObj(cur.node.right, cur.depth + 1, cur.offset + offsetMod));
			}
			if (!map.containsKey(cur.offset)) {
				map.put(cur.offset, cur);
			}
			else {
	        	throw new NoSuchElementException("more than one node in tree with the same offset?");
			}
		}
		return map;
	}


	public void pprintVert() {
		System.out.println("printing tree");

		if (isEmpty()) {
			System.out.println("Empty Tree");
			System.out.println("tree printing complete");
			return;
		}

		HashMap<Double, QueueObj> map = toHashMap();
		for (int i = 0; i < maxOffset; i++) {
			if (map.containsKey((double) (maxOffset - i))) {
				QueueObj cur = map.get(maxOffset - i);
				String s = new String();
				for (int j = 0; j < cur.depth; j++) {
					s += "  ";
				}
				System.out.println(s + cur.node.data);
			}
			else {
				System.out.println();
			}
		}
		System.out.println("tree printing complete");
		
	}

	public static void main(String[] args) {
//		BST<Integer> b = new BST<Integer>();
//		b.preOrderPrint();
//		b.inOrderPrint();
//		b.postOrderPrint();
//        Random ran = new Random(); 
////    	ran.setSeed(1);
//		for(int i = 0; i < 	5; i++) {
//			b = new BST<Integer>();
//			for (int j = 0; j < 5; j++) {
//				b.insert(ran.nextInt(20));
//			}
//			b.pprintVert();
//			BST<Integer> bb = new BST<Integer>(b);
//			bb.pprintVert();
//			System.out.println("max = " + b.findMax());
//			System.out.println("min = " + b.findMin());
//		}        	
//
//
//		
//		BST<Integer> bv = new BST<Integer>();
//		for (int j = 0; j < 4; j++) {
//			bv.insert(j);
//		}
//		for (int j = -3; j < 0; j++) {
//			bv.insert(j);
//		}
//		bv.pprint();
//		System.out.println(bv.toHashMap());
//		System.out.println(bv.maxOffset);
//		bv.pprintVert();
//		bv.remove(-1);
//		bv.pprintVert();
//		bv.remove(2);
//		bv.pprintVert();
//		bv.remove(0);
//		bv.pprintVert();

		
		
		
		
		
		
		
		BST<Integer> intBst = new BST<Integer>(); 
        BST<Double> doubleBst = new BST<Double>(); 
        BST<Character> charBst = new BST<Character>(); 
        

        System.out.println("**Integer BST Tests**\n");
        System.out.println("Should be empty (true): " + intBst.isEmpty());
        System.out.println("Size of an empty tree (0): " + intBst.getSize());
        System.out.println("Height of an empty tree, i.e. root is null (-1): " + intBst.getHeight());
        intBst.insert(10);
        System.out.println("Inserting 10. 10 should be root: " + intBst.getRoot());
        System.out.println("Inserting 22, 12, 41, 17, 68...");
        intBst.insert(22);
        intBst.insert(12);
        intBst.insert(41);
        intBst.insert(17);
        intBst.insert(68);
        System.out.println("InOrderPrint: Should print out 10 12 17 22 41 68:");
        intBst.inOrderPrint();
        System.out.println("PreOrderPrint: Should print out 10 22 12 17 41 68:");
        intBst.preOrderPrint();
        System.out.println("PostOrderPrint: Should print out 17 12 68 41 22 10:");
        intBst.postOrderPrint();
        
        System.out.println("Should not be empty (false); " + intBst.isEmpty());
        System.out.println("10 should still be root: " + intBst.getRoot());
        System.out.println("Minimum should be 10: " + intBst.findMin());
        System.out.println("Maximum should be 68: " + intBst.findMax());
        System.out.println("Size should be 6: " + intBst.getSize());
        System.out.println("Height should be 3: " + intBst.getHeight());
        System.out.println("Searching for 20 (false): " + intBst.search(20));
        System.out.println("Searching for 17 (true): " + intBst.search(17));
        System.out.println("Removing 17...");
        intBst.remove(17);
        System.out.println("Searching for 17 (false): " + intBst.search(17));
        System.out.println("InOrderPrint: Should print out 10 12 22 41 68:");
        intBst.inOrderPrint();
        
        System.out.println( "Copying the tree...");
        BST<Integer> intBstCopy = new BST<Integer>(intBst); //copying intBst
        System.out.println("InOrderPrint: Copy should print out 10 12 22 41 68:");
        intBstCopy.inOrderPrint();
        System.out.println("Two copies are equal (true): " + intBstCopy.equals(intBst));
        System.out.println("Testing for deep copy...Removing 10 from copy...");
        intBstCopy.remove(10);
        System.out.println("InOrderPrint: Copy should print out 12 22 41 68:");
        intBstCopy.inOrderPrint();
        System.out.println("InOrderPrint: Original should print out 10 12 22 41 68:");
        intBst.inOrderPrint();
        System.out.println("Copy size (4): " + intBstCopy.getSize());
        System.out.println("Original size (5): " + intBst.getSize());
        System.out.println("Two copies are equal (false): " + intBstCopy.equals(intBst));
        
        System.out.println("\n\n**Character BST Tests**\n");
        System.out.println("Inserting D, A, C, S, B, P...");
        charBst.insert('D');
        charBst.insert('A');
        charBst.insert('C');
        charBst.insert('S');
        charBst.insert('B');
        charBst.insert('P');
        charBst.insert('Z');
        
        System.out.println("InOrderPrint: Should print out A B C D P S Z:");
        charBst.inOrderPrint();
        System.out.println("PreOrderPrint: Should print out D A C B S P Z:");
        charBst.preOrderPrint();
        System.out.println("PostOrderPrint: Should print out B C A P Z S D:");
        charBst.postOrderPrint();
        System.out.println("Should not be empty (false); " + charBst.isEmpty());
        System.out.println("Root should be D: " + charBst.getRoot());
        System.out.println("Minimum should be A: " + charBst.findMin());
        System.out.println("Maximum should be Z: " + charBst.findMax());
        System.out.println("Size should be 7: " + charBst.getSize());
        System.out.println("Height should be 3: " + charBst.getHeight());
        System.out.println("Searching for Z (true): " + charBst.search('Z'));
        System.out.println("Searching for D (true): " + charBst.search('D'));
        System.out.println("Searching for Q (false): " + charBst.search('Q'));
        System.out.println("Checking 3 cases of remove....");
        System.out.print("Removing Z (easy case): ");
        charBst.remove('Z');
        charBst.inOrderPrint();
        System.out.print("Removing C (medium case): ");
        charBst.remove('C');
        charBst.inOrderPrint();
        System.out.print("Removing D (hard case): ");
        charBst.remove('D');
        charBst.inOrderPrint();
        
        System.out.println( "Copying the tree...");
        BST<Character> charBstCopy = new BST<Character>(charBst); //copying intBst
        System.out.println("InOrderPrint: Copy should print out A B P S:");
        charBstCopy.inOrderPrint();
        System.out.println("Testing for deep copy...Inserting Q in the copy...");
        charBstCopy.insert('Q');
        System.out.println("InOrderPrint: Copy should print out A B P Q S:");
        charBstCopy.inOrderPrint();
        System.out.println("InOrderPrint: Original should print out A B P S:");
        charBst.inOrderPrint();
        System.out.println("Copy size (5): " + charBstCopy.getSize());
        System.out.println("Original size (4): " + charBst.getSize());
        
        System.out.println("\n\n**Testing error messages**\n");
        
        try {
            System.out.println("Error for getRoot. Tree is empty.");
            doubleBst.getRoot();
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }
        
        try {
            System.out.println("Error for remove. Element not found.");
            charBstCopy.remove('Z');
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }
        
        try {
            System.out.println("Error for remove. Tree is empty.");
            doubleBst.remove(3.5);
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }
        
        try {
            System.out.println("Error for findMin. Tree is empty.");
            doubleBst.findMin();
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }
        
        try {
            System.out.println("Error for findMax. Tree is empty.");
            doubleBst.findMax();
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }
        

	}

}
