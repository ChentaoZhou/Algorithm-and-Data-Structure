package Exercise10BST;

public class BST {
	
	/** Inner class **/
	private static class Node <E extends Comparable<E>> {
		protected E element;
		protected Node<E> left, right;
		
		protected Node(E elem) {		
			element = elem;			
			left = null;  right = null;		
		}
	}
	
	/**Search method**/
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

	
	
}
