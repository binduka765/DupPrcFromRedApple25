package firstround_sdetsriques;

import java.util.ArrayList;
import java.util.Collections;

public class MainClass {
	//to sort items in Array List in reverse order
	public static void main(String[] args) {
	    ArrayList<String> arrayList = new ArrayList<String>();
	    arrayList.add("A");
	    arrayList.add("B");
	    arrayList.add("C");
	    arrayList.add("D");
	    arrayList.add("E");
	    System.out.println(arrayList);
	    Collections.reverse(arrayList);
	    System.out.println(arrayList);
	}

}
