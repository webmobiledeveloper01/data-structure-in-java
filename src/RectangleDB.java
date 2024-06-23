
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * < MUST add honor pledge here >
 */

/**
 * The class containing the main method, the entry point of the application. It
 * will take a command line file argument which include the commands to be read
 * and creates the appropriate BST object and outputs the correct results
 * to the console as specified in the file.
 *
 * @author CS Staff
 * @version 2024-5-22
 */
public class RectangleDB {
	
	/**
     * Read contents of a file into a string
     * 
     * @param path
     *            File name
     * @return the string
     * @throws IOException
     */
//    static String readFile(String path) throws IOException {
//        byte[] encoded = Files.readAllBytes(Paths.get(path));
//        return new String(encoded);
//    }

    /**
     * The entry point of the application.
     *
     * @param args
     *            The name of the command file passed in as a command line
     *            argument.
     */
    public static void main(String[] args) {

        if (args.length < 1) {
            System.out.println(
                "Invalid file. No filename in command line arguments");
            return;
        }

        Database rectDB = new Database();
        
        // The following pseudocode walks through a possible design for an
        // entrypoint for your rectangledb
        // setup a file for the file containing the commands
        // Open the file and scan through it (your may need a try catch here)
        // take the first command line argument and opens that file
        // create a scanner object
        // create a command processor object
        // read the entire file and processes the commands
        // line by line
        // determines if the file has more lines to read
        // close the scanner
        // catch the exception if the file cannot be found
        // and output the correct information to the console
        
        CommandProcessor cmder = new CommandProcessor(rectDB);
        try {
        	Scanner scanner  = new Scanner(new File(args[0])); 
	        while (scanner.hasNextLine()) {
	            String command = scanner.nextLine();
	            cmder.processor(command);
	        }
	        scanner.close(); // Close the scanner after reading the file
        } catch (IOException e) {
           // e.printStackTrace();
        }
    }
}
