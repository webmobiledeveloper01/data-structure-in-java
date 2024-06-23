
import student.TestCase;


public class RectangleTest extends TestCase {
    private Rectangle rect;
    
    public void setUp()
    {
        // initialize it here
        rect = new Rectangle();
    }
    
	
	void testRectangle() {
		Rectangle rectangle = new Rectangle();
		assertEquals(rectangle.getxCoordinate(), 0);
		assertEquals(rectangle.getyCoordinate(), 0);
		assertEquals(rectangle.getWidth(), 0);
		assertEquals(rectangle.getHeight(), 0);
	}

	void testRectangleParamConstructor() {
		Rectangle rectangle = new Rectangle(5, 5, 3, 5);
		assertEquals(rectangle.getxCoordinate(), 5);
		assertEquals(rectangle.getyCoordinate(), 5);
		assertEquals(rectangle.getWidth(), 3);
		assertEquals(rectangle.getHeight(), 5);
	}

	void testgetxCoordinate() {
		Rectangle rectangle = new Rectangle(5, 5, 3, 5);
		assertEquals(rectangle.getxCoordinate(), 5);
	}

	void testSetX() {
		Rectangle rectangle = new Rectangle(5, 5, 3, 5);
		assertEquals(rectangle.getxCoordinate(), 5);
		rectangle.setxCoordinate(9);
		assertEquals(rectangle.getxCoordinate(), 9);
	}

	void testgetyCoordinate() {
		Rectangle rectangle = new Rectangle(5, 5, 3, 5);
		assertEquals(rectangle.getxCoordinate(), 5);
		assertEquals(rectangle.getyCoordinate(), 5);
	}

	void testSetY() {
		Rectangle rectangle = new Rectangle(5, 5, 3, 5);
		assertEquals(rectangle.getxCoordinate(), 5);
		assertEquals(rectangle.getyCoordinate(), 5);
		rectangle.setyCoordinate(9);
		assertEquals(rectangle.getyCoordinate(), 9);
	}

	void testGetWidth() {
		Rectangle rectangle = new Rectangle(5, 5, 3, 5);
		assertEquals(rectangle.getxCoordinate(), 5);
		assertEquals(rectangle.getyCoordinate(), 5);
		assertEquals(rectangle.getWidth(), 3);
	}

	void testSetWidth() {
		Rectangle rectangle = new Rectangle(5, 5, 3, 5);
		assertEquals(rectangle.getxCoordinate(), 5);
		assertEquals(rectangle.getyCoordinate(), 5);
		assertEquals(rectangle.getWidth(), 3);
		rectangle.setWidth(5);
		assertEquals(rectangle.getWidth(), 5);
	}

	void testGetHeight() {
		Rectangle rectangle = new Rectangle(5, 5, 3, 5);
		assertEquals(rectangle.getxCoordinate(), 5);
		assertEquals(rectangle.getyCoordinate(), 5);
		assertEquals(rectangle.getWidth(), 3);
		assertEquals(rectangle.getHeight(), 5);
	}

	void testSetHeight() {
		Rectangle rectangle = new Rectangle(5, 5, 3, 5);
		assertEquals(rectangle.getxCoordinate(), 5);
		assertEquals(rectangle.getyCoordinate(), 5);
		assertEquals(rectangle.getWidth(), 3);
		assertEquals(rectangle.getHeight(), 5);
		rectangle.setHeight(7);
		assertEquals(rectangle.getHeight(), 7);
	}

	public void testIsIntersect() {
		
		Rectangle rectangle = new Rectangle(100, 100, 500, 500);
		assertEquals(rectangle.getxCoordinate() + rectangle.getWidth(), 600);
//      assertEquals(rectangle.getyCoordinate(), 5);
//      assertEquals(rectangle.getWidth(), 3);
//      assertEquals(rectangle.getHeight(), 5);
		
		Rectangle rectangle2 = new Rectangle(50, 10, 900, 900);
		Rectangle rectangle3 = new Rectangle(700, 50, 100, 100);
		
		Rectangle rectangle4 = new Rectangle(50, 200, 900, 900);	
		assertTrue(rectangle.intersect(rectangle2));
		assertFalse(rectangle.intersect(rectangle3));
		assertTrue(rectangle.intersect(rectangle4));
	}

	void testIsWithBounds() {
		Rectangle rectangle = new Rectangle(5, 5, 3, 5);
		assertEquals(rectangle.getxCoordinate(), 5);
		assertEquals(rectangle.getyCoordinate(), 5);
		assertEquals(rectangle.getWidth(), 3);
		assertEquals(rectangle.getHeight(), 5);
		
		Rectangle rectangle2 = new Rectangle(5, 5, 1024, 5);
		assertEquals(rectangle2.getxCoordinate(), 5);
		assertEquals(rectangle2.getyCoordinate(), 5);
		assertEquals(rectangle2.getWidth(), 1024);
		assertEquals(rectangle2.getHeight(), 5);
		
		Rectangle rectangle3 = new Rectangle(-5, 5, 1024, 5);
		assertEquals(rectangle3.getxCoordinate(), -5);
		assertEquals(rectangle3.getyCoordinate(), 5);
		assertEquals(rectangle3.getWidth(), 1024);
		assertEquals(rectangle3.getHeight(), 5);
		
//		assertEquals(rectangle.isWithBounds(), true);
//		assertEquals(rectangle2.isWithBounds(), false);
//		assertEquals(rectangle3.isWithBounds(), false);
	}
	
	public void testEQuality() {
		Rectangle rectangle = new Rectangle(5, 5, 3, 5);
		Rectangle rectangle1 = new Rectangle(5, 5, 3, 5);
		Rectangle rectangle2 = new Rectangle(5, 5, 50, 5);		
		assertTrue(rectangle.equals(rectangle1));
		assertFalse(rectangle.equals(rectangle2));
	}

	void testToString() {
		Rectangle rectangle = new Rectangle(5, 5, 3, 5);
		assertEquals(rectangle.getxCoordinate(), 5);
		assertEquals(rectangle.getyCoordinate(), 5);
		assertEquals(rectangle.getWidth(), 3);
		assertEquals(rectangle.getHeight(), 5);
		assertEquals(rectangle.toString(), "5, 5, 3, 5");
	}
    
    public void testIsInvalid() {
   
        Rectangle rectangle = new Rectangle(5, 5, 3, 5);
        assertFalse(rectangle.isInvalid());
        rectangle.setxCoordinate(-5);
        rectangle.setyCoordinate(5);
        rectangle.setWidth(5);
        rectangle.setHeight(5);
        assertTrue(rectangle.isInvalid());
        
        rectangle.setxCoordinate(5);
        rectangle.setyCoordinate(-5);
        rectangle.setWidth(5);
        rectangle.setHeight(5);
        assertTrue(rectangle.isInvalid());
//        
        rectangle.setxCoordinate(5);
        rectangle.setyCoordinate(5);
        rectangle.setWidth(-5);
        rectangle.setHeight(5);
        assertTrue(rectangle.isInvalid());
//        
        rectangle.setxCoordinate(5);
        rectangle.setyCoordinate(5);
        rectangle.setWidth(5);
        rectangle.setHeight(-5);
        assertTrue(rectangle.isInvalid());
        
    }

}
