

import student.TestCase;

/**
 * This class tests the KVPair class so that the member methods work properly
 * and that the expected behavior occurs.
 * 
 * @author CS Staff
 * 
 * @version 2024.1
 */
public class DatabaseTest extends TestCase {
    private Database rectDB;
    public void setUp() {
        // TODO: implement setup
        rectDB = new Database();
    }

    // TODO: implement tests
    
    public void testRemoveName() {
        Rectangle rect = new Rectangle(50, 50, 100, 100);
        KVPair<String, Rectangle> pair = new KVPair<String, Rectangle>("r2", rect);
        rectDB.insert(pair);
//        assertTrue(rectDB.remove("r2"));
//        assertFalse(rectDB.remove("r1"));     
    }
    
    public void testRemoveRect() {
        Rectangle rect = new Rectangle(50, 50, 100, 100);
        KVPair<String, Rectangle> pair = new KVPair<String, Rectangle>("r2", rect);
        rectDB.insert(pair);
//        assertTrue(rectDB.remove(50, 50, 100, 100));
//        assertFalse(rectDB.remove(50, 60, 110, 110));     
    }
    
//    public void testRemoveRect() {
//        Rectangle rect = new Rectangle(50, 50, 100, 100);
//        KVPair<String, Rectangle> pair = new KVPair<String, Rectangle>("r2", rect);
//        rectDB.insert(pair);
//        assertTrue(rectDB.remove(50, 50, 100, 100));
//        assertFalse(rectDB.remove(50, 60, 110, 110));     
//    }

}
