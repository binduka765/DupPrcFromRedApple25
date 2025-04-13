package firstround_sdetsriques;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

public class MostRepeatedWord {
	/*
	 * to find the word with the highest frequency from a file in Java?
	 */
	
	 public static void main(String[] args) {
		    int count = 0;
		    String mostRepeatedWord = null;
		    // Creating wordCountMap which holds words as keys and their occurrences as values
		    HashMap<String, Integer> wordCountMap = new HashMap<String, Integer>();
		    try (
		      BufferedReader  reader = new BufferedReader(new FileReader("./src/test/resources/file.txt"));
		){
		// Reading the first line into currentLine 
		    String currentLine = reader.readLine();
		      while (currentLine != null) {
		        // splitting the currentLine into words
		        String[] words = currentLine.toLowerCase().split(" ");
		
		for (String word : words) {
		          // If word is already present in wordCountMap, updating its count
		          if(wordCountMap.containsKey(word)) {
		            wordCountMap.put(word, wordCountMap.get(word)+1);
		          } else {
		            wordCountMap.put(word, 1);
		          }
		        }
		        // Reading next line into currentLine
		        currentLine = reader.readLine();
		}
		      // Getting the most repeated word and its occurrence
		      Set<Entry<String, Integer>> entrySet = wordCountMap.entrySet();
		      for (Entry<String, Integer> entry : entrySet) {
		        if(entry.getValue() > count) {
		          mostRepeatedWord = entry.getKey();
		          count = entry.getValue();
		        }
		}
		      System.out.println("The most repeated word in input file is: "+mostRepeatedWord);
		      System.out.println("Number Of Occurrences: "+count);
		    }
		    catch (IOException e) {
		      e.printStackTrace();
		} 
		    }

}
