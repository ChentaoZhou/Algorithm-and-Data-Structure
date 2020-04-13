package Exercise10BST;



public class BST<E extends Comparable<E>> {
	// Each BST object is a binary-search-tree header.
	private BST.Node<E> root;

	public BST() {
		// Construct an empty BST.
		root = null;
	}

	// //////// Inner class //////////
	private static class Node<E extends Comparable<E>> {
		protected E element;
		protected Node<E> left, right;

		protected Node(E elem) {
			element = elem;
			left = null;
			right = null;
		}

		public Node<E> deleteTopmost() {
			if (this.left == null)
				return this.right;
			else if (this.right == null)
				return this.left;
			else { // this node has two children
				this.element = this.right.getLeftmost();
				this.right = this.right.deleteLeftmost();
				return this;
			}
		}

		private E getLeftmost() {
			Node<E> curr = this;
			while (curr.left != null)
				curr = curr.left;
			return curr.element;
		}

		public Node<E> deleteLeftmost() {
			if (this.left == null)
				return this.right;
			else {
				Node<E> parent = this, curr = this.left;
				while (curr.left != null) {
					parent = curr;
					curr = curr.left;
				}
				parent.left = curr.right;
				return this;
			}
		}

	}

	// ///// end of inner class ///////////

	public BST.Node<E> search(E target) {
		int direction = 0;
		BST.Node<E> curr = root;
		for (;;) {
			if (curr == null)
				return null;
			direction = target.compareTo(curr.element);
			if (direction == 0)
				return curr;
			else if (direction < 0)
				curr = curr.left;
			else
				curr = curr.right;
		}
	}
	/** recursive search method---tool method,unrelated to this BSTs**/
	public static BST.Node search(BST.Node top, Comparable target){
		if(top == null) return null;
		else {
			int comp = target.compareTo(top.element);
			if(comp == 0)
				return top;
			else if(comp<0)
				return search(top.left, target);
			else
				return search(top.right,target);
		}
	}

	public void insert(E elem) {
		int direction = 0;
		BST.Node<E> parent = null, curr = root;
		for (;;) {
			if (curr == null) {
				BST.Node<E> ins = new BST.Node<E> (elem);
				if (root == null)
					root = ins;
				else if (direction < 0)
					parent.left = ins;
				else
					parent.right = ins;
				return;
			}
			direction = elem.compareTo(curr.element);
			if (direction == 0)
				return;
			parent = curr;
			if (direction < 0)
				curr = curr.left;
			else
				curr = curr.right;
		}
	}

	/** Recursive insert method---static method**/
	public static BST.Node insert(BST.Node top, Comparable elem) {
		// Insert the element elemin the subtree whose topmost node is top.
		// Return a link to the modified subtree.
		if (top == null) {
			top = new BST.Node(elem);
			return top;
		} else {

			int comp = elem.compareTo(top.element);
			if (comp < 0)
				top.left = insert(top.left, elem);
			else if (comp > 0)
				top.right = insert(top.right, elem);
		}
		return top;

	}


	public void delete(E elem) {
		int direction = 0;
		BST.Node<E> parent = null, curr = root;
		for (;;) {
			if (curr == null)
				return;
			direction = elem.compareTo(curr.element);
			if (direction == 0) {
				BST.Node<E> del = curr.deleteTopmost();
				if (curr == root)
					root = del;
				else if (curr == parent.left)
					parent.left = del;
				else
					parent.right = del;
				return;
			}

			parent = curr;
			if (direction < 0)
				curr = parent.left;
			else
				// direction > 0
				curr = parent.right;
		}
	}
		
	public void printInOrder () {
		printInOrder(root);
		}
		
		
		private static <E extends Comparable<E>>  void printInOrder (BST.Node<E> top) {
			// Print, in ascending order, all the elements in the BST 
			// subtree whose topmost node is top.
			if (top != null) {
				printInOrder(top.left);
				System.out.println(top.element);
				printInOrder(top.right);
				}
			
		


	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	   BST<String> animals = new BST<String>();
	   
	   animals.insert("lion");
	   animals.insert("fox");
	   animals.insert("rat");
	   animals.insert("cat");
	   animals.insert("pig");
	   animals.insert("dog");
	   animals.insert("tiger");
	   animals.printInOrder();
	   
	   

	}

}
