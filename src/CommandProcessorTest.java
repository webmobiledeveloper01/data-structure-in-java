
import student.TestCase;

/**
 * This class tests the CommandProcessor class.
 * Test each possible command on its bounds,
 * if applicable to ensure they work properly.
 * Also test passing improper command to ensure
 * all class functionalities work as intended.
 * 
 * @author <your_name>
 * @version <version_no>
 */
public class CommandProcessorTest extends TestCase {
    private CommandProcessor cmdProcessor;
    private Database rectDB;
    /**
     * The setUp() method will be called automatically before
     * each test and reset whatever the test modified. For this
     * test class, only a new database object is needed, so
     * creat a database here for use in each test case.
     */
    public void setUp() {
        // TODO: implement setup
        rectDB = new Database();
        cmdProcessor = new CommandProcessor(rectDB);
    }
    

    // TODO: implement tests

}
