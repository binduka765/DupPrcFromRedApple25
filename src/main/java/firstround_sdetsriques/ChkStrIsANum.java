package firstround_sdetsriques;

public class ChkStrIsANum {
	
	 public static void main (String[] args) {
		    String regex = "[0-9]+";
		    // String regex = "\\\\d+";
		    String data = "23343453";
		    System.out.println("Is Number: "+ data.matches(regex));
		}

}
