package seldec2023;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringConcept26 {
	//regex: is a special kind of string which is supported in all ProgLs
	//with the help of which u can create a combination/pattern of a specific
	//string -- domain.replaceAll(regex, replacement);
	// "\\s+" -->>removes spaces more than one when used as a regex
	//"\\D+" -->>to remove non numeric values-space is also a non numeric value
	//D --denotes digit
	public static void main(String[] args) {
		String name = "Bin Auto Group";
		System.out.println(name.toLowerCase());
		System.out.println(name.toUpperCase());
		
		String domain = "     hello    selenium   ";
		String dom = domain.replaceAll("\\s+", "");
		System.out.println(dom);
		
		String t1 = "your order id is 12345";
		String orderId = t1.replaceAll("\\D+", "");
		System.out.println(orderId);
		
		String t2 = "your user id is 9090 and order id is 12345";
//		String newStr = t2.replaceAll("\\D+", "");
//		System.out.println(newStr);
		
		Pattern pattern = Pattern.compile("\\d+");
		Matcher matcher = pattern.matcher(t2);
		
//		while(matcher.find()) {
//			System.out.println(matcher.group());
//		}
		
		String userId = null;
		String oId = null;
		if(matcher.find()) {
			userId = matcher.group();
			System.out.println(userId);
		}
		
		if(matcher.find()) {
			oId = matcher.group();
			System.out.println(oId);
		}
		
		System.out.println(userId);
		System.out.println(oId);

	}

}
