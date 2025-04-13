package firstround_sdetsriques;
//Convert lower to upper case without using toUppercase() in java?
public class toLowerCase {
	
	public static void main(String[] args) {
		
	}

	public static void toLowerCase(String a) {
		for (int i = 0; i < a.length(); i++) {
			char aChar = a.charAt(i);
			if (65 <= aChar && aChar <= 90) {

			}
			aChar = (char) ((aChar + 32));
		}
		char[] aChar = null;
		System.out.print(aChar);
	}
}


