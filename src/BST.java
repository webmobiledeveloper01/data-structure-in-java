
import java.util.Iterator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Stub for binary search tree class
 * We use generics here because we want this BST to be able to hold more than
 * just Rectangles (or KVPairs)
 * 
 * @author {Your Name Here}
 * @param <T>
 *            the generic type; extends Comparable
 */
public class BST<T extends Comparable<T>> implements Iterable<BSTNode<T>> {
    /** The root. */
    private BSTNode<T> root;

    /** The size. */
    private int size;

    /**
     * Instantiates a new Binary Search Tree.
     */
    public BST() {
        root = null;
        size = 0;
        
    }
    
    /**
	 * Adds a data entry to the BST
	 * 
	 * null is positive infinity
	 * 
	 * @param data The data entry to add
	 */
	public void add(T data) {
		root = add(data, root);
	}
	
	/**
	 * Recursive add() method helper
	 */
	private BSTNode<T> add(T data, BSTNode<T> node){	
		if(node == null) {
			node = new BSTNode<T>(data);
			int bstSize = 0;
			bstSize = getSize();
			bstSize++;
			setSize(bstSize);	
		} 
		else{
//			if(data == null){
//				node.setRight(add(data, node.getRight()));
//			}else{
//				if(node.getValue() == null){
//					node = new BSTNode<T>(data);
//					node.setRight(add(null, node.getRight()));
//				}
				if(data.compareTo(node.getValue()) <= 0){
					node.setLeft(add(data, node.getLeft()));
				}
				if(data.compareTo(node.getValue()) > 0){
					node.setRight(add(data, node.getRight()));	
				}
//			}	
		}
			
		return node;
	} 
	
	/**
	 * Adds each data entry from the collection to this BST
	 * 
	 * @param c
	 */
//	public void addAll(Collection<? extends T> c) {
//		for(T data : c){
//			add(data);	
//		}
//	}
	
	/**
	 * Removes a data entry from the BST
	 * 
	 * null is positive infinity
	 * 
	 * @param data The data entry to be removed
	 * @return The removed data entry (null if nothing is removed)
	 * 
	 */
	public T remove(T data) {
		boolean b = false;
//		if(contains(data)){
//			b = true;
//		}
		b = contains(data);
		root = remove(root, data);
		if(!b) return null;
		return data;
	}
	
	private BSTNode<T> remove(BSTNode<T> here, T data) {
		if (here != null) {	
			if (data.compareTo(here.getValue()) < 0) {
				here.setLeft(remove(here.getLeft(), data));
			} else if (data.compareTo(here.getValue()) > 0) {
				here.setRight(remove(here.getRight(), data));
			} else { 		    
				here = removeNode(here);
			}
		}
		return here;
	}
	
	private BSTNode<T> removeNode(BSTNode<T> here) {
		if (here.getLeft() == null)
			here = here.getRight() ;
		else if (here.getRight() == null)
			here = here.getLeft();
		else {			
				BSTNode<T> big = here.getLeft();
				BSTNode<T> last = null;
				while (big.getRight() != null) {
					last = big;
					big = big.getRight();
				}
//				here.data = big.data;
				here.setValue(big.getValue());
				if (last == null) {
//					here.left = big.left;
					here.setLeft(big.getLeft());
				} else {
//					last.right = big.left;
					here.setRight(big.getLeft());
				}
			}	
		return here;
	}
	
	/**
	 * Checks if the BST contains a data entry
	 * 
	 * null is positive infinity
	 * 
	 * @param data The data entry to be checked
	 * @return If the data entry is in the BST 
	 */
	public boolean contains(T data) {
//		if(root == null)
//			return false;
		return search(data, getRoot());
		
	}
	
	/**
	 * Return the depth of a data entry in the BST
	 * 
	 * @param data The data entry to be checked
	 * @return the depth of a data entry is in the BST 
	 */
	
	public int getDepth(T data) {
		if(root == null){
			return 0;
		}else{
			return getDepth(data, root);
		}
	}
	
	public int getDepth(T data, BSTNode<T> node) {
        if (node == null) {
            return 0; // Data not found, return -1 to indicate it
        }

        int comparison = data.compareTo(node.getValue());

        if (comparison == 0) {
            return 0; // Data found, return 0 for its depth
        } else if (comparison < 0) {
            int leftDepth = getDepth(data, node.getLeft());
            return (leftDepth != -1) ? leftDepth + 1 : -1;
        } else {
            int rightDepth = getDepth(data, node.getRight());
            return (rightDepth != -1) ? rightDepth + 1 : -1;
        }
    }
	
	
	
