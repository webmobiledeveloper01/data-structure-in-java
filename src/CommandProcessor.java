

/**
 * The purpose of this class is to parse a text file into its appropriate, line
 * by line commands for the format specified in the project spec.
 * 
 * @author CS Staff
 * 
 * @version 2024-05-22
 */
public class CommandProcessor {

    // the database object to manipulate the
    // commands that the command processor
    // feeds to it
    private Database rectDB;

    /**
     * The constructor for the command processor requires a database instance to
     * exist, so the only constructor takes a database class object to feed
     * commands to.
     * 
     * @param dataIn
     *            the database object to manipulate
     */
    public CommandProcessor(Database dataIn) {
        rectDB = dataIn;
    }
    
    /**
     * This method parses keywords in the line and calls methods in the
     * database as required. Each line command will be specified by one of the
     * keywords to perform the actions.
     * These actions are performed on specified objects and include insert,
     * remove,
     * regionsearch, search, and dump. If the command in the file line is not
     * one of these, an appropriate message will be written in the console. This
     * processor method is called for each line in the file. Note that the
     * methods called will themselves write to the console, this method does
     * not, only calling methods that do.
     * 
     * @param line
     *            a single line from the text file
     */
    public void processor(String line) {
        
    	String[] arr = line.trim().split("[\\s\\t]+");       
//    	int i = 0;
    	String command = "";
		
//		for (String s : arr) {
//			if(i == 0) {
//				command = s.trim().toLowerCase();
//			}
//			i++;
//		}
    	
    	command = arr[0];
	
        if (command.equals("insert")) {
            // Calls insert
        	if (arr.length != 6) {
                System.out.println("Invalid add command: " + String.join(" ", arr));
                return;
            }
        	
        	try {
                String id = arr[1].trim();
                int x = Integer.parseInt(arr[2].trim());
                int y = Integer.parseInt(arr[3].trim());
                int width = Integer.parseInt(arr[4].trim());
                int height = Integer.parseInt(arr[5].trim());
                 
                Rectangle rect = new Rectangle(x, y, width, height);
                
                if(rect.isInvalid()) System.out.println("Rectangle rejected: (" + id +", " + rect.toString() + ")");
                else {
                	KVPair<String, Rectangle> rectData = new KVPair<String, Rectangle>(id, rect);
                    rectDB.insert(rectData);
//                    System.out.println("Rectangle accepted: (" + id +", " + rect.toString() + ")");
                    System.out.println("Rectangle accepted: " + rectData.toString());
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid number format in add command: " + String.join(" ", arr));
            }
        }
        // calls the appropriate remove method based on the
        // number of white space delimited strings in the line
        else if (command.equals("remove")) {
            // checks the number of white space delimited strings in the line
            int numParam = arr.length - 1;
            if (numParam == 1) {
                // Calls remove by name
          	  	String rectName = arr[1].trim();    
              	rectDB.remove(rectName);
	        }
	        else if (numParam == 4) {
	            // Calls remove by coordinate, converting string
	            // integers into their Integer equivalent minus whitespace
	        	int x = Integer.parseInt(arr[1].trim());
	            int y = Integer.parseInt(arr[2].trim());
	            int width = Integer.parseInt(arr[3].trim());
	            int height = Integer.parseInt(arr[4].trim());
	            Rectangle rect = new Rectangle(x, y, width, height);
	            if(rect.isInvalid()) System.out.println("Rectangle rejected: ("+ rect.toString() + ")");
	            else {
	            	rectDB.remove(x, y, width, height);
	            }
	        }
        }
        else if (command.equals("regionsearch")) {
            // calls the regionsearch method for a set of coordinates
            // the string integers in the line will be trimmed of whitespace        	
        	if (arr.length != 5) {
                System.out.println("Invalid add command: " + String.join(" ", arr));
                return;
            }
        	try {
                int x = Integer.parseInt(arr[1].trim());
                int y = Integer.parseInt(arr[2].trim());
                int width = Integer.parseInt(arr[3].trim());
                int height = Integer.parseInt(arr[4].trim());
                Rectangle rect = new Rectangle(x, y, width, height);
                if(width <= 0 || height <= 0)
                	System.out.println("Rectangle rejected: (" + rect.toString() + ")");
                else {
                	 
                	System.out.println("Rectangles intersecting region (" + rect.toString() + "):");
                	rectDB.regionsearch(x, y, width, height);
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid number format in add command: " + String.join(" ", arr));
            }
        }
        else if (command.equals("intersections")) {
            // calls the intersections method, no parameters to be passed
            // (see the intersections JavaDoc in the Database class for more
            // information)
        	
        	if (arr.length != 1) {
                System.out.println("Invalid add command: " + String.join(" ", arr));
                return;
            }
        	
//        	try {	 
            	System.out.println("Intersection pairs:");
            	rectDB.intersections();
//            	rectDB.regionsearch(x, y, width, height);
//            } catch (NumberFormatException e) {
//                System.out.println("Invalid number format in add command: " + String.join(" ", arr));
//            }
        }
        else if (command.equals("search")) {
            // calls the search method for a name of object
        	int numParam = arr.length - 1;
            if (numParam == 1) {
          	  	String rectName = arr[1].trim();    
              	rectDB.search(rectName);
	        }

        }
        else if (command.equals("dump")) {
            // calls the dump method for the database, takes no parameters
            // (see the dump() JavaDoc in the Database class for more
            // information)
        	
        	if (arr.length != 1) {
                System.out.println("Invalid add command: " + String.join(" ", arr));
                return;
            }
        	
//        	try {	 
            	System.out.println("BST dump:");
            	rectDB.dump();
//            	rectDB.regionsearch(x, y, width, height);
//            } catch (NumberFormatException e) {
//                System.out.println("Invalid number format in add command: " + String.join(" ", arr));
//            }

        }
        else {
        	
            // the first white space delimited string in the line is not
            // one of the commands which can manipulate the database,
            // a message will be written to the console
        	if(!(command.equals(null) || command.equals("")))
        		System.out.println("Unrecognized command.");
        		
        }
        
    }

}
