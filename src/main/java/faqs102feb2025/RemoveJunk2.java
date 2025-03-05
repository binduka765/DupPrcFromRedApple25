package faqs102feb2025;

public class RemoveJunk2 {

	public static void main(String[] args) {
		
		String s = "!@#$%^7da9*&^%";
		
		//Regular Expression: [^a-z0-9A-Z]
		
		s = s.replaceAll("[^a-z0-9A-Z]", "");
		System.out.println(s);

	}

}
