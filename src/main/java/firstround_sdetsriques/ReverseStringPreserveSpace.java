package firstround_sdetsriques;

public class ReverseStringPreserveSpace {
	
	/**
	 * 1. Create a string to store result. Mark the space position of the given string in this string.
	   2. Insert the character from input string into the result string in reverse 
	   order.
       3. While inserting the character check if the result string already contains 
       a spaceat index ‘j’ or not. If it contains, we copy the character to the next 
       position.
	 * @param str
	 */
	
	static void reverses(String str) {
		// Java program to reverse a string
		// preserving spaces.
		
	    char[] inputArray = str.toCharArray();
	    char[] result = new char[inputArray.length];
	    // Mark spaces in result
	    for (int i = 0; i < inputArray.length; i++) {
	      if (inputArray[i] == ' ') {
	
	result[i] = ' ';
	      }
	    }
	    // Traverse input string from beginning
	    // and put characters in result from end
	    int j = result.length - 1;
	    for (int i = 0; i < inputArray.length; i++) {
	      // Ignore spaces in input string
	      if (inputArray[i] != ' ') {
	        // ignore spaces in result.
	        if (result[j] == ' ') {
	j--; }
	        result[j] = inputArray[i];
	j--; }
	}
	    System.out.println(String.valueOf(result));
	  }
	  public static void main(String[] args) {
	    reverses("India Is my country");
	}

}