	public boolean search(T data, BSTNode<T> node){
//		if(data.compareTo(node.getValue()) == 0) return true;
		if(data.compareTo(node.getValue()) < 0){
//			if(node.getLeft() == null) return false;
		    if(node.getLeft() != null)
		        return search(data, node.getLeft());
		}else if(data.compareTo(node.getValue()) > 0){
			//if(node.getRight() == null) return false;
		    if(node.getRight() != null)
		        return search(data, node.getRight());
		}
		return true;	
	}
	
	
	/**
	 * Finds the pre-order traversal of the BST
	 * 
	 * @return A list of the data set in the BST in pre-order
	 */
	public List<T> preOrder() {
		List<T> list = new ArrayList<T>();
		preOrder(root, list);
		return  list;	
	}
	
	public void preOrder(BSTNode<T> node, List<T> list) {
		if(node != null){
			list.add(node.getValue());
			preOrder(node.getLeft(), list);
			preOrder(node.getRight(), list);
		}	
	}
	
	/**
	 * Finds the in-order traversal of the BST
	 * 
	 * @return A list of the data set in the BST in in-order
	 */
	public List<T> inOrder() {
		List<T> list = new ArrayList<T>();
		inOrder(root, list);
		return list;
	}
	
	public void inOrder(BSTNode<T> node, List<T> list){
		if(node != null){
			inOrder(node.getLeft(), list);
			list.add(node.getValue());
			inOrder(node.getRight(), list);	
		}
	}
	
	/**
	 * Finds the post-order traversal of the BST
	 * 
	 * @return A list of the data set in the BST in post-order
	 */
	public List<T> postOrder() {
		List<T> list = new ArrayList<T>();
		postOrder(root, list);
		return list;
	}
	public void postOrder(BSTNode<T> node, List<T> list){
		if(node != null){
			postOrder(node.getLeft(), list);
			postOrder(node.getRight(), list);
			list.add(node.getValue());
		}
	}
	
//	private int searchInOrderOffsetPre(List<? extends T> inorder, T key, int index) {
//		int offset = 0;
//		for (int i = index; i < inorder.size(); i++) {
//			if(inorder.get(i) == null && key == null){
//				return offset;
//			}
//			if (inorder.get(i).compareTo(key) == 0 ) {
//				return offset;
//			}	
//			offset++;
//		}
//		return -1;
//	}	
	
	/**
	 * Checks to see if the BST is empty
	 * 
	 * @return If the BST is empty or not
	 */
//	public boolean isEmpty() {
//		return root == null;
//	}
	
	/**
	 * Clears this BST
	 */
	public void clear() {
		root = null;
	}

    /**
     * Size of the tree
     *
     * @return the tree size as an int
     */
    public int size() {
        return size;
    }
    
    /**
	 * First clears this BST, then reconstructs the BST that is
	 * uniquely defined by the given preorder and inorder traversals
	 * 
	 * (When you finish, this BST should produce the same preorder and
	 * inorder traversals as those given)
	 * 
	 * @param preorder a preorder traversal of the BST to reconstruct
	 * @param inorder an inorder traversal of the BST to reconstruct
	 */
	
//	public void reconstruct(List<? extends T> preorder, List<? extends T> inorder) {
//		if(preorder == null){
//			throw new NullPointerException("Cannot build a tree if preorder is null");
//		}
//		clear();
//		root = reconstruct(preorder, inorder, 0, 0, preorder.size());
//	}
	
//	private BSTNode<T> reconstruct(List<? extends T> preorder, List<? extends T> inorder, int p, int q, int length){
//		if(preorder == null || length ==0){
//			return null;
//		}
//		BSTNode<T> node = new BSTNode<T>(preorder.get(p));
//		int offset = searchInOrderOffsetPre(inorder, 	preorder.get(p), q);
//		node.setLeft(reconstruct(preorder, inorder, p + 1, q, offset));
////		node.left = reconstruct(preorder, inorder, p + 1, q, offset);
//		node.setRight(reconstruct(preorder, inorder, p + offset + 1, q + offset + 1, length - (offset + 1)));
////		node.right = reconstruct(preorder, inorder, p + offset + 1, q + offset + 1,length - (offset + 1));
//		
//		return node;			
//	}
	
	public BSTNode<T> getRoot() {
		return root;
	}

	public void setRoot(BSTNode<T> root) {
		this.root = root;
	}
	
	public void setSize(int size) {
		this.size = size;
	}
	
	public int getSize() {
        return this.size;
    }

    /**
     * This is an auto-generated method stub for an iterator object because we
     * have implemented Iterable to traverse the BST (perhaps during the
     * intersections command)
     */
    @Override
    public Iterator<BSTNode<T>> iterator() {
        // TODO Auto-generated method stub
        return null;
    }

}
