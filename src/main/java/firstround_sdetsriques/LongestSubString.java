package firstround_sdetsriques;

import java.util.HashMap;
import java.util.Map;

public class LongestSubString {
	
/**
 * 1. Start traversing the string from left to right and maintain track
   2. Check the non-repeating characters in current substring with the help of a 
   start and end index
 * @param input
 * @return
 */
	
	 public static String getUniqueCharacterSubstring(String input) {
	      Map<Character, Integer> visited = new HashMap<>();
	      String output = "";
	      for (int start = 0, end = 0; end < input.length(); end++) {
	          char currChar = input.charAt(end);
	          if (visited.containsKey(currChar)) {
	              start = Math.max(visited.get(currChar) + 1, start);
	          }
	          if (output.length() < end - start + 1) {
	
	output = input.substring(start, end + 1);
	          }
	          visited.put(currChar, end);
	      }
	      return output;
	  }
	  public static void main(String[] args) {
	      String input = "LongestSubstringFindOut";
	      System.out.println(getUniqueCharacterSubstring(input));
	  }

}
