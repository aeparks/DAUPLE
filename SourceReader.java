/* Aaron Parks
 * CSS 590 - Software Traceability
 * University of Washington | Bothell
 * Summer 2015
 * Final Project: DAUPLE
 * 
 *  -- "SourceReader" -----------------------------------------------------------
 * Will read in two source code files and store them in an ArrayList.  The scope
 * for an instance of "SourceReader" is the duration of the program execution.
 * SourceReader maintains the ArrayLists.
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public  class SourceReader {
	public static List<String> left           = null;  //first source file
	public static List<String> right          = null;  //second source file
	private static BufferedReader temp_reader = null;
	
	private static String line = null;

	//parameter is a two-element array with filename string for each file
	public SourceReader(String[] fileNames) {
		left  = new ArrayList<String>();
		right = new ArrayList<String>();
		
		readSource(fileNames);
	}
	
	/* "readSource"
	 * Will use a BufferedReader to read in the text/source/whatever from the supplied
	 * fileNames (i.e. the parameters 'file1' and 'file2').  The lines from 'file1' will
	 * be stored in the 'left' ArrayList while the lines from 'file2' will be stored in
	 * the 'right' ArrayList.  
	 */
	private static void readSource(String[] param) {
		try {
			//populate 'left'
			temp_reader = new BufferedReader(new FileReader(param[0]));
			while((line = temp_reader.readLine()) != null)
				left.add(line);
				
			//clear holders
			line = null;
			temp_reader.close();
			
			//populate 'right'
			temp_reader = new BufferedReader(new FileReader(param[1]));
			while ((line = temp_reader.readLine()) != null)
				right.add(line);
			
		} catch (IOException error) {error.printStackTrace();}
	}
}