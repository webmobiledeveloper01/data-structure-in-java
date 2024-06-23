
import java.util.Iterator;
import java.util.List;

/**
 * This class is responsible for interfacing between the command processor and
 * the BST. The responsibility of this class is to further interpret
 * variations of commands and do some error checking of those commands. This
 * class further interpreting the command means that the two types of remove
 * will be overloaded methods for if we are removing by name or by coordinates.
 * Many of these methods will simply call the appropriate version of the
 * BST method after some preparation.
 * 
 * @author CS Staff
 * 
 * @version 2024-05-22
 */
public class Database {

    // this is the BST object that we are using a
    // string for the name of the rectangle and then
    // a rectangle object, these are stored in a BSTNode,
    // see the Rectangle class for more information
    private BST<KVPair<String, Rectangle>> tree;

    // This is an Iterator object over the BST to loop through it from outside
    // the class.
    // You will need to define an extra Iterator for the intersections method.
    private Iterator<KVPair<String, Rectangle>> itr1;

    /**
     * The constructor for this class initializes a BST object
     * with a KVPair of Strings and Rectangles
     */
    public Database() {
        tree = new BST<KVPair<String, Rectangle>>();
    }


    /**
     * Inserts the KVPair in the BST if the rectangle has valid coordinates
     * and dimensions, that is that the coordinates are non-negative and that
     * the rectangle object has some area (not 0, 0, 0, 0). This insert will
     * add the KVPair specified into the sorted BST appropriately
     * 
     * @param pair
     *            the KVPair to be inserted
     */
    public void insert(KVPair<String, Rectangle> pair) {
        // Delegates the decision mostly to BST, only
        // writing the correct message to the console from
        // that
    	tree.add(pair);
    	
    }


    /**
     * Removes a rectangle with the name "name" if available. If not an error
     * message is printed to the console.
     * 
     * @param name
     *            the name of the rectangle to be removed
     */
    public void remove(String name) {
    	List<KVPair<String, Rectangle>> rectangleList;
    	rectangleList = (List<KVPair<String, Rectangle>>) tree.postOrder();
    	for (KVPair<String, Rectangle> element : rectangleList) {
//    		System.out.println("(" + element.getKey()+", " + element.getValue().toString() + ")" );
    		if(element.getKey().compareTo(name) == 0) {
    	       if(tree.remove(element)!= null) {
    	           System.out.println("Rectangle removed: (" + element.getKey()+", " + element.getValue().toString() + ")" );
                   return;
    	       }	
    		}			
        }
    	System.out.println("Rectangle not found: (" + name + ")" );
    }


    /**
     * Removes a rectangle with the specified coordinates if available. If not
     * an error message is printed to the console.
     * 
     * @param x
     *            x-coordinate of the rectangle to be removed
     * @param y
     *            x-coordinate of the rectangle to be removed
     * @param w
     *            width of the rectangle to be removed
     * @param h
     *            height of the rectangle to be removed
     */
    public void remove(int x, int y, int w, int h) {
    	
    	List<KVPair<String, Rectangle>> rectangleList;
    	rectangleList = (List<KVPair<String, Rectangle>>)tree.postOrder();
    	Rectangle rect = new Rectangle(x, y, w, h);
    	for (KVPair<String, Rectangle> element : rectangleList) {
    		if(element.getValue().equals(rect)) {
			    if(tree.remove(element)!= null) {
			        System.out.println("Rectangle removed: (" + element.getKey()+", " + element.getValue().toString() + ")" );
	                return; 
			    }
			    
    		}			
        }
    	System.out.println("Rectangle not found: (" + rect.toString() + ")" );
    }


    /**
     * Displays all the rectangles inside the specified region. The rectangle
     * must have some area inside the area that is created by the region,
     * meaning, Rectangles that only touch a side or corner of the region
     * specified will not be said to be in the region.
     * 
     * @param x
     *            x-Coordinate of the region
     * @param y
     *            y-Coordinate of the region
     * @param w
     *            width of the region
     * @param h
     *            height of the region
     */
    public void regionsearch(int x, int y, int w, int h) {
    	List<KVPair<String, Rectangle>> rectangleList;
    	rectangleList = (List<KVPair<String, Rectangle>>)tree.preOrder();
    	for (KVPair<String, Rectangle> element : rectangleList) {
    		Rectangle rect = new Rectangle(x, y, w, h);
    		if(element.getValue().intersect(rect)) {
    		    System.out.println("(" + element.getKey()+", " + element.getValue().toString() + ")" );
    		}		
        }
    }


    /**
     * Prints out all the rectangles that intersect each other. Note that
     * it is better not to implement an intersections method in the BST class
     * as the BST needs to be agnostic about the fact that it is storing
     * Rectangles.
     */
    public void intersections() {
    	List<KVPair<String, Rectangle>> rectangleList;
    	rectangleList = (List<KVPair<String, Rectangle>>)tree.preOrder(); 
    	int i = 0, j = 0;
    	int rectSize = rectangleList.size() - 1;
    	for (i = 0; i < rectSize; i++) {
	        for (j = i + 1 ; j < rectSize + 1; j++) {
	        	Rectangle rect = rectangleList.get(i).getValue();
	        	if(!rect.isInvalid())
	        	    if(rect.intersect(rectangleList.get(j).getValue()))
	                    System.out.println("(" + rectangleList.get(i).getKey()+", " + rectangleList.get(i).getValue().toString() + ")"
	                            + " | (" + rectangleList.get(j).getKey()+", " + rectangleList.get(j).getValue().toString() + ")");
	        	
	        }
    	}
    }


    /**
     * Prints out all the rectangles with the specified name in the BST.
     * This method will delegate the searching to the BST class completely.
     * 
     * @param name
     *            name of the Rectangle to be searched for
     */
    public void search(String name) {
    	List<KVPair<String, Rectangle>> rectangleList;
    	rectangleList = (List<KVPair<String, Rectangle>>)tree.postOrder();
//    	int i = 0;
    	boolean bFirstShow = true;
    	for (KVPair<String, Rectangle> element : rectangleList) {
//    		System.out.println("(" + element.getKey()+", " + element.getValue().toString() + ")" );
    		if(element.getKey().compareTo(name) == 0) {
//    			if(i == 0)
    		    if(bFirstShow) {
    		        System.out.println("Rectangles found matching \"" + name + "\":");
    		        bFirstShow = false;
    		    }
    				
    			System.out.println("(" + element.getKey()+", " + element.getValue().toString() + ")" );
//    			i++;
    		}			
        }
//    	if(i == 0)
    	if(bFirstShow)
    		System.out.println("Rectangle not found: (" + name + ")" );
    }


    /**
     * Prints out a dump of the BST which includes information about the
     * size of the BST and shows all of the contents of the BST. This
     * will all be delegated to the BST.
     */
    public void dump() {
    	List<KVPair<String, Rectangle>> rectangleList;
    	rectangleList = (List<KVPair<String, Rectangle>>)tree.inOrder();
    	if(rectangleList.size() == 0)
    		System.out.println("Node has depth " + tree.getDepth(null) + ", Value (" + tree.getRoot() + ")");
    	else {
    		for (KVPair<String, Rectangle> element : rectangleList) {
    			System.out.println("Node has depth " + tree.getDepth(element) + ", Value (" + element.getKey() + ", " + element.getValue().toString() + ")");
//        		System.out.println("(" + element.getKey()+", " + element.getValue().toString() + ")" );		
            }
    	}
    	System.out.println("BST size is: " + tree.size());
    }

}
