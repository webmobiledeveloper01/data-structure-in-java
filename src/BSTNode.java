
public class BSTNode<T extends Comparable<T>> {
    /** The left */
    private BSTNode<T> left;
    /** The right */
    private BSTNode<T> right;
    /** The value storing comparable rectangle node */
    private T value;
    
//    public BSTNode() {
//        setValue(null);
//    }

    /**
     * Instantiates a new node
     * 
     * @param value
     *            the value
     */
    public BSTNode(T value) {
    	setValue(value);
    }
    
    public T getValue() {
		return value;
	}
    
    public void setValue(T value) {
		this.value = value;
	}
    
    public BSTNode<T> getLeft() {
		return left;
	}
	
	public void setLeft(BSTNode<T> left) {
		this.left = left;
	}
	
	public BSTNode<T> getRight() {
		return right;
	}
	
	public void setRight(BSTNode<T> right) {
		this.right = right;
	}

//    // It could be worth including a toString() method for BSTNode for easier
//    // debugging!
//    /**
//     * Returns the BSTNode in a human readable format.
//     *
//     * @return A human readable string representing the BSTNode object
//     */
//    public String toString() {
//        return String.format("%s", value);
//    }
}
