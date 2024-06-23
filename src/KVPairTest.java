

import student.TestCase;

/**
 * This class tests the KVPair class so that the member methods work properly
 * and that the expected behavior occurs.
 * 
 * @author CS Staff
 * 
 * @version 2024.1
 */
public class KVPairTest extends TestCase {
    private KVPair<String, Rectangle> pair;
    public void setUp() {
        // TODO: implement setup
        Rectangle rect = new Rectangle(50, 50, 110, 110);
        pair = new KVPair<String, Rectangle>("r2", rect);
    }

    // TODO: implement tests
    
    public void testCompareTo() {
        Rectangle rect = new Rectangle(50, 50, 110, 110);
        KVPair<String, Rectangle> pair1 = new KVPair<String, Rectangle>("r2", rect);
        assertEquals(pair.compareTo(pair1), 0);
        KVPair<String, Rectangle> pair2 = new KVPair<String, Rectangle>("r3", rect);
        assertEquals(pair.compareTo(pair2), -1);
        KVPair<String, Rectangle> pair3 = new KVPair<String, Rectangle>("r1", rect);
        assertEquals(pair.compareTo(pair3), 1);
    }

}
