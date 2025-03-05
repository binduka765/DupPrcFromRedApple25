package faqs102feb2025duppractice;

public class RemoveJunk2 {

	public static void main(String[] args) {
		//Regexp: [^a-z0-9A-Z]
		
		String s = "*&$)!@5akXjNBinAuto25(#$%^*";
		
	     s = s.replaceAll("[^a-z0-9A-Z]", "");
		System.out.println(s);
		
		

	}

}
