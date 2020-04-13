package Exercise10BST;
/**
 * This class contains static methods used for BSTs opeartions
 * **/
public class BSTsTools {
	/** recursive search method---tool method,unrelated to this BSTs**/
	public static BST.Node recursiveSearch(BST.Node top, Comparable target){
		if(top == null) return null;
		else {
			int comp = target.compareTo(top.element);
			if(comp == 0)
				return top;
			else if(comp<0)
				return recursiveSearch(top.left, target);
			else
				return recursiveSearch(top.right,target);
		}
	}
	
	/** Recursive insert method---static method**/
	public static BST.Node recursiveInsert(BST.Node top, Comparable elem) {
		// Insert the element elemin the subtree whose topmost node is top.
		// Return a link to the modified subtree.
		if (top == null) {
			top = new BST.Node(elem);
			return top;
		} else {

			int comp = elem.compareTo(top.element);
			if (comp < 0)
				top.left = recursiveInsert(top.left, elem);
			else if (comp > 0)
				top.right = recursiveInsert(top.right, elem);
		}
		return top;

	}
	/** recursive delete method**/
	public static BST.Node recursiveDelete (BST.Node top, Comparable elem) {
		if(top == null) return top;
		else {
			int comp = elem.compareTo(top.element);
			if(comp == 0)
				return top.deleteTopmost();
			else if(comp < 0) {
				top.left = recursiveDelete(top.left, elem);
			}
				else top.right = recursiveDelete(top.right, elem);
			
		}
		return top;
	}
}
