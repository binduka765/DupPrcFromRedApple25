package faqs102feb2025duppractice;

public class ReverseAString1 {

	public static void main(String[] args) {
		
		String s = "Python";
		System.out.println(s.length());
		
		String rev = "";
		for(int i=s.length()-1;i>=0;i--) {
			rev = rev + s.charAt(i);
		}
		System.out.println(rev);

	}

}
