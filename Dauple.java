/* Aaron Parks
 * CSS 590 - Software Traceability
 * University of Washington | Bothell
 * Summer 2015
 * Final Project: DAUPLE
 * 
 * -- "Dauple" ----------------------------------------------------------------------------
 * 
 */

import java.util.Scanner;

public class Dauple {
	//holder for source file names //these will be the diffed source files
	private String[] fileNames = new String[2];
	//holder for user input  //must start with default string so first 'while' loop works
	private String userInput = "null";
	//reader for user input from standard in
	private Scanner UIreader = new Scanner(System.in);

	public void run() {		
		//program splashscreen
		//honestly, i wrote this after hours of frustation with trying to compile
		//   the cpp.jj grammar file //i felt better afterwards
		this.drawSplash();
		
		while (!userInput.equalsIgnoreCase("exit")) {
			//stores the file path for the two source files to be compared
			while (fileNames[0] == null) {		
				//currently options are hard-coded to these six file names
				//in later iterators of this program, there would be no option to enter the
				//   file name, but rather the user would select the files like in a traditional
				//   diff tool
				System.out.println("Files to be compared:\n ->\"store\"\n ->\"npp\"\n ->\"track\")");
				userInput = UIreader.next();
	
				switch (userInput.toLowerCase()) {
		    		case "store":
		    			fileNames[0] = "store_old.cpp";
		    			fileNames[1] = "store_new.cpp";
		    			break;
		    		case "npp":
		    			fileNames[0] = "npp681.cpp";
		    			fileNames[1] = "npp6792.cpp";
		    			break;
		    		case "track":
		    			fileNames[0] = "trackpanel_old.cpp";
		    			fileNames[1] = "trackpanel_new.cpp";
		    			break;
		    		default:
		    			if (!userInput.equalsIgnoreCase("exit"))
		    				System.out.println("Invalid entry");
		    			break;
		        }
				//check if user wants to exit
				if (userInput.equalsIgnoreCase("exit"))
					break;
		    }//end while loop switch
			
			//check for program exit
			if (userInput.equalsIgnoreCase("exit"))
				break;
		
			//invoke 'SourceReader' to read in the files
			SourceReader srcReader = new SourceReader(fileNames);
		
			//FOR TESTING ONLY  //the following menu is temporary
			System.out.println("Select option:\n -> \"Lines\"\n -> \"LCS\"");
			userInput = UIreader.next();
			
			switch (userInput.toLowerCase()) {
			case "lines":
				System.out.println("Lines in \"" + fileNames[0] + "\": " + srcReader.left.size());
				System.out.println("Lines in \"" + fileNames[1] + "\": " + srcReader.right.size());
				break;
			case "lcs":
				//invoke lcs class
				LCS newLCS = new LCS();
				newLCS.getSubSequence(srcReader.left, srcReader.right);
				break;
			default:
				if (!userInput.equalsIgnoreCase("exit"))
					System.out.println("Invalid entry");
				break;		
			}
			
			//final message
			System.out.println("Continue? (Enter 'exit' to end program");
			userInput = UIreader.next();
			
			//check if new user wants to select new files
			if (userInput.equalsIgnoreCase("back"))
				fileNames[0] = null;
			//check if user wants to exit from program
			if (userInput.equalsIgnoreCase("exit"))
				UIreader.close();
			
		}// end main 'while' loop
		System.out.println("** END DAUPLE PROGRAM **");
	}// end 'run' method
	
	/* "drawScreen"
	 * Only purpose is the write initial program information - including title, author, and other
	 * relevant information to the default output when program loads
	 */
	private void drawSplash() {
		System.out.println(" _____  _____  _   _  ____   _     ____");
		System.out.println("|  _  \\|  _  || | | ||  _ \\ | |   |  __|        by Aaron Parks");
		System.out.println("| | | || |_| || | | || |_| || |   | |__            CSS590: Software Traceability");
		System.out.println("| | | ||  _  || | | ||  __/ | |   |  __|           University of Washington | Bothell");
		System.out.println("| |_| || | | || |_| || |    | |__ | |__            Summer 2015");
		System.out.println("|_____/|_| |_||_____||_|    |____||____|");
		System.out.println("A Diff Application Using a Parse Library in Eclipse v0.2\n");
	}
}

