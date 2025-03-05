package faqs1set;

public class ConsonantsVowels1 {

	public static void main(String[] args) {
		// a e i o u
		char ch = 'm';
		
		if(ch=='a' || ch=='e' || ch=='i' || ch=='0' || ch=='u') {
			System.out.println(ch + " is a vowel");
		}else {
			System.out.println(ch + " is a consonant");
		}
	
		System.out.println("-----------------------");
		
		//2: using switch case statement
		 ch = 'o';
		switch (ch) {
		case 'a':
		      System.out.println(ch+ " is a vowel");
		      break;
		case 'e':
		      System.out.println(ch+ " is a vowel");
		      break;
		case 'i':
		      System.out.println(ch+ " is a vowel");
		      break;
		case 'o':
		      System.out.println(ch+ " is a vowel");
		      break;
		case 'u':
		      System.out.println(ch+ " is a vowel");
			break;

		default:
			System.out.println(ch+ "is a consonant");
			break;
		}

	}

}
