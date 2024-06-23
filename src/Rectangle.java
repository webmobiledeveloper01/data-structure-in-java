

/**
 * This class holds the coordinates and dimensions of a rectangle and methods to
 * check if it intersects or has the same coordinates as an other rectangle.
 * 
 * @author CS Staff
 * 
 * @version 2024-01-22
 */
public class Rectangle {
    // the x coordinate of the rectangle
    private int xCoordinate;
    // the y coordinate of the rectangle
    private int yCoordinate;
    // the distance from the x coordinate the rectangle spans
    private int width;
    // the distance from the y coordinate the rectangle spans
    private int height;
    
    public Rectangle() {
        xCoordinate = 0;
        yCoordinate = 0;
        width = 5;
        height = 5;
    }

    /**
     * Creates an object with the values to the parameters given in the
     * xCoordinate, yCoordinate, width, height
     * 
     * @param x
     *            x-coordinate of the rectangle
     * @param y
     *            y-coordinate of the rectangle
     * @param w
     *            width of the rectangle
     * @param h
     *            height of the rectangle
     */
    public Rectangle(int x, int y, int w, int h) {
        xCoordinate = x;
        yCoordinate = y;
        width = w;
        height = h;
    }


    /**
     * Getter for the x coordinate
     *
     * @return the x coordinate
     */
    public int getxCoordinate() {
        return xCoordinate;
    }
    
    /**
     * Setter for the x coordinate
     *
     */
    public void setxCoordinate(int xCoord) {
        xCoordinate = xCoord;
    }


    /**
     * Getter for the y coordinate
     *
     * @return the y coordinate
     */
    public int getyCoordinate() {
        return yCoordinate;
    }
    
    /**
     * Setter for the y coordinate
     *
     */
    public void setyCoordinate(int yCoord) {
        yCoordinate = yCoord;
    }

    /**
     * Getter for the width
     *
     * @return the width
     */
    public int getWidth() {
        return width;
    }
    
    /**
     * Setter for the width
     *
     */
    public void setWidth(int w) {
        width = w;
    }

    /**
     * Getter for the height
     *
     * @return the height
     */
    public int getHeight() {
        return height;
    }
    
    /**
     * Setter for the height
     *
     */
    public void setHeight(int h) {
        height = h;
    }
//
//
//    /**
//     * Checks if the invoking rectangle intersects with rec.
//     * 
//     * @param r2
//     *            Rectangle parameter
//     * @return true if the rectangle intersects with rec, false if not
//     */
    public boolean intersect(Rectangle r2) {
    	int x11, y11, x12, y12;
    	int x21, y21, x22, y22;
    	x11 = xCoordinate;
    	y11 = yCoordinate;
    	x12 = x11 + width;
    	y12 = y11 + height;
    	
    	x21 = r2.getxCoordinate();
    	y21 = r2.getyCoordinate();
    	x22 = x21 + r2.getWidth();
    	y22 = y21 + r2.getHeight();
//    	if(x11 >= x21) {
    	if(x11 >= x21 && x11 <= x22) {
    		if(y11 >= y21 && y11 <= y22 || y11 < y21 && y12 > y21) 
    		    return true;
    	}
    	else if(x11 < x21 && x12 > x21) {
    		if(y11 < y21 && y12 > y21 || y11 < y22 && y12 > y22) return true;
    	}
        return false;
    }
//
//
//    /**
//     * Checks, if the invoking rectangle has the same coordinates as rec.
//     * 
//     * @param rec
//     *            the rectangle parameter
//     * @return true if the rectangle has the same coordinates as rec, false if
//     *         not
//     */
    public boolean equals(Rectangle rec) {
    	if(xCoordinate == rec.getxCoordinate() && yCoordinate == rec.getyCoordinate() && width == rec.getWidth() && height == getHeight()) return true;
        return false;
    }


    /**
     * Outputs a human readable string with information about the rectangle
     * which includes the x and y coordinate and its height and width
     * 
     * @return a human readable string containing information about the
     *         rectangle
     */
    public String toString() {
    	return String.format("%s, %s, %s, %s", xCoordinate, yCoordinate, width, height);
//        return null;
    }


    /**
     * Checks if the rectangle has invalid parameters
     * 
     * @return true if the rectangle has invalid parameters, false if not
     */
    public boolean isInvalid() {
        if(xCoordinate < 0 || xCoordinate >= 1024) return true;
        if(yCoordinate < 0 || yCoordinate >= 1024) return true;
        if(width <= 0 || width > 1024) return true;
        if(height <= 0 || height > 1024) return true;
        if(xCoordinate + width > 1024) return true;
        if(yCoordinate + height > 1024) return true;
        return false;

    }
}
