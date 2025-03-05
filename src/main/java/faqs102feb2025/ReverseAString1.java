package faqs102feb2025;

public class ReverseAString1 {
	/*
	 * diff between String and StringBuffer?
	 * do we have reverse fn in String?
	 */

	public static void main(String[] args) {
		String s = "Selenium";
		int len = s.length();
//		System.out.println(len);
		
		String rev = "";
		
		for(int i=len-1;i>=0;i--) {
			rev = rev + s.charAt(i);
		}
		System.out.println(rev);
		
		
		//2: way -- using StringBuffer class
		StringBuffer sb = new StringBuffer(s);
		System.out.println(sb.reverse());
		

	}

}
