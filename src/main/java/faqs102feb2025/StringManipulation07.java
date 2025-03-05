package faqs102feb2025;

public class StringManipulation07 {

	public static void main(String[] args) {
		
		//String: is a collection of diff characters
		
		String str = "The rains have started here so plants are happy";
		String str1 = "The rains Have started here so plants are happy";
		
		System.out.println(str.length());
		System.out.println(str.charAt(5));
		System.out.println(str.indexOf('s'));//1st occurrence of s
		System.out.println(str.indexOf('s',str.indexOf('s')+1));//2nd occurrence of s
System.out.println(str.indexOf('s', str.indexOf('s',str.indexOf('s')+1)+1));//3rd

	System.out.println(str1.indexOf("have"));
	
	//String comparison
	System.out.println(str.equals(str1));
	
	System.out.println(str.equalsIgnoreCase(str1));
	
	//substring
	System.out.println(str.substring(0, 9));
	
	//trim
	String s = "    Hello   world   ";
	System.out.println(s.trim());//only before and after the phrase spaces
	
	//to remove in between spaces - use replace()
	System.out.println(s.replace(" ", ""));
	
	String date = "02-02-2025";
	System.out.println(date.replace("-", "/"));
	
	//split:
	String test = "Hello_World_test_selenium";
	System.out.println(test.split("_"));
	
	String testval[] = test.split("_");
	
	for(String e:testval) {
		System.out.println(e);
	}
	
	System.out.println("================");
	
	for(int i=0;i<testval.length;i++) {
		System.err.println(testval[i]);
	}
	
	
	}

}
