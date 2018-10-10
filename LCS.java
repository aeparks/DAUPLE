/* adapted from the LCS example by Robert Sedgewick and Kevin Wayne
 * .bib entry {Sedgewick_2012}
 * 
 * The logic is the same, but the values being compared are different. By
 * passing two string Lists, entire lines of code are compared and not
 * just characaters
 */
import java.util.List;

public class LCS {
	
	public void getSubSequence(List<String> left, List<String> right) {
		int[][] matrix = new int[left.size()+1][right.size()+1];
		
		for (int i = left.size()-1; i >= 0; i--) {
			for (int j = right.size()-1; j >= 0; j--) {
				if (left.get(i).equalsIgnoreCase(right.get(j)))
					matrix[i][j] = matrix[i+1][j+1] + 1;
				else {
					matrix[i][j] = Math.max(matrix[i+1][j], matrix[i][j+1]);
				}
			}
		}
		
		//reset variables for next iteration
		int i = 0, j = 0;
		while (i < left.size() && j < right.size()) {
			if (left.get(i).equalsIgnoreCase(right.get(j))) {
				System.out.println(left.get(i));
				i++;
				j++;
			}
			else if (matrix[i+1][j] >= matrix[i][j+1])
				i++;
			else
				j++;
		}
	}
}
