package firstround_sdetsriques;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class SortFileText {
	
	 public static void main(String[] args) {
		    //Create an ArrayList object to hold the lines of input file
		    ArrayList<String> lines = new ArrayList<String>();
		    try (
		      BufferedReader  reader = new BufferedReader(new FileReader("./src/test/resources/file.txt"));
		      BufferedWriter  writer = new BufferedWriter(new FileWriter("./src/test/resources/output.txt"));
		) {
		
		//Reading all the lines of input file one by one and adding them into ArrayList
		      String currentLine = reader.readLine();
		      while (currentLine != null) {
		        lines.add(currentLine);
		        currentLine = reader.readLine();
		}
		      //Sorting the ArrayList
		      Collections.sort(lines);
		      //Writing sorted lines into output file
		      for (String line : lines) {
		        writer.write(line);
		        writer.newLine();
		      }
		    }
		    catch (IOException e) {
		      e.printStackTrace();
		    }
		}

}
