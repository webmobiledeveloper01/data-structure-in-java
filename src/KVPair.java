
/**
 * This class holds a generic Key-value pair implementation. The purpose of this
 * class is to hold generic KVPair object which will be stored in the BST.
 * There is also a toString method for easily translating the objects contained
 * in the KVPair into a human readable string.
 * 
 * @author CS Staff
 * 
 * @version 2024-05-22
 * @param <K>
 *            Key to be used
 * @param <V>
 *            Value to be associated with the key
 */

// public class KVPair<K, V> implements Comparable<KVPair<K, V>> {
// Another Implementation choice is to require KPair to implement Comparable not
// K
public class KVPair<K extends Comparable<K>, V>
    implements Comparable<KVPair<K, V>> {

    // the object to be a key
    private K key;
    // the object to be the value at the key
    private V value;
    
    public KVPair() {
        key = null;
        value = null;
    }
    /**
     * The constructor assigns value to the key and value fields from user
     * specified objects.
     * 
     * @param strKey
     *            the key for the KVPair
     * @param val
     *            the value for the KVPair
     */
    public KVPair(K strKey, V val) {
        this.key = strKey;
        this.value = val;
    }


    /**
     * Returns the key of this KVPair
     *
     * @return the key of the KVPair
     */
    public K getKey() {
        return key;
    }


    /**
     * Returns the value of this KVPair
     *
     * @return the value that the KVPair holds
     */
    public V getValue() {
        return value;
    }


    /**
     * Returns the KVPair in a human readable format.
     *
     * @return A human readable string representing the KVPair object
     */
    public String toString() {
       
        if(key == null) return "";
        return String.format("(%s, %s)", key, value);
    }


    /**
     * You should implement the compareTo method from the Comparable interface.
     * This will be used to easily compare two KVPair objects.
     *
     * @param o
     * @return
     */
    @Override
    public int compareTo(KVPair<K, V> o) {
        // TODO Auto-generated method stub
    	if(key.compareTo(o.getKey()) > 0) return 1; 
    	else if(key.compareTo(o.getKey()) < 0) return -1; 
    	else if(value.toString().equals(o.getValue().toString()))
	        return 0;
	    return 1;
//    	    else if(value.toString().compareTo(o.getValue().toString()) > 0) return 1; 
//            else if(value.toString().compareTo(o.getValue().toString()) < 0) return -1; 
    	
//        return 0;
    }
    
}
